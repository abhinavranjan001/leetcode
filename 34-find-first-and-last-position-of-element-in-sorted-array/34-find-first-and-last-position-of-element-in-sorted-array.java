class Solution {
    public int[] searchRange(int[] nums, int target) {

        int binResult = binarySearch(nums, 0, nums.length - 1, target);
        if (binResult == -1) return new int[]{-1, -1};

        int l = 0, r = binResult;
        int m = (l + r) / 2;

        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] != target && nums[m + 1] == target) {
                break;
            } else if (nums[m] == target) r = m - 1;
            else l = m + 1;
        }

        int left = m;

        l = binResult;
        r = nums.length - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] != target && nums[m - 1] == target) {
                break;
            } else if (nums[m] == target) l = m + 1;
            else r = m - 1;
        }

        int right = m;
        if(nums[left] != target) left++;
        if(nums[right] != target) right--;
        return new int[]{left, right};
    }

    public int binarySearch(int[] arr, int l, int r, int x) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) return m;
            if (arr[m] < x) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
    
}