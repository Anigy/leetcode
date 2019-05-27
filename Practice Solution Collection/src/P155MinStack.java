import java.util.Stack;

public class P155MinStack {


    /**
     * initialize your data structure here.
     */
    public P155MinStack() {

    }
    public Stack<Integer> data = new Stack<Integer>();
    public Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        if (!data.isEmpty()) {
            int curMin = min.peek();
            data.push(x);
            if (x <= curMin) {
                min.push(x);
            } else {
                min.push(curMin);
            }
        } else {
            data.push(x);
            min.push(x);
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
