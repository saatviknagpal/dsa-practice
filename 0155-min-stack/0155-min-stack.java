public class MinStack {
    Stack<Integer> stack;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        min = Math.min(min, x);
        stack.push(x);
        stack.push(min);
    }

    public void pop() {
        stack.pop();
        stack.pop();
        min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
    }

    public int top() {
        int temp = stack.pop();
        int res = stack.peek();
        stack.push(temp);
        return res;
    }

    public int getMin() {
        return stack.peek();
    }
}
