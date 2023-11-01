package tdc.edu.whetherforecast.model;

public class Cart {
    private String name;
    private int qty;
    private int price;
    private int img;
    private int rate;

    public Cart(String name, int qty, int price, int img, int rate) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.img = img;
        this.rate = rate;
    }


    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    public int getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", img=" + img +
                ", rate=" + rate +
                '}';
    }
}
