//
// Created by ${Ritchie} on 2018/9/7.
//

#ifndef BINARYSEARCH_BINARYSEARCH_H
#define BINARYSEARCH_BINARYSEARCH_H

#include <iostream>
using namespace std;

// 二分查找法,在有序数组arr中,查找target
// 如果找到target,返回相应的索引index
// 如果没有找到target,返回-1
template<typename T>
int binarySearch(T arr[], int n, T target){

    // 在arr[l...r]之中查找target
    int l = 0, r = n-1;
    while( l <= r ){

        //int mid = (l + r)/2;
        // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
        int mid = l + (r-l)/2;

        if( arr[mid] == target )
            return mid;

        if( arr[mid] > target )
            r = mid - 1;
        else
            l = mid + 1;
    }

    return -1;
}
#endif //BINARYSEARCH_BINARYSEARCH_H
