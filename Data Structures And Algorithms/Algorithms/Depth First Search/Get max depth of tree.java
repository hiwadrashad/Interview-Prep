// Given the root of a binary tree, return its maximum depth.
//A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
  public int maxDepth(TreeNode root) {
      if (root == null)
      {
          return 0;
      }
      
      int lh = maxDepth(root.left);
      int rh = maxDepth(root.right);
      
      return 1 + Math.max(lh,rh);
  }
}

// big o of O(n) as all the nodes need to be traversed