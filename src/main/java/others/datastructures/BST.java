package others.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BST extends TreeNode {
    TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insert(int val) {
        if (val <= this.val) {
            if (left == null) {
                left = new TreeNode(val);
            } else {
                ((BST) left).insert(val);
            }
        } else {
            if (right == null) {
                right = new TreeNode(val);
            } else {
                ((BST) right).insert(val);
            }
        }
    }

    //Level order or Depth First traversal
    public void levelOrderTraversel(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root == null) return;
        nodeQueue.add(root);
        TreeNode currNode;
        while (!nodeQueue.isEmpty()) {
            currNode = nodeQueue.remove();
            System.out.println(currNode.val);
            if (currNode.left != null) nodeQueue.add(currNode.left);
            if (currNode.right != null) nodeQueue.add(currNode.right);
        }
    }
}

