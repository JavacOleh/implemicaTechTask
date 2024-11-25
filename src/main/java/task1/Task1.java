package task1;

import task1.console.Parenthesis;

import java.util.Scanner;

//Main class
public class Task1 {
    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextInt()) {
            int n = scanner.nextInt();

            if (n > 0)
                parenthesis.generateParentheses(n).forEach(System.out::println);
            else
                System.out.println("it's not above than 0");
        }else
            System.out.println("It's not int");

    }
}
