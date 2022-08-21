//Given a binary tree, find its minimum depth.

//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
        {
            return 0;
        }
        
        int lh = minDepth(root.left);
        int rh = minDepth(root.right);
        
        return (lh == 0 || rh == 0) ? lh + rh + 1 : Math.min(lh,rh)+1; 
    }

// big O of O(N)