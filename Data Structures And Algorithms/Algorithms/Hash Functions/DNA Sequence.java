//The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

//For example, "ACGAATTCCG" is a DNA sequence.
//When studying DNA, it is useful to identify repeated sequences within the DNA.

//Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 

//Example 1:

//Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//Output: ["AAAAACCCCC","CCCCCAAAAA"]
//Example 2:

//Input: s = "AAAAAAAAAAAAA"
//Output: ["AAAAAAAAAA"]

 public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> list = new ArrayList<>();
        
        if(s == null || s.length()<=10){
            return list;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i<=s.length()-10 ; i++){
            
            String current = s.substring(i,i+10);
            map.put(current, map.getOrDefault(current,0)+1);
        }
		
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            
            if(entry.getValue()>=2){
                list.add(entry.getKey());
            }
            
        } 
        return list;
    }

// time complexity of O(N)