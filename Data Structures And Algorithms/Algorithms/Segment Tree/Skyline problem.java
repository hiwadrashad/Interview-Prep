//A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.

//The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:

//lefti is the x coordinate of the left edge of the ith building.
//righti is the x coordinate of the right edge of the ith building.
//heighti is the height of the ith building.
//You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

//The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.

//Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]

 

//Example 1:


//Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
//Explanation:
//Figure A shows the buildings of the input.
//Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.

  public List<List<Integer>> getSkyline(int[][] buildings) {
    final int n = buildings.length;
    if (n == 0)
      return new ArrayList<>();
    if (n == 1) {
      final int left = buildings[0][0];
      final int right = buildings[0][1];
      final int height = buildings[0][2];
      List<List<Integer>> ans = new ArrayList<>();
      ans.add(new ArrayList<>(Arrays.asList(left, height)));
      ans.add(new ArrayList<>(Arrays.asList(right, 0)));
      return ans;
    }

    List<List<Integer>> leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
    List<List<Integer>> rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));
    return merge(leftSkyline, rightSkyline);
  }

  private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
    List<List<Integer>> ans = new ArrayList<>();
    int i = 0; // left's index
    int j = 0; // right's index
    int leftY = 0;
    int rightY = 0;

    while (i < left.size() && j < right.size())
      // Choose the point with smaller x
      if (left.get(i).get(0) < right.get(j).get(0)) {
        leftY = left.get(i).get(1); // Update the ongoing leftY
        addPoint(ans, left.get(i).get(0), Math.max(left.get(i++).get(1), rightY));
      } else {
        rightY = right.get(j).get(1); // Update the ongoing rightY
        addPoint(ans, right.get(j).get(0), Math.max(right.get(j++).get(1), leftY));
      }

    while (i < left.size())
      addPoint(ans, left.get(i).get(0), left.get(i++).get(1));

    while (j < right.size())
      addPoint(ans, right.get(j).get(0), right.get(j++).get(1));

    return ans;
  }

  private void addPoint(List<List<Integer>> ans, int x, int y) {
    if (!ans.isEmpty() && ans.get(ans.size() - 1).get(0) == x) {
      ans.get(ans.size() - 1).set(1, y);
      return;
    }
    if (!ans.isEmpty() && ans.get(ans.size() - 1).get(1) == y)
      return;
    ans.add(new ArrayList<>(Arrays.asList(x, y)));
  }

  //time complexity of N(Log N)