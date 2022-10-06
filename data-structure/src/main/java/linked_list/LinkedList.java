package linked_list;

/**
 * @author Ray
 * @date 2022/10/6 15:12
 * @description 链表
 */

public class LinkedList<E> implements List<E> {

    /**
     * 节点结构
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    public LinkedList() {
    }

    /**
     * 头插法
     * @param e 元素
     */
    void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null,e,f);
        first = newNode;

        // 当第一次插入元素时，即此时只有 newNode
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * 尾插法
     * @param e 元素
     */
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l,e,null);
        last = newNode;

        // 当第一次插入元素时，即此时只有 newNode
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    E unlink(Node<E> x){
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        // 处理 prev
        // 当指定节点x为头节点时
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        // 处理 next
        // 当指定节点x为尾节点时
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    Node<E> node(int index) {
        // >> 算数右移 相当于 size / 2
        // index < size/2
        // 如果 index 离左边近，用 头节点 向后进行遍历，否则用 尾节点 向前进行遍历
        if (index < (size >> 1)) {
            Node<E> x = first;
            for(int i = 0 ; i < index ; i++){
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1 ; i > index ; i--) {
                x = x.prev;
            }
            return x;
        }
    }
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next ) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next ) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public void printLinkList() {
        if (this.size == 0) {
            System.out.println("链表为空");
        } else {
            Node<E> temp = first;
            System.out.print("目前的列表，头节点：" + first.item + " 尾节点：" + last.item + " 整体：");
            while (temp != null) {
                System.out.print(temp.item + "，");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E prev(int index) {
        return node(index).prev.item;
    }

    @Override
    public E next(int index) {
        return node(index).next.item;
    }
}
