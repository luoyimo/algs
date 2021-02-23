package binarytree;

import binarytree.node.TreeNode;
import util.InitDataHelper;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 翻转树 leetcode 226题
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author luoyi
 * <p>
 * **      4
 * **    /   \
 * **   2     7
 * **  / \   / \
 * ** 1   3 6   9
 * <p>
 * result
 * <p>
 * **      4
 * **    /   \
 * **   7     2
 * **  / \   / \
 * ** 9   6 3   1
 */
public class InvertTree {

    public TreeNode invertTreeRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTreeRecursion(root.left);
        invertTreeRecursion(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }

    public TreeNode invertTreeStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop == null) {
                continue;
            }
            TreeNode left = pop.left;
            pop.left = pop.right;
            pop.right = left;
            stack.push(pop.left);
            stack.push(pop.right);
        }
        return root;
    }


    public TreeNode invertTreeQueue(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.poll();
            if (pop == null) {
                continue;
            }
            TreeNode left = pop.left;
            pop.left = pop.right;
            pop.right = left;
            stack.add(pop.left);
            stack.add(pop.right);
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = InitDataHelper.initTree();
        System.out.println(root);
        InvertTree solution = new InvertTree();
        solution.invertTreeRecursion(root);
        System.out.println(root);
        solution.invertTreeStack(root);
        System.out.println(root);
        solution.invertTreeQueue(root);
        System.out.println(root);
    }
}
