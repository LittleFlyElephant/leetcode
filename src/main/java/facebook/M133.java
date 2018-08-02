package facebook;

import util.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

public class M133 {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    void dfs(UndirectedGraphNode newNode, UndirectedGraphNode oldNode) {
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode node: oldNode.neighbors) {
            if (!map.containsKey(node.label)) {
                UndirectedGraphNode tmp = new UndirectedGraphNode(node.label);
                dfs(tmp, node);
            }
            newNode.neighbors.add(map.get(node.label));
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        dfs(root, node);
        return root;
    }
}
