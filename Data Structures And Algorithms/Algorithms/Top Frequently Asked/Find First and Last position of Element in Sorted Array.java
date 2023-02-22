//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

//If target is not found in the array, return [-1, -1].

//You must write an algorithm with O(log n) runtime complexity.

 

//Example 1:

//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:

//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//Example 3:

//Input: nums = [], target = 0
//Output: [-1,-1]

    public int[] searchRange(int[] nums, int target) {
                int n = nums.length;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++) {
            if (target != nums[i])
                continue;
            if (first == -1)
                first = i;
            last = i;
        }
        if (first != -1) {
            int[] result = {first,last};
            return result;
        }
        else
        {
            int[] result = {-1,-1};
            return result;
        }
    }