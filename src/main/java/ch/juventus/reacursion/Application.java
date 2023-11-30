package ch.juventus.reacursion;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        int n = 40;
        long start = System.currentTimeMillis();
        long result = iterativeFibonacci(n);
        long end = System.currentTimeMillis();
        System.out.println("Calculated fibonacci number " + n + "=" + result + " with iterative in approach " + (end - start) + "ms");

        start = System.currentTimeMillis();
        result = recursiveFibonacci(n);
        end = System.currentTimeMillis();
        System.out.println("Calculated fibonacci number " + n + "=" + result + " with recursive in approach " + (end - start) + "ms");

        List<String> testInput = getPalindromeTestInput();
        testInput.forEach(input -> {
            boolean isPalindrome = isPalindrome(input);
            System.out.println(input + " -> " + isPalindrome);
        });
    }

    private static long iterativeFibonacci(long n) {
        long fib = 0;
        long prev = 1;
        for (int i = 0; i < n; i++) {
            long temp = fib;
            fib += prev;
            prev = temp;
        }
        return fib;
    }

    private static long recursiveFibonacci(long n) {
        if (n <= 1) {
            return n;
        } else {
            return recursiveFibonacci(n-2) + recursiveFibonacci(n-1);
        }
    }

    private static boolean isPalindrome(String input) {
        if(input.length() < 2) {
            return true;
        }

        input = input.toLowerCase();
        String firstCharacter = input.substring(0, 1);
        String lastCharacter = input.substring(input.length() - 1);

        if(firstCharacter.equals(lastCharacter)) {
            String substring = input.substring(1, input.length() - 1);
            return isPalindrome(substring);
        } else {
            return false;
        }
    }

    private static List<String> getPalindromeTestInput() {
        List<String> testInput = new ArrayList<>();
        testInput.add("Anna");
        testInput.add("Korb");
        testInput.add("Bob");
        testInput.add("Mein Computer");
        testInput.add("Level");
        testInput.add("Fuss");
        testInput.add("Anna Bob Anna");
        testInput.add("Kamel und Stein");
        testInput.add("!+Level+!");
        return testInput;
    }
}
