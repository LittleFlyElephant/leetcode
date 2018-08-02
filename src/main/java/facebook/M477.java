package facebook;

public class M477 {
    //新思路：统计各bit上的1的个数
    public int totalHammingDistance(int[] nums) {
        int len = nums.length, ans = 0;
        for (int i=0; i<32; i++) {
            int tmp = 0;
            for (int j=0; j<len; j++) {
                tmp += (nums[j]>>>i)&1;
            }
            ans += tmp*(len-tmp);
        }
        return ans;
    }
}
