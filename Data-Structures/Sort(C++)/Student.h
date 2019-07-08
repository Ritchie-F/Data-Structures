//
// Created by ${Ritchie} on 2018/9/4.
//
#ifndef SELECTIONSORT_STUDENT_H
#define SELECTIONSORT_STUDENT_H
#include <iostream>
//#include <string>
using namespace std;
struct Student{
    string name;
    int score;
    // 重载小于运算法,定义Student之间的比较方式
    // 如果分数相等，则按照名字的字母序排序
    // 如果分数不等，则分数高的靠前
    bool operator<(const Student& otherStudent){
        return score != otherStudent.score ? score > otherStudent.score : name < otherStudent.name;
    }

    // 重载<<符号, 定义Student实例的打印输出方式
    friend ostream& operator<<(ostream &os, const Student &student){
        os<<"Student: "<<student.name<<" "<<student.score;
        return os;
    }
};
#endif //SELECTIONSORT_STUDENT_H
