package test;

import others.datastructures.BST;
import others.datastructures.TreeNode;
import utilities.MyUtility;

import java.util.LinkedList;
import java.util.Queue;

public class TreeClient {
    public static void main(String[] args){
        String inputStr = "[3,9,20,null,null,15,7]";
        TreeNode root = MyUtility.stringToTreeNode(inputStr);
        new TreeClient().levelOrderTraversel(root);
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
