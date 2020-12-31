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

    public ListNode revertList(ListNode listNode) {
        ListNode pre, curr, next;
        pre = null;
        curr = listNode;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode revertList(ListNode listNode, ListNode nextNode) {
        ListNode pre, curr, next;
        pre = null;
        curr = listNode;
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
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = revertList(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
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
