package com.lh.linkedlist;


/**
 * 简单单向链表
 *
 * @author liuhe
 * @date 2018/4/26
 */
public class SingleNodeTest {
    public static void main(String[] args) {
        SingleLinkList singleLinkList = new SingleLinkList(2);
        singleLinkList.appendToTail(3);
        singleLinkList.appendToTail(4);

        singleLinkList.printNodes(singleLinkList);

        System.out.println("-----------l h-----------");
        SingleLinkList singleLinkList1 = singleLinkList.deleteNode(singleLinkList, 3);
        singleLinkList.printNodes(singleLinkList1);
    }
}
