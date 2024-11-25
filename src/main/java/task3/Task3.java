package task3;

import task3.console.TaskAddition;

import java.math.BigInteger;
import java.util.Scanner;

//Main class
public class Task3 {
    public static void main(String[] args) {
        TaskAddition taskAddition = new TaskAddition();
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextInt()) {
            int n = scanner.nextInt();

            BigInteger factorialResult = taskAddition.factorial(n);
            int sum = taskAddition.sumOfDigits(factorialResult);

            System.out.println("For factorial of(" + n + ")\nwhich equals: " + factorialResult + "\nSum equals: " + sum);
        }
    }
}
