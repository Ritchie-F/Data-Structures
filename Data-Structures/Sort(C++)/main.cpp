#include <iostream>
#include "Student.h"
#include "SortTestHelper.h"
#include "SelectionSort.h"
#include "InsertionSort.h"
#include "ShellSort.h"
#include "MergeSort.h"
#include "QuickSort.h"
#include "HeapSort.h"
//#include <algorithm>,C++11 标准中，swap函数就在std这个命名空间中，老版本C++标准需要引入该库。
//#include <string>
using namespace std;
int main(){
//        int a[10] = {10,9,8,7,6,5,4,3,2,1};
//        insertionSort(a ,10);

//        SortTestHelper::printArray(a,10);
//        // 测试模板函数，传入浮点数数组
//        float b[4] = {4.4,3.3,2.2,1.1};
//        selectionSort(b,4);
////        SortTestHelper::printArray(b,4);
//
//        // 测试模板函数，传入字符串数组
//        string c[4] = {"D","C","B","A"};
//        selectionSort(c,4);
////        SortTestHelper::printArray(c,4);
//        Student d[4] = { {"D",90} , {"C",100} , {"B",95} , {"A",95} };
//        selectionSort(d,4);
////        SortTestHelper::printArray(d,4);




    int n = 1000000;

    // 测试1 一般性测试
    cout<<"Test for random array, size = "<<n<<", random range [0, "<<n<<"]"<<endl;
    int* arr1 = SortTestHelper::generateRandomArray(n,0,n);
    int* arr2 = SortTestHelper::copyIntArray(arr1, n);
    int* arr3 = SortTestHelper::copyIntArray(arr1, n);
    int* arr4 = SortTestHelper::copyIntArray(arr1, n);
    int* arr5 = SortTestHelper::copyIntArray(arr1, n);
    int* arr6 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);
//    SortTestHelper::testSort("Quick Sort 2 Ways", quickSort2Ways, arr3, n);
//    SortTestHelper::testSort("Quick Sort 3 Ways", quickSort3Ways, arr4, n);
    SortTestHelper::testSort("Heap Sort 1", heapSort1, arr5, n);
    SortTestHelper::testSort("Heap Sort 2", heapSort2, arr6, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;
    delete[] arr5;
    delete[] arr6;

    cout<<endl;


    // 测试2 测试近乎有序的数组
    int swapTimes = 100;
    cout<<"Test for nearly ordered array, size = "<<n<<", swap time = "<<swapTimes<<endl;
    arr1 = SortTestHelper::generateNearlyOrderedArray(n,swapTimes);
    arr2 = SortTestHelper::copyIntArray(arr1, n);
    arr3 = SortTestHelper::copyIntArray(arr1, n);
    arr4 = SortTestHelper::copyIntArray(arr1, n);
    arr5 = SortTestHelper::copyIntArray(arr1, n);
    arr6 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);
  //  SortTestHelper::testSort("Quick Sort 2 Ways", quickSort2Ways, arr3, n);
  //  SortTestHelper::testSort("Quick Sort 3 Ways", quickSort3Ways, arr4, n);
    SortTestHelper::testSort("Heap Sort 1", heapSort1, arr5, n);
    SortTestHelper::testSort("Heap Sort 2", heapSort2, arr6, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;
    delete[] arr5;
    delete[] arr6;

    cout<<endl;


    // 测试3 测试存在包含大量相同元素的数组
    cout<<"Test for random array, size = "<<n<<", random range [0,10]"<<endl;
    arr1 = SortTestHelper::generateRandomArray(n,0,10);
    arr2 = SortTestHelper::copyIntArray(arr1, n);
    arr3 = SortTestHelper::copyIntArray(arr1, n);
    arr4 = SortTestHelper::copyIntArray(arr1, n);
    arr5 = SortTestHelper::copyIntArray(arr1, n);
    arr6 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Merge Sort", mergeSort, arr1, n);
    // 这种情况下, 普通的QuickSort退化为O(n^2)的算法, 不做测试
    //SortTestHelper::testSort("Quick Sort", quickSort, arr2, n);
//    SortTestHelper::testSort("Quick Sort 2 Ways", quickSort2Ways, arr3, n);
//    SortTestHelper::testSort("Quick Sort 3 Ways", quickSort3Ways, arr4, n);
    SortTestHelper::testSort("Heap Sort 1", heapSort1, arr5, n);
    SortTestHelper::testSort("Heap Sort 2", heapSort2, arr6, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;
    delete[] arr5;
    delete[] arr6;

    return 0;


}

