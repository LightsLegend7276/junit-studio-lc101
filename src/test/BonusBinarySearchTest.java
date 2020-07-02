package test;

import main.BonusBinarySearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


import static org.junit.Assert.*;

public class BonusBinarySearchTest {

    private int[] numbers = new int[52];
    private int randomNumber = 0;

    @Before
    public void setUp() {
        randomNumber = (int) Math.round(Math.random() * 100);
        for (int i = 0; i < 52; i++) {
            numbers[i] = (int) Math.round(Math.random() * 100);
        }
    }

    @After
    public void closeStream() {

    }

    @Test
    public void edgeBinarySearch() {
        Arrays.sort(numbers);
        int resultOne = BonusBinarySearch.binarySearch(numbers, numbers[numbers.length-1]);
        int resultTwo = BonusBinarySearch.binarySearch(numbers, numbers[0]);
        assertEquals(51, resultOne);
        assertEquals(0, resultTwo);
    }

    @Test
    public void checkIfNumberIsWithinSortedNumberRange() {
        int result = BonusBinarySearch.binarySearch(numbers, 103);
        assertEquals(-1, result);
    }

    @Test
    public void binarySearchReturnsExpectedResult() {
        int result = BonusBinarySearch.binarySearch(numbers, randomNumber);
        Arrays.sort(numbers);
        int expected = -1;
        Integer[] copyOfNumbers = Arrays.stream( numbers ).boxed().toArray( Integer[]::new );
        int expectedTwo = Arrays.asList(copyOfNumbers).indexOf(randomNumber);
        for (int i = 0; i < copyOfNumbers.length; i++) {
            if (numbers[i] == randomNumber) {
                expected = i;
                break;
            }
        }
        assertEquals(expected, result);
        assertEquals(expectedTwo, result);
    }

    @Test
    public void edgeIndexSearch() {
        Arrays.sort(numbers);
        int resultOne = BonusBinarySearch.indexSearch(numbers, numbers[numbers.length-1]);
        int resultTwo = BonusBinarySearch.indexSearch(numbers, numbers[0]);
        assertEquals(51, resultOne);
        assertEquals(0, resultTwo);
    }

    @Test
    public void checkIfNumberIsWithinSortedNumberRangeIndexSearch() {
        int result = BonusBinarySearch.indexSearch(numbers, 103);
        assertEquals(-1, result);
    }

    @Test
    public void indexSearchReturnsExpectedResult() {
        int result = BonusBinarySearch.indexSearch(numbers, randomNumber);
        Arrays.sort(numbers);
        int expected = -1;
        Integer[] copyOfNumbers = Arrays.stream( numbers ).boxed().toArray( Integer[]::new );
        int expectedTwo = Arrays.asList(copyOfNumbers).indexOf(randomNumber);
        for (int i = 0; i < copyOfNumbers.length; i++) {
            if (numbers[i] == randomNumber) {
                expected = i;
                break;
            }
        }
        assertEquals(expected, result);
        assertEquals(expectedTwo, result);
    }
}