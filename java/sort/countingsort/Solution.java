package sort.countingsort;

import java.util.Arrays;

/**
 * @author zhanglinyu
 * @date 2020/2/22 15:23
 */
public class Solution {
    //原A中所有数在0~K之间
    private void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k + 1];

        //将A的值作为C的index，C里的值为A的值出现的次数
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            C[value]++;
        }

        //C的值依次相加，目的是找出B的index
        for (int i = 1; i <= k; i++){
            C[i] = C[i] + C[i - 1];
        }

        //将A中的元素放入B中正确的index上
        for (int i = A.length - 1; i >=0; i--) {
            int valueA = A[i];
            int valueC = C[valueA];
            B[valueC - 1] = valueA;
            C[valueA]--;//若有重复元素，则重复元素的index在原index上减一
        }

    }

    public static void main(String[] args) {
        int[] A = {2,5,3,0,2,3,0,3};
        int[] B = new int[A.length];
        int k = 5;
        Solution solution = new Solution();
        solution.countingSort(A,B, k);
        Arrays.stream(B).forEach(value -> System.out.print(value + ","));
    }
}
