/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int nodeSum(Node root, int l, int r) {
        if (root == null) return 0;
        if (root.data < l) {
            return nodeSum(root.right, l, r);
        } else if (root.data > r) {
            return nodeSum(root.left, l, r);
        } else {
            return root.data + nodeSum(root.left, l, r) + nodeSum(root.right, l, r);
        }
    }
}
