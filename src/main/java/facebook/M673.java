package facebook;

public class M673 {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length, maxF = 0;
        if (len == 0) return 0;
        int[] f = new int[len], ans = new int[len];
        for (int i=0; i<len; i++) {
            f[i] = 1;
            ans[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    if (f[j]+1 > f[i]) {
                        f[i] = f[j]+1;
                        ans[i] = ans[j];
                    } else if (f[j]+1 == f[i]) {
                        ans[i] += ans[j];
                    }
                }
            }
            maxF = Math.max(maxF, f[i]);
        }
        int sum = 0;
        for (int i=0; i<len; i++) {
            if (maxF == f[i]) sum += ans[i];
        }
        return sum;
    }
}
