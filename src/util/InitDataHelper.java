package util;

import binarytree.node.ConnectedNode;
import binarytree.node.TreeNode;
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

    public static TreeNode initTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
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
