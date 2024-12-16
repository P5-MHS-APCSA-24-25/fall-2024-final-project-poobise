// Title: Items
// Author: Matthew Tuan
// Period: 5A

public class Items {
    private Items[] inventory = new Items[1];
    private Items[] hitItems = new Items[1];
    private Items[] lengthItems = new Items[1];

    public String name;
    public String itemType;
    public int value;
    public String upgradeType;
    public double time;

    public String buyKey;
    public double price;
    public String description;

    public Items(String gN, String gIT, int gV, String gUT, double gTi, String gBK, int gP, String gD) {
        name = gN;
        itemType = gIT;
        value = gV;
        upgradeType = gUT;
        time = gTi;
        buyKey = gBK;
        price =gP;
        description = gD;
    }

    // this sets the item's type to it's array so it can be used later when checking for hits or automatic hits
    public void setItemsFolder() {
        for (int i=1; i < inventory.length; i++) {
            Items currentItem = inventory[i];
            if (currentItem.itemType.equals("On Hit")) {
                hitItems = addToItemArray(hitItems, currentItem);
            } else if (currentItem.itemType.equals("On Length")) {
                lengthItems = addToItemArray(lengthItems,currentItem);
            }
        }
    }
    
    // is called when user input is recieved, and returns a value depending on the total added and multiplied amount of hit item values
    public double activateItems(double letters) {
        double totalAdd = 0;
        double totalMulti = 1;
        double totalAddAfter = 0;

        for (int i=1; i < hitItems.length-1; i++) {
            Items currentItem = hitItems[i];
            
            System.out.println(currentItem.name);
            if (currentItem.upgradeType.equals("add"))
                totalAdd += currentItem.value;
            else if (currentItem.upgradeType.equals("multi"))
                totalMulti *= currentItem.value;
            else if (currentItem.upgradeType.equals("addAfter"))
                totalAddAfter += currentItem.value;
        }
        
        for (int i=1; i < lengthItems.length-1; i++) {
            Items currentItem = lengthItems[i];
            
             if (letters > currentItem.time) {
                if (currentItem.upgradeType.equals("add"))
                    totalAdd += currentItem.value;
                else if (currentItem.upgradeType.equals("multi"))
                    totalMulti *= currentItem.value;
                else if (currentItem.upgradeType.equals("addAfter"))
                    totalAddAfter += currentItem.value;
            }
            
        }
        
        return (letters + totalAdd) * totalMulti + totalAddAfter;
    }

    // called when item is attempted to buy, returns the same amount of hits 
    public double buyItem(Items itemToBuy, double currentHits) {
        if (currentHits >= itemToBuy.price) {
            currentHits -= itemToBuy.price;
            inventory = addToItemArray(inventory, itemToBuy);
        }
        return currentHits;
    } 

    public boolean checkItemStatus(Items givenItem) {
        for (int i=1; i < inventory.length; i++) {
            Items currentItem = inventory[i];
            if (currentItem.name.equals(givenItem.name)) {
                return false;
            }
        }
        return true;
    }

    private Items[] addToItemArray(Items[] array, Items itemToAdd) {

        Items[] newArray = new Items[array.length+1];

        for (int i = 1; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[array.length] = itemToAdd;

        return newArray;
    }
}