package com.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BiTreeDemo {
    public static void main(String[] args) {
        BiTree biTree = new BiTree();
        BiTNode biTreeRoot = new BiTNode();
        //A B # D # # C E # # #
        biTree.create(biTreeRoot);
        biTree.preOrderTraverse(biTreeRoot);
        System.out.println("-----------");
        biTree.midOrderTraverse(biTreeRoot);
        System.out.println("-----------");
        biTree.postOrderTraverse(biTreeRoot);
        System.out.println("-----------");
        biTree.levelOrderTraverse(biTreeRoot);
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
        if(!s.equals("#")){
            //  前序中序后序不同是在创建时根结点的顺序不同
            //  以下为前序
            //  中序：lChild -> biTree -> rChild
            //  后序：rChild -> lChild -> biTree
            biTree.data = s;
            if(biTree.lChild == null){
                biTree.lChild = new BiTNode();
            }
            create(biTree.lChild);

            if(biTree.rChild == null){
                biTree.rChild = new BiTNode();
            }
            create(biTree.rChild);
        }
    }

    //  前序遍历
    public void preOrderTraverse(BiTNode biTree){
        if(biTree == null){
            return;
        }
        System.out.println(biTree.data);
        preOrderTraverse(biTree.lChild);
        preOrderTraverse(biTree.rChild);
    }

    //  中序遍历
    public void midOrderTraverse(BiTNode biTree){
        if(biTree == null){
            return;
        }
        midOrderTraverse(biTree.lChild);
        System.out.println(biTree.data);
        midOrderTraverse(biTree.rChild);
    }

    //  后序遍历
    public void postOrderTraverse(BiTNode biTree){
        if(biTree == null){
            return;
        }
        midOrderTraverse(biTree.lChild);
        midOrderTraverse(biTree.rChild);
        System.out.println(biTree.data);
    }

    //  层序遍历
    public void levelOrderTraverse(BiTNode biTree){
        Queue<BiTNode> queue = new LinkedList<>();
        queue.add(biTree);
        while(!queue.isEmpty()){
            BiTNode temp = queue.poll();
            System.out.println(temp.data);
            if(temp.lChild != null){
                queue.add(temp.lChild);
            }
            if(temp.rChild != null){
                queue.add(temp.rChild);
            }
        }
    }
}

//  二叉树结点
class BiTNode{
    public String data; //  数据
    public BiTNode lChild;  //  左子树
    public BiTNode rChild;  //  右子树

    public BiTNode() {
    }

    @Override
    public String toString() {
        return "BiTNode{" +
                "data=" + data +
                '}';
    }
}