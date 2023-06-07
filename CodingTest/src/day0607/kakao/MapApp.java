package day0607.kakao;

import java.util.Arrays;
import java.util.Scanner;

public class MapApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자 n 입력 : ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        System.out.print("arr1 에 들어갈 숫자 n개 입력 : ");

        int i = 0;
        while (i < n) {
            arr1[i] = sc.nextInt();
            if (0 <= arr1[i] && arr1[i] <= Math.pow(2, n) - 1)
                i++;
        }

        System.out.print("arr2 에 들어갈 숫자 n개 입력 : ");
        i = 0;
        while (i < n) {
            arr2[i] = sc.nextInt();
            if (0 <= arr2[i] && arr2[i] <= Math.pow(2, n) - 1)
                i++;
        }

        int[] result = new int[n];
        String[] result2 = new String[n];

        for (i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] | arr2[i];

            result2[i] = Integer.toBinaryString(result[i]).replaceAll("1", "#");
            result2[i] = result2[i].replaceAll("0", " ");
        }

        System.out.println(Arrays.toString(result2));

    }

}
