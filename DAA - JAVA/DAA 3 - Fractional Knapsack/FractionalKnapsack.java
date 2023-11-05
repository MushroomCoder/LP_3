import java.util.*;

public class FractionalKnapsack {
    static class KnapsackItem {
        private int index;
        private double value;
        private double weight;
        private double ratio;

        public KnapsackItem(int index, double value, double weight) {
            this.index = index;
            this.value = value;
            this.weight = weight;
            this.ratio = value / weight;
        }

        public int getIndex() {
            return index;
        }

        public double getValue() {
            return value;
        }

        public double getWeight() {
            return weight;
        }

        public double getRatio() {
            return ratio;
        }

        @Override
        public String toString() {
            return "Item " + index + " (Value: " + value + ", Weight: " + weight + ")";
        }
    }

    static void knapSack(ArrayList<KnapsackItem> items, int capacity) {
        Comparator<KnapsackItem> comparator = new Comparator<KnapsackItem>() {
            @Override
            public int compare(KnapsackItem o1, KnapsackItem o2) {
                if (o2.getRatio() > o1.getRatio()) return 1;
                else return -1;
            }
        };
        Collections.sort(items, comparator);
        int usedCapacity = 0;
        double totalValue = 0;

        for (KnapsackItem item : items) {
            if (usedCapacity + item.getWeight() <= capacity) {
                usedCapacity += item.getWeight();
                System.out.println("Taken: " + item);
                totalValue += item.getValue();
            } else {
                double remainingCapacity = capacity - usedCapacity;
                double value = item.getRatio() * remainingCapacity;
                System.out.println("Taken: item index = " + item.getIndex() + ", obtained value = " + value + ", used weight = " + remainingCapacity + ", ratio = " + item.getRatio());
                usedCapacity += remainingCapacity;
                totalValue += value;
            }
            if (usedCapacity == capacity) break;
        }

        System.out.println("\nTotal value obtained: " + totalValue);
    }

    public static void main(String[] args) {
        ArrayList<KnapsackItem> items = new ArrayList<>();
        items.add(new KnapsackItem(1, 10, 2));
        items.add(new KnapsackItem(2, 5, 3));
        items.add(new KnapsackItem(3, 15, 5));
        items.add(new KnapsackItem(4, 7, 7));
        items.add(new KnapsackItem(5, 6, 1));
        int capacity = 15;

        knapSack(items, capacity);
    }
}
