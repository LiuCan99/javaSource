package com.company.test.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * LinkedList
 * 底层是由双向链表实现，没有初始化大小也没有扩容机制，
 * 线程不安全
 * 直接在头部或尾部添加
 *
 * https://blog.csdn.net/m0_37884977/article/details/80467658
 */
public class LinkedListTest {

    /**
     * 初始化LinkesList
     *  Node 类是LinkedList中的私有内部类，LinkedList中就是通过Node来存储集合中的元素。
     *  ArrayList比它多提供了一个通过设置初始化容量来初始化类。
     *  LinkedList不提供该方法的原因：因为LinkedList底层是通过链表实现的，每当有新元素添加进来的时候，
     *  都是通过链接新的节点实现的，也就是说它的容量是随着元素的个数的变化而动态变化的。
     *  而ArrayList底层是通过数组来存储新添加的元素的，所以我们可以为ArrayList设置初始容量（实际设置的数组的大小）。
     */
    @Test
    public void initLinkedList(){
        //无参，初始化
        LinkedList<Integer> list=new LinkedList<>();

        //传入一个集合（Collection）作为参数初始化LinkedList
        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);
        LinkedList<Integer> list2=new LinkedList<>(arrlist);
    }


    /**
     * add/offer:添加元素
     * 1.记录原尾节点信息
     * 2.设置新添加的元素为为节点，（原尾节点的指针，添加的元素，null）
     * 3.原集合如果为空集合则将新添加的元素设置为头节点，不为空则设置为尾节点
     * 4.更新集合长度、修改次数标识
     */
    @Test
    public void add(){
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(1);
        linkedList.offer(2);

        linkedList.add(1,8);
    }

    /**
     * get:获得指定索引的元素
     * 1.比较指定索引更靠近链表（LinkedList）的头节点还是尾节点
     * 2.然后从头/尾进行遍历获得指定索引上的节点信息
     * 3.获得节点上的值
     */
    @Test
    public void get(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");

        String s = linkedList.get(1);
    }
    /**
     * remove：删除指定索引元素
     * 1.遍历获得该索引位置的节点元素
     * 2.如果待删除的上一个节点为空则说明他是头节点，将他的下一个节点设置为头节点；不为空则将待删除的节点前后连接起来
     * 3.如果待删除的下一个节点为空则说明他是尾节点，将他的上一个节点设置为尾节点；不为空则将待删除的节点前后连接起来
     * 4.更新集合长度、集合修改次数
     */
    @Test
    public void remove(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");

        linkedList.remove(1);
        System.out.println(linkedList.toString());
    }


    /**
     * clear:清空LinkedList中的所有元素
     * 1.直接遍历整个LinkedList，然后把每个节点都置空
     * 2.最后要把头节点和尾节点设置为空，size也设置为空，但是modCount仍然自增
     */
    @Test
    public void clear(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");

        linkedList.clear();
        System.out.println(linkedList.toString());
    }

    /**
     * contains:判断LinkedList是否包含某一个元素
     * 1.底层通过调用indexof()。该方法主要用于计算元素在LinkedList中的位置。
     * 2.首先依据obejct是否为空，分为两种情况：
     * 然后通过在每种情况下，从头节点开始遍历LinkedList，判断是否有与object相等的元素，
     * 如果有，则返回对应的位置index，如果找不到，则返回-1。
     *
     */
    @Test
    public void contains(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");
        boolean aa = linkedList.contains("aa");

    }

    /**
     * element:返回头节点的值。(为null抛异常)
     * （调用该方法：如果头节点为空，则抛出NoSuchElementException。）
     */
    @Test
    public void element(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");

        String element = linkedList.element();
    }

    /**
     * peek:返回头节点的值。（为null返回null）
     */
    @Test
    public void peek(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");

        String peek = linkedList.peek();
    }


    /**
     *pop:弹出头结点的元素。（删除头结点的值，并返回删除的值）
     */
    @Test
    public void pop(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");

        String pop = linkedList.pop();
    }

    /**
     * push:增加一个新的元素：（新添加的元素位于LinkedList的头结点。）
     */
    @Test
    public void push(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");

       linkedList.push("cc");
    }








}
