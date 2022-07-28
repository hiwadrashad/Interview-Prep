//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
//such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

class Solution {
    public int fib(int n) {
          int[] solution = new int[n+2];
          solution[0] = 0;
          solution[1] = 1;
          for(int i = 2; i <= n; i++)
          {
              solution[i] = solution[i -1] + solution[i -2];
          }
          return solution[n];
        }
    }

//with a big o notation of O(n)