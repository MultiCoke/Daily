package com.datastructures.list;

import java.util.Stack;

public class SingleLinkedListInstanceDemo {
    public static void main(String[] args) {
        HeroSingleLinkedList sl1 = new HeroSingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(7, "林冲", "豹子头");

        //添加节点
//        sl1.add(hero1);
//        sl1.add(hero3);
//        sl1.add(hero2);
//        sl1.add(hero4);

        //按顺序添加节点
        sl1.addOrderByNo(hero1);
        sl1.addOrderByNo(hero3);
        sl1.addOrderByNo(hero2);
        sl1.addOrderByNo(hero4);
        sl1.list();
        System.out.println("sl1");
        System.out.println(sl1.getHead().hashCode());
        System.out.println("---------------");

/*        //逆序打印
        System.out.println("逆向打印");
        SingleLinkedList.reversePrint(sl1.getHead());

        //更新节点
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        sl1.update(newHeroNode);
        System.out.println("更新后的节点");
        sl1.list();

        //删除节点
        sl1.delete(1);
        System.out.println("删除后的节点");;
        sl1.list();

        //链表节点个数
        System.out.println("有效节点的个数为：" + SingleLinkedList.getLength(sl1.getHead()));

        //得到倒数第一个节点
        System.out.println("倒数第1个节点信息：" + SingleLinkedList.getIndex(sl1.getHead(), 1));*/

        //反转单链表
        HeroSingleLinkedList.reverse(sl1.getHead());
        sl1.list();

        //合并两个单向链表
        HeroSingleLinkedList sl2 = new HeroSingleLinkedList();
        System.out.println("sl2");
        System.out.println(sl2.getHead().hashCode());

        HeroNode hero5 = new HeroNode(2, "xx", "yy");
        HeroNode hero6 = new HeroNode(4, "ww", "ee");
        HeroNode hero7 = new HeroNode(6, "ss", "dd");
        HeroNode hero8 = new HeroNode(8, "bb", "nn");

        sl2.add(hero5);
        sl2.add(hero6);
        sl2.add(hero7);
        sl2.add(hero8);
        System.out.println("----------------");

        //合并后的链表

        HeroNode sl2Head = sl2.getHead().next;
        HeroNode temp;
        while(sl2Head != null){
            temp = sl2Head;
            sl2Head = sl2Head.next;
            sl1.addOrderByNo(temp);
        }

        System.out.println("---------------");
        sl1.list();
    }
}


//创建一个单向链表类
class HeroSingleLinkedList{
    //创建一个头节点
    private HeroNode head;

    public HeroSingleLinkedList() {
        this.head = new HeroNode(0, "", "");
    }

    public HeroNode getHead() {
        return head;
    }

    //添加节点
    public void add(HeroNode hn){
        //使用临时节点指向头节点
        HeroNode temp = this.head;
        //移动临时节点到最后一个节点
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //将最后一个节点指向新添加的节点
        temp.next = hn;
    }

    //按编号的顺序插入
    public void addOrderByNo(HeroNode hn){
        HeroNode temp = this.head;
        //是否可添加标值
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            else if(temp.next.no > hn.no){
                break;
            }
            else if(temp.next.no == hn.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(!flag){
            //交换引入位置
            hn.next = temp.next;
            temp.next = hn;
        }
        else{
            System.out.printf("编号%d已存在。无法添加", hn.no);
        }
    }

    //更新节点
    public void update(HeroNode newHeroNode){
        if(this.head == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;
        //是否找到更新节点
        boolean flag = false;

        while(true){
            if (temp.next == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = newHeroNode.name;
            temp.nikeName = newHeroNode.nikeName;
        }
        else{
            System.out.println("未找到节点");
        }
    }

    //删除节点
    public void delete(int no){
        if(this.head == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;
        //是否找到删除节点
        boolean flag = false;

        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }
        else{
            System.out.println("未找到节点");
        }
    }


    //获取到单链表的有效节点的个数

    /**
     *
     * @param head 链表的头节点
     * @return 有效节点的个数
     */
    public static int getLength(HeroNode head){
        if(head.next == null){
           return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表中的倒数第index个节点的数据
    public static HeroNode getIndex(HeroNode head, int index){
        if(head.next == null){
            return null;
        }
        int size = getLength(head);
        if (index > 0 && index < size){
            HeroNode cur = head.next;
            for (int i = 0; i < size - index; i++) {
                cur = cur .next;
            }
            return cur;
        }
        else{
            return null;
        }
    }

    //反转单链表
    public static void  reverse(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverse = new HeroNode(0, "", "");
        while(cur != null){
            //保存当前节点的下一个节点
            next = cur.next;
            //把当前节点指向reverse的下一个节点，接力指向
            cur.next = reverse.next;
            //把reverse指向当前节点
            reverse.next = cur;
            //移动cur
            cur = next;
        }
        //把头节点指向与新节点交换
        head.next = reverse.next;

    }

    //反转打印链表
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;
        }

        //创建一个栈，存储链表元素
        Stack<HeroNode> heroNodeStack = new Stack<>();
        //遍历链表，存入栈
        HeroNode cur = head.next;
        while(cur != null){
            heroNodeStack.push(cur);
            cur = cur.next;
        }
        //出栈打印
        while(heroNodeStack.size() > 0){
            System.out.println(heroNodeStack.pop());
        }
    }

    //遍历链表
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
        }

        //将临时节点指向第一个节点
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            //打印节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//创建头节点
class HeroNode{
    public int no;
    public String  name;
    public String  nikeName;
    public HeroNode next;

    public HeroNode(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
        this.next = null;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
