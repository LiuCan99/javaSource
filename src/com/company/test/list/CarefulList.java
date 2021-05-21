package com.company.test.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CarefulList {


    /**
     *Arrays.asList使用注意事项
     */
    @Test
    public void asList(){
        //1.不能使用基本数据类型作为参数
        int[] ints= new int[] { 1, 2, 3, 4 };
        List<int[]> ints1 = Arrays.asList(ints);
        int size = ints1.size();//-->1 基本类型是不能作为泛型参数

        int a=1;
        int b=1;
        int c=1;
        List<Integer> asList1 = Arrays.asList(a, b, c);

        Integer[] nums1= new Integer[] { 1, 2, 3, 4 };

        //2.数据同步，改变原始数组的内容或者改变通过Arrays.asList方法得到的list的元素值值，相互之间的数据都会自动更新，因为这个方法是将数组和列表链接起来
        List<Integer> asList = Arrays.asList(nums1);

        nums1[0]=999;//原数组
        asList.set(1,888);//集合
        foreach(asList);


        //2）通过Arrays.asList方法得到的list是固定大小的，不可以add或remove方法去改变list的元素
        //todo 会抛出UnsupportedOperationException（不支持操作异常）
//        asList.add(1);
//        asList.remove(1);

        ArrayList arrayList= new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        ArrayList arrayList2= new ArrayList();
        arrayList2.add(1);
        arrayList2.add(3);

        boolean b1 = arrayList.retainAll(arrayList2);

    }

    /**
     * 使用remove注意事项
     */
    @Test
    public void removeNO(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);

        //1.索引删除
        for (int i = 0; i < list.size(); i++) {
            //删除所有为2的元素
            if(list.get(i)==2){
                list.remove(i);
//                i--;
            }
        }
        System.out.print("删除所有为2的元素-->");
        foreach(list);
        //最后输出值为 1，2，3
        //这是因为当遍历得索引为1时删除了第一个2的元素，此时第二个2会移动到被删除索引【1】的位置，但是遍历的索引下一轮是【2】所以最后集合中还是存在2的元素

    }


    @Test
    public void removeOK(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);

        //2.迭代器
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next==3){
                //此处使用的迭代器的remove
                iterator.remove();
            }
        }
        System.out.print("使用迭代器：删除所有为3的元素-->");
        foreach(list);

        //3.lamda表达式
        list.removeIf(n->n==4);
        System.out.print("使用lamda表达式：删除所有为4的元素-->");
        foreach(list);
    }




    /*打印方法*/
    private static void foreach(List list) {
        for (Object object : list) {
            System.out.print(object + ",");
        }
        System.out.println();
    }
}
