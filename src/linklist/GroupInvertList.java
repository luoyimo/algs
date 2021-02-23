package linklist;

import linklist.node.ListNode;
import util.InitDataHelper;

/**
 * @program: algs
 * @description: 按组翻转链表
 * @author: luoyi
 * @create: 2020-12-31 19:32
 */
public class GroupInvertList {

    public ListNode revertList(ListNode headNode) {
        if (headNode == null) {
            return null;
        }
        ListNode curr = headNode;
        ListNode pre = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode revertList(ListNode headNode, ListNode nextNode) {
        if (headNode == null) {
            return null;
        }
        ListNode curr = headNode;
        ListNode pre = null;
        ListNode next = null;
        while (curr != nextNode) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode firstNode = head;
        ListNode nextNode = head;
        for (int i = 0; i < k; i++) {
            //不足k个,不需要翻转
            if (nextNode == null) {
                return head;
            }
            nextNode = nextNode.next;
        }
        ListNode listNode = revertList(firstNode, nextNode);
        firstNode.next = reverseKGroup(nextNode, k);
        return listNode;
    }


    public static void main(String[] args) {
        ListNode listNode = InitDataHelper.initLinkedList();
        GroupInvertList groupInvertList = new GroupInvertList();
        listNode = groupInvertList.revertList(listNode);
        System.out.println(listNode);
        listNode = InitDataHelper.initLinkedList();
        listNode = groupInvertList.revertList(listNode, listNode.next.next);
        System.out.println(listNode);
        listNode = InitDataHelper.initLinkedList();
        listNode = groupInvertList.reverseKGroup(listNode, 2);
        System.out.println(listNode);
    }
}
