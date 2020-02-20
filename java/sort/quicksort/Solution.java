package sort.quicksort;

/**
 * @author zhanglinyu
 * @date 2020/2/20 16:48
 */
public class Solution {
    private int partition(int[] A, int p, int r) {
        int x = A[r];//主元
        int i = p - 1;//要替换的
        for (int j = p;j < r; j++) {
            if (A[j] <= x) {
                i++;
                int tmp1 = A[i];
                A[i] = A[j];
                A[j] = tmp1;
            }
        }
        int tmp2 = A[i + 1];
        A[i + 1] = A[r];
        A[r] = tmp2;
        return i + 1;
    }

    private void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }
}
