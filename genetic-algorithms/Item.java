public class Item {

    private int value;

    private int size;

    public Item(int value, int size) {
        this.value = value;
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
    
    public int getValue() {
        return this.value;
    }

    public String toString() {
        return String.format("<Item value=%d, size=%d>", this.value, this.size);
    }
}
