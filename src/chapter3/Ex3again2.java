package chapter3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex3again2 {


    public Ex3again2() {


    }

    private void solution() {

        int n, m, k; // 배열의 크기, 숫자가 더해지는 횟수, 연속 가능한 횟수

        int[] array = null; // 수 배열

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            for (int i = 0; i < 2; i++) {
                String[] arrayStr = null;
                if (i == 0) {
                    arrayStr = br.readLine().split(" ");
                    array = Arrays.stream(arrayStr).mapToInt(Integer::parseInt).toArray();
                } else {
                    arrayStr = br.readLine().split(" ");
                    n = Integer.parseInt(arrayStr[0]);
                    m = Integer.parseInt(arrayStr[1]);
                    k = Integer.parseInt(arrayStr[2]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Arrays.sort(array);


    }


}
