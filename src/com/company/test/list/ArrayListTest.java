package com.company.test.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

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

        ArrayList<Object> list2=new ArrayList<>(20);
    }

    /**
     * add:添加元素，直接添加到数组的末尾
     * 添加之前需要判断该集合是否需要扩容
     */
    @Test
    public void add(){
        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist.add(35);
    }

    /**
     * get:获得指定索引的元素
     */
    @Test
    public void get(){
        ArrayList<Integer> arrlist = new ArrayList<>(4);
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
        ArrayList<Integer> arrlist = new ArrayList<>(4);
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        //将arrList集合的第0个索引位置的元素值替换为2
        Integer set = arrlist.set(0, 2); //返回原元素值：35
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
        boolean aa = arrlist2.remove(null);
        boolean  b= arrlist2.remove("88");
    }

    /**
     * removeIf:删除符合条件的元素
     */
    @Test
    public void removeIf(){
        User user1=new User(18,"jack","男");
        User user2=new User(20,"rose","女");
        User user3=new User(22,"tom","男");
        ArrayList<User> arrlist = new ArrayList<>();
        arrlist.add(user1);
        arrlist.add(user2);
        arrlist.add(user3);

//        arrlist.removeIf(null);  抛空指针异常
        arrlist.removeIf(user->user.getAge()>20);
        System.out.println(arrlist);
    }

    /**
     * removeAll、clear
     *clear()方法是为了通过删除所有元素而重置列表，
     * 而removeAll(Collection c)是为了从集合中删除某些存在于另一个提供的集合中的元素，并不是为了从集合中移除所有元素。（底层调用contains方法）
     * 所以如果你的目的是删除所有元素，用clear(),
     * 如果你的目的是删除某些存在于另一集合的元素，那么选择removeAll(Collection c)方法。
     *
     */
    @Test
    public void clearAndRemoveAll(){
        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);
        //直接遍历然后使元素=null，复杂度是O(n)
        arrlist.clear();

        ArrayList<Integer> arrlist2 = new ArrayList<>();
        arrlist2.add(35);
        arrlist2.add(20);
        arrlist2.add(25);
        //检查迭代器顺序返回的每个元素是否包含在特定的集合中。如果存在，调用迭代器的remove方法将它从集合中移除
        //里面会调用contains()方法，removeAll的复杂度是O(n^2)
        arrlist2.removeAll(arrlist);
    }



    /**
     * contains:当前集合是否包含指定的元素
     * 底层使用的是indexOf()
     */
    @Test
    public void contains(){
        ArrayList<Integer> arrlist = new ArrayList<>(4);

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
        ArrayList<Integer> arrlist = new ArrayList<>(5);

        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        arrlist.trimToSize();

        for (Integer number : arrlist) {
            System.out.println("Number = " + number);
        }
    }


    /**
     * iterator:获得迭代器
     * hasNext()：是否有下一个元素
     * next()：下一个元素
     * remove()：移除当前元素
     */
    @Test
    public void iterator(){
        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        Iterator<Integer> iterator = arrlist.iterator();
        //判断是否还有下一个元素
        while (iterator.hasNext()){
            //获得下一个元素
            Integer next = iterator.next();
//            iterator.next()=33;  迭代中不能赋值
            //移除当前元素
            iterator.remove();
        }
        System.out.println(arrlist.toString());
    }

    /**
     *isEmpty：判断集合是否为空
     * 判断实际存储的数据数量（size）是否等于0
     */
    @Test
    public void isEmpty(){
        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        ArrayList<Integer> arrlist2 = new ArrayList<>();

        //实际存储的数据数量
        boolean empty = arrlist.isEmpty();
    }

    /**
     *
     */
    @Test
    public void forEach(){
        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        arrlist.forEach(num->{
            if(num<25){
     //使用for循环删除list中的元素b,会抛出异常ConcurrentModificationException
     //原因：foreach使用迭代器遍历的，在调用next()方法,next()会校验是否有修改,remove的时候对集合进行了修改导致校验不通过
                arrlist.remove(num);
            }
        });
    }

}
