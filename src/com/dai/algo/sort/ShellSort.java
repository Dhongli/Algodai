package com.dai.algo.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        //shellSort(arr); //����ʽ
        shellSort2(arr);//��λ��ʽ
        System.out.println(Arrays.toString(arr));
    }

    // ʹ�����Ƶ��ķ�ʽ����дϣ������
    // ϣ������ʱ�� �����������ڲ���ʱ���ý�����,
    // ϣ������ĵ�1������
    // ��Ϊ��1�������ǽ�10�����ݷֳ��� 5��
    // ϣ������ĵ�2������
    // ��Ϊ��2�������ǽ�10�����ݷֳ��� 5/2 = 2��
    // ϣ������ĵ�3������
    // ��Ϊ��3�������ǽ�10�����ݷֳ��� 2/2 = 1��
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count = 0;
        // ����ǰ����𲽷�����ʹ��ѭ������
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // �������������е�Ԫ��(��gap�飬ÿ���и�Ԫ��), ����gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("ϣ�������" + (++count) + "�� =" + Arrays.toString(arr));
        }
    }

    //�Խ���ʽ��ϣ����������Ż�->��λ��
    public static void shellSort2(int[] arr) {

        // ����gap, ���𲽵���С����
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // �ӵ�gap��Ԫ�أ�����������ڵ������ֱ�Ӳ�������
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //�ƶ�
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //���˳�while�󣬾͸�temp�ҵ������λ��
                    arr[j] = temp;
                }

            }
        }
    }
}
