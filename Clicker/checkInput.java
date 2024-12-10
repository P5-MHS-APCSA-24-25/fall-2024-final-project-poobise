// Title: Check Input
// Author: Matthew Tuan
// Period: 5A

public class checkInput {
    public String currentInput = "";
    public int plop = 1;
    public double hits = 2;
    public boolean acceptInputs = true;

    public checkInput(String startInput) {
        currentInput = startInput;
    }
    
    public void setInput(String givenInput) {
        if (acceptInputs)
            currentInput = givenInput;
    }

    public String checkInput() {
        if (currentInput == "shop") {
            return currentInput;
        } else
            return String.valueOf(currentInput.length());

    }
}