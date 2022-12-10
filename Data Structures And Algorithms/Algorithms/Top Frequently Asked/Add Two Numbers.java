//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

//Example 1:


//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        
        ListNode result = new ListNode();
        ListNode ans = result;
        int carry=0;
        while(l1 != null && l2 != null){
            
            int sum = carry + l1.val + l2.val;
            int digit = sum%10;
            carry = sum/10;
            
            l1 = l1.next;
            l2 = l2.next;
            
           result.next = new ListNode(digit);   
            result = result.next;
        }
        
        while(l1 != null){
            int sum = carry + l1.val;
            int digit = sum%10;
            carry = sum/10;
            result.next = new ListNode(digit);
            l1 = l1.next;
            result = result.next;
        } 
        
        while(l2 != null){
            int sum = carry + l2.val;
            int digit = sum%10;
            carry = sum/10;
            result.next = new ListNode(digit);
            l2 = l2.next;
            result = result.next;
        } 
        
        if(carry != 0){
            result.next = new ListNode(carry);
        }
        
        return ans.next;
    }