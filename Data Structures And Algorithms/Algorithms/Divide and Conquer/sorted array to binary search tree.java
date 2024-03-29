//Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

//A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 

//Example 1:


//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        
        TreeNode head = helper(nums,0,nums.length-1);
        
        return head;
    }
    
    public TreeNode helper(int[] nums,int low,int high){
        if(low>high)
            return null;
        
        int mid = (low+high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,low,mid-1);
        node.right = helper(nums,mid+1,high);
        
        return node;
    }

  