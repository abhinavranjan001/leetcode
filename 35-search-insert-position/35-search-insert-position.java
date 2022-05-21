class Solution {
    public int searchInsert(int[] nums, int target) {
        int first = 0, last = nums.length-1;
        int mid = (first + last)/2;  
        while( first <= last ){  
                if ( nums[mid] < target ){  
                    first = mid + 1;     
                }else if ( nums[mid] == target ){  
                    return mid;  
                }else{  
                last = mid - 1;  
            }  
            mid = (first + last)/2;  
        }  
        if ( first > last )  return first;
        else return 0;
    }
}