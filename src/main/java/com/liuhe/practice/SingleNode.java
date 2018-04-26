package main.java.com.liuhe.practice;

/**
 * 简单单向链表
 *
 * @author liuhe
 * @create 2018-04-26
 */
public class SingleNode {

    SingleNode next = null;
    int data;

    public SingleNode(int data) {
        this.data = data;
    }

    /**
     * 增加节点
     *
     * @param data 节点数据
     */
    public void appendToTail(int data) {
        SingleNode end = new SingleNode(data);
        SingleNode n = this;
        while (null != n.next) {
            n = n.next;
        }
        n.next = end;
    }

    public SingleNode deleteNode(SingleNode head, int data) {
        SingleNode n = head;

        if (n.data == data) {
            // 表头指向下一个节点
            return head.next;
        }

        while (null != n.next) {
            if (n.next.data == data) {
                n.next = n.next.next;
                //    表头不变
                return head;
            }
        }

        return head;
    }

    public void printNodes(SingleNode node) {
        while (null != node) {
            System.out.println(node.data);
            node = node.next;
        }
    }

}

