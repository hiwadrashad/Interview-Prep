//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

//Example 1:

//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
              List<Integer> arr = new ArrayList<Integer> ();
        for (int num : nums) {
            arr.add(num);
        }
        int length = arr.size();
        List<List<Integer>> retList = new ArrayList<>();
        execute(length, 0, arr, retList);
        return retList;
    }
    
       public void execute(int length, int index, List<Integer> nums, List<List<Integer>> retList) {
        if (index == length) {
            retList.add(new ArrayList<>(nums));
        }
        for (int i = index; i < length; i++) {
            Collections.swap(nums, index, i);
            execute(length, index + 1, nums, retList);
            Collections.swap(nums, index, i);
        }
}
}

// time complexity of O(N)