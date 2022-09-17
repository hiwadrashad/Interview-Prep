//given the head of a singly linked list, reverse the list, and return the reversed list.

 

//Example 1:


//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]

 public ListNode reverseList(ListNode head) {
         ListNode newHead = null;
         while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

// time complexity of O(N)