package ca.neu;

public class BinaryTree {

    protected Node root;

    public Node lowestCommonAncestor(Node root, Node a, Node b) {
        if (root == null)
            return null;

        if (root == a || root == b)
            return root;
        Node left = lowestCommonAncestor(root.left,a,b);
        Node right = lowestCommonAncestor(root.right, a,b);

        if(left!=null && right!=null)
            return root;
        if(left == null)
            return right;
        else
            return left;

    }


    public boolean isBST(Node node, int minKey, int maxKey) {

        if (node == null)
            return true;
        if (node.value < minKey || node.value > maxKey)
            return false;

        return (isBST(node.left, minKey, node.value-1) &&
                isBST(node.right, node.value+1, maxKey));
    }

    public int rootToLeafSumWithBST(Node node, int minKey, int maxKey) {

        if (node == null || isBST(node,minKey,maxKey) == false) {
            return 0;
        }
        int left = rootToLeafSumWithBST(node.left,minKey,maxKey);
        int right = rootToLeafSumWithBST(node.right,minKey,maxKey);
        return (left > right ? left: right)+node.value;

    }
}
