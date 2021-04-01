package com.company.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序:
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
 * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 *
 * 步骤1: 从第一个元素开始，该元素可以认为已经被排序；
 * 步骤2: 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 步骤3: 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 步骤4: 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 步骤5: 将新元素插入到该位置后；
 */
public class InsertionSort {

    @Test
    public void insertion(){
        int[] sourceArray={1,5,3,9,7,2};
        //当前元素
        int current;

        for(int i=0;i<sourceArray.length-1;i++){
            //第一个元素默认已经被排序，所以从i+1开始
            current=sourceArray[i+1];
            //记录当前索引
            int index=i;

            //当前索引>=0 && 下一个元素的值<当前索引值
            while (index>=0&&current>sourceArray[index]){
                //下一个元素的值=当前索引值
                sourceArray[index+1]=sourceArray[index];
                index--;
            }
            //下一个元素的值=当前排序值
            sourceArray[index+1]=current;
        }
        System.out.println(Arrays.toString(sourceArray));
    }




}
