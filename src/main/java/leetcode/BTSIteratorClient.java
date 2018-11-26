package leetcode;

import java.util.*;

class BSTIterator {
    Deque<Node> nodeStack;
    Node root;
    Node currNode;

    class Node {
        int val;
        Node right, left;

        Node(int val) {
            this.val = val;
        }
    }

    public boolean hasNext() {
        if (nodeStack != null) {
            if (!nodeStack.isEmpty())
                return true;
        } else {
            nodeStack = new ArrayDeque<>();
            Node currNode = findLeast(root);
            if (currNode != null && currNode != root) {
                return true;
            }
        }
        return false;
    }

    public Node findLeast(Node node) {
        if (node.left != null) {
            nodeStack.add(node);
            return findLeast(node.left);
        }
        nodeStack.add(node);
        return node;
    }

    public Node findNext() {
        currNode = nodeStack.pollLast();
        if (currNode != null) {
            Node nextNode = findNextLeast(currNode);
            if (nextNode != null && nextNode != currNode) {
                nodeStack.addLast(nextNode);
            }
        } else {
            throw new NoSuchElementException("No next element found");
        }
        return currNode;
    }

    public Node findNextLeast(Node node) {
        if (node.right != null) {
            findLeast(node.right);
        }
        return node;
    }

    public Node stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        Node root = new Node(Integer.parseInt(item));
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new Node(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new Node(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}

public class BTSIteratorClient {
    public static void main(String[] args) {
        BSTIterator bstIterator = new BSTIterator();
        bstIterator.root = bstIterator.stringToTreeNode("[4, 2, 6, 1, 3, 5, 7]");
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.findNext().val);
        }
    }
}