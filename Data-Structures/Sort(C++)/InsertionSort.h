//
// Created by ${Ritchie} on 2018/9/4.
//

#ifndef SELECTIONSORT_INSERTIONSORT_H
#define SELECTIONSORT_INSERTIONSORT_H

#include <iostream>
using namespace std;

template<typename T>
void insertionSort(T arr[], int n){

    for( int i = 1 ; i < n ; i ++ ) {
//每次选择第i个元素插入(0 , i-1)区间内的合适位置
        // 写法1
//        for( int j = i ; j > 0 ; j-- )
//            if( arr[j] < arr[j-1] )
//                swap( arr[j] , arr[j-1] );
//            else
//                break;

        // 写法2
        //插入排序的循环终止条件多了一个 arr[j] < arr[j--] ，否则可提前终止循环，
//      //选择排序第二曾循环要全部循环一次，理论上插入排序优于选择排序,
//      //但是此处内层循环进行交换，一次交换操作涉及三次赋值，耗时严重，故需要改进。
//       for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
//            swap(arr[j], arr[j - 1]);
//        }

       // 写法3
        T e = arr[i];
        int j; // j保存元素e应该插入的位置
        for (j = i; j > 0 && arr[j-1] > e; j--){
            arr[j] = arr[j-1];
        }
        arr[j] = e;
    }

    return;
}
// 对arr[l...r]范围的数组进行插入排序
template<typename T>
void insertionSort(T arr[], int l, int r){

    for( int i = l+1 ; i <= r ; i ++ ) {

        T e = arr[i];
        int j;
        for (j = i; j > l && arr[j-1] > e; j--)
            arr[j] = arr[j-1];
        arr[j] = e;
    }

    return;
}
#endif //SELECTIONSORT_INSERTIONSORT_H
