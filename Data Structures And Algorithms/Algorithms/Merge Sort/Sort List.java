//Given the head of a linked list, return the list after sorting it in ascending order.

 

//Example 1:


//Input: head = [4,2,1,3]
//Output: [1,2,3,4]

    private static ListNode findMid(ListNode head) {
        // find the midpoint of the list
        // if the total number of nodes is even, return the first of mid
        ListNode slow = head, fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null) {
                slow = slow.next;
            }
        }
        return slow;
    }
    
    private static ListNode mergeSort(ListNode head) {
        // trivial cases
        // also the base case of recursion
        if ((head == null) || (head.next == null)) {
            return head;
        }
        
        // step 1: find midpoint, and break the list after midpoint
        ListNode mid = findMid(head);
        ListNode secondHead = mid.next;
        mid.next = null;
        
        // step 2: merge sort the two halves
        head = mergeSort(head);
        secondHead = mergeSort(secondHead);
        
        // step 3: merge the two sorted halves
        head = mergeTwoLists(head, secondHead);
        
        return head;
    }
    
    private static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        else if (head2 == null) {
            return head1;
        }
        
        ListNode dummyHead = new ListNode(0);
        ListNode pMerge = dummyHead;
        ListNode p1 = head1, p2 = head2;
        while ((p1 != null) || (p2 != null)) {
            // if p1 has reached end (is null) then use p2
            if (p1 == null) {
                pMerge.next = p2;
                pMerge = pMerge.next;
                p2 = p2.next;
            }
            // if p2 has reached end (is null) then use p1
            else if (p2 == null) {
                pMerge.next = p1;
                pMerge = pMerge.next;
                p1 = p1.next;
            }
            // otherwise, use the node with the smaller value
            else {
                if (p1.val < p2.val) {
                    pMerge.next = p1;
                    pMerge = pMerge.next;
                    p1 = p1.next;
                }
                else {
                    pMerge.next = p2;
                    pMerge = pMerge.next;
                    p2 = p2.next;
                }
            }
        }
        
        return dummyHead.next;
    }

    public ListNode sortList(ListNode head) {
        // top-down recursive approach
        return mergeSort(head);
    }

// time complexity of O(N log N)