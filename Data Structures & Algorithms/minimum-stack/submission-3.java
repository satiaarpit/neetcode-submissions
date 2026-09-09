class MinStack {

    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        Pair p = new Pair();
        p.value = val;
        if(stack.isEmpty() || val < stack.peek().currentMin)   {
            p.currentMin = val;
        } else  {
            p.currentMin = stack.peek().currentMin;
        }
        stack.push(p);
    }
    
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek().value;
    }
    
    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek().currentMin;
    }

    class Pair  {
        int value;
        int currentMin;
    }
}
