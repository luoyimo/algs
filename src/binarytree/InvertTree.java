package binarytree;

import binarytree.node.Node;
import util.InitDataHelper;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 翻转树 leetcode 226题
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author luoyi
 */
public class InvertTree {

    public Node invertTreeRecursion(Node root) {
        if (root == null) {
            return null;
        }
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTreeRecursion(root.left);
        invertTreeRecursion(root.right);
        return root;
    }

    public Node invertTreeStack(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop == null) {
                continue;
            }
            Node left = pop.left;
            pop.left = pop.right;
            pop.right = left;
            stack.push(pop.left);
            stack.push(pop.right);
        }
        return root;
    }


    public Node invertTreeQueue(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node pop = stack.poll();
            if (pop == null) {
                continue;
            }
            Node left = pop.left;
            pop.left = pop.right;
            pop.right = left;
            stack.add(pop.left);
            stack.add(pop.right);
        }
        return root;
    }


    public static void main(String[] args) {
        Node root = InitDataHelper.initTree();
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