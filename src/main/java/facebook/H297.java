package facebook;

import util.TreeNode;

import java.util.Arrays;

public class H297 {
    int dfs(TreeNode node, int index, Integer[] arr) {
        if (node == null) return index+1;
        arr[index++] = node.val;
        index = dfs(node.left, index, arr);
        index = dfs(node.right, index, arr);
        return index;
    }

    int getH(TreeNode node) {
        if (node == null) return 0;
        return getH(node.left)+getH(node.right)+1;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        int h = getH(root);
        Integer[] arr = new Integer[2*h+1];
        Arrays.fill(arr, null);
        dfs(root, 0, arr);
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == null){
                ans.append(",+");
            } else {
                ans.append(",").append(arr[i]);
            }
        }
        if (ans.length() == 0) return "";
        return ans.substring(1);
    }

    TreeNode getTree(String[] arr, int x) {
        if (x >= arr.length) return null;
        if (arr[x].charAt(0) == '+') return null;
        TreeNode node = new TreeNode(Integer.valueOf(arr[x]));
        node.left = getTree(arr, x+1);
        node.right = getTree(arr, 2*getH(node.left)+x+2);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] s = data.split(",");
        return getTree(s, 0);
    }
}
