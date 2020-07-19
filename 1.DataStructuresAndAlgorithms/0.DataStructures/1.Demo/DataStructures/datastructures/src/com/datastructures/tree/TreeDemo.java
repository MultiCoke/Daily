package com.datastructures.tree;

public class TreeDemo {
}

//  双亲表示法树结构
class PTree<E>{
    private Object[] nodes;  //  存储结点的数组
    private int r;              //  根结点位置
    private int n;              //  结点数

    private static final int MAX_TREE_SIZE = 100;   //  最大容量

    public PTree() {
        this.nodes = new Object[MAX_TREE_SIZE];
    }

    //  添加结点

}

//  双亲表示法结点
class PTNode<E>{
    public E data;  //  结点数据
    int parent; //  双亲位置

    public PTNode(E data, int parent) {
        this.data = data;
        this.parent = parent;
    }
}