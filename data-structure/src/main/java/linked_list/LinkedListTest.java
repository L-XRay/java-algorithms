package linked_list;

import org.junit.jupiter.api.Test;

/**
 * @author Ray
 * @date 2022/10/6 19:33
 * @description 链表测试
 */
public class LinkedListTest {

    @Test
    public void test_LinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("b");
        linkedList.linkLast("c");
        linkedList.linkFirst("a");
        linkedList.printLinkList();
        linkedList.remove("a");
        linkedList.printLinkList();
        linkedList.addFirst("X");
        linkedList.printLinkList();
    }
}
