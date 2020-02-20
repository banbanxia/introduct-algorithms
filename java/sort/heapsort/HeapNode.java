package sort.heapsort;

/**
 * @author zhanglinyu
 * Defination of Heap
 * @date 2020/2/18 9:46
 */
public class HeapNode {
    protected static int getParentIndex(int i) {
        return i / 2;
    }

    protected static int getLeftIndex(int i) {
        return 2 * i;
    }

    protected static int getRightIndex(int i) {
        return 2 * i + 1;
    }
}
