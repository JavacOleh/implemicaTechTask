package task3.console;

import java.math.BigInteger;

//Class which contains methods to solve task 3
public class TaskAddition {
    //Method to find factorial
    public BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    //Method to sum digits in factorial result
    public int sumOfDigits(BigInteger number) {
        int sum = 0;
        String numberStr = number.toString();  //Converting digit to text format
        for (char digitChar : numberStr.toCharArray()) {
            sum += Character.getNumericValue(digitChar);  //Converting symbol to digit and adding to sum value
        }
        return sum;
    }
}
