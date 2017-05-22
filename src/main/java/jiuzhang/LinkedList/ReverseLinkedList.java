package jiuzhang.LinkedList;

import jiuzhang.ListNode;

/**
 * Created by fanjiangqi on 2017/5/22.
 * 反转链表，很基础，一定要记住
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;

    }
}
