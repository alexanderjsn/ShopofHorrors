public class Discount extends Food {

    //Hämtar Food egenskaper
    public Discount(String name, int stock, double price) {
        super(name, stock, price);
    }

    // skapar rabatt variabel som jag multiplicerar med Price. Returnerar nytt pris.

    @Override
    public double getPrice() {
        double discount = 0.5;
        double newPrice = super.getPrice() * discount;
        return newPrice;
    }
}



