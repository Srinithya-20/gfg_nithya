/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int findMedian(Node root) {
        if (root == null) return 0;
        int n = countNodes(root);
        int count = 0;
        Node curr = root;
        Node prev = null;
        Node first = null, second = null;
        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (n % 2 != 0 && count == (n + 1) / 2)
                    return curr.data;
                else if (n % 2 == 0 && (count == n / 2 || count == n / 2 + 1)) {
                    if (first == null) first = curr;
                    else second = curr;
                }
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    count++;
                    if (n % 2 != 0 && count == (n + 1) / 2)
                        return curr.data;
                    else if (n % 2 == 0 && (count == n / 2 || count == n / 2 + 1)) {
                        if (first == null) first = curr;
                        else second = curr;
                    }
                    curr = curr.right;
                }
            }
        }
        if (first != null && second != null) return first.data;
        return 0;
    }

    private int countNodes(Node root) {
        int count = 0;
        Node curr = root, prev;
        while (curr != null) {
            if (curr.left == null) {
                count++;
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    count++;
                    curr = curr.right;
                }
            }
        }
        return count;
    }
}
