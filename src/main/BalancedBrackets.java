package main;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BalancedBrackets {
    /**
     * The function BalancedBrackets should return true if and only if
     * the input string has a set of "balanced" brackets.
     *
     * That is, whether it consists entirely of pairs of opening/closing
     * brackets (in that order), none of which mis-nest. We consider a bracket
     * to be square-brackets: [ or ].
     *
     * The string may contain non-bracket characters as well.
     *
     * These strings have balanced brackets:
     *  "[LaunchCode]", "Launch[Code]", "[]LaunchCode", "", "[]"
     *
     * While these do not:
     *   "[LaunchCode", "Launch]Code[", "[", "]["
     *
     * @param str - to be validated
     * @return true if balanced, false otherwise
     */
    public static boolean hasBalancedBrackets(String str) {
//        int brackets = 0;
        boolean result = true;
        if (str.equals("")) {
            return true;
        }
        if (str.indexOf("]") < str.indexOf("[") || str.lastIndexOf('[') > str.lastIndexOf(']')
                || !str.contains("[") || !str.contains("]")) {
            result = false;
        }
        char[] chars = str.toCharArray();
        List<Integer> bracketArray = new LinkedList<>();
//        for (char ch : str.toCharArray()) {
        for (char aChar : chars) {
            if (aChar == ('[')) {
                bracketArray.add(0);
//                brackets++;
            } else if (aChar == ']') {
                bracketArray.add(1);
//                brackets--;
            }
        }
        for (int i= 0; i < bracketArray.size() - 1; i++) {
            if (bracketArray.get(i).equals(bracketArray.get(i + 1))) {
                return false;
            }
        }
        return result;
    }
}
