package org.example.practice2;

import java.util.Iterator;

@SuppressWarnings("uncheck")
public class Array <T> implements Iterable <T> {

    private T[] arr;

    // length user thinks that array is.
    private int len = 0;

    // Actual array size
    private int capacity = 0;

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public T get(int index) {
        return arr[index];
    }
    public void set(int index, T elem ) {
        arr[index] = elem;
    }

    // clear方法忘记了
    public void clear() {
        // 要对整个数组清理， 选capacity
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {
        // 扩容
        if (len+1 >= capacity) {
           if (capacity == 0) { capacity = 1; }
           else { capacity *= 2; } // double the size
           T[] new_arr = (T[]) new Object[capacity];
           for (int i = 0, j = 0; i < len; i++, j++) { new_arr[j] = arr[i]; }
           arr = new_arr; // arr has extra null padded
        }
        // 赋值，提取出来。
        // 整个添加可以分成两步： (还有一步，因为添加不需要判断，所以省略了)
        // 1. 准备好空间；2. 赋值； 首先判断空间够不够，不够就扩容。然后赋值
        arr[++len] = elem;
    }

    public T removeAt(int rm_index) {
        // 比起添加，因为是移除，首先的判断有没有，有才能移除
        // 移除： 新建数组，把index下标的值拿掉
        // 保证index是合法的
        if (rm_index < 0 || rm_index > len) { throw new IndexOutOfBoundsException(); }
        // 开始移除，先记录下移除的是什么
        T data = arr[rm_index];
        T[] new_arr = (T[])new Object[--capacity];
        for (int i = 0, j = 0; i < len; i++,j++) {
            // rm_index 是索引下标还是个数？ 下标吧应该是
            new_arr[j] = arr[i];
            if ( i == rm_index) { j--; } // j是控制new_arr中数据的
        }
        arr = new_arr;
        // 不能忘记返回下标对应的数据
        return data;
    }

    public void remove(T elem) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(elem)) { removeAt(i); }
        }
    }

    public int indexOf(T elem) {
        for (int i = 0; i < len; i++) {
            if ( arr[len].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < len; i++) {
            sb.append(arr[i] + ",");
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return len > index;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }
}
