package com.lh.linkedlist;

/**
 * 简单单向链表
 *
 * @author liuhe
 * @create 2018-04-26
 */
public class SingleLinkList {

    SingleLinkList next = null;
    int data;

    public SingleLinkList(int data) {
        this.data = data;
    }

    /**
     * 增加节点
     *
     * @param data 节点数据
     */
    public void appendToTail(int data) {
        SingleLinkList end = new SingleLinkList(data);
        SingleLinkList n = this;
        while (null != n.next) {
            n = n.next;
        }
        n.next = end;
    }

    public SingleLinkList deleteNode(SingleLinkList head, int data) {
        SingleLinkList n = head;

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

    public void printNodes(SingleLinkList node) {
        while (null != node) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}

