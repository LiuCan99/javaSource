package com.company.test.list;

import org.junit.Test;

import java.util.ArrayList;

public class TestList {

    /**
     * ArrayList数组初始化
     * 底层是一个动态数组，初始化大小为10，线程不安全，元素允许重复
     * 扩容为原数组的1.5倍，当添加第11个元素时扩容
     * 扩容时会创建一个新的容量的数组，将原数组的元素拷贝，原数组将会被GC回收
     */
    @Test
    public void initArray(){
        //当用户没有指定 ArrayList 的容量时(即调用无参构造函数)，返回的是该数组==>刚创建一个 ArrayList 时，其内数据量为 0。
        //当用户第一次添加元素时，该数组将会扩容，变成默认容量为 10(DEFAULT_CAPACITY) 的一个数组===>通过  ensureCapacityInternal() 实现
        // 它与 EMPTY_ELEMENTDATA 的区别就是：该数组是默认返回的，而后者是在用户指定容量为 0 时返回
        ArrayList<Integer> list=new ArrayList<>();

        ArrayList<Object> list2=new ArrayList<>(10);
    }

    /**
     * add:添加元素，直接添加到数组的末尾
     * 添加之前需要判断该集合是否需要扩容
     */
    @Test
    public void add(){
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        arrlist.add(35);
    }

    /**
     * remove:移除指定索引的元素，返回被移除的元素（只会删除一个）
     * index:传递索引，返回被移除的元素
     * object：传递元素，返回boolean值,没有该元素返回false
     */
    @Test
    public void remove(){
        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        //移除索引为1的元素,返回被移除的元素
        Integer remove = arrlist.remove(1); //20

        ArrayList<String> arrlist2 = new ArrayList<>();
        arrlist2.add("aa");
        arrlist2.add("aa");
        arrlist2.add("aa");
        arrlist2.add("bb");
        boolean aa = arrlist2.remove("aa");
        boolean  b= arrlist2.remove("88");
    }

    /**
     * get:获得指定索引的元素
     */
    @Test
    public void get(){
        ArrayList<Integer> arrlist = new ArrayList<Integer>(4);
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        Integer integer = arrlist.get(1);
    }

    /**
     *set：将此列表中指定位置的元素替换为，指定的元素。返回的是该索引位置的原元素
     */
    @Test
    public void set(){
        ArrayList<Integer> arrlist = new ArrayList<Integer>(4);
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        //将arrList集合的第0个索引位置的元素值替换为2
        Integer set = arrlist.set(0, 2); //返回原元素值：35
    }

    /**
     *contains:当前集合是否包含指定的元素
     * 底层使用的是indexOf()
     */
    @Test
    public void contains(){
        ArrayList<Integer> arrlist = new ArrayList<Integer>(4);

        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        int i1 = arrlist.indexOf(null); //-1
        boolean contains1 = arrlist.contains(null);//false

        int i2 = arrlist.indexOf(25);//2
        boolean contains2 = arrlist.contains(20);//true

        int i3 = arrlist.indexOf(0);//-1
        boolean contains3 = arrlist.contains(0);//false
    }

    /**
     * trimToSize：整此ArrayList实例的是列表的当前大小的容量。
     *
     * java.util.ArrayList.trimToSize()
     * 方法修整此ArrayList实例的是列表的当前大小的容量。
     * 应用程序可以使用此操作，以尽量减少一个ArrayList实例的存储。
     * ArrayList所说没有用的值并不是null，而是ArrayList每次增长会预申请多一点空间，1.5倍+1，
     * 而不是两倍这样就会出现当size() = 1000的时候，ArrayList已经申请了1200空间的情况trimToSize 的作用只是去掉预留元素位置，
     * 就是删除多余的200，改为只申请1000,内存紧张的时候会用到.
     */
    @Test
    public void trimToSize(){
        ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        arrlist.trimToSize();

        for (Integer number : arrlist) {
            System.out.println("Number = " + number);
        }
    }

}
