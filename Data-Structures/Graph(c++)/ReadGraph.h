//
//Created by Ritchie on 9/6/18.
//

#ifndef GRAPH_READGRAPH_H
#define GRAPH_READGRAPH_H

#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <cassert>

using namespace std;

// 读取图算法
template <typename Graph>
class ReadGraph{

public:
    // 从文件filename中读取图的信息, 存储进图graph中
    ReadGraph(Graph &graph, const string &filename){

        ifstream file(filename);//文件是否存在
        string line;
        int V, E;

        assert( file.is_open() );//文件是否可以打开

        // 第一行读取图中的节点个数和边的个数
        assert( getline(file, line) );//读取第一行，放入字符串line中
        stringstream ss(line);//line中字符串放入stringstream ss中
        ss>>V>>E;//读取点数和边数

        assert( V == graph.V() );//图在构造的时候便需要传入点数，此处需要判断外部定义的点数和图定义中的点的数目是否一致

        // 读取每一条边的信息
        for( int i = 0 ; i < E ; i ++ ){

            assert( getline(file, line) );
            stringstream ss(line);

            int a,b;
            ss>>a>>b;
            assert( a >= 0 && a < V );
            assert( b >= 0 && b < V );
            graph.addEdge( a , b );
        }
    }
};

#endif //GRAPH_READGRAPH_H
