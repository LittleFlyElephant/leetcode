package facebook;

import java.util.ArrayList;
import java.util.List;

public class H301 {
    char[] carr;
    int[] f, ln, rn;
    boolean[] del;
    int len, suml = 0, sumr = 0;

    void dfs(List<String> ans, int x, int lf, int rf) {
        if (x > 0) {
            if (suml-ln[x-1] < lf) return;
            if (sumr-rn[x-1] < rf) return;
        }
        if (x == len) {
            if (lf != 0 || rf != 0) return;
            StringBuilder bu = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (f[i] < 0) return;
                if (!del[i]) bu.append(carr[i]);
            }
            ans.add(bu.toString());
        } else {
            //不删
            dfs(ans, x+1, lf, rf);
            //删除
            if (carr[x] == '(' && lf > 0) {
                if (x > 0 && carr[x-1] == '(' && !del[x-1]) return;
                for (int i = x; i < len; i++) {
                    f[i] --;
                }
                del[x] = true;
                dfs(ans, x+1, lf-1, rf);
                del[x] = false;
                for (int i = x; i < len; i++) {
                    f[i] ++;
                }
            } else if (carr[x] == ')' && rf > 0){
                if (x > 0 && carr[x-1] == ')' && !del[x-1]) return;
                for (int i = x; i < len; i++) {
                    f[i] ++;
                }
                del[x] = true;
                dfs(ans, x+1, lf, rf-1);
                del[x] = false;
                for (int i = x; i < len; i++) {
                    f[i] --;
                }
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) {
            ans.add("");
            return ans;
        }
        carr = s.toCharArray();
        f = new int[carr.length];
        ln = new int[carr.length];
        rn = new int[carr.length];
        del = new boolean[carr.length];
        len = carr.length;
        int c = 0, lf = 0, rf = 0;
        for (int i=0; i<carr.length; i++) {
            int val = 0;
            if (i > 0) {
                ln[i] = ln[i-1];
                rn[i] = rn[i-1];
            }
            if (carr[i] == '(') {
                val = 1;
                ln[i] ++;
                suml ++;
            }
            else if (carr[i] == ')') {
                val = -1;
                rn[i] ++;
                sumr ++;
            }
            if (i == 0) {
                f[i] = val;
            }
            else {
                f[i] = f[i-1] + val;
            }
            c += val;
            if (c < 0) {
                c = 0;
                rf ++;
            }
        }
        lf = rf + f[len-1];
//        printf();
//        System.out.println(lf +" "+rf);
        dfs(ans, 0, lf, rf);
        return ans;
    }
}
