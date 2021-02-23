package binarytree;

import binarytree.node.TreeNode;

/**
 * @author luoyi
 * <p>
 * <p>
 * <p>
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * <p>
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int maxValue = Integer.MIN_VALUE;
        int index = 0;
        //递归，选取剩余部分最大值，i<=high,下标非0，选取最大值
        for (int i = low; i <= high; i++) {
            if (num[i] > maxValue) {
                maxValue = num[i];
                index = i;
            }
        }
        TreeNode treeNode = new TreeNode(maxValue);
        treeNode.left = build(num, low, index - 1);
        treeNode.right = build(num, index + 1, high);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        MaxBinaryTree maxBinaryTree = new MaxBinaryTree();
        TreeNode treeNode = maxBinaryTree.constructMaximumBinaryTree(nums);
        System.out.println(treeNode);

    }
}
