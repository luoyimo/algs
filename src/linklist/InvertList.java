package linklist;

import linklist.node.ListNode;
import util.InitDataHelper;

/**
 * @author luoyi
 */
public class InvertList {


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode invertList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode listNode = invertList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }


    /**
     * 后继节点
     */
    ListNode successor = null;

    /**
     * 部分反转链表，前N位
     *
     * @param head
     * @return
     */
    public ListNode partInvertList(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode listNode = partInvertList(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return listNode;
    }

    /**
     * 部分反转  1 <= m < n <= last
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode partInvertList(ListNode head, int m, int n) {
        if (m==1){
            ListNode listNode = partInvertList(head, n);
            return listNode;
        }
        //以head.next作为头结点,则往后递归m-1个节点，n-1个节点
        head.next = partInvertList(head.next, m - 1, n - 1);
        return head;
    }


    public static void main(String[] args) {
        ListNode first = InitDataHelper.initLinkedList();
        InvertList invertList = new InvertList();
        ListNode listNode = invertList.invertList(first);
        System.out.println(listNode);
//
        ListNode partInvert = InitDataHelper.initLinkedList();
        ListNode partResult = invertList.partInvertList(partInvert, 3);
        System.out.println(partResult);
//
        ListNode partInvert2 = InitDataHelper.initLinkedList();
        ListNode partResult2 = invertList.partInvertList(partInvert2, 2, 4);
        System.out.println(partResult2);

    }


}
