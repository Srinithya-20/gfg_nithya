/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        postOrderHelper(root, res);
        return res;
    }
    
    private void postOrderHelper(Node root, ArrayList<Integer> res) {
        if (root == null) return;
        postOrderHelper(root.left, res);
        postOrderHelper(root.right, res);
        res.add(root.data);
    }
}
