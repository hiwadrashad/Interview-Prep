//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

//Example 1:

//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
//Example 2:

//Input: n = 1
//Output: ["()"]

 public List<String> generateParenthesis(int n) {
    ArrayList<String> res = new ArrayList<String>();
	if(n <= 0){
	    return res;
	}
	
	generate("", n, 0, res);
	
	return res;
}

public void generate(String str, int left, int right, ArrayList<String> res){
    if(right == 0 && left == 0){
        res.add(str);
    }
    
    if(right > 0){
        generate(str+")", left, right-1, res);
    }
    if(left > 0){
        generate(str+"(", left-1, right+1, res);
    }
}
