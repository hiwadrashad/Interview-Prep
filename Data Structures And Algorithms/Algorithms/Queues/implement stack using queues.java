//Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

//Implement the MyStack class:

//void push(int x) Pushes element x to the top of the stack.
//int pop() Removes the element on the top of the stack and returns it.
//int top() Returns the element on the top of the stack.
//boolean empty() Returns true if the stack is empty, false otherwise.

    Queue<Integer> q = new LinkedList<Integer>();

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());    
        }
    }

    public void pop() {
        q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

// time complexity is O(N)