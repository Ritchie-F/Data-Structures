public class LoopQueue<E> implements Queue<E> {


    private E[] data ;
    private int front , tail ;
    private int size ;//其实不需要size成员变量也能实现，此处为了逻辑编写更加简单，可以尝试去掉size

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];//循环队列会浪费一个数组空间，所以要想实现传入的capacity，数据数组容量要+1
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);//直接调用有参数的构造函数，为capacity设置默认值10
    }
    public int getCapacity(){
        return data.length - 1 ;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail ;
    }

    /**
     * 实现动态扩容
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newdata = (E[]) new Object[newCapacity + 1];
        for (int i = 0 ; i < size ; i ++){
            newdata[i] = data[(front + i) % data.length];//data数组中front队首不一定在下标为0的位置，扩容时重新将队首元素放到数组的第一个位置
        }
        data = newdata;
        front = 0;
        tail = size;
    }

    @Override
    public void enqueue(E e) {
        if (( tail + 1 ) % data.length == front ){ //入队之前先进行判断，队列是否已满
            resize(getCapacity() * 2); //若满，队列需要扩容。需要注意capacity是用户传入的队列容量，我们实际的队列长度.length=capacity+1
        }
        data[tail] = e;
        tail = ( tail + 1 ) % data.length ;
        size ++;
    }


    @Override
    public E dequeue() {
        E ret = data[front];
        data[front] = null ;
        front = ( front + 1) % data.length ;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("The queue is empty");
        }
        return data[front] ;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){ //循环队列，tail可能小于front，也可使用resize函数中的数组遍历方式
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
