import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public final class NonGASolutions {

    private NonGASolutions() {}

    public static ItemCollection getItemsBasedOnValue(List<Item> items, int containerCapacity) {
        // Sort by value descending, then by size ascending
        List<Item> sortedList = new ArrayList<>(items);
        sortedList.sort(Comparator.comparing(Item::getValue, Comparator.reverseOrder())
            .thenComparing(Comparator.comparing(Item::getSize)));

        return getItemsThatFit(containerCapacity, sortedList);
    }

    public static ItemCollection getItemsBasedOnSize(List<Item> items, int containerCapacity) {
        // Sort by size ascending, then by value descending
        List<Item> sortedList = new ArrayList<>(items);
        sortedList.sort(Comparator.comparing(Item::getSize)
            .thenComparing(Comparator.comparing(Item::getValue).reversed()));
        
        return getItemsThatFit(containerCapacity, sortedList);
    }

    public static ItemCollection getItemsBasedOnValueSizeRatio(List<Item> items, int containerCapacity) {
        // Sort by (value / size) descending
        List<Item> sortedList = new ArrayList<>(items);
        // Function<Item, Double> compFuncByRate = i -> (double)i.getValue()/ (double)i.getSize();
        // sortedList.sort(Comparator.comparing(compFuncByRate).reversed());
        sortedList.sort(Comparator.comparing((Function<Item, Double>) i -> (double)i.getValue()/ (double)i.getSize())
            .reversed());

        return getItemsThatFit(containerCapacity, sortedList);
    }

    public static ItemCollection getItemsThatFit(int containerCapacity, List<Item> sortedList) {
        List<Item> results = new ArrayList<>();
        int sizeUsed = 0;
        for (Item sortedItem : sortedList) {
            int itemSize = sortedItem.getSize();
            if ((sizeUsed + itemSize) <= containerCapacity) {
                results.add(sortedItem);
                sizeUsed += itemSize;
            }
        }
        return new ItemCollection(results);
    }
    
}