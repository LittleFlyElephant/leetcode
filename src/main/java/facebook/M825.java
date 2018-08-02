package facebook;

public class M825 {

    boolean re(int a1, int a2) {
        if (a2 <= 0.5*a1+7 || a2 > a1 || (a2 > 100 && a1 < 100))
            return false;
        return true;
    }

    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        boolean[][] map = new boolean[121][121];
        for (int i=1; i<=120; i++) {
            for (int j=1; j<=120; j++) {
                map[i][j] = re(i, j);
            }
        }
        for (int i=0; i<ages.length; i++) {
            count[ages[i]] ++;
        }
        int ans = 0;
        for (int i=1; i<=120; i++) {
            for (int j=1; j<=120; j++) {
                if (map[i][j]) {
                    if (i!=j)
                        ans += count[i]*count[j];
                    else
                        ans += count[i]*(count[j]-1);
                }
            }
        }
        return ans;
    }
}
