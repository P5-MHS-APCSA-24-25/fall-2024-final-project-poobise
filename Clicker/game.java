// Title: Game
// Author: Matthew Tuan
// Period: 5A

import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Items firstOne = new Items("firstone","On Hit",1,"add",0,"b",3,"1 more hit per letter");

        Scanner input = new Scanner(System.in);
        checkInput checker = new checkInput("helo");

        double hits = 0.0; // change back to capital D if something goes wrong
        boolean shopOpen = false;

        while (true) {
            String userInput = input.next();

            if (userInput != "") {
                checker.setInput(userInput);
                String checkedInput = checker.checkInput();

                if (checkedInput.equals("shop")) {
                    shopOpen = !shopOpen;
                    checker.toggleShop();
                } else if (checkedInput.matches(".*\\d.*")) {
                    hits += firstOne.activateHitItems(Double.parseDouble(checkedInput));
                } else if (shopOpen) {
                    if (checkedInput.equals(firstOne.buyKey)) {
                        hit = firstOne.buyItem(firstOne,hits);
                        firstOne.setItemsFolder();
                    }
                }
            }

            if (shopOpen) {
                System.out.println("WELCOME TO THE SHOP!");
                System.out.println("current items are: ");
                if (firstOne.checkItemStatus())
                    System.out.println(firstOne.name+": "+firstOne.description+"\nPrice is: "+firstOne.price);
                else
                    System.out.println("Item bought");
            } else
                System.out.println("Hits: "+hits);
        }   
    }
}
