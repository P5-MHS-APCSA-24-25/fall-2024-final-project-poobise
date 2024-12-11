// Title: Items
// Author: Matthew Tuan
// Period: 5A

public class Items {
    private Items[] inventory = {};
    private Items[] hitItems = {};
    public String name;
    public String itemType;
    public int value;
    public String upgradeType;
    public double time;

    public Items(String gN, String gIT, int gV, String gUT, double gTi) {
        name = gN;
        itemType = gIT;
        value = gV;
        upgradeType = gUT;
        time = gTi
    }

    public void checkItems() {
        for (i=1,i <= inventory.size(),i++) {
            private Items currentItem = inventory[i];
            if (currentItem.itemType == "On Hit" && currentItem.time == 0) {
                hitItems = addToItemArray(hitItems, checkItems);
            } else if (currentItem.itemType == "Automatic") {

            }
        }
    }

    public void activateHitItems() {
        for (i=1,i >=inventory.size(),i++) { }
    }

    private Items[] addToItemArray(Items[] array, Items itemToAdd) {

        Items[] newArray = Items[array.size()];

        for (int i = 1; i =< array.size(),i++) {
            newArray[i] = array[i];
        }

        newArray[array.size()+1] = itemToAdd;

        return newArray;
    }
}