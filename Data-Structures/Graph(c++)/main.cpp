#include <iostream>
#include <cstdlib>
#include <ctime>
#include "SparseGraph.h"
#include "DenseGraph.h"
#include "ReadGraph.h"
#include "Component.h"
using namespace std;

int main() {
    //测试1


//    //创建一个有20个节点，100条边的图，100条边随机生成
//    int N = 20;
//    int M = 100;
//
//    srand(time(NULL));
//
//    //SparseGraph
//    SparseGraph g1(N , false);//N个节点的稀疏图，并且为无向图
//    for (int i = 0; i < M ; i ++) {
//        int a = rand()%N;
//        int b = rand()%N;
//        g1.addEdge(a , b);
//    }
//    //遍历；O(E),有多少条边就遍历了多少次
//    for (int v = 0; v < N ; v++) {
//        cout<<v<<" : ";
//        SparseGraph::adjIterator adj(g1,v);
//        for (int w = adj.begin(); !adj.end(); w = adj.next()) {
//            cout<<w<<" ";
//        }
//        cout<<endl;
//
//    }
//    cout<<endl;
//
//    //Dense Graph
//    DenseGraph g2(N , false);
//    for (int i = 0; i < M ; i ++) {
//          int a = rand()%N;
//          int b = rand()%N;
//          g2.addEdge(a , b);
//    }
//    //遍历 O(V^2)
//    for (int v = 0; v < N ; v ++) {
//        cout<<v<<" ";
//        DenseGraph::adjIterator adj(g2,v);
//        for (int w = adj.begin(); !adj.end(); w = adj.next()) {
//            cout<<w<<" ";
//        }
//        cout<<endl;
//    }
//    return 0;
    //测试2

    // 使用两种图的存储方式读取testG1.txt文件
//    string filename = "testG1.txt";
//    SparseGraph g1( 13 , false );
//    ReadGraph<SparseGraph> readGraph1( g1 , filename );
//    cout<<"test G1 in Sparse Graph:" << endl;
//    g1.show();
//
//    cout<<endl;
//
//    DenseGraph g2( 13 , false );
//    ReadGraph<DenseGraph> readGraph2( g2 , filename );
//    cout<<"test G2 in Dense Graph:" << endl;
//    g2.show();
//
//    cout<<endl;
// TestG1.txt - g1 and g2
    string filename1 = "testG1.txt";
    SparseGraph g1 = SparseGraph(13, false);
    ReadGraph<SparseGraph> readGraph1(g1, filename1);
    Component<SparseGraph> component1(g1);
    cout<<"TestG1.txt, Using Sparse Graph, Component Count: "<<component1.count()<<endl;

    DenseGraph g2 = DenseGraph(13, false);
    ReadGraph<DenseGraph> readGraph2(g2, filename1);
    Component<DenseGraph> component2(g2);
    cout<<"TestG1.txt, Using Dense Graph, Component Count: "<<component2.count()<<endl;

    cout<<endl;

    // TestG2.txt - g3 and g4
    string filename2 = "testG2.txt";
    SparseGraph g3 = SparseGraph(7, false);
    ReadGraph<SparseGraph> readGraph3(g3, filename2);
    Component<SparseGraph> component3(g3);
    cout<<"TestG2.txt, Using Sparse Graph, Component Count: "<<component3.count()<<endl;

    DenseGraph g4 = DenseGraph(7, false);
    ReadGraph<DenseGraph> readGraph4(g4, filename2);
    Component<DenseGraph> component4(g4);
    cout<<"TestG2.txt, Using Dense Graph, Component Count: "<<component4.count()<<endl;

}