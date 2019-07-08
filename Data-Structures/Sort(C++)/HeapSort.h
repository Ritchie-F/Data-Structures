//
// Created by ${Ritchie} on 2018/9/7.
//

#ifndef SELECTIONSORT_HEAPSORT_H
#define SELECTIONSORT_HEAPSORT_H
#include <algorithm>
#include <cassert>

using namespace std;


template<typename Item>
class MaxHeap{

private:
    Item *data;
    int count;
    int capacity;

    void shiftUp(int k){
        while( k > 1 && data[k/2] < data[k] ){
            swap( data[k/2], data[k] );
            k /= 2;
        }
    }

    void shiftDown(int k){
        while( 2*k <= count ){
            int j = 2*k;
            if( j+1 <= count && data[j+1] > data[j] ) j ++;
            if( data[k] >= data[j] ) break;
            swap( data[k] , data[j] );
            k = j;
        }
    }

public:

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    // 时间复杂度为O(nlogn)
    MaxHeap(int capacity){
        data = new Item[capacity+1];
        count = 0;
        this->capacity = capacity;
    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    //只要从最后一个非叶子节（元素个数/2）点向前遍历每一个节点即可. 如果当前节点比左右子树节点都大, 则已经是一个最大堆，否则shiftDown
    // 该构造堆的过程, 时间复杂度为O(n)
    MaxHeap(Item arr[], int n){
        data = new Item[n+1];
        capacity = n;

        for( int i = 0 ; i < n ; i ++ )//从索引1 开始构建
            data[i+1] = arr[i];
        count = n;

        for( int i = count/2 ; i >= 1 ; i -- )
            shiftDown(i);
    }

    ~MaxHeap(){
        delete[] data;
    }

    // 返回堆中的元素个数
    int size(){
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    bool isEmpty(){
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    void insert(Item item){
        assert( count + 1 <= capacity );
        data[count+1] = item;
        shiftUp(count+1);
        count ++;
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    Item extractMax(){
        assert( count > 0 );
        Item ret = data[1];
        swap( data[1] , data[count] );
        count --;
        shiftDown(1);
        return ret;
    }

    // 获取最大堆中的堆顶元素
    Item getMax(){
        assert( count > 0 );
        return data[1];
    }
};
// heapSort1, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
// 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
// 整个堆排序的整体时间复杂度为O(nlogn)
template<typename T>
void heapSort1(T arr[], int n){

    MaxHeap<T> maxheap = MaxHeap<T>(n);
    for( int i = 0 ; i < n ; i ++ )
        maxheap.insert(arr[i]);

    for( int i = n-1 ; i >= 0 ; i-- )
        arr[i] = maxheap.extractMax();

}


// heapSort2, 借助我们的heapify过程创建堆
// 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
// 堆排序的总体时间复杂度依然是O(nlogn), 但是比上述heapSort1性能更优, 因为创建堆的性能更优
template<typename T>
void heapSort2(T arr[], int n){

    MaxHeap<T> maxheap = MaxHeap<T>(arr,n);
    for( int i = n-1 ; i >= 0 ; i-- )
        arr[i] = maxheap.extractMax();

}



//原地堆排序，不需要额外的新空间

// 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
// 该优化思想和我们之前对插入排序进行优化的思路是一致的
template<typename T>
void __shiftDown2(T arr[], int n, int k){

    T e = arr[k];
    while( 2*k+1 < n ){
        int j = 2*k+1;
        if( j+1 < n && arr[j+1] > arr[j] )
            j += 1;

        if( e >= arr[j] ) break;

        arr[k] = arr[j];
        k = j;
    }

    arr[k] = e;
}
// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
template<typename T>
void heapSort(T arr[], int n){

    // 注意，此时我们的堆是从0开始索引的
    // 从(最后一个元素的索引-1)/2开始，此处为heapify建堆时，最后一个非叶子节点的位置
    // 最后一个元素的索引 = n-1
    for( int i = (n-1-1)/2 ; i >= 0 ; i -- )
        __shiftDown2(arr, n, i);

    for( int i = n-1; i > 0 ; i-- ){
        swap( arr[0] , arr[i] );
        __shiftDown2(arr, i, 0);
    }
}


#endif //SELECTIONSORT_HEAPSORT_H
