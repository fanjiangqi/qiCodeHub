package algorithm.sort;

/**
 * Created by fanjiangqi on 2017/5/6.
 * 堆排序
 * 注意：使用了a[0]，所有第k个节点的父节点是 2k+1, 2k+2， k是偶数子节点k/2-1，奇数k/2
 */
public class HeapSort {
    public static void heapSort(Comparable[] a){
        int hi = a.length - 1 ;
        //堆有序
        for (int k = a.length/2 - 1; k >= 0; k--){
            sink(a, k ,hi);
        }
        while ( hi > 0){
            exch(a, 0, hi--);
            sink(a, 0, hi);
        }
    }

    /**
     * 下沉函数
     * @param a
     * @param k 下沉的那个元素
     * @param n 下沉的范围
     */
    private static void sink(Comparable[] a, int k, int n){
        while (2 * k + 1 <= n){
            int j = 2 * k + 1;
            if (j < n && less(a, j, j+1))
                j++;
            if (less(a, j, k))
                break; //需要下沉的元素比2个子节点都大
            exch(a, k, j);
            k = j;
        }
    }
    private static  boolean  less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0 ;
    }
    private static void exch(Comparable[] a ,int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {3, 5, 7, 9,10,12,0};
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+ " ");
        }
       Character[] b = {'s','o','r','t','e', 'x', 'a', 'm', 'p','l','e'};
        heapSort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+ " ");
        }

    }
}
