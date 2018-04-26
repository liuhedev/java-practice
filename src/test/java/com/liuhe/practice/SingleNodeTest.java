package test.java.com.liuhe.practice;

import main.java.com.liuhe.practice.SingleNode;

/**
 * 简单单向链表
 *
 * @author liuhe
 * @date 2018/4/26
 */
public class SingleNodeTest {
    public static void main(String[] args) {
        SingleNode singleNode = new SingleNode(2);
        singleNode.appendToTail(3);
        singleNode.appendToTail(4);

        singleNode.printNodes(singleNode);

        System.out.println("-----------l h-----------");
        SingleNode singleNode1 = singleNode.deleteNode(singleNode, 3);
        singleNode.printNodes(singleNode1);
    }
}
