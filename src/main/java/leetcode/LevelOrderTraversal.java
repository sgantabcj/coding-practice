package leetcode;

import java.util.*;

public class LevelOrderTraversal {
    private boolean isBalanced = true;

    public static void main(String[] args) {
        Integer[] input = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = getTree(input);
        LevelOrderTraversal lot = new LevelOrderTraversal();
        /*printTree(root);
        System.out.println("Maximum depth of the given tree: " + Arrays.toString(input) + " is: " + new LevelOrderTraversal().getMaxDepth(root));
        System.out.println("Test: Given array: " + Arrays.toString(input) + " Tree converted to array: " + Arrays.toString(treeToArray(root)));
        System.out.println("Balanced BST tree from given: " + Arrays.toString(input) + " is: ");
        printTree(getHeightBalancedBST(input));*/

        //To test if given tree is height balanced tree
        //positive test case - [3,9,20,null,null,15,7]
        //negative test case - [1,2,2,3,3,null,null,4,4]
//        System.out.println("Is given tree: " + Arrays.toString(input) + " is balanced: " + lot.isTreeBalanced(root));

        //To get the min depth of the tree
//        System.out.println("The min depth of given tree is: "+lot.minDepth(root));

        //To find if a sum is present in a tree where the sum of all the values from root to leaf is equal to given sum
        int reqSum = 22;
        printTree(root);
        System.out.println("Does given tree contains the sum: "+reqSum+" - "+lot.hasPathSum(root,reqSum));
    }

    private static TreeNode getTree(Integer[] input) {
        if (input.length == 0) return null;
        TreeNode root = new TreeNode(input[0]);
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        int index = 1;
        TreeNode currNode;
        while (!nodeQ.isEmpty()) {
            currNode = nodeQ.poll();

            if (index == input.length) {
                break;
            }

            if (input[index] != null) {
                currNode.left = new TreeNode(input[index]);
                nodeQ.add(currNode.left);
            }
            index++;

            if (index == input.length) {
                break;
            }

            if (input[index] != null) {
                currNode.right = new TreeNode(input[index]);
                nodeQ.add(currNode.right);
            }
            index++;
        }
        return root;
    }

    private static TreeNode getHeightBalancedBST(Integer[] input) {
        if (input.length == 0) return null;
        int length = input.length;
        TreeNode root = new TreeNode(input[length / 2]);
        TreeNode currNode = null;
        for (int i = 0; i < length / 2; i++) {
            TreeNode left = root.left;
            if (left != null) {
                left.insert(input[i]);
            } else {
                root.left = new TreeNode(input[i]);
            }
        }
        for (int i = (length / 2) + 1; i < length; i++) {
            TreeNode right = root.right;
            if (right != null) {
                right.insert(input[i]);
            } else {
                root.right = new TreeNode(input[i]);
            }
        }
        return root;
    }

    private static Integer[] treeToArray(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        List<Integer> retVal = new ArrayList<>();
        TreeNode currNode;
        while (!nodeQ.isEmpty()) {
            currNode = nodeQ.poll();
            if (currNode != null) {
                retVal.add(currNode.val);
                if (currNode.left != null) nodeQ.add(currNode.left);
                if (currNode.right != null) nodeQ.add(currNode.right);
            }
        }
        return retVal.toArray(new Integer[0]);
    }

    private static void printTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> nextToVisitQ = new LinkedList<>();
        nextToVisitQ.addFirst(root);
        TreeNode currNode;
        while (!nextToVisitQ.isEmpty()) {
            int length = nextToVisitQ.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                currNode = nextToVisitQ.pollLast();
                if (currNode != null) {
                    currLevel.add(currNode.val);
                    nextToVisitQ.addFirst(currNode.left);
                    nextToVisitQ.addFirst(currNode.right);
                } else {
                    currLevel.add(null);
                }
            }
            result.add(currLevel);
        }
        int maxHeight = result.size();
        int currIntLevel = 1;
        for (List<Integer> currLevel : result) {
            for (Integer currNodeVal : currLevel) {
                if (currNodeVal != null) {
                    System.out.print(currNodeVal + " ");
                } else {
                    System.out.print("  ");
                }
            }
            currIntLevel++;
            System.out.println();
        }
    }

/*
    private static void printTree(TreeNode root){
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        TreeNode currNode = null;
        while(!nodeQ.isEmpty()){
            currNode = nodeQ.poll();
            if(currNode!=null) System.out.println(currNode.val);
        }
    }
*/

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
        }
        /*Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        TreeNode currNode;
        int retVal = 0;
        while (!nodeQ.isEmpty()) {
            currNode = nodeQ.poll();
            if (currNode != null) {
                retVal++;
                if (currNode.left != null) nodeQ.add(currNode.left);
                if (currNode.right != null) nodeQ.add(currNode.right);
            }
        }
        return retVal;*/
    }

    private List<List<Integer>> returnReverseLevelOrderTree(TreeNode root) {
        List<List<Integer>> retVal = new ArrayList<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        TreeNode currNode;
        while (!nodeQ.isEmpty()) {
            List<Integer> currLevelList = new ArrayList<>();
            int length = nodeQ.size();
            for (int i = 0; i < length; i++) {
                currNode = nodeQ.poll();
                if (currNode != null) {
                    currLevelList.add(currNode.val);
                    nodeQ.add(currNode.left);
                    nodeQ.add(currNode.right);
                }
            }
            stack.push(currLevelList);
        }

        while (!stack.isEmpty()) {
            retVal.add(stack.pop());
        }
        return retVal;
    }

    private boolean isTreeBalanced(TreeNode root) {
        if (root == null) return isBalanced;
        checkIsTreeBalanced(root);
        return isBalanced;
    }

    private int checkIsTreeBalanced(TreeNode tn) {
        if (tn == null || !isBalanced) return -1;
        int l = checkIsTreeBalanced(tn.left);
        int r = checkIsTreeBalanced(tn.right);
        if (Math.abs(r - l) > 1) isBalanced = false;
        return Math.max(r, l) + 1;
    }

    private int minDepth(TreeNode root) {
        int retVal = 0;
        if(root == null) return retVal;
        Deque<TreeNode> nodeQ = new ArrayDeque<>();
        nodeQ.add(root);
        TreeNode currNode;
        wl:
        while(!nodeQ.isEmpty()){
            int length = nodeQ.size();
            for(int i=1;i<=length;i++){
                currNode = nodeQ.poll();
                if(currNode!=null){
                    if(currNode.left == null && currNode.right == null){
                        retVal++;
                        break wl;
                    }
                    if(currNode.right != null) nodeQ.add(currNode.right);
                    if(currNode.left != null) nodeQ.add(currNode.left);
                }
            }
            retVal++;
        }
        return retVal;
    }

    private boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return true;
        if((sum-(root.val) == 0) && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.right,sum-(root.val))
                && hasPathSum(root.left,sum-(root.val));
    }

}

class TreeNode {
    final int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

    public void insert(int val) {
        if (val <= this.val) {
            if (left == null) {
                left = new TreeNode(val);
            } else {
                left.insert(val);
            }
        } else {
            if (right == null) {
                right = new TreeNode(val);
            } else {
                right.insert(val);
            }
        }
    }
}