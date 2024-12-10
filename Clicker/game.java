// Title: Game
// Author: Matthew Tuan
// Period: 5A

import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Double hits = 0.0;
        Scanner input = new Scanner(System.in);
        checkInput plop = new checkInput("helo");

        while (true) {
            String userInput = input.next();
            System.out.println("input is: "+userInput);

            if (userInput != "") {
                plop.setInput(userInput);
                String yeah = plop.checkInput();
                if (yeah.includes("123456")) {
                    hits += yeah;
                }
            }

            System.out.println("Hits: "+hits);
        }
    }
}
