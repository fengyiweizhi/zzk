package leetcode;

/**
 * @author 风亦未止
 * @date 2022/2/22 18:04
 */
public class leetcode21 {


    public static class ListNode {
        int val;
        ListNode next;
         ListNode() {}
       ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(2,listNode);
        ListNode list1 = new ListNode(1,listNode1);

        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3,listNode2);
        ListNode list2 = new ListNode(1,listNode3);
        ListNode listNode4 = mergeTwoLists(list1, list2);

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null&&list2==null){
            return null;
        }
        if (list1==null&&list2!=null){
            return new ListNode(list2.val,list2.next);
        }
        if (list1!=null&&list2==null){
            return new ListNode(list1.val,list1.next);
        }
        if (list1.val<= list2.val){
            return new ListNode(list1.val,mergeTwoLists(list1.next,list2));
        }else {
            return new ListNode(list2.val,mergeTwoLists(list1,list2.next));
        }
    }


}
