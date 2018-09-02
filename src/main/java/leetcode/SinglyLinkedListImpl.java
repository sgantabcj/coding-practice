package leetcode;

public class SinglyLinkedListImpl {
    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    private static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    private static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(Integer.toString(node.val)).append(", ");
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args){
        String line1 = "[]";
        String line2 = "[2,4,6]";
        ListNode l1 = stringToListNode(line1);

        ListNode l2 = stringToListNode(line2);

        ListNode ret = new SinglyLinkedListSolution().mergeTwoLists(l1, l2);

        String out = listNodeToString(ret);

        System.out.print("spliced list: "+out);
    }
}
class SinglyLinkedListSolution {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode retVal = null;
        ListNode nPtr = null;
        int size = 0;
        while(l1 != null && l2 != null){
            if(size == 0){
                if(l1.val <= l2.val){
                    retVal = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    retVal = new ListNode(l2.val);
                    l2 = l2.next;
                }
                nPtr = retVal;
                size++;
                continue;
            }

            if(l1.val <= l2.val){
                nPtr.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                nPtr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            nPtr = nPtr.next;
            size++;
        }

        if(l1!=null){
            if(size == 0){
                return l1;
            }
            nPtr.next = l1;
            return retVal;
        }else if(l2 != null){
            if(size == 0){
                return l2;
            }
            nPtr.next = l2;
        }

        return retVal;
    }
}
class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
}