cmake_minimum_required(VERSION 3.12)
project(SelectionSort)

set(CMAKE_CXX_STANDARD 14)

add_executable(SelectionSort main.cpp Student.h SortTestHelper.h SelectionSort.h InsertionSort.h BubbleSort.h ShellSort.h MergeSortBU.h QuickSort.h MergeSort.h HeapSort.h)