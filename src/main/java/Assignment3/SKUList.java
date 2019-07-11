package Assignment3;

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
        if (item.matches(REGEX_PATTERN)) {
            int index = getInsertIndex(item, 0);
            for (int i = size; i > index; i--) {
                sku[i] = sku[i-1];
            }
            sku[index] = item;
            size++;
        }
        else {
            throw new SKUException("The SKU " + item + " is invalid");
        }
    }

    private int getInsertIndex(String item, int letterIndex) {
        int arrayIndex;
        for (arrayIndex = 0; arrayIndex < size; arrayIndex++) {
            if(item.charAt(letterIndex) < sku[arrayIndex].charAt(letterIndex)) return arrayIndex;
            if(item.charAt(letterIndex) == sku[arrayIndex].charAt(letterIndex)){
                while (item.charAt(letterIndex) == sku[arrayIndex].charAt(letterIndex) && letterIndex < 10) {
                    letterIndex++;
                }
                if(item.charAt(letterIndex) < sku[arrayIndex].charAt(letterIndex)) {
                    letterIndex = 0;
                    return arrayIndex;
                }
                letterIndex = 0;
                return arrayIndex+1;
            }
        }
        return arrayIndex;
    }

    public void sortedRemove(String item) throws SKUException {

    }

    public String sortedGet(int index) {
        return null;
    }

    public int locateIndex(String item) {

        return 0;
    }
    @Override
    public String toString() {
        String items = "";
        for(String item: sku) {
            if(item != null) items += (item + "\n");
        }
        return items;
    }
}
