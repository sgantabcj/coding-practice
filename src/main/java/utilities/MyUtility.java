package utilities;

import others.datastructures.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyUtility {

    public static <T> void printMultiList(List<List<T>> multiList){
        System.out.println("{");
        for(List<T> lst : multiList){
            System.out.println("\t"+ Arrays.toString(lst.toArray()));
        }
        System.out.println("}");
    }

    public static int[] stringToIntegerArray(String line) {
        line = line.trim();
        if (line.length() == 0) return new int[0];

        String[] stringArr = line.split(" ");
        int[] retVal = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            String numStr = stringArr[i].trim();
            retVal[i] = (numStr.charAt(0) == '-') ? -(Integer.parseInt(numStr.substring(1))) : Integer.parseInt(numStr);
        }
        return retVal;
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
        while (!nodeQueue.isEmpty()) {
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


}
