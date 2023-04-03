package com.lambda.自定义List;

/**
 * @author 风亦未止
 * @date 2023/3/31 19:50
 */
public class MyList<T>{

    private T[] data;
    private Integer size;

    public MyList<T> filter(MyFilter<T> filter) {
        MyList<T> res = new MyList<>();
        for (int i = 0; i < size; i++) {
            if (filter.filter(data[i])) {
                res.add(data[i]);
            }
        }
        return res;
    }

    public MyList() {
        this.data = (T[]) new Object[1];
        this.size = 0;
    }

    public MyList(int n) {
        this.data = (T[]) new Object[n];
        this.size = 0;
    }


    public T get(int  num) {
        if (num > size) {
            return null;
        }
        return data[num];
    }

    public boolean add(T o) {
        // 扩容
        reSize(size);
        size++;
        data[size - 1] = o;
        return true;
    }

    public boolean removeByIndex(int index) {
        int  i = index;
        if (i >= size) {
            return false;
        }
        for (int j = i + 1; j < size; j++) {
            data[j - 1] = data[j];
        }
        reSize(size--);
        return true;
    }

    private void reSize(int size) {
        if (size + 1 > data.length) {
            T[] temp = (T[]) new Object[size * 2];
            for (int i = size - 1, in = 0; i >= in; i--) {
                temp[i] = data[i];
            }
            data = temp;
        }
        if (size <= data.length / 4 && data.length / 2 != 0) {
            T[] temp = (T[]) new Object[data.length / 2];
            for (int i = size - 1, in = 0; i >= in; i--) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    public int size() {
        return size;
    }

}
