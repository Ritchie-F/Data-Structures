//
// Created by ${Ritchie} on 2018/9/4.
//

#ifndef SELECTIONSORT_SELECTIONSORT_H
#define SELECTIONSORT_SELECTIONSORT_H
#include <iostream>
//#include <algorithm>,C++11 标准中，swap函数就在std这个命名空间中，老版本C++标准需要引入该库。
using namespace std;

template<typename T>
void selectionSort(T arr[], int n){

    for (int i = 0; i < n; i++) {
        //寻找（i,n）区间内的最小值,将最小值放到arr[i]的位置
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr[i], arr[minIndex]);
    }

    return;
}
#endif //SELECTIONSORT_SELECTIONSORT_H
