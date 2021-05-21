package com.company.test.hashmap;

import com.company.test.User;
import org.junit.Test;

import java.util.HashMap;

public class CarefulMap {

    /**
     * map使用非系统key时，需要重写equals和hashCode，否则value为null
     * 因为hashMap是根据key的hash值来 equals对比查询value的
     */
    @Test
    public void aboutKey(){
        User user = new User(18,"jack","男");
        HashMap<User,String> map=new HashMap<>();
        map.put(user,"jack");

        System.out.println(map.get(new User(18,"jack","男") ));
    }
}
