package com.company.test.string;

import org.junit.Test;

public class TestString {

    /**
     * equals 比较的是字符串的内容
     * == 比较的是字符串指向的地址
     */
    @Test
    public void equals(){
        String s1="aaa";
        String s2="bbb";
        boolean equals1 = s1.equals(s2);//false
        boolean equals2 = s1.equals("aaa");//true
        boolean equals3 = s1.equals(new String("aaa"));//true

        boolean e1= s1=="aaa";//true
        boolean e2= s1==new String("aaa");//false new String创建了一个新的对象虽然值一样但是指向的内存地址不一样
    }

    /**
     * String中的equals与contentEquals，这2个方法都可以用来比较String对象内容是否相同。
     * 但是equals只能对2个String对象内容比较，否则返回false；
     * contentEquals比较类型为java.lang.CharSequence的对象内容是否相同。
     */
    @Test
    public void contentEquals(){
       String s1=new String("111");
       String s2=new String("111");
       StringBuilder s3=new StringBuilder("111");

       //true  true
        boolean b = s1.contentEquals(s2);
        boolean equals = s1.equals(s2);

        //true  false
        boolean b1 = s1.contentEquals(s3);
        boolean equals1 = s1.equals(s3);
    }

    /**
     * 	String的isEmpty()方法，在String为null的时候，会出现空指针错误！！！！
     * 	因为，"" 和 new String()，会有占位符，也就是创建了对象，而null的时候，String 不会创建占位符。
     * 	更通俗的说就是："" 和new String() 的时候，String是有长度的，而null没有长度。
     *
     * 	综上，以后判断String的时候，使用lang3下的StringUtiles工具类可以完美的避过以上的坑点。
     * 	StringUtils.isNotBlank（）和StringUtils.isNotEmpty()
     */
    @Test
    public void isEmpty(){
        String str1="12";
        String str2="";
        String str3=null;
        String str4;

        boolean empty = str1.isEmpty();// false
        boolean empty1 = str2.isEmpty();//true
        boolean empty2 = str3.isEmpty();//空指针异常
//        boolean empty3 = str4.isEmpty(); 未初始化编译不通过
    }

    /**
     * 字符串前面部分的每个字符完全一样，返回：后面两个字符串长度差；
     * 字符串前面部分的每个字符存在不一样，返回：出现不一样的字符 ASCII 码的差值。
     * 字符串的每个字符完全一样，返回 0；
     */
    @Test
    public void compareTo(){
        String foo = "ABCDe";

        // 前面和后面每个字符完全一样，返回 0
        String bar01 = "ABC";
        int i = foo.compareTo(bar01); //0

        // 前面每个字符完全一样，返回：后面就是字符串长度差
        String bar02 = "ABCD";
        String bar03 = "ABCDE";
        int i1 = foo.compareTo(bar02);// -1 (前面相等,foo 长度小 1)
        int i2 = foo.compareTo(bar03);// -2 (前面相等,foo 长度小 2)


        // 前面每个字符不完全一样，返回：出现不一样的字符 ASCII 差
        String bar04 = "ABD";
        String bar05 = "aABCD";
        int i3 = foo.compareTo(bar04);// -1  (foo 的 'C' 字符 ASCII 码值为 67，bar04 的 'D' 字符 ASCII 码值为 68。返回 67 - 68 = -1)
        int i4 = foo.compareTo(bar05);// -32 (foo 的 'A' 字符 ASCII 码值为 65，bar04 的 'a' 字符 ASCII 码值为 97。返回 65 - 97 = -32)

        String bysocket01 = "泥瓦匠";
        String bysocket02 = "瓦匠";
        int i5 = bysocket01.compareTo(bysocket02);// -2049 （泥 和 瓦的 Unicode 差值）

    }

    /**
     * regionMatches(int firstStart, String other, int otherStart, int len)
     * 当某个字符串调用该方法时，表示从当前字符串的firstStart位置开始，取一个长度为len的子串；然后从另一个字符串other的otherStart位置开始也取一个长度为len的子串，然后比较这两个子串是否相同，如果这两个子串相同则返回true，否则返回false。
     */
    @Test
    public void regionMatches(){
        String str1="123232345623";
        String str2="12312122323";
        boolean b = str1.regionMatches(1, str2, 1, 2);//true

        //问一个字符串中某个子串出现了多少次？
        int number = 0;
        String str = "fdafdadfadf";
        for (int i = 0; i < str.length(); i++) {
            if (str.regionMatches(i, "da", 0, 2)) {
                number++;
            }
        }
        System.out.println(number);
    }

    /**
     * startsWith("ab",0) 前缀，开始位置
     */
    @Test
    public void startsWith(){
        String str="abcdef";
        boolean a = str.startsWith("ab",0);
        boolean b = str.startsWith("b");
    }

    /**
     * indexOf 查找指定字符的位置
     *
     */
    @Test
    public void indexOf(){
        String string = "aaa456ac";
        //查找指定字符是在字符串中的下标。在则返回所在字符串下标；不在则返回-1.
        int b = string.indexOf("b");// indexOf(String str); 返回结果：-1，"b"不存在

        // 从第四个字符位置开始往后继续查找，包含当前位置
        int a = string.indexOf("a", 3);//indexOf(String str, int fromIndex); 返回结果：6

        //（与之前的差别：上面的参数是 String 类型，下面的参数是 int 类型）参考数据：a-97,b-98,c-99

        // 从头开始查找是否存在指定的字符
        int i = string.indexOf(99);//indexOf(int ch)；返回结果：7
        int c = string.indexOf('c');//indexOf(int ch)；返回结果：7

        //从fromIndex查找ch，这个是字符型变量，不是字符串。字符a对应的数字就是97。
        int i1 = string.indexOf(97, 3);//indexOf(int ch, int fromIndex); 返回结果：6
        int a1 = string.indexOf('a', 3);//indexOf(int ch, int fromIndex); 返回结果：6

    }


    /**
     * 截取字符串
     */
    @Test
    public void substring(){
        String str="abcdefghij";
        //bc
        String substring = str.substring(1, 3);

    }

    /**
     *
     * 拼接字符串，将指定字符串连接到此字符串的结尾。
     */
    @Test
    public void concat(){
        String str="abcdefghij";
        String concat = str.concat("123");
    }

    /**
     *
     */
    @Test
    public void replace(){
        String str="aaaabbbbcccc";
        String aaa = str.replace("aaa", "111");
        String bbb = str.replace('b', '1');

    }
}
