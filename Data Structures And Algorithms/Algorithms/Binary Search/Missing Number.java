//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

//Example 1:

//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

class Solution {
    public int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
  
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
               return mid;
  
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
  
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid+1, r, x);
        }
  
        // We reach here when element is not present
        //  in array
        return -1;
    }
  
    
    public int missingNumber(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++)
        {
            int x = binarySearch(nums,0,length - 1,i);
            if (x == -1)
            {
                return i;
            }
        }
        return length;
        
    }
}
// space complexity of O(N) and Time Complexity of O(N)