package facebook;

public class E278 {
    //defined
    boolean isBadVersion(int version){
        return false;
    }
    //my
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (int)(((long)l+r)/2);
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
}
