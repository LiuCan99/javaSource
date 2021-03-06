package com.company.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序:
 * 冒泡排序（Bubble Sort）也是一种简单直观的排序算法。
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 *
 *  算法步骤:
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {

    @Test
    public void bubble(){
        int[] sourceArray={1,5,3,9,7};
        int temp;
        //i 控制循环次数
        for(int i=1;i<sourceArray.length;i++){
            //j 内层循环，控制每次交换位置的元素  -i已经排序完成的元素不需要再次比较
            for(int j=0;j<sourceArray.length-i;j++){
                //比较相邻的两个元素，符合条件则交换位置
                if(sourceArray[j]<sourceArray[j+1]){
                    temp=sourceArray[j];
                    sourceArray[j]=sourceArray[j+1];
                    sourceArray[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(sourceArray));


    }
}
