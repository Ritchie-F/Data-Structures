//
// Created by ${Ritchie} on 2018/9/6.
//

#ifndef SELECTIONSORT_MERGESORTBU_H
#define SELECTIONSORT_MERGESORTBU_H
//自底向上的实现归并函数
#include <iostream>
#include "InsertionSort.h"
#include "MergeSort.h"

using namespace std;

template <typename T>
template <typename T>
void mergeSortBU(T arr[], int n){

    // 对于小规模数组, 使用插入排序
    for( int i = 0 ; i < n ; i += 16 )
        insertionSort(arr,i,min(i+15,n-1));

    // 一次性申请aux空间, 并将这个辅助空间以参数形式传递给完成归并排序的各个子函数
    T* aux = new T[n];
    for( int sz = 16; sz <= n ; sz += sz )
        for( int i = 0 ; i < n - sz ; i += sz+sz )
            // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
            // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
            if( arr[i+sz-1] > arr[i+sz] )
                __merge(arr, aux, i, i+sz-1, min(i+sz+sz-1,n-1) );
    delete[] aux; // 使用C++, new出来的空间不要忘记释放掉:)
}
#endif //SELECTIONSORT_MERGESORTBU_H
