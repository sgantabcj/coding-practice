package leetcode;

import others.datastructures.TreeNode;
import utilities.MyUtility;

import java.util.Scanner;

public class SymmetricTreeFinder {
    public static void main(String[] args) {
        SymmetricTreeFinder stf = new SymmetricTreeFinder();
        System.out.println("Enter the tree values separated by \",\" enclosed in square brackets eg:\"[x,y,z,...]\"");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        TreeNode root = MyUtility.stringToTreeNode(input);
        boolean isSymmetric = stf.isSymmetricUsingRecursion(root);
        System.out.println("Is given tree: " + input + " symmetric: " + isSymmetric);
    }

    //using recursion
    public boolean isSymmetricUsingRecursion(TreeNode n) {
        return isMirror(n.left, n.right);
    }

    public boolean isMirror(TreeNode ln, TreeNode rn) {
        if (ln == null && rn == null) return true;
        if (ln == null || rn == null) return false;
        return (ln.val == rn.val)
                && isMirror(ln.left, rn.right)
                && isMirror(ln.right, rn.left);
    }

//    //using iteration
//    public boolean isSymmetricUsingIteration(TreeNode n){
//        if(ln == ) return true;
//        if(ln == null || rn == null) return false;
//    }
}
