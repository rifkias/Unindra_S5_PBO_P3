public class Order {
    String name, sugar, type;
    int qty;
    public Order(String name, String sugar, String type, int qty) {
        this.name = name;
        this.sugar = sugar;
        this.type = type;
        this.qty = qty;
    }
    public String getName() {
        return name;
    }
    public String getSugar() {
        return sugar;
    }
    public String getType() {
        return type;
    }
    public int getQty() {
        return qty;
    }
    
}
