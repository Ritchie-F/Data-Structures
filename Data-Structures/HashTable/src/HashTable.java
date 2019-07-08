import java.util.TreeMap;

public class HashTable<K, V> {//哈希表中的K不需要具有可比性，K必须实现HashCode方法，Java中所有类都是Object的子类，object类中已实现

    private static final int upperTol = 10;//超过上界，扩容
    private static final int lowerTol = 2;//小于下界，缩容
    private static final int initCapacity = 7;
    private TreeMap<K, V>[] hashtable;
    private int size;
    private int M;//合适的素数

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];//M个TreeMap；
        for(int i = 0 ; i < M ; i ++)
            hashtable[i] = new TreeMap<>();
    }

    public HashTable(){
        this(initCapacity);
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }//hash值为正整形

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key))
            map.put(key, value);//已经存在key，将值进行修改
        else{
            map.put(key, value);//真正添加，需要维护size变量
            size ++;
            if (size >= upperTol * M){//此处N/M，除法可能转化为浮点型，所以用乘法表示
                resize(2 * M);
            }
        }
    }

    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;
            if (size < lowerTol * M && M/2 >= initCapacity){
                resize(M / 2);
            }
        }
        return ret;
    }

    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }
    private void resize(int newM){
        TreeMap<K , V>[] newHashTable = new TreeMap[newM];
        for (int i = 0 ; i< newM ; i ++){
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = M;
        this.M = newM; //hash函数中，M没有变，所以此处需要提前更新M的值
        for(int i = 0 ; i < oldM ; i ++){
            TreeMap<K, V> map = hashtable[i];
            for(K key: map.keySet()){
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashtable = newHashTable;
    }

}
