package main.Parser;

import java.util.Scanner;

public class Parser {
    public static void main(String[] args) {
        while (true)
        {
            ISpaceNormolizer parser = new AutomatSpaceNormalizer();
            System.out.println("Enter the string in which you want to remove unnecessary spaces");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String result = parser.normalize(input);
            System.out.println("Result:" + result);
        }
    }
}
