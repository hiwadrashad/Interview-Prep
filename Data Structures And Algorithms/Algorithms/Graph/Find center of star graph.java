// a star graph is a graph in which their is a center node which is connected with all the edges
//There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

//You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

 

//Example 1:


//Input: edges = [[1,2],[2,3],[4,2]]
//Output: 2
//Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.

   HashMap<Integer, Integer> map = new HashMap<>();
                        
                        // incrementing u and v count to calculate degrees
                        for(int[] a : edges) {
                            map.put(a[0], map.getOrDefault(a[0], 0) + 1);
                            map.put(a[1], map.getOrDefault(a[1], 0) + 1);
                        }
                        
                        // the center node will have max degree (i.e degree > 1)
                        // this is because all other nodes will be having degree equal to 1
                        int ans = -1;
                        for(int key : map.keySet()) {
                            if(map.get(key) > 1) {
                                ans = key;
                                break;
                            }
                        }
                        return ans;

//time complexity of O(N)