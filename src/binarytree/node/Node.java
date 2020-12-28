package binarytree.node;

/**
 * @author luoyi
 */
public class Node {

    public int val;

    public Node left, right;

    public Node(int val) {
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
