//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

//The overall run time complexity should be O(log (m+n)).

 

//Example 1:

//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 
 
int firstlen = nums1.length;
int secondlen = nums2.length;
int finallen = firstlen+secondlen;
 
int[] merged = new int[finallen];
 
 
int pointer1 = nums1.length >0 ? 0 : -1;
int pointer2 = nums2.length > 0 ? 0 : -1;
  
 
int index = 0;
 
 while(pointer1 != -1 && pointer1 < firstlen && pointer2 != -1 && pointer2 <secondlen){
 
 
     if(nums1[pointer1] < nums2[pointer2]){
 
         merged[index++] = nums1[pointer1];
        pointer1++;
 
     }else{
 
         merged[index++] = nums2[pointer2];
         pointer2++;
     }
 }
 
    while(pointer1 < firstlen && pointer1 != -1){
 
 
        merged[index++] = nums1[pointer1++];
    }
 
    while(pointer2 < secondlen && pointer2 != -1){
 
        merged[index++] = nums2[pointer2++];
    }
    
 
 
     if(finallen % 2 ==0) return (merged[finallen/2] + merged[(finallen/2) - 1] )/2.0;
 
 
     return merged[finallen/2];
 
 
    }