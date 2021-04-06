package com.company.test.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    /**
     * HasnMap集合
     * 底层是的数组+链表+红黑树，jdk 1.8之前都是数组+链表的结构，
     * 初始化大小为16（2的4次方），最大容量为2的30次方，线程不安全，key不可以重复,无序
     * 扩容当长度>length*0.75（负载因子）时扩容
     *
     *
     */
    @Test
    public void initHashMap(){
        HashMap<String,Integer> map=new HashMap<>();

        HashMap<String,Integer> map2=new HashMap<>(20);

        HashMap<String,Integer> map3=new HashMap<>(20,1);
    }

    /**
     * put:添加元素 （key，value）
     * 当再次添加的元素key相同时，之前的会被覆盖
     * 1.根据key计算hash值，判断该哈希桶位置是否有值
     * 2.1 有哈希冲突
     *   插入元素的hash值与首节点hash值一致，则记录首节点
     *   插入元素hash值与首节点不一致，但属于红黑树节点，
     *       判断红黑树节点中该节点是否存在，添加成功返回null
     *   插入元素不为首节点，不为红黑树节点，则为链表节点
     *      遍历链表，查询是否有该节点
     *      没有该节点，添需要判断添加的当前元素是否需要转换为红黑树结构
     * 2.2 没有hash冲突，根据hash值更新value值
     * 3.添加元素，判断是否需要扩容，更新长度、修改次数
     */
    @Test
    public void put(){
        HashMap<String,Integer> map=new HashMap<>();
        /**
         * 而key的hash值，并不仅仅只是key对象的hashCode()方法的返回值，还会经过扰动函数的扰动，以使hash值更加均衡。
         * 因为hashCode()是int类型，取值范围是40多亿，只要哈希函数映射的比较均匀松散，碰撞几率是很小的。
         * 但就算原本的hashCode()取得很好，每个key的hashCode()不同，但是由于HashMap的哈希桶的长度远比hash取值范围小，默认是16，
         * 所以当对hash值以桶的长度取余，以找到存放该key的桶的下标时，由于取余是通过与操作完成的，会忽略hash值的高位。
         * 因此只有hashCode()的低位参加运算，发生不同的hash值，但是得到的index相同的情况的几率会大大增加，这种情况称之为hash碰撞。 即，碰撞率会增大。
         *
         * 扰动函数就是为了解决hash碰撞的。它会综合hash值高位和低位的特征，并存放在低位，因此在与运算时，相当于高低位一起参与了运算，以减少hash碰撞的概率。
         * （在JDK8之前，扰动函数会扰动四次，JDK8简化了这个操作）
         *
         * 扩容操作时，会new一个新的Node数组作为哈希桶，然后将原哈希表中的所有数据(Node节点)移动到新的哈希桶中，相当于对原哈希表中所有的数据重新做了一个put操作。
         * 所以性能消耗很大，可想而知，在哈希表的容量越大时，性能消耗越明显。
         */
        map.put("jack",18);
    }

    /**
     * remove:删除指定key
     * 1.判断移除节点在数组、链表还是红黑树上
     *   1.1数组上，则记录要删除的元素节点
     *   1.2在红黑树上，遍历红黑树，找到并返回该节点
     *   1.3在链表上，遍历找到该节点
     *2.删除节点
     *  2.1如果删除的节点是红黑树结构，则去红黑树中删除
     *  2.2如果是链表结构，且删除的节点为数组下标节点，也就是头结点，直接让下一个作为头
     *  2.3为链表结构，删除的节点在链表中，把要删除的下一个结点设为上一个结点的下一个节点
     *3. 更新计数器、长度
     *4.删除
     *   4.1返回删除的节点，删除成功
     *   4.2返回null表示没有该节点，删除失败
     */
    @Test
    public void remove(){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("jack",18);
        map.put("rose",19);

        map.remove("jack");
    }

    /**
     * get:获得指定key的value
     * 1.如果是头结点，则直接返回头结点
     * 2.是红黑树结构,红黑树中找，然后返回
     * 3.链表节点，一样遍历链表，找到该节点并返回
     */
    @Test
    public void get(){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("jack",18);
        map.put("rose",19);

        Integer jack = map.get("jack");
    }

    /**
     *clear:把所有的数组下标元素都置位null
     */
    @Test
    public void clear(){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("jack",18);
        map.put("rose",19);

        map.clear();
    }


    /**
     * 小结：
     * 运算尽量都用位运算代替，更高效。
     * 对于扩容导致需要新建数组存放更多元素时，除了要将老数组中的元素迁移过来，也记得将老数组中的引用置null，以便GC
     * 取下标 是用 哈希值 与运算 （桶的长度-1） i = (n - 1) & hash。 由于桶的长度是2的n次方，这么做其实是等于 一个模运算。但是效率更高
     * 扩容时，如果发生过哈希碰撞，节点数小于8个。则要根据链表上每个节点的哈希值，依次放入新哈希桶对应下标位置。
     * 因为扩容是容量翻倍，所以原链表上的每个节点，现在可能存放在原来的下标，即low位， 或者扩容后的下标，即high位。 high位= low位+原哈希桶容量
     * 利用哈希值 与运算 旧的容量 ，if ((e.hash & oldCap) == 0),可以得到哈希值去模后，是大于等于oldCap还是小于oldCap，等于0代表小于oldCap，应该存放在低位，否则存放在高位。这里又是一个利用位运算 代替常规运算的高效点
     * 如果追加节点后，链表数量》=8，则转化为红黑树
     * 插入节点操作时，有一些空实现的函数，用作LinkedHashMap重写使用。
     */
}
