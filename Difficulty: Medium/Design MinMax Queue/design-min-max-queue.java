import java.util.*;

class SpecialQueue {
    private Deque<Integer> queue;
    private Deque<Integer> minDeque;
    private Deque<Integer> maxDeque;

    public SpecialQueue() {
        queue = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
        maxDeque = new ArrayDeque<>();
    }

    public void enqueue(int x) {
        queue.addLast(x);
        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.addLast(x);
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.addLast(x);
    }

    public void dequeue() {
        if (queue.isEmpty()) return;
        int val = queue.pollFirst();
        if (!minDeque.isEmpty() && minDeque.peekFirst() == val) {
            minDeque.pollFirst();
        }
        if (!maxDeque.isEmpty() && maxDeque.peekFirst() == val) {
            maxDeque.pollFirst();
        }
    }

    public int getFront() {
        return queue.peekFirst();
    }

    public int getMin() {
        return minDeque.peekFirst();
    }

    public int getMax() {
        return maxDeque.peekFirst();
    }
}
