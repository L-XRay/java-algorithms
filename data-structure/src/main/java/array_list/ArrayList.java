package array_list;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    /**
     * 默认初始化空间
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 空元素
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /**
     * ArrayList 元素数组缓存区
     */
    transient Object[] elementData;

    /**
     * 集合长度
     */
    private int size;

    public ArrayList() {
        // 默认构造一个空元素,当集合开始添加元素再增加长度
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public boolean add(E e) {
        // 确保内部容量
        int minCapacity = size + 1;
        // 如果是初始化,第一次添加元素,判断所需容量与默认容量，取两者之间的最大值作为初始化空间，增加冗余
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
        }

        // 判断扩容
        // minCapacity 集合当前所需最小容量 > elementData.length 扩容前数组长度
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            // 扩容后容量 newCapacity = oldCapacity + oldCapacity/2
            int newCapacity = oldCapacity + (oldCapacity >> 1);

            // 如果扩容后容量仍小于集合当前所需容量,直接使用集合当前所需容量作为扩容后的容量
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }
}
