//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

//Return the max sliding window.

 

//Example 1:

//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7

   public int[] maxSlidingWindow(int[] nums, int k) {
        
        int result[] = new int[nums.length - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            Pair p = new Pair(j, nums[j]);
            pq.add(p);
            if (j - i + 1 < k) {
                j++;
            } else {
                result[i] = pq.peek().val;
                while (!pq.isEmpty() && pq.peek().key < i+1) {
                    pq.remove();
                }
                i++;
                j++;
                
            }

        }
        
        return result;
        
    }
    
    static class Pair implements Comparable<Pair> {

        int key;
        int val;

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return o.val - this.val;
        }

    }

//time complexity of O(N²)