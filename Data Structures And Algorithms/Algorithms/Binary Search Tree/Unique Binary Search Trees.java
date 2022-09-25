//Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

//Example 1:


//Input: n = 3
//Output: 5

    public int numTrees(int n) {
           int [] dp = new int[n+1];
    dp[0]= 1;
    dp[1] = 1;
    for(int level = 2; level <=n; level++)
        for(int root = 1; root<=level; root++)
            dp[level] += dp[level-root]*dp[root-1];
    return dp[n];
    }

// time complexity of O(N²)