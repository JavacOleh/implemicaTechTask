package task1.console;

import java.util.ArrayList;
import java.util.List;

//Class for realisation task 1
public class Parenthesis {

    //Method returns list of generated true parentheses
    public List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateValidParenthesesHelper(n, n, "", result);
        return result;
    }

    //Method to generate true parentheses
    private void generateValidParenthesesHelper(int openLeft, int closeLeft, String current, List<String> result) {
        if (openLeft == 0 && closeLeft == 0) {
            result.add(current);
            return;
        }

        if (openLeft > 0) {
            generateValidParenthesesHelper(openLeft - 1, closeLeft, current + "(", result);
        }

        if (closeLeft > openLeft) {
            generateValidParenthesesHelper(openLeft, closeLeft - 1, current + ")", result);
        }
    }
}
