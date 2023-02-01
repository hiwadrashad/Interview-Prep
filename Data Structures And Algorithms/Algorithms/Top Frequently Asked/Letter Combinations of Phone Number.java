//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

//Example 1:

//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//Example 2:

//Input: digits = ""
//Output: []
//Example 3:

//Input: digits = "2"
//Output: ["a","b","c"]

    String[] keyMapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public void comboRecursive(String digits, String asf, List<String> ans){
        
        if(digits.length()==0){
            ans.add(asf);
            return;
        }
        char firstDigit = digits.charAt(0);
        String digitLeft = digits.substring(1);
        
        String key = keyMapping[Integer.parseInt(""+firstDigit)];
        for(char ch : key.toCharArray()){
            comboRecursive(digitLeft,""+asf+ch,ans);
        }
        
    }
    
    public List<String> letterCombinations(String digits) {
       
        List<String> ans = new ArrayList<>();
         if(digits.equals("")) return ans;
        
        comboRecursive(digits,"",ans);
        return ans;
        
    }