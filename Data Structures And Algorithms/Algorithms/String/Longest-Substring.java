import java.util.List;
//Notes
//.toCharArray to convert string to chars
// List should take fulll name as generic parameter like List<Integer>
// List should be initialized as = new ArrayList<Integer>()
// array can be indexed with Char, default value is 0 inside integer array
// Custom
class Solution {
    public int lengthOfLongestSubstring(String s) {
           List<Integer> countlengths = new ArrayList<Integer>();
        int currentlength = 0;
        char[] chars = s.toCharArray();
        List<Character> previouslyseencharacters = new ArrayList<Character>();
        for(int i = 0; i < chars.length;i++ )
        {
           if(previouslyseencharacters.contains(chars[i]))
           {
               previouslyseencharacters = new ArrayList();
               previouslyseencharacters.add(chars[i]);
               countlengths.add(currentlength);
               currentlength = 0;
               continue;
           }
           currentlength = currentlength + 1;
           previouslyseencharacters.add(chars[i]);
        }
        countlengths.add(currentlength);
        int returnanswer = 0;
        for (int x = 0; x < countlengths.size(); x++)
        {
           if (countlengths.get(x) > returnanswer)
           {
               returnanswer = countlengths.get(x);
           }
            
        }
        return returnanswer;
    }
}

//FAULTY
// time complexity is O(n)

//Brute Force
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    private boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }

        return true;
    }
// time complexity = O(∑ i=0 n−1 (∑ j=i+1 n (j−i)))=O(∑ i=0 n−1 2 (1+n−i)(n−i))=O(n^3)
// space complexity = O(min(n,m))
}