package Assignment2.Problem3;

// removed extension of ArrayList<Item>
public class ShippingOrder {
    private List<Item> items;
    private double shippingCost;

    // construct new shippingOrder with initialItems and address
    public ShippingOrder(List<Item> initialItems, String address) {
        items = new ArrayList<>(initialItems);
        calculateShippingCost(address);
    }

    // example of a separate method to calculate shipping cost
    private void calculateShippingCost(String address) {
        double totalWeight = calculateTotalWeight();
        double rate = ShippingRateService.fetchRate(address);
        this.shippingCost = rate * totalWeight;
    }

    // example of a separate method to calculate total weight of items in order
    private double calculateTotalWeight() {
        return items.stream().mapToDouble(Item::getWeight).sum();
    }
}

