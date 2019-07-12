package Assignment3.Qu2;

import Assignment3.ADTListInterface;
import Assignment3.SKUException;

public class SKUList implements ADTListInterface<String> {

    private String[] sku = new String[25];
    private int size;
    private static final int MAX_SIZE = 25;
    private static final String REGEX_PATTERN = "[A-Z][0-9]{2}-[0-9]{4}[A-Z]-[A-Z]";


    public void createSortedList() {
        sku = new String[25];
        size = 0;
    }

    public boolean sortedIsEmpty() {
        return size == 0;
    }

    public int sortedSize() {
        return size;
    }

    public void sortedAdd(String item) throws SKUException {
        if(size == MAX_SIZE) throw new SKUException("The list is full");
        if (item.matches(REGEX_PATTERN) && locateIndex(item) == -1) {
            int index = getInsertIndex(item, 0);
            for (int i = size; i > index; i--) {
                sku[i] = sku[i - 1];
            }
            sku[index] = item;
            size++;
        } else {
            throw new SKUException("The SKU " + item + " is invalid or already in use");
        }
    }

    private int getInsertIndex(String item, int letterIndex) {
        int arrayIndex;
        for (arrayIndex = 0; arrayIndex < size; arrayIndex++) {
            if (item.charAt(letterIndex) < sku[arrayIndex].charAt(letterIndex)) return arrayIndex;
            if (item.charAt(letterIndex) == sku[arrayIndex].charAt(letterIndex)) {
                while (item.charAt(letterIndex) == sku[arrayIndex].charAt(letterIndex) && letterIndex < 10) {
                    letterIndex++;
                }
                if (item.charAt(letterIndex) < sku[arrayIndex].charAt(letterIndex)) {
                    return arrayIndex;
                }
                letterIndex = 0;
            }
        }
        return arrayIndex;
    }

    public void sortedRemove(String item) {
        int deleteIndex = locateIndex(item);
        if ((!this.sortedIsEmpty()) && deleteIndex != -1) {
            for (int i = deleteIndex; i < size; i++) {
                sku[i] = sku[i + 1];
            }
            size--;
        }
    }

    public String sortedGet(int index) {
        return sku[index];
    }

    public int locateIndex(String item) {
        for (int i = 0; i < size; i++) {
            if (sku[i].equals(item)) return i;
        }
        return -1;
    }

    public String getSortedList() {
        String items = "";
        for (String item : sku) {
            if (item != null) items += (item + "\n");
        }
        return items;
    }
}
