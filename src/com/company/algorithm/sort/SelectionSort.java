package com.company.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序：
 * 选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。
 * 所以用到它的时候，数据规模越小越好。
 * 唯一的好处可能就是不占用额外的内存空间了吧。
 *
 *  算法步骤：
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {

    @Test
    public void selection(){
        int[] sourceArray={1,5,3,9,7};

        //记录每一轮最大的值
        int temp;
        for(int i=0;i<sourceArray.length-1;i++){
            for (int j=i+1;j<sourceArray.length;j++){
                if(sourceArray[i]<sourceArray[j]){
                    temp=sourceArray[i];
                    sourceArray[i]=sourceArray[j];
                    sourceArray[j]=temp;
                }
            }

        }
        System.out.println(Arrays.toString(sourceArray));
    }
}
