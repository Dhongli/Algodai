package com.dai.algo.sort;

import java.util.Arrays;

public class QuikSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{4, 5, 8, 6, 7, 1, 2, 3};
        int[] arr = new int[]{4, 5, 8, 6, 7, 10, 1, 2, 3};
//        int[] arr = new int[]{1,3,2,4};
//        int[] arr = new int[]{6, 5, 8, 4, 7, 1, 2, 3};
//        quikSort(arr, 0, arr.length - 1);
//        quickSort1(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 挖坑填坑法,先把基准挖出来给x(第一个数),在最右边开始找比基准x小的给第一个位置填上,然后i后移,找比x大的给j位置填上,j前移
     */
    private static void quickSort(int s[], int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) {
                    j--;
                }
                if (i < j) {
                    s[i++] = s[j];
                }
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j) {
                    s[j--] = s[i];
                }
            }
            // 当i,j在中路会和后,把基准给中路填上,此时基准左边都比基准小,右边都比基准大
            s[i] = x;
            // 向左向右递归重复找基准挖坑填坑
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }

    private static void quickSort1(int[] arr, int l, int r) {
        if (l < r) {
            int i = l + 1;
            int j = r;
            while (i < j) {
                while (arr[i] < arr[l]) {
                    i++;
                }
                while (arr[j] > arr[l]) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // 做下面这两步,导致程序出错,[4, 5, 8, 6, 7, 1, 2, 3]-->[7, 3, 2, 1, 4, 6, 8, 5]
//            i++;
//            j--;
            }
            if (i >= j) {
                int temp = arr[l];
                arr[l] = arr[j];
                arr[j] = temp;
            }
            // 向左递归
            if (l < j) {
                quickSort1(arr, l, j - 1);
            }
        }
    }

    public static void quickSort2(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        /*//向左递归
        if(left < r) {
            quickSort2(arr, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort2(arr, l, right);
        }*/
    }

    static void quickSort3(int d[], int lf, int rg) {
        int i, j, tmp;
        int lf_idx;
        int rg_idx;
        if (lf < rg) {
            lf_idx = lf + 1;
            rg_idx = rg;
            while (true) {
                for (i = lf + 1; i <= rg; i++) {
                    if (d[i] >= d[lf]) {
                        lf_idx = i;
                        break;
                    }
                    lf_idx++;
                }
//{4, 5, 8, 6, 7, 1, 2, 3}
                for (j = rg; j >= lf + 1; j--) {
                    if (d[j] <= d[lf]) {
                        rg_idx = j;
                        break;
                    }
                    rg_idx--;
                }

                if (lf_idx < rg_idx) {
                    tmp = d[lf_idx];
                    d[lf_idx] = d[rg_idx];
                    d[rg_idx] = tmp;
                } else {
                    break;
                }
            }
            if (lf_idx >= rg_idx) {
                tmp = d[lf];
                d[lf] = d[rg_idx];
                d[rg_idx] = tmp;
//                quickSort3(d,lf,rg_idx-1);
//                quickSort3(d,rg_idx+1,rg);
            }
        }
    }
}
