//You are given an array of strings products and a string searchWord.

//Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

//Return a list of lists of the suggested products after each character of searchWord is typed.

 

//Example 1:

//Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
//Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
//Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
//After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
//After typing mou, mous and mouse the system suggests ["mouse","mousepad"].

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie trie = new Trie();
    for(String product : products){                                                     // update trie data-structure with all products,
      trie.insert(product);                                                           // by inserting each product to trie
    }
    return trie.search(trie, 3, searchWord, new ArrayList<List<String>>() );            // search in Trie, and keep updating final list 
  }
  // ==================================================== Trie data-structure ====================================================== //
  class Trie {
    TrieNode root;
    public Trie() {                                                                     // Trie Constructor    
      root = new TrieNode(' ');                                                       // Create root node, with ' ' as val.  
    }
    // ----------------------------------------------------------------- 
    public List<List<String>> search(Trie trie, int count, String searchWord, List<List<String>> resultList){         // search in Trie, and keep updating final list    
      for(int i = 1; i <= searchWord.length(); i++){
        List<String> list = new ArrayList<String>();
        TrieNode node = trie.root;
        String typedSoFar = searchWord.substring(0, i);
        node = reachLastCharOfPrefix(typedSoFar, count, node );                      // call method to first reach last node of current substring (prefix)
        list = depthFirstSearch(node, list, count);                                  // call *DFS* to search further on all chilren of node
        resultList.add(list); 
      }
      return resultList;
    }
    // -----------------------------------------------------------------
    public List<String> depthFirstSearch(TrieNode node, List<String> list, int count){
      if(node == null || list.size() >= count){ return list; }                          // if node is null, or, List got 3 strings by now, return list.  Don't forget "node == null"
      if(! node.word.isEmpty()){ list.add(node.word); }                                 // if node's word is not Empty, we have found the word. add it to list, and continue further
      for(TrieNode childNode : node.children){
        if(childNode == null){ continue; }
        list = depthFirstSearch(childNode, list, count);                              // call DFS/recursion on childNode  
      }                        
      return list;
    }
    // -----------------------------------------------------------------
    public TrieNode reachLastCharOfPrefix(String prefix, int count, TrieNode node) {
      for(int i = 0; i < prefix.length(); i++){
        char ch = prefix.charAt(i);
        if(node.children[ch - 'a'] == null){ return null; }
        node = node.children[ch - 'a'];
      }
      return node;
    }
    // -----------------------------------------------------------------
    public void insert(String word) {                                                     // Let's we are inserting word "mobile"
      TrieNode node = this.root; 
      for(int i = 0; i < word.length(); i++){                                           // loop through each char of word
        char ch = word.charAt(i);                                                     // let's say first char is 'm' which is to be inserted
        if(node.children[ch - 'a'] == null){                                          // if child exists at children[m - 'a']. children[109-97] = children[12]
          node.children[ch - 'a'] = new TrieNode(ch);                               // then insert new TrieNode object of value 'm' at children[12] 
        }
        node = node.children[ch - 'a'];                                               // go to next child node
      }
      node.word = word;    
    }
    // ========================= class TrieNode ======================== //
    static class TrieNode{
      char val;                                                                         // node's char value e.g. 'm'
      TrieNode[] children;                                                              // each node can have upto 26 children.
      String word = "";
      TrieNode(char val){                                                               // pass val in the constructor              
        this.val = val;
        children = new TrieNode[26];                                                  // because every child is of char type. we have 26 characters.
      }
    }
  }

  //  time complexity of O(N)