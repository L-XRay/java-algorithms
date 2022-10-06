package linked_list;

/**
 * @author Ray
 * @date 2022/10/6 15:09
 * @description
 */
public interface List<E> {

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();

    int size();

    E prev(int index);

    E next(int index);
}
