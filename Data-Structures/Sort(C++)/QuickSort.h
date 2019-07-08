//
// Created by ${Ritchie} on 2018/9/6.
//

#ifndef SELECTIONSORT_QUICKSORT_H
#define SELECTIONSORT_QUICKSORT_H

#include <iostream>
#include "InsertionSort.h"
using namespace std;
// 对arr[l...r]部分进行partition操作
// 将基准元素放到正确的位置上。返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
template <typename T>
int __partition(T arr[], int left, int right){
    // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
    swap( arr[left] , arr[rand()%(right-left+1)+left] );
    T v = arr[left];//每次都取序列的第一个元素作为基准

    int j = left; // arr[left+1...j] < v ; arr[j+1...i) > v，i为当前要考察元素的位置坐标
    for( int i = left + 1 ; i <= right ; i ++ ) {
        if (arr[i] < v) {
            //当前考察元素小于基准元素，将当前考察元素放入arr[left+1...j]
            j++;
            swap(arr[j], arr[i]);
           // swap(arr[++j], arr[i]);
        }
    }
    swap( arr[left] , arr[j]);   //将基准元素放在正确的位置

    return j;
}

// 对arr[l...r]部分进行快速排序
template <typename T>
void __quickSort(T arr[], int left, int right){

//    if( left >= right )//验证越界，但是在进行优化（小规模数组使用插入排序后，即多余）
//        return;
    // 对于小规模数组, 使用插入排序进行优化
    if( right - left <= 15 ){
        insertionSort(arr,left,right);
        return;
    }
    int p = __partition(arr, left, right);
    __quickSort(arr, left, p-1 );
    __quickSort(arr, p+1, right);
}

template <typename T>
void quickSort(T arr[], int n){
    __quickSort(arr, 0, n-1);
}
#endif //SELECTIONSORT_QUICKSORT_H
