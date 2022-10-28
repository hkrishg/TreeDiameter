import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;

  }
};

class Main {

  public static int diameter;
  public static int diameterOfBinaryTree(TreeNode root) {
    diameter = 0;
    longestPath(root);
    return diameter;
  }

  private static int longestPath(TreeNode node) {
    if (node == null)
      return 0;
    // recursively find the longest path in
    // both left child and right child
    int leftPath = longestPath(node.left);
    int rightPath = longestPath(node.right);

    // update the diameter if left_path plus right_path is larger
    diameter = Math.max(diameter, leftPath + rightPath + 1);

    // return the longest one between left_path and right_path;
    // remember to add 1 for the path connecting the node and its parent
    return Math.max(leftPath, rightPath) + 1;
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.right.left = new TreeNode(5);
    root1.right.right = new TreeNode(6);
    System.out.println(Main.diameterOfBinaryTree(root1));
  }
}