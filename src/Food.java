
public class Food {

    private String name;
    private int stock;
    private double price;

    // konstruktor

    public Food(String name, int stock, double price){
        this.setName(name);
        this.setStock(stock);
        this.setPrice(price);
    }
    // getters och setters
    public String getName(){

        return name;
    }

    public double getPrice(){

        return price;
    }

    public int getStock(){

        return stock;
    }

    public void setPrice(double price){
            this.price = price;
        }

    public void setName(String name){
        this.name = name;
    }


    public void setStock(int stock){
        this.stock = stock;
    }

    // uppdaterar lager saldo
    public void updateStock(){

        stock --;
    }
}

