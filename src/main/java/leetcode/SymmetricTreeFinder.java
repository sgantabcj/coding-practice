package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SymmetricTreeFinder {
    public static void main(String[] args){
        SymmetricTreeFinder stf = new SymmetricTreeFinder();
        System.out.println("Enter the tree values separated by \",\" enclosed in square brackets eg:\"[x,y,z,...]\"");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        TreeNode root = stringToTreeNode(input);
        boolean isSymmetric = stf.isSymmetricUsingRecursion(root);
        System.out.println("Is given tree: "+input+" symmetric: "+isSymmetric);
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    //using recursion
    public boolean isSymmetricUsingRecursion(TreeNode n){
        return isMirror(n.left,n.right);
    }
    public boolean isMirror(TreeNode ln, TreeNode rn){
        if(ln == null && rn == null) return true;
        if(ln == null || rn == null) return false;
        return (ln.val == rn.val)
                && isMirror(ln.left,rn.right)
                && isMirror(ln.right,rn.left);
    }

    static class TreeNode{
        TreeNode left,right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }

//    //using iteration
//    public boolean isSymmetricUsingIteration(TreeNode n){
//        if(ln == ) return true;
//        if(ln == null || rn == null) return false;
//    }
}
