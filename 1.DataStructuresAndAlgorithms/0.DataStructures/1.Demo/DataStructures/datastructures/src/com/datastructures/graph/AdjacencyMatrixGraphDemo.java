package com.datastructures.graph;

import java.util.*;

public class AdjacencyMatrixGraphDemo {
    public static void main(String[] args) {
        //  初始化一个邻接矩阵
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5);
        //  顶点信息
        String[] vertexes = {"A", "B", "C", "D", "E"};
        //  添加顶点信息
        for (String vertex : vertexes) {
            graph.addVertex(vertex);
        }
        // 添加边 A-B A-C B-C B-D B-E
        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);
        //  展示图
        graph.showGraph();
        //  递归深度优先遍历
        //  graph.dfsStack();
        //  广度优先遍历
        graph.bfs();
    }
}

//  邻接矩阵存储的无向图
class AdjacencyMatrixGraph{
    private ArrayList<String> vertexArr;    //  顶点数组
    private int[][] edges;  //  邻接矩阵
    private int numberOfEdges;  //  边的数目
    private boolean[] isVisited; //  顶点访问标志

    //  构造方法，n表示顶点数
    public AdjacencyMatrixGraph(int n){
        vertexArr = new ArrayList<>(n);
        edges = new int[n][n];
        numberOfEdges = 0;
        isVisited = new boolean[n];
    }

    //  添加顶点
    public void addVertex(String s){
        vertexArr.add(s);
    }

    //  添加边，v1表示边的一个顶点，v2表示边的另一个顶点，weight表示权值
    public void addEdges(int v1, int v2, int weight){
        //  无向图的邻接矩阵是个对称矩阵
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numberOfEdges++;
    }

    //  深度优先遍历
    private void dfs(boolean[] isVisited, int i){
        //  访问第一个顶点信息，打印顶点信息，并把标志位设为true
        System.out.print(vertexArr.get(i));
        isVisited[i] = true;
        //  获取第一个邻接顶点下标
        int w = getFirstAdjacentVertex(i);
        //  如果w不为-1，则继续访问
        while (w != -1){
            //  如果w为-1，获取w的上一个顶点的下一个邻接顶点
            if(!isVisited[w]){
                dfs(isVisited, w);
            }else{
                w = getNextAdjacentVertex(i, w);
            }
        }

    }

    //  重载dfs，防止非连通图遍历不全
    public void dfs(){
        for (int i = 0; i < getVertexNumber(); i++) {
            if(!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }

    //  获取index 顶点第一个邻接顶点下标
    //  若存在返回下标，不存在返回-1
    public int getFirstAdjacentVertex(int index){
        for(int i = 0; i < vertexArr.size(); i++){
            if(edges[index][i] != 0){
                return i;
            }
        }
        return -1;
    }

    //  获取当前顶点的下一个邻接顶点
    public int getNextAdjacentVertex(int v1, int v2){
        for(int i = v2 + 1; i < vertexArr.size(); i++){
            if(edges[v1][i] != 0){
                return i;
            }
        }
        return -1;
    }

    //  使用栈实现深度优先算法
    public void dfsStack(){
        for (int i = 0; i < vertexArr.size(); i++) {
            if(!isVisited[i]){
                Stack<Integer> vStack = new Stack<>();
                vStack.push(i);
                while(!vStack.isEmpty()){
                    int temp = vStack.pop();
                    if(isVisited[temp]){
                        continue;
                    }else{
                        isVisited[temp] = true;
                        System.out.println(getVertexByIndex(temp));
                    }
                    for (int j = 0; j < vertexArr.size(); j++) {
                        if(edges[temp][j] != 0 && !isVisited[j]){
                            vStack.push(j);
                        }
                    }
                }
            }
        }
    }

    //  使用队列实现广度优先算法
    public void bfs(){
        for (int i = 0; i < vertexArr.size(); i++) {
            if(!isVisited[i]){
                isVisited[i] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty()){
                    int temp = queue.poll();
                    System.out.println(getVertexByIndex(temp));
                    for(int j = 0; j < vertexArr.size(); j++){
                        if(edges[temp][j] != 0 && !isVisited[j]){
                            isVisited[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }
        }
    }

    //  获取顶点的个数
    public int getVertexNumber(){
        return vertexArr.size();
    }

    //  获取边的个数
    public int getNumberOfEdges(){
        return numberOfEdges;
    }

    //  获取指定下标的顶点
    public String getVertexByIndex(int index){
        return vertexArr.get(index);
    }

    //  打印邻接矩阵
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
