//Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.

//Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".

 

//Example 1:

//Input: s = "banana"
//Output: "ana"

    public String longestDupSubstring(String S) {
          String res = "";
    int l = 0, r = 0;
    HashSet<String> memo = new HashSet<>();
    String before = null;
    int beforeIndex = 0;
    int len = S.length();
    while (l < len && r < len) {
        if (before == null || l != beforeIndex) {
            before = S.substring(l + 1);
            beforeIndex = l;
        }
        String t = S.substring(l, r + 1);
        if (!memo.contains(t) && before.contains(t)) {
            r++;
            if (r - l > res.length()) {
                res = S.substring(l, r);
            }
        } else {
            l++;
            r = l + res.length();
        }
        memo.add(t);
    }
    return res;  
    }