package facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M71 {
    public String simplifyPath(String path) {

        String[] sp = path.split("/");
        Stack<String> st = new Stack<>();
        //trunc
        List<String> paths = new ArrayList<>();
        for (String s: sp) {
            if (!s.equals("")) {
                paths.add(s);
            }
        }
        for (String s: paths) {
            if (s.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else if (!s.equals(".")) {
                st.push(s);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.insert(0, st.pop());
            ans.insert(0, '/');
        }
        if (ans.length() == 0) return "/";
        return ans.toString();
    }

    public static void main(String[] args) {
        String test = "/../";
        System.out.println((new M71()).simplifyPath(test));
    }
}
