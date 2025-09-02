/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null) return null;

        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        if (k > n) return head;
        if (2 * k - 1 == n) return head;

        Node prevStart = null, kthFromStart = head;
        for (int i = 1; i < k; i++) {
            prevStart = kthFromStart;
            kthFromStart = kthFromStart.next;
        }

        Node prevEnd = null, kthFromEnd = head;
        for (int i = 1; i < n - k + 1; i++) {
            prevEnd = kthFromEnd;
            kthFromEnd = kthFromEnd.next;
        }

        if (prevStart != null) {
            prevStart.next = kthFromEnd;
        } else {
            head = kthFromEnd;
        }

        if (prevEnd != null) {
            prevEnd.next = kthFromStart;
        } else {
            head = kthFromStart;
        }

        Node tempNext = kthFromStart.next;
        kthFromStart.next = kthFromEnd.next;
        kthFromEnd.next = tempNext;

        return head;
    }
}
