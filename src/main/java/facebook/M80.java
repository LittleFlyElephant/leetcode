package facebook;

import java.util.Arrays;

public class M80 {
    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int j = 0, len = nums.length, count = 0, tmp = 0;
        for (int i=0; i<len; i++) {
            if (count == 0) {
                tmp = nums[i];
                nums[j++] = nums[i];
                count ++;
            } else if (nums[i] == tmp) {
                if (count == 1) {
                    count ++;
                    nums[j++] = nums[i];
                }
            } else {
                tmp = nums[i];
                count = 1;
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
