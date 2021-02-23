package binarytree.node;

/**
 * @author luoyi
 */
public class TreeNode {

    public int val;

    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{" +
                "val:" + val +
                ", left:" + left +
                ", right:" + right +
                '}';
    }
}
