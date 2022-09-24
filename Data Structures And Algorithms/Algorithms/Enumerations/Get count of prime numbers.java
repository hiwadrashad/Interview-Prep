//Given an integer n, return the number of prime numbers that are strictly less than n.

 

//Example 1:

//Input: n = 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

    public int countPrimes(int n) {
            if (n <= 2) {
        return 0;
    }

    int count = 1;
    
    for (int i = 3; i < n; i++) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) break;
            
            if (j == i - 1 && i % j != 0) {
                count++;
            }
        }
    }
    
    return count;
    }

//time complexity of O(N²)