// Title: Game
// Author: Matthew Tuan
// Period: 5A

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Items combo = new Items("Combo","On Hit",1,"addAfter",0,"com",20,"Blam. Hit Brian again after every string!");
        Items stone = new Items("Stone","On Hit",2,"addAfter",0,"sto",40,"Ker-Bloosh. Hit Brian twice after every string!");
        Items ants = new Items("Ants","On Length",3,"addAfter",9,"ant",40,"3 ants bite Brian if your input is longer than 9!");
        Items stick = new Items("Stick","On Hit",2,"multi",0,"sti",200,"Sticks and stones will break Brian's bones and give you a 2x multiplier!");
        Items capybara = new Items("Capybara","On Hit",2,"add",0,"cap",200,"Even these guys hate Brian. Adds 2 to every string, but is able to be multiplied!");
        Items peter = new Items("Peter Griffin","On Hit",10,"addAfter",0,"pet",500,"Shut up Brian. \"Roadhouses\" Brian 10 times.");


        Scanner input = new Scanner(System.in);
        CheckInput checker = new CheckInput("helo");

        double hits = 0.0; // change back to capital D if something goes wrong
        boolean shopOpen = false;

        while (true) {
            String userInput = input.next();

            if (userInput != "") {
                checker.setInput(userInput); // sets input in the checker so it can be checked
                String checkedInput = checker.CheckInput(); // checks input into a variable

                if (checkedInput.equals("shop")) {
                    shopOpen = !shopOpen; // toggles the shop
                    checker.toggleShop();
                } else if (checkedInput.matches(".*\\d.*")) {
                    hits += combo.activateItems(Double.parseDouble(checkedInput)); //  adds hits to the total hit amount from the checkedInput variable, which is turned into a double, and then activates items that activate on hit.
                } else if (shopOpen) {
                    if (checkedInput.equals(combo.buyKey) && combo.checkItemStatus(combo)) { // checks if shop is open, then if the input equals the buying key for the item
                        if (combo.buyItem(combo,hits) != hits) {
                            hits = combo.buyItem(combo,hits); // sets the amount of hits to a returned value
                            combo.setItemsFolder(); // sets the folder for the item
                        } else
                            System.out.println("Not enough hits, go hit Brian more!");
                    }
                    if (checkedInput.equals(stone.buyKey) && combo.checkItemStatus(stone)) { 
                        if (combo.buyItem(stone,hits) != hits) {
                            hits = combo.buyItem(stone,hits);
                            combo.setItemsFolder(); 
                        } else
                            System.out.println("Not enough hits, go hit Brian more!");
                    }
                    if (checkedInput.equals(ants.buyKey) && combo.checkItemStatus(ants)) { 
                        if (combo.buyItem(ants,hits) != hits) {
                            hits = combo.buyItem(ants,hits);
                            combo.setItemsFolder(); 
                        } else
                            System.out.println("Not enough hits, go hit Brian more!");
                    }
                }
            }

            if (shopOpen) {
                System.out.println("WELCOME TO THE SHOP!");
                System.out.println("current items are: ");
                if (combo.checkItemStatus(combo))
                    System.out.println(combo.name+": "+combo.description+"\nPrice is: "+combo.price+"\nType \""+combo.buyKey+"\" to buy");
                else
                    System.out.println("Item bought");
                if (combo.checkItemStatus(stone))
                    System.out.println(stone.name+": "+stone.description+"\nPrice is: "+stone.price+"\nType \""+stone.buyKey+"\" to buy");
                else
                    System.out.println("Item bought");
                if (combo.checkItemStatus(ants))
                    System.out.println(ants.name+": "+ants.description+"\nPrice is: "+ants.price+"\nType \""+ants.buyKey+"\" to buy");
                else
                    System.out.println("Item bought");
            } else
                System.out.println("Hits: "+hits); // displays hits

        }   
    }
}
