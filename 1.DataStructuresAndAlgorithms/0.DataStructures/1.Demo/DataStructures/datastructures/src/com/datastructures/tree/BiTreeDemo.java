package com.datastructures.tree;

import java.util.Scanner;

public class BiTreeDemo {
    public static void main(String[] args) {
        BiTree biTree = new BiTree();
        BiTNode biTreeRoot = new BiTNode();
        biTree.create(biTreeRoot);
        biTree.preOrderTraverse(biTreeRoot);
    }
}

//  二叉树
class BiTree{
    private final Scanner sc;

    public BiTree() {
        this.sc = new Scanner(System.in);
    }

    //  创建树
    public void create(BiTNode biTree){
        String s = sc.nextLine();
        if(s.equals("#")){
            biTree = null;
        }else{
            //  前序中序后序不同是在创建时根结点的顺序不同
            //  以下为前序
            //  中序：lchild -> bitree -> rchild
            //  后序：rchild -> lchild -> bitree
            biTree.data = s;
            if(biTree.lchild == null){
                biTree.lchild = new BiTNode();
            }
            create(biTree.lchild);

            if(biTree.rchild == null){
                biTree.rchild = new BiTNode();
            }
            create(biTree.rchild);
        }
    }

    //  前序遍历
    public void preOrderTraverse(BiTNode biTree){
        if(biTree == null){
            return;
        }
        System.out.println(biTree.data);
        preOrderTraverse(biTree.lchild);
        preOrderTraverse(biTree.rchild);
    }
}

//  二叉树结点
class BiTNode{
    public String data; //  数据
    public BiTNode lchild;  //  左子树
    public BiTNode rchild;  //  右子树

    public BiTNode() {
    }

    public BiTNode(String data) {
        this.data = data;
        this.lchild = null;
        this.rchild = null;
    }

    @Override
    public String toString() {
        return "BiTNode{" +
                "data=" + data +
                '}';
    }
}