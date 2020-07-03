package test;

import main.BalancedBrackets;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedBracketsTest {

    //TODO: add tests here
    @Test
    public void emptyTest() {
        assertEquals(true, true);
    }

    @Test
    public void onlyBracketsReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]LaunchCode"));
        assertTrue(BalancedBrackets.hasBalancedBrackets(""));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[LaunchCode]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("Launch[Code]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("LaunchCode"));
    }

    @Test
    public void openBracketShouldComeFirst() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("]["));
        assertTrue(BalancedBrackets.hasBalancedBrackets("He[llo]"));
    }

    @Test
    public void closeBracketShouldComeLast() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("L[aunch][Code"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[][][]"));
    }

    @Test
    public void eachTypeOfBracketShouldExist() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("]"));
        assertFalse(BalancedBrackets.hasBalancedBrackets("He[llo"));
    }

    @Test
    public void multipleBalancedBracketsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[L][a][u][n][c][h][C][o][d][e]"));
        assertTrue(BalancedBrackets.hasBalancedBrackets("[Launch][Code]"));
    }

    @Test
    public void multipleBalancedBracketsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("[]]["));
        assertFalse(BalancedBrackets.hasBalancedBrackets("[L][a][u][n][c]][[h][C][o][d][e]"));
        assertFalse(BalancedBrackets.hasBalancedBrackets("[]][[]"));
    }

    @Test
    public void nestedReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[[][][][][]]"));

    }
}
