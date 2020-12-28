package util;

import binarytree.node.ConnectedNode;
import binarytree.node.Node;
import linklist.node.ListNode;

/**
 * @author luoyi
 */
public class InitDataHelper {


    public static ListNode initLinkedList() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);
        return first;
    }

    public static Node initTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    public static ConnectedNode initConnectedTree() {
        ConnectedNode root = new ConnectedNode(1);
        root.left = new ConnectedNode(2);
        root.right = new ConnectedNode(3);
        root.left.left = new ConnectedNode(4);
        root.left.right = new ConnectedNode(5);
        root.right.left = new ConnectedNode(6);
        root.right.right = new ConnectedNode(7);
        return root;
    }
}
