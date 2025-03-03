package Алгоритмы.Занятие3;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    public void push(int x) {
        queue.add(x);
        for (var i = 0; i<queue.size()-1; i++){
            var moveElement = queue.poll();
            queue.add(moveElement);
        }
    }
    public int pop() {
        return queue.poll();
    }
    public int top() {
        return queue.peek();
    }
    public boolean empty() {
        return queue.isEmpty();
    }
}
