public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e , Node next){
            this.e = e ;
            this.next = next ;
        }
        public Node(E e){
            this(e, null) ;
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }

    }

    private Node dummyHead; //虚拟头节点，不存储元素，指向真正的头节点，为了让链表中对于节点的操作统一起来
    private int size;

    public LinkedList(){
        dummyHead = new Node() ;
        size = 0 ;
    }
    /**
     * 获取链表中的元素个数
     */
    public int getSize(){
        return size;
    }
    /**
     * 返回链表是否为空
     */
    public boolean isEmpty(){
        return size == 0 ;
    }
    /**
     * 在链表头添加新的元素
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//上面三行可用一行代码进行替换
//          head = new Node(e , head);
//          size ++;
            add(0,e);
    }
    /**
     * 在链表中间添加元素
     * 在链表的index（0-basesd）位置添加新的元素e
     * 在链表中不是一个常用的操作，练习用
     */
    public void add(int index, E e){
         if (index < 0 || index > size){
             throw new IllegalArgumentException("Add failed . Illegal index.");
         }
         else{
             Node prev = dummyHead; //找index这个位置前一个位置的节点，从dummyHead开始遍历 index次
             for (int i = 0 ; i < index ; i ++){
                 prev = prev.next;
             }
//             Node node = new Node(e);
//             node.next = prev.next;
//             prev.next = node;
//上面三行可以用下面一行代码代替
             prev.next = new Node(e,prev.next);
             size ++;
         }
    }
    /**
     * 在链表的头节点添加元素
     * @param e
     */
    public void addLast(E e){
        add(size , e);
    }
    /**
     * 获取链表中第index(0-based)个位置的元素
     * 在链表中不是一个常用的操作，练习用
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed , the index is illegal !");
        }
        Node cur = dummyHead.next; //找index这个位置元素的值，从cur开始遍历 index次 cur意思是current 当前的
        for (int i = 0 ; i < index ; i ++){
            cur = cur.next;
        }
        return cur.e;
    }
    /**
     * 获取链表第一个位置的元素
     */
    public E getFirst(){
        return get(0);
    }
    /**
     * 获取链表的最后一个元素
     */
    public E getLast(){
        return get(size-1);
    }
    /**
     * 修改链表中第index(0-based)个位置的元素为e
     * 在链表中不是一个常用的操作，练习用
     */
    public void set(int index , E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed , illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++){
            cur = cur.next;
        }
        cur.e = e;
    }
    /**
     * 删除链表中第index(0-based)个位置的元素
     */
    public E remove(int index){
        if (index < 0 || index >=size){
            throw new IllegalArgumentException("Remove failed, illegal index !!!");
        }
        else{
            Node prev = dummyHead;
            for(int i = 0 ; i < index ; i ++){
                prev = prev.next;
            }
            Node retNode = prev.next;
            prev.next = retNode.next;
            retNode.next = null;
            size --;
            return retNode.e;
        }
    }
    /**
     * 删除链表的第一个元素
     */
    public E removeFirst(){
        return remove(0);
    }
    /**
     * 删除链表的最后一个元素
     */
    public E removeLast(){
        return remove(size-1);
    }
    /**
     * 判断链表中是否存在某个元素
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if (cur.e.equals(e)){
                return true;
            }
        }
        return false;
    }
    /**
     * 重写toString函数
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        return res.toString();
        //等价的for循环语句实现
//        for (Node cur = dummyHead.next ; cur != null; cur = cur.next ){
//            res.append(cur + "->");
//        }
//        res.append("null");
    }


}

