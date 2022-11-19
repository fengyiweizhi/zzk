package leetcode;

/**
 * @author 风亦未止
 * @date 2022/6/14 21:30
 */
public class LinkListGo {
    static class ListNode {
     public int val;
     ListNode next;
     ListNode(int x) { val = x; }

  }

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode newListNode= listNode2;
        newListNode.val=3;
        System.out.println(listNode2.val);
    }
}
