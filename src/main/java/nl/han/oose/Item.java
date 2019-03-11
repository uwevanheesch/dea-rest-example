package nl.han.oose;

public class Item {

    private String name;
    private String sku;

    // Required for managed objects
    public Item() {
    }

    public Item(String name, String sku) {
        this.name = name;
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
