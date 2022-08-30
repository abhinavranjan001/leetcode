class Solution {
    public int jump(int[] nums) {
        int l = nums.length, c = 0, min = 0;
        if(l == 1) return 0;
        if(l == 2 && nums[0] > 0) return 1;

        int[] nums1 = new int[l];

        nums1[l - 1] = 0;
        for (int i = l - 2; i >= 0; i--) {
            c = nums[i];
            min = nums1[i+1];
            for (int j = i + 1; j < l && c > 0; j++, c--) {
                min = Math.min(min, nums1[j]);
            }
            nums1[i] = min+1;
        }
        return nums1[0];
    }
}