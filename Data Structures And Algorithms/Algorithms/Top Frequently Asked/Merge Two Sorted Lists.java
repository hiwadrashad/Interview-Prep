//You are given the heads of two sorted linked lists list1 and list2.

//Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

//Return the head of the merged linked list.

 

//Example 1:


//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:

//Input: list1 = [], list2 = []
//Output: []
//Example 3:

//Input: list1 = [], list2 = [0]
//Output: [0]
 

 
    public ListNode mergeTwoLists(ListNode h1, ListNode h2)
    {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
  
        // start with the linked list
        // whose head data is the least
        if (h1.val < h2.val) {
            h1.next = mergeTwoLists(h1.next, h2);
            return h1;
        }
        else {
            h2.next = mergeTwoLists(h1, h2.next);
            return h2;
        }
    }