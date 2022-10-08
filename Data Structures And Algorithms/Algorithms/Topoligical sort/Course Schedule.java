//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.

 

//Example 1:

//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
//Example 2:

//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 
  public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        int n = numCourses;
        int[] vis = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) map.put(i, new ArrayList<Integer>());
        for (int[] p : prerequisites) {
            map.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < n; ++i) {
            if (!dfs(i, vis, map)) return false;
        }
        return true;
    }

    private boolean dfs(int i, int[] vis, Map<Integer, List<Integer>> map) {
        if (vis[i] == 1) return false;
        if (vis[i] == 2) return true;
        vis[i] = 1;
        for (int next : map.get(i)) {
            if (!dfs(next, vis, map)) return false;
        }
        vis[i] = 2;
        return true;
    }

// time complexity of O(N)