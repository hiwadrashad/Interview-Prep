
//Given an array of integers nums, return the number of good pairs.
//A pair (i, j) is called good if nums[i] == nums[j] and i < j

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i = 0;i < nums.length;i++)
        {
            for(int x = 0;x < nums.length;x++)
            {
                if (x > i)
                {
                    if(nums[x] == nums[i])
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

//space complexity is O(1) time complexity is o(n²)