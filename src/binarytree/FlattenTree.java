package binarytree;

import binarytree.node.TreeNode;
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

    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = InitDataHelper.initTree();
        FlattenTree flattenTree = new FlattenTree();
        flattenTree.flatten(treeNode);
        System.out.println(treeNode);

    }
}
