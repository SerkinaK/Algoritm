package Algorithms.Lesson3;


import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }
    public void push(int val) {
        stack.push(val);
        if (minstack.empty() || minstack.peek() >=val){
            minstack.push(val);
        }
    }
    public void pop() {
        if (minstack.peek().equals(stack.peek())){
            minstack.pop();
        }
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minstack.peek();

    }
}



