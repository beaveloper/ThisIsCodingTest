public class SortEx {

    /**
     * 선택정렬
     * O(n*n)
     * @param nums
     * @return
     */
    public static int[] selectionSort(int... nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

            }

        }

        return nums;
    }

    /**
     * 버블정렬
     * O(n*n)
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int... nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
//            SortEx.valid(nums);
        }

        return nums;
    }

    /**
     * 삽입정렬
     * O()
     * @param nums
     * @return
     */
    public static int[] insertionSort(int... nums) {

        return nums;
    }

    private static void valid(int... nums) {
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }
}
