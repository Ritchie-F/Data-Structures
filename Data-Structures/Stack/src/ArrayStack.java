/**
 * Created by Ritchie on 2018/8/5.
 */
public class ArrayStack<E> implements Stack<E> {
    ArrayOfGeneric<E> array;
    public ArrayStack(int capacity){
        array = new ArrayOfGeneric<>(capacity);
    }
    public ArrayStack(){
        array = new ArrayOfGeneric<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * ArrayStack 基于动态数组实现的栈特有的方法，因为栈与实现无关，所以栈这个接口中没有包含这个方法
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0 ; i < array.getSize(); i ++){
            res.append(array.getValue(i));
            if (i != array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

}
