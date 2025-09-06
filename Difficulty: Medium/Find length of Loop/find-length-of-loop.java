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
    public int lengthOfLoop(Node head) {
        if (head == null) return 0;
        
        Node slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) { 
                return countLoopLength(slow);
            }
        }
        
        return 0;
    }
    
    private int countLoopLength(Node node) {
        Node temp = node;
        int count = 1;
        
        while (temp.next != node) {
            count++;
            temp = temp.next;
        }
        
        return count;
    }
}
