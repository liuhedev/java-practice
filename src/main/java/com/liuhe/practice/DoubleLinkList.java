package main.java.com.liuhe.practice;

/**
 * 链表中的每个节点既指向前面一个节点，也指向后面一个节点，就像丢手绢游戏一样，每个人都手拉手。
 * （1）头插入：要对链表进行判断，如果为空则设置尾节点为新添加的节点，如果不为空，还要设置头节点的一个前节点为新节点
 * （2）尾插入：如果链表为空，则直接设置头节点为新添加的节点，否则设置尾节点的后一个节点为新添加的节点。同时设置新添加的节点的前一个节点为尾节点
 * (3) 头删除 :判断节点是否有下个节点，如果没有则设置节点为null，并且删除下个节点指向前节点的指针
 *
 * @author liuhe
 * @date 2018/4/26
 */
public class DoubleLinkList {

    DoubleLinkList pre = null;
    DoubleLinkList tail = null;
    int data;

    public DoubleLinkList(DoubleLinkList pre, DoubleLinkList tail, int data) {
        this.pre = pre;
        this.tail = tail;
        this.data = data;
    }

    public DoubleLinkList(DoubleLinkList pre, DoubleLinkList tail) {
        this.pre = pre;
        this.tail = tail;
    }

    public DoubleLinkList(int data) {
        this.data = data;
    }

    /**
     * 头插入
     *
     * @param data
     */
    void appendFirst(int data) {
        DoubleLinkList newNode = new DoubleLinkList(data);
        // 如果头结点为null，那使用当前节点为双链的尾节点
        if (null == this.pre) {
            this.tail = newNode;
        } else {
            this.pre.pre = newNode;
            //把first节点往下移动
            newNode.tail = pre;
        }
        pre = newNode;
    }

    /**
     * 尾插入
     *
     * @param data
     */
    void appendLast(int data) {
        DoubleLinkList newNode = new DoubleLinkList(data);
        if (null == pre) {
            pre = newNode;
        } else {
            newNode.pre = tail.pre;
            tail = newNode;
        }
    }
}
