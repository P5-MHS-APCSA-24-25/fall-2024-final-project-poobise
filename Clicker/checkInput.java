// Title: Check Input
// Author: Matthew Tuan
// Period: 5A

public class checkInput {
    public String currentInput = "";
    public int plop = 1;
    public double hits = 2;
    public boolean shopOpen = false;

    public checkInput(String startInput) {
        currentInput = startInput;
    }
    
    public void toggleShop() {
        shopOpen = !shopOpen;
    }

    public void setInput(String givenInput) {
        currentInput = givenInput;
    }

    public String checkInput() {
        if (currentInput.equals("shop") || shopOpen) {
            return currentInput;
        } else
            return String.valueOf(currentInput.length());

    }
}