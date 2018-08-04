package facebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        for (List<Integer> row: wall) {
            int tmp = 0;
            for (Integer item: row) {
                tmp += item;
                int val = map.getOrDefault(tmp, 0);
                map.put(tmp, val+1);
            }
            len = tmp;
        }
        int ans = 0;
        for (Integer i: map.keySet()) {
            if (i != len) {
                ans = Math.max(ans, map.get(i));
            }
        }
        return wall.size() - ans;
    }
}
