package facebook;

import java.util.*;

public class M127 {int diff(String s1, String s2) {
    int count = 0;
    char[] arr1 = s1.toCharArray();
    char[] arr2 = s2.toCharArray();
    for (int i=0; i<arr1.length; i++) {
        if (arr1[i] != arr2[i]) count++;
    }
    return count;
}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Map<String, Boolean> map = new HashMap<>();
        q.offer(beginWord);
        map.put(beginWord, true);
        int ans = 1;
        while (!q.isEmpty()) {
            List<String> tmp = new ArrayList<>();
            while (!q.isEmpty()) {
                String str = q.poll();
                for (String s2: wordList) {
                    if (!map.containsKey(s2) && diff(str, s2) == 1) {
                        tmp.add(s2);
                        map.put(s2, true);
                        if (s2.equals(endWord)) return ans+1;
                    }
                }
            }
            ans ++;
            for (String str: tmp) {
                q.offer(str);
            }
        }
        return 0;
    }
}
