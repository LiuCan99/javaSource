package com.company.test.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

    @Test
    public void initSet(){
        HashSet<String> hashSet=new HashSet<>();
    }

    @Test
    public void get(){
        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("aa");
        hashSet.add("dd");
        //添加
        hashSet.add("cc");
        //移除
        hashSet.remove("aa");
        //判空
        hashSet.isEmpty();
        //包含
        boolean aa = hashSet.contains("aa");


        //遍历
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
