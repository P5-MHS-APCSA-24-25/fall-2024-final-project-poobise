// Title: Game
// Author: Matthew Tuan
// Period: 5A

import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        checkInput plop = new checkInput("helo");

        Double hits = 0.0;
        boolean shopOpen = false;

        while (true) {
            String userInput = input.next();

            if (userInput != "") {
                plop.setInput(userInput);
                String checkedInput = plop.checkInput();
                if (checkedInput == "shop") {
                    shopOpen = true;
                } else if (checkedInput.matches(".*\\d.*")) {
                    hits += Double.parseDouble(checkedInput);
                }
            }

            if (!shopOpen)
                System.out.println("Hits: "+hits);
        }   
    }
}
