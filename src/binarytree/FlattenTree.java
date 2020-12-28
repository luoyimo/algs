package binarytree;

import binarytree.node.Node;
import util.InitDataHelper;

/**
 * 114. 二叉树展开为链表
 * <p>
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author luoyi
 */
public class FlattenTree {

    public Node flatten(Node root) {
        if (root == null) {
            return null;
        }
        flatten(root.left);
        flatten(root.right);
        Node temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        Node node = InitDataHelper.initTree();
        FlattenTree flattenTree = new FlattenTree();
        flattenTree.flatten(node);
        System.out.println(node);

    }
}
