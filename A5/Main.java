package ca.neu;

public class Main {

    public static void main(String[] args) {
        //BinaryTreeSolution tree = new BinaryTreeSolution();
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1, 10);
        tree.root.left = new Node(2, 8);
        tree.root.right = new Node(3, 18);
        tree.root.left.left = new Node(4, 6);
        tree.root.left.right = new Node(5, 9);
        tree.root.right.left = new Node(6, 16);
        tree.root.right.right = new Node(7, 20);
        tree.root.right.left.left = new Node(8, 14);
        tree.root.right.right.right = new Node(9, 24);
        tree.root.right.left.left.left = new Node(10, 12);

        System.out.println("LCA of 3 and 10 is node " + tree.lowestCommonAncestor(tree.root, tree.root.right, tree.root.right.left.left.left).id);
        System.out.println("LCA of 4 and 5 is node " + tree.lowestCommonAncestor(tree.root, tree.root.left.left, tree.root.left.right).id);
        System.out.println("LCA of 2 and 4 is node  " + tree.lowestCommonAncestor(tree.root, tree.root.left, tree.root.left.left).id);

        int rootToLeafMaxSum = tree.rootToLeafSumWithBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (rootToLeafMaxSum > 0) {
            System.out.println("Our Binary Tree is also a Binary Search Tree with maximum root to leaf sum of " + rootToLeafMaxSum);
        } else {
            System.out.println("Our tree is not a binary tree");
        }
    }
}
