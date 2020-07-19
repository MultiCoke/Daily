# 树

## 1.定义

+ 树是n(n >= 0)个结点的有限集。n = 0时称为空树。在任意一颗非空树中:
  (1) 有且仅有一个特定的称为根Root的结点
  (2) 当n > 1时，其余节点可分为m(m > 0)个互不相交的有限集, T1, T2, Tm, 其中每一个集合本身又是一棵树,并且称为根的子树(SubTree)

![1](https://github.com/Upmerge/Daily/blob/master/1.DataStructuresAndAlgorithms/0.DataStructures/0.Note/image/1.PNG)


## 2.结点分类

+ 结点拥有的子树数称为结点的度(Degree)
+ 度为0的结点称为叶结点(Leaf)或终端结点
+ 度不为0的结点称为非终端结点或分支结点
+ 除根结点之外，分支结点也称为内部结点
+ 树的度是树内各结点的度的最大值

![2](https://github.com/Upmerge/Daily/blob/master/1.DataStructuresAndAlgorithms/0.DataStructures/0.Note/image/2.PNG)

## 3.结点间关系

+ 结点的子树的根称为该结点的孩子，相应地，该结点称为孩子的双亲
+ 同一双亲的孩子之间互称兄弟
+ 结点的祖先是从根到该结点所经分支上的所有结点
+ 以某结点为根的子树中的任一结点都称为该结点的子孙

![3](https://github.com/Upmerge/Daily/blob/master/1.DataStructuresAndAlgorithms/0.DataStructures/0.Note/image/3.PNG)

## 4.结点的其他相关概念

+ 结点的层次从根开始定义起，根为第一层，根的孩子为第二层
+ 双亲在同一层的结点互为堂兄弟
+ 树种结点的最大层次称为树的深度或高度
+ 如果将树种的结点的各子树看成从左到右是有次序的，不能互换的，则称该树为有序树，否则为无序树
+ 森林(Forest)是m(m >= 0)棵互不相交的树的集合

![4](https://github.com/Upmerge/Daily/blob/master/1.DataStructuresAndAlgorithms/0.DataStructures/0.Note/image/4.PNG)

## 5.树的抽象数据类型

## 6.树的存储结构

1. 顺序存储结构

+ 双亲表示法
  + 在每个结点中,附近一个指示器指示其双亲结点到链表中的位置
  + 其中data是数据域,存储结点的数据信息,而parent是指针域
  
![5](https://github.com/Upmerge/Daily/blob/master/1.DataStructuresAndAlgorithms/0.DataStructures/0.Note/image/5.PNG)

+ 孩子表示法
  + 把每个结点的孩子排列起来,以单链表作存储结构,则n个结点有n个孩子链表,如果是叶子结点则此单链表为空。然后n个头指针又组成一个线性表,采用顺序存储结构,存放进一个一维数组中。

![6](https://github.com/Upmerge/Daily/blob/master/1.DataStructuresAndAlgorithms/0.DataStructures/0.Note/image/6.PNG)

+ 孩子兄弟表示法
  + 任意一棵树，它的结点的第一个孩子如果存在就是唯一的，它的右兄弟如果存在也是唯一的。因此，我们设置两个指针，分别指向该结点的第一个孩子和此结点的兄弟。

![7](https://github.com/Upmerge/Daily/blob/master/1.DataStructuresAndAlgorithms/0.DataStructures/0.Note/image/7.PNG)

## 二叉树的定义

1. 定义

+ 二叉树(Binary Tree)是n(N >= 0)个结点的有限集合，该集合或者为空集（称为空二叉树），或者由一个根节点和两颗互不相交的，分别称为根节点的左子树和右子树的二叉树组成。

![8](https://github.com/Upmerge/Daily/blob/master/1.DataStructuresAndAlgorithms/0.DataStructures/0.Note/image/8.PNG)

2. 二叉树特点

+ 每个结点最多有两颗子树，所以二叉树中不存在度大于2的结点。注意不是只有两颗子树，而是最多有。没有子树或者有一颗子树都是可以的。
+ 左子树和右子树是有顺序的，次序不能任意颠倒。
+ 即使树种某结点只有一颗子树，也要区分它是左子树还是右子树。
+ 二叉树的五种基本形态
  + 空二叉树
  + 只有一个根节点
  + 根结点只有左子树
  + 根结点只有右子树
  + 根结点既有左子树又有右子
