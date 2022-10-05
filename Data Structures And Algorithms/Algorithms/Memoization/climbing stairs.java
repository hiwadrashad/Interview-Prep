//You are climbing a staircase. It takes n steps to reach the top.

//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

//Example 1:

//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps

    public int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
 
    public int countWays(int s)
    {
        return fib(s + 1);
    }
 
    public int climbStairs(int n) {
      return countWays(n);  
    }

    //time complexity of O(N)