package facebook;

import util.TreeNode;

public class E572 {
    boolean suc(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if ((t == null && s != null)||(s == null && t != null)) return false;
        if (t.val != s.val) return false;
        return suc(s.left, t.left) && suc(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return suc(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
