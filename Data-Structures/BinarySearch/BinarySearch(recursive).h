//
// Created by ${Ritchie} on 2018/9/7.
//

#ifndef BINARYSEARCH_BINARYSEARCH_RECURSIVE_H
#define BINARYSEARCH_BINARYSEARCH_RECURSIVE_H
#include<iostream>;
using namespace std;

// 用递归的方式写二分查找法
template<typename T>
int __binarySearch2(T arr[], int l, int r, T target){

    if( l > r )
        return -1;

    //int mid = (l+r)/2;
    // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
    int mid = l + (r-l)/2;

    if( arr[mid] == target )
        return mid;
    else if( arr[mid] > target )
        return __binarySearch2(arr, l, mid-1, target);
    else
        return __binarySearch2(arr, mid+1, r, target);
}

template<typename T>
int binarySearch2(T arr[], int n, T target){

    return __binarySearch2( arr , 0 , n-1, target);
}
#endif //BINARYSEARCH_BINARYSEARCH_RECURSIVE_H
