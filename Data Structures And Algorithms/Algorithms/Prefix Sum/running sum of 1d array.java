//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

//Return the running sum of nums.

 

//Example 1:

//Input: nums = [1,2,3,4]
//Output: [1,3,6,10]
//Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

class Solution {
    public int[] runningSum(int[] nums) {
      int[] answer = new int[nums.length]; 
        int previous = 0;
        for (int x = 0; x < nums.length; x++)
        {
            previous = previous + nums[x];
            answer[x] = previous;
        }
        return answer;
    }
}

//time complexity of O(N)