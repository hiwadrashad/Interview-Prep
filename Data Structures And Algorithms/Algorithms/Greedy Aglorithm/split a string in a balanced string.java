// a greedy algorithm means to get with the least amount of options to the full answer
// e.g you have 1 2 3 you need 5 you take 2 and 3 as the shortest answer\

//Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

//Given a balanced string s, split it into some number of substrings such that:

//Each substring is balanced.
//Return the maximum number of balanced strings you can obtain.

 

//Example 1:

//Input: s = "RLRRLLRLRL"
//Output: 4
//Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
//Example 2:

//Input: s = "RLRRRLLRLL"
//Output: 2
//Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
//Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
//Example 3:

//Input: s = "LLLLRRRR"
//Output: 1
//Explanation: s can be split into "LLLLRRRR"

class Solution {
    public int balancedStringSplit(String s) {
        int answer = 0;
        
        char[]chars = s.toCharArray();
        
        int LCount = 0;
        int RCount = 0;
        
        for(int i = 0; i < chars.length;i++)
        {
            
            if (chars[i] == 'L')
            {
               LCount++;   
            }
            if(chars[i] == 'R')
            {
                RCount++;
            }
            
            if(LCount != 0 && RCount != 0)
            {
                if (LCount == RCount)
                {
                answer++;
                LCount = 0;
                RCount = 0;
                }
            }  
                
        }
        return answer;
    }
}

// big o notation of O(n)