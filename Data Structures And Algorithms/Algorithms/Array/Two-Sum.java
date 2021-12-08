import java.util.HashMap;
import java.util.Map;

//Notes
// get array length is a property
// hashMap = C# Dictionary
//Custom
class Solution {
    public int[] TwoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++)
        {
            for(int x = 0;x<nums.length;x++)
            {
                if (i != x)
                {
                    if(nums[i] + nums[x] == target)
                    {
                        return new int []{i,x};
                    }
                }
            }
        }
        return new int []{0,0};
    }
}

// time complexity is O(n2) space complexity is O(1)


//Optimal
class Solution2 {
 
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}

// space complexity will be traded with time complexity which results in 
// a time complexity of O(n) and space complexity of O(n)