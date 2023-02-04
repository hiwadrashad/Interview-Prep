//Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

//Example 1:


//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//Example 2:

//Input: head = [1], n = 1
//Output: []
//Example 3:

//Input: head = [1,2], n = 1
//Output: [1]

 ListNode removeNthFromEnd(ListNode head, int B)
{
    // To store length of the linked list
    int len = 0;
    ListNode tmp = head;
    while (tmp != null)
    {
        len++;
        tmp = tmp.next;
    }
     
    // B > length, then we can't remove node
    if (B > len)
    {
        System.out.print("Length of the linked list is " + len);
        System.out.print(" we can't remove "+ B +
                         "th node from the");
        System.out.print(" linked list\n");
        return head;
    }
     
    // We need to remove head node
    else if (B == len)
    {
         
        // Return head.next
        return head.next;
         
    }
    else
    {
        // Remove len - B th node from starting
        int diff = len - B;        
        ListNode prev= null;    
        ListNode curr = head;        
        for(int i = 0; i < diff; i++)
        {
            prev = curr;        
            curr = curr.next;    
        }
        prev.next = curr.next;
        return head;
    }