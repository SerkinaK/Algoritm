package Алгоритмы.Занятие3;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue(){
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        moveElements();
        return out.pop();
    }
    public int peek() {
        moveElements();
        return out.peek();
    }
    public boolean empty() {
        return in.empty() && out.empty();
    }
    private void moveElements(){
        if (out.empty()) {
            while (!in.empty()) {
                var moveElement = in.pop();
                out.add(moveElement);
            }
        }
    }
}
