// Title: Game
// Author: Matthew Tuan
// Period: 5A

import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Items firstOne = new Items("firstone","On Hit",2,0)

        Scanner input = new Scanner(System.in);
        checkInput plop = new checkInput("helo");

        Double hits = 0.0;
        boolean shopOpen = false;

        while (true) {
            String userInput = input.next();

            if (userInput != "") {
                plop.setInput(userInput);
                String checkedInput = plop.checkInput();

                if (checkedInput.equals("shop")) {
                    shopOpen = true;
                    plop.toggleShop();
                } else if (checkedInput.matches(".*\\d.*")) {
                    hits += Double.parseDouble(checkedInput);
                } else if (shopOpen) {
                    if (checkedInput.equals("b")) {

                    }
                }
            }

            if (shopOpen) {
                System.out.println("WELCOME TO THE SHOP!")
                System.out.println("current items are: ")
                System.out.println(firstOne)
            } else
                System.out.println("Hits: "+hits);
        }   
    }
}
