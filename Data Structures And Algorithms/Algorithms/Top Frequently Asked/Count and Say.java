//The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

//countAndSay(1) = "1"
//countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
//To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

//For example, the saying and conversion for digit string "3322251":


//Given a positive integer n, return the nth term of the count-and-say sequence.

 

//Example 1:

//Input: n = 1
//Output: "1"
//Explanation: This is the base case.
//Example 2:

//Input: n = 4
//Output: "1211"
//Explanation:
//countAndSay(1) = "1"
//countAndSay(2) = say "1" = one 1 = "11"
//countAndSay(3) = say "11" = two 1's = "21"
//countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

  public static String generator(String str)
  {
    String ans = "";
 
    HashMap<Character, Integer>tempCount = new HashMap<>(); 
    // It is used to count integer sequence
 
    for (int i = 0; i < str.length() + 1; i++) {
      // when current char is different from prev one we
      // clear the map and update the ans
      if (i == str.length()  || tempCount.containsKey(str.charAt(i)) == false && i > 0) {
        ans += String.valueOf(tempCount.get(str.charAt(i-1))) + str.charAt(i-1);
        tempCount.clear();
      }
      // when current char is same as prev one we increase
      // it's count value
 
      if(i == str.length()){
        tempCount.put(null, 1);
      }
      else{
        if(tempCount.containsKey(str.charAt(i))){
          tempCount.put(str.charAt(i), tempCount.get(str.charAt(i))+1);
        }
        else{
          if(i != str.length())tempCount.put(str.charAt(i), 1);
        }
      }
    }
    return ans;
  }
 
  public String countAndSay(int n)
  {
    String res = "1"; // res variable keep tracks of string
    // from 1 to n-1
 
    // For loop iterates for n-1 time and generate strings
    // in sequence "1" -> "11" -> "21" -> "1211"
    for (int i = 1; i < n; i++) {
      res = generator(res);
    }
 
    return res;
  }