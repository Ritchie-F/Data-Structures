/**
 * Created by Ritchie on 2018/8/14.
 */
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> list;
    public  LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e); //因为添加头节点的复杂度为O(1),删除头节点的复杂度为O(1)，所以将头节点做栈顶
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:top ");
        res.append(list);
        return res.toString();
    }
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i=0 ; i < 5 ; i ++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
//        stack.push("a");
//        stack.push(1);
//        stack.push(2);
//        stack.push(7);
//        System.out.println(stack);
    }
}
