//
// Created by ${Ritchie} on 2018/9/6.
//

#ifndef SELECTIONSORT_MERGESORT_H
#define SELECTIONSORT_MERGESORT_H
#include <iostream>
#include "InsertionSort.h"  
using namespace std;


// 将arr[l...mid]和arr[mid+1...r]两部分进行归并
// 其中aux为完成merge过程所需要的辅助空间
template<typename  T>
void __merge(T arr[], T aux[], int left, int mid, int right){

    // 由于aux的大小和arr一样, 所以我们也不需要处理aux索引的偏移量
    // 进一步节省了计算量:)
    for( int i = left ; i <= right; i ++ )
        aux[i] = arr[i];

    // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
    int i = left, j = mid+1;
    for( int k = left ; k <= right; k ++ ){

        if( i > mid ){  // 如果左半部分元素已经全部处理完毕
            arr[k] = aux[j]; j ++;
        }
        else if( j > right ){  // 如果右半部分元素已经全部处理完毕
            arr[k] = aux[i]; i ++;
        }
        else if( aux[i] < aux[j] ) {  // 左半部分所指元素 < 右半部分所指元素
            arr[k] = aux[i]; i ++;
        }
        else{  // 左半部分所指元素 >= 右半部分所指元素
            arr[k] = aux[j]; j ++;
        }
    }

}

// 使用优化的归并排序算法, 对arr[l...r]的范围进行排序
// 其中aux为完成merge过程所需要的辅助空间
template<typename T>
void __mergeSort(T arr[], T aux[], int left, int right){

//    if( left >= right )//验证越界，但是在进行优化（小规模数组使用插入排序后，即多余）
//        return;
    // 对于小规模数组, 使用插入排序
    if( right - left <= 15 ){
        insertionSort(arr, left, right);
        return;
    }

    int mid = (left+right)/2;
    __mergeSort(arr, aux, left, mid);
    __mergeSort(arr, aux, mid+1, right);

    // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
    // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
    if( arr[mid] > arr[mid+1] )
        __merge(arr, aux, left, mid, right);
}


template<typename T>
void mergeSort(T arr[], int n){

    // 在 mergeSort中, 我们一次性申请aux空间,
    // 并将这个辅助空间以参数形式传递给完成归并排序的各个子函数
    T *aux = new T[n];//默认初始化为0
    __mergeSort( arr , aux, 0 , n-1 );

    delete[] aux;   // 使用C++, new出来的空间不要忘记释放掉:)
}
#endif //SELECTIONSORT_MERGESORT_H
