package facebook;

import util.TreeNode;

public class E235 {
    void dfs(TreeNode node, TreeNode par, int h) {
        if (node == null) return;
        node.parent = par;
        node.h = h;
        dfs(node.left, node, h+1);
        dfs(node.right, node, h+1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, null, 0);
        while (!p.equals(q)) {
            if (p.h > q.h) p = p.parent;
            else q = q.parent;
        }
        return p;
    }
}
