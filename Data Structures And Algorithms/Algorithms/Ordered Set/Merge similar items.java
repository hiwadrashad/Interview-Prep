You are given two 2D integer arrays, items1 and items2, representing two sets of items. Each array items has the following properties:

//items[i] = [valuei, weighti] where valuei represents the value and weighti represents the weight of the ith item.
//The value of each item in items is unique.
//Return a 2D integer array ret where ret[i] = [valuei, weighti], with weighti being the sum of weights of all items with value valuei.

//Note: ret should be returned in ascending order by value.

 

//Example 1:

//Input: items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
//Output: [[1,6],[3,9],[4,5]]
//Explanation: 
//The item with value = 1 occurs in items1 with weight = 1 and in items2 with weight = 5, total weight = 1 + 5 = 6.
//The item with value = 3 occurs in items1 with weight = 8 and in items2 with weight = 1, total weight = 8 + 1 = 9.
//The item with value = 4 occurs in items1 with weight = 5, total weight = 5.  
//Therefore, we return [[1,6],[3,9],[4,5]].

  public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
    TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int[] it : items1) {
            cnt.merge(it[0], it[1], Integer::sum);
        }
        for (int[] it : items2) {
            cnt.merge(it[0], it[1], Integer::sum);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            ans.add(Arrays.asList(e.getKey(), e.getValue()));
        }
        return ans;
    }

//time complexity O(N)