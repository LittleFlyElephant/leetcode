package facebook;

import util.TreeLinkNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M117 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<TreeLinkNode> tmp = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeLinkNode node = q.poll();
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            for (int i=0; i<tmp.size(); i++) {
                if (i < tmp.size()-1) {
                    tmp.get(i).next = tmp.get(i+1);
                }
                q.offer(tmp.get(i));
            }
        }
    }
}
