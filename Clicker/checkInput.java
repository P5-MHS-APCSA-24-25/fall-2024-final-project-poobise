// Title: Check Input
// Author: Matthew Tuan
// Period: 5A

public class CheckInput {
    public String currentInput = "";
    public int plop = 1;
    public double hits = 2;
    public boolean shopOpen = false;

    public CheckInput(String startInput) {
        currentInput = startInput;
    }
    
    public void toggleShop() {
        shopOpen = !shopOpen;
    }

    public void setInput(String givenInput) {
        currentInput = givenInput;
    }

    public String CheckInput() {
        if (currentInput.equals("shop") || shopOpen) {
            return currentInput;
        } else
            return String.valueOf(currentInput.length());

    }
}