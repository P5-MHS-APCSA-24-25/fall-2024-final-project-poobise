// Title: Items
// Author: Matthew Tuan
// Period: 5A

public class Items {
    private Items[] inventory = new Items[1];
    private Items[] hitItems = new Items[1];

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

    public void setItemsFolder() {
        for (int i=1; i < inventory.length; i++) {
            Items currentItem = inventory[i];
            if (currentItem.itemType.equals("On Hit") && currentItem.time == 0) {
                hitItems = addToItemArray(hitItems, currentItem);
            } else if (currentItem.itemType.equals("Automatic")) {

            }
        }
    }

    public double activateHitItems(double letters) {
        double totalMulti = 1;
        for (int i=1; i < hitItems.length; i++) {
            Items currentItem = hitItems[i];
            System.out.println(currentItem.upgradeType);
            if (currentItem.upgradeType.equals("add"))
                letters += currentItem.value;
            else if (currentItem.upgradeType.equals("multi"))
                totalMulti *= currentItem.value;
        }
        return letters*totalMulti;
    }

    public void buyItem(Items itemToBuy, double currentHits) {
        if (currentHits >= itemToBuy.price) {
            currentHits -= itemToBuy.price;
            inventory = addToItemArray(inventory, itemToBuy);
        }
    } 

    public boolean checkItemStatus() {
        for (int i=1; i < inventory.length; i++) {
            Items currentItem = inventory[i];
            if (currentItem.name.equals(name)) {
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