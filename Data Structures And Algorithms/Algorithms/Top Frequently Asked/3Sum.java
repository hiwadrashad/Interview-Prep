//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

//Notice that the solution set must not contain duplicate triplets.

 

//Example 1:

//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:

//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:

//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.

  static boolean binary_search(int l,int r,int[]nums, int x)
    {
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(nums[mid]==x) return true;
            else if(nums[mid]>x) r=mid-1;
            else l=mid+1;
        }
        return false;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
       
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(binary_search(j+1,n-1,nums,-(nums[i]+nums[j])))
                {
                    List<Integer> t=new  ArrayList<Integer>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(-(nums[i]+nums[j]));
                    ans.add(t);
                }
                
                while(j+1<n && nums[j+1]==nums[j]) j++;
            }
            
            while(i+1<n && nums[i+1]==nums[i]) i++;
        }
        
        return ans;  
    }