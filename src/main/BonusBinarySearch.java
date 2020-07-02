package main;

import java.util.Arrays;

public class BonusBinarySearch {

    /**
     * A binary search implementation for integer arrays.
     *
     * Info about binary search: https://www.geeksforgeeks.org/binary-search/
     *
     * @param sortedNumbers - must be sorted from least to greatest
     * @param n - number to search for
     * @return index of search item if it's found, -1 if not found
     */
    public static int binarySearch(int[] sortedNumbers, int n) {
        int right = sortedNumbers.length - 1;
        int left = 0;
        int result = -1;
        Arrays.sort(sortedNumbers);
        if (n == sortedNumbers[0]) {
            result = 0;
        } else if (n == sortedNumbers[sortedNumbers.length-1]) {
            result = sortedNumbers.length-1;
        } else if (n < sortedNumbers[0] || n > sortedNumbers[sortedNumbers.length-1]) {
            return result;
        } else {
            while (right - left > 1) {
                int mid = left + (right - left == 1 ? 1 : (right - left) / 2);
                if (sortedNumbers[mid] > n) {
                    right = mid;
                } else if (sortedNumbers[mid] < n) {
                    left = mid;
                } else {
                    result = mid;
                    break;
                }
            }
        }
        return result;
    }

    public static int indexSearch(int[] sortedNumbers, int n) {
        Arrays.sort(sortedNumbers);
        Integer[] copyOfNumbers = Arrays.stream( sortedNumbers ).boxed().toArray( Integer[]::new );
        return Arrays.asList(copyOfNumbers).indexOf(n);
    }
}
