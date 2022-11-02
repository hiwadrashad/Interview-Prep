//You are given a string s. You can convert s to a palindrome by adding characters in front of it.

//Return the shortest palindrome you can find by performing this transformation.

 

//Example 1:

//Input: s = "aacecaaa"
//Output: "aaacecaaa"

    public String shortestPalindrome(String s) {
           String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] next = getTable(temp);
        return new StringBuilder(s.substring(next[next.length - 1] + 1)).reverse().toString() + s;
    }

    public int[] getTable(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;

        while (j < s.length() - 1) {
            if (k == -1 || s.charAt(j) == s.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

// time complexity of O(N)