import java.util.List;

public class ItemCollection {

    private List<Item> items;

    public ItemCollection(List<Item> rawItems) {
        this.items = rawItems;
    }

    public ItemCollection(
        int numItems, 
        int itemSmallestSize, int itemBiggestSize,
        int itemSmallestValue, int itemBiggestValue
    ) {
        // TODO
    }

    public List<Item> getItems() {
        return this.items;
    }

    public int getTotalValue() {
        return this.items.stream()
            .map(Item::getValue)
            .reduce(0, Integer::sum);
    }

    public int getTotalSize() {
        return this.items.stream()
            .map(Item::getSize)
            .reduce(0, Integer::sum);
    }
}
