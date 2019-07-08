//
// Created by Ritchie on 9/6/18.
//

#ifndef GRAPH_COMPONENT_H
#define GRAPH_COMPONENT_H

//求图的联通分量
#include <iostream>
#include <cassert>
using namespace std;


template <typename Graph>
class Component{

private:
    Graph &G;
    bool* visited;
    int ccount = 0;//记录有多少个联通分量
    int *id; //int型的id数组，用来判断两个节点是否相连，相连的节点id取同样的值，不相连的取不同值

    void dfs( int v ){//深度优先遍历
        visited[v] = true;
        id[v] = ccount;//可以连接的节点的id数组值为同一联通分量编号。
        typename Graph::adjIterator adj(G,v); //编译器无法辨别adjIterator是类Graph中的某个类还是方法
                                                //所以需要显示的添加关键字 typename，申明这是一个类
        for( int i = adj.begin() ; !adj.end() ; i = adj.next() ) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

public:
    Component(Graph &graph):G(graph){

        visited = new bool[G.V()];
        id = new int[G.V()];
        for( int i = 0 ; i < G.V() ; i ++ ){
            visited[i] = false;
            id[i] = -1;
        }
        ccount = 0;

        for( int i = 0 ; i < G.V() ; i ++ )
            if( !visited[i] ){
                //对一个没有访问过的节点进行一次深度优先遍历，联通分量数目加1
                dfs(i);
                ccount += 1;
            }
    }

    ~Component(){

        delete [] visited;
        delete [] id;
    }

    int count(){
        return ccount;
    }

    bool isConnected( int v , int w ){//判断两个节点是否连接

        assert( v >= 0 && v < G.V() );
        assert( w >= 0 && w < G.V() );
        assert( id[v] != -1 && id[w] != -1 );
        return id[v] == id[w];
    }
};
#endif //GRAPH_COMPONENT_H
