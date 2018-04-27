package com.lh.linkedlist;

/**
 * 链表中的每个节点既指向前面一个节点，也指向后面一个节点，就像丢手绢游戏一样，每个人都手拉手。
 * （1）头插入：要对链表进行判断，如果为空则设置尾节点为新添加的节点，如果不为空，还要设置头节点的一个前节点为新节点
 * （2）尾插入：如果链表为空，则直接设置头节点为新添加的节点，否则设置尾节点的后一个节点为新添加的节点。同时设置新添加的节点的前一个节点为尾节点
 * (3) 头删除 :判断节点是否有下个节点，如果没有则设置节点为null，并且删除下个节点指向前节点的指针
 * https://blog.csdn.net/a19881029/article/details/22695289
 *
 * @author liuhe
 * @date 2018/4/26
 */
public class DoubleLinkList {

    Node header = null;
    Node tail = null;

    /**
     * 头插入
     *
     * @param data
     */
    void add(int data) {
        Node node = new Node(data);
        /**
         * 如果头结点等于null 说明还没有数据 头结点和尾节点都是当前节点
         */
        if (null == header) {
            header = node;
            tail = node;
        } else {
            /**
             * 默认从尾部添加
             */
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }


    public Node find(int data) {
        Node cur = header;
        while (null != cur) {
            if (data == cur.data) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


    /**
     * 节点类
     */
    private static class Node {
        // 上一个
        Node pre;
        // 数据
        int data;
        // 下一个
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
