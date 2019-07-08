/**
 * Created by Ritchie on 2018/8/4.
 */
public class ArrayOfGeneric<E>{
    private E data[];
    private int size;
/**
 * 构造函数，传入一个参数capacity构造Array
  */
    public ArrayOfGeneric(int capacity){
        data = (E[]) new Object[capacity]; //因为java不支持语法：data = new E[capacity];
        size = 0;
    }
/**
 * 默认构造函数，默认的capacity=10
  */
    public ArrayOfGeneric(){
        this(10);
    }
/**
 * 获取数组中的元素个数的方法
 */
    public int getSize(){
        return size;
    }
/**
 * 获取数组的容量的方法
 */
    public int getCapacity(){
        return data.length;
    }
/**
 * 判断数组是否为空
  */
    public boolean isEmpty(){
        return size == 0;
    }
/**
 * 向数组的所有元素后添加新元素e
  */
    public void addLast(E e){
//        if(size==data.length){
//            throw new IllegalArgumentException("addlast failed ,array is full!");
//        }
//        data[size] = e;
//        size++;
        add(size,e); //直接调用向任意位置添加元素的方法即可
    }
/**
 * 向数组的头部添加新元素
  */
    public void addFirst(E e){
        add(0,e);
    }
/**
 * 向数组的index位置添加新元素e
  */
    public void add(int index,E e){

        if (index < 0 || index > size ){
            throw new IllegalArgumentException("add failed, Require index >= 0 and index <= size.");
        }
        if (size == data.length){
            resize(2*data.length);
        }
        for(int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 构造动态数组，扩容函数
     * @param newCapacity
     */
    private void resize(int newCapacity) {
         E[] newData = (E[])new Object[newCapacity];
         for (int i = 0 ; i < size ; i++){
             newData[i] = data[i];
         }
         data = newData;
    }

    /**
 * 获取数组的元素
  */
    public E getValue(int i){
        if (i < 0 || i >= size){
            throw new IllegalArgumentException("Get failed, Index is illeagle! ");
        }
        return data[i];
    }

    public E getFirst(){
        return getValue(0);
    }

/**
 * 进行数组元素更新
  */
    public void setValue(int i , E value){
        if(i < 0 || i >= size){
            throw new IllegalArgumentException("Set failed, Index is illeagle! ");
        }
        data[i] = value;
    }
/**
 * 判断数组中是否包含元素e
  */
    public boolean contain(E e){
        for(int i = 0 ; i < size ; i++ ){
            if(data[i].equals(e)){       //此处为泛型数组，此处的比较应该用值比较equals，而不是引用比较=(=为比较二者指针指向的存储地址)
                return true;
            }
        }
        return false;
    }
/**
 * 查找元素e在数组中的第一个索引位置i
  */
    public int find(E e){
        for(int i = 0 ; i < size ; i++ ){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
/**
 * 删除指定位置的元素,并返回删除的元素
  */
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed, Index is illeagle! ");
        }
        E ret = data[index];
        for (int i = index ; i < size-1 ; i++){
            data[i]=data[i+1];
        }
        size--; //不要忘记维护size变量
        data[size] = null; //利用java的自动垃圾回收机制，如果data[size]还存着一个对象的引用的话是不会被回收，所以此处令其=null，(loitering!=memory leak）
        if (size == data.length/4 && data.length != 0) { //采用lazy的缩容处理方式，并要注意数组的容量不能为0
            resize(data.length / 2);
        }
        return ret;//返回值必须放在一个方法的最后
    }
/**
 * 删除数组的第一个元素,并返回删除的元素值
  */
    public E removeFirst(){
       return remove(0);
    }
/**
 * 删除数组的最后一个元素，并返回删除的元素值
  */
    public E removeLast(){
        return remove(size-1);
    }
/**
 * 判断数组中是否有某个元素，有则删除一个
 */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }
    /**
 * 打印数组元素
  */
    @Override //做个标注，表明是覆盖了Object类中的方法
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size , data.length));
        res.append('[');
        for(int i = 0;i<size;i++){
            res.append(data[i]);
            if (i != size-1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
