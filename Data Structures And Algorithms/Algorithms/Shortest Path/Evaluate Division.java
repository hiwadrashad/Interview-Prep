//You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

//You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

//Return the answers to all queries. If a single answer cannot be determined, return -1.0.

//Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

    private static double[] calcEquation(List<List<String>> equations, double[] values,
                                         List<List<String>> queries) {
        // Build the graph
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            // From source to destination the weight of edge is values[i]
            if (graph.containsKey(from)) {
                graph.get(from).put(to, values[i]);
            } else {
                HashMap<String, Double> map = new HashMap<>();
                map.put(to, values[i]);
                graph.put(from, map);
            }
            // From destination to source the weight of edge is (1 / values[i])
            if (graph.containsKey(to)) {
                graph.get(to).put(from, 1 / values[i]);
            } else {
                HashMap<String, Double> map = new HashMap<>();
                map.put(from, 1 / values[i]);
                graph.put(to, map);
            }
        }
        // Solve queries
        double ans[] = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            // Visited set
            HashSet<String> visited = new HashSet<>();
            ans[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), visited);
        }
        return ans;
    }
    private static double dfs(HashMap<String, HashMap<String, Double>> graph, String from, String to,
                              HashSet<String> visited) {
        // Source not found
        if (!graph.containsKey(from)) {
            return -1.0;
        }
        // Direct edge
        if (graph.get(from).containsKey(to)) {
            return graph.get(from).get(to);
        }
        // Mark source as visited
        visited.add(from);
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            if (!visited.contains(entry.getKey())) {
                // For all unvisited neighbors of source do dfs
                // neighbor becomes the source and destination remains same
                double ans = dfs(graph, entry.getKey(), to, visited);
                if (ans != -1.0) {
                    // If ans of any neighbor is not -1, return (edge weight * ans of neighbor)
                    return (ans * entry.getValue());
                }
            }
        }
        // All neighbors returned -1, return -1
        return -1.0;
    }

//time complexity O(N)