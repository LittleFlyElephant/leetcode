package facebook;

import java.util.ArrayList;
import java.util.List;

public class M721 {  // 太慢，需要优化
    boolean[][] map;
    int len = 0;
    boolean[] vis;

    boolean isSame(List<String> a1, List<String> a2) {
        for (int i = 1; i < a1.size(); i++) {
            for (int j = 1; j < a2.size(); j++) {
                if (a1.get(i).compareTo(a2.get(j)) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    void insert(List<String> ans, String str) {
        int index = 0;
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).compareTo(str) == 0) {
                return;
            } else if (ans.get(i).compareTo(str) > 0) {
                break;
            }
            index ++;
        }
        ans.add(index, str);
    }

    void dfs(int x, List<List<String>> accs, List<String> ans) {
        for (int i = 1; i < accs.get(x).size(); i++) {
            insert(ans, accs.get(x).get(i));
        }
        vis[x] = true;
        for (int i = 0; i < len; i++) {
            if (map[x][i] && !vis[i]) {
                dfs(i, accs, ans);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        len = accounts.size();
        map = new boolean[len][len];
        vis = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (isSame(accounts.get(i), accounts.get(j))) {
                    map[i][j] = true;
                    map[j][i] = true;
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!vis[i]) {
                List<String> tmp = new ArrayList<>();
                tmp.add(accounts.get(i).get(0));
                dfs(i, accounts, tmp);
                ans.add(tmp);
            }
        }
        return ans;
    }
}
