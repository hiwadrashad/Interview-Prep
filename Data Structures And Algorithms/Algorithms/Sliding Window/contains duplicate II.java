  
//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

//Example 1:

//Input: nums = [1,2,3,1], k = 3
//Output: true

     const set = new Set();
     for(let i = 0; i < nums.length; i++){
         // Once repeated elements appear in the sliding window, the requirements are met
         if(set.has(nums[i])){
             return true
         }
         // Every value is added
         set.add(nums[i]);

         // Once the number exceeds k, delete the first number, that is, the sliding window moves to the right
         if(set.size> k){
             set.delete(nums[i-k]);
         }
     }
     return false

//time complexity of O(N)