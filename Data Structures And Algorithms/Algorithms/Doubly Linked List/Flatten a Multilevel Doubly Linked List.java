//You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

//Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

//Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

 

//Example 1:


//Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//Output: [1,2,3,7,8,11,12,9,10,4,5,6]
//Explanation: The multilevel linked list in the input is shown.
//After flattening the multilevel linked list it becomes:

    private Node getChildTail(Node head)
    {
        if(head == null)
            return head;
        
        // Find the last child node
        while(head.next != null)
            head = head.next;
        
        return head;
    }
    
    
    public Node flatten(Node head) {
        
        if(head == null)
            return head;
        
        // Making n as a temp node 
        Node n = head;
        
        while(n != null)
        {
            if(n.child != null)
            {
                
            // using getChildTail recursive function to return tail of child doubly linked list
            Node child_tail = getChildTail(n.child);
        
            // After ensuring temp node is not null
            // Setting next's prev node as child tail
            if(n.next != null)
                n.next.prev = child_tail;
            
            child_tail.next = n.next;
            n.next = n.child;
            n.child.prev = n;
            
            // Remove pointer to child node
            n.child = null;
            }
            n = n.next;
        }
        return head;
    }
    

// Time complexity of O(N)
