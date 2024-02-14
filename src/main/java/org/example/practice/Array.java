package org.example.practice;

import java.util.Iterator;

/**
 * @author YimengShi
 */
@SuppressWarnings("uncheck")
public class Array<T> implements Iterable<T> {

    // 定义变量
    Array<T> arr = null ;


    int lens = 0; // the length of this array

    int capacity = 0; // the real length of this array

    // 方法
    Array() {
        new Array(16);
    }

    Array(int capacity) {
        // 判断入参
        if (capacity < 0) {throw new IllegalThreadStateException();}
        // 设置lens和capacity
        this.capacity = capacity;
        // new arr
        arr = new Array<>(capacity);
    }

    // access - set
    public boolean set(int index, T object) {
        // 判断入参
        if (index >= lens && index >= capacity) { throw  new ArrayIndexOutOfBoundsException();}
        // 设置值
        return  arr[index] = object;
    }
    // access - get
    public T get(int index) {
        // 判断入参
        if (index >= lens && index >= capacity) { throw  new ArrayIndexOutOfBoundsException();}
        // 设置值
        return  arr[index];
    }
    // insert - index
    public boolean add(int index, T object) {
        if (index >= lens && index >= capacity) {
            // 扩容
            this.lens++;
            return expansionCapacity();
        }

        return false
    }

    // 扩容
    public boolean expansionCapacity( ) {
        // 思考 capacity 和 len 的关系
        if (lens >= capacity) {

        }
    }
    // appending

    // remove - by index


    // remove - by index



    @Override
    public Iterator<T> iterator() {
        return null;

    }
}
