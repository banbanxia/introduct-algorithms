package sort.heapsort;

/**
 * @author zhanglinyu
 * Solution of HeapSort
 * @date 2020/2/18 9:52
 */
public class Solution {
    //单个节点构建最大堆
    private void maxHeapify(int[] A, int i, int length) {
        int l = HeapNode.getLeftIndex(i);
        int r = HeapNode.getRightIndex(i);

        int largest = i;
        //int length = A.length;
        if (l < length && A[l] > A[i]) {
            largest = l;
        }

        if (r < length && A[r] > A[largest]) {
            largest = r;
        }

        if (largest != i) {
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            maxHeapify(A, largest, length);//为了不破坏原先的堆，需将改变了的节点再与下面的节点相比较
        }
    }

    //数组构建最大堆
    private void buildMaxHeap(int[] A) {
        //因数组的后一半为叶子节点，因此构建前一半即可
        for (int i = 0; i < A.length / 2; i++) {
            maxHeapify(A, i, A.length);
        }
    }

    //构建最大堆后，将第一个节点置于数组最后一位
    private void heapSort(int[] A) {
        buildMaxHeap(A);
        for (int i = A.length - 1; i > 0; i--) {
            int tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;

            //去掉数组的最后一位

            maxHeapify(A, 0, A.length - 1);
        }
    }
}
