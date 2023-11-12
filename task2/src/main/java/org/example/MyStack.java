package org.example;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
    private Object[] array;
    private int size;

    private void grow(){
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array,newCapacity);
    }

    private void addElement(T element){
        add(element);
    }



    public MyStack(int size) {
        this.size = size;
        array = new Object[size];
    }

    public MyStack() {
        final int DEFAULT_CAPACITY = 10;
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int indexOf(Object o, int index){
        int res = -1;
        for (int i = index; i < size; i++) {
            if (array[i].equals(o)){
                res = i;
                break;
            }
        }
        return res;
    }
    public int indexOf(Object o){
        return indexOf(o, 0);
    }
    public boolean contains(Object o){
        return indexOf(o) >= 0;
    }

    public void add(T element){
        if (size == array.length)
            grow();
        array[size] = element;
        size++;
    }

    public void removeElementAt(int index){
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    size);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = size - index - 1;
        if (j > 0) {
            System.arraycopy(array, index + 1, array, index, j);
        }
        array[--size] = null;
    }
    public boolean removeElement(Object o){
        int i = indexOf(o);
        if (i >= 0) {
            removeElementAt(i);
            return true;
        }
        return false;
    }

    public T remove(int index){
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        T oldValue = elementAt(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        array[--size] = null; // Let gc do its work
        return oldValue;
    }

    public boolean remove(Object o){
        return removeElement(o);
    }

    public void removeAllElements(){
        final Object[] es = array;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    public T pop(){
        T el = peek();
        size--;
        return el;
    }
    @SuppressWarnings("unchecked")
    private T arrayData(int index) {
        return (T) array[index];
    }
    public T elementAt(int index){
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + size);
        }

        return arrayData(index);
    }
    @SuppressWarnings("unchecked")
    public T peek(){

        T peek = (T) array[size-1];
        int     len = size();

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    public int lastIndexOf(Object o, int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(index + " >= "+ size);

        if (o == null) {
            for (int i = index; i >= 0; i--)
                if (array[i]==null)
                    return i;
        }
        else {
            for (int i = index; i >= 0; i--)
                if (o.equals(array[i]))
                    return i;
        }
        return -1;
    }
    public boolean empty(){
        return size == 0;
    }
    public int lastIndexOf(Object o){
        return lastIndexOf(o,size-1);
    }
    public int search(Object o){
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    public T get(int index){
        return elementAt(index);
    }

    public T push(T item){
        addElement(item);
        return item;
    }

    @Override
    public String toString(){
        Iterator<T> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            T e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new RuntimeException();
                }
                return (T) array[currentIndex++];
            }
        };
    }
}
