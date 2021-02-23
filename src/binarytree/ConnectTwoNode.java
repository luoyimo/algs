package binarytree;

import binarytree.node.ConnectedNode;
import util.InitDataHelper;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConnectTwoNode {

    public ConnectedNode connect(ConnectedNode root) {
        connectTwoNode(root, null);
        return root;
    }

    public ConnectedNode connectLinkedList(ConnectedNode root) {
        if (root == null) {
            return null;
        }
        //cur我们可以把它看做是每一层的链表
        ConnectedNode cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            ConnectedNode dummy = new ConnectedNode(0);
            //pre表示下一层节点的前一个节点
            ConnectedNode pre = dummy;

            //然后开始遍历当前层的链表
            //因为是完美二叉树，如果有左子节点就一定有右子节点
            while (cur != null && cur.left != null) {
                //让pre节点的next指向当前节点的左子节点，也就是把它串起来
                pre.next = cur.left;
                //然后再更新pre
                pre = pre.next;

                //pre节点的next指向当前节点的右子节点，
                pre.next = cur.right;
                pre = pre.next;
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }

    /**
     * @param root
     * @param next
     */
    public void connectTwoNode(ConnectedNode root, ConnectedNode next) {
        if (root == null) {
            return;
        }
        root.next = next;
        connectTwoNode(root.left, root.right);
        connectTwoNode(root.right, root.next == null ? null : root.next.left);
    }

    public static void main(String[] args) {
        ConnectedNode tree = InitDataHelper.initConnectedTree();
        ConnectTwoNode connectTwoNode = new ConnectTwoNode();
        connectTwoNode.connect(tree);
        System.out.println(tree);

    }

}


