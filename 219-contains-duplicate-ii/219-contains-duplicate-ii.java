class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int j = 0, x = k;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            x = i + k;
            while (j < nums.length && j <= x) {
                if (nums[i] == nums[j++])
                    return true;
            }
        }
        return false;
    }
}