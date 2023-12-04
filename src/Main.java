// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Arraylist och Scanner
import java.util.*;

public class Main {
    public static void main(String[] args) {


        // Info om inventory
        Inventory bag = new Inventory("", 0.00, 100.00,0);
        bag.inBag();

         // Arraylist med objekt för varorna

        ArrayList<Food> varor = new ArrayList<>();
        Food Kniv = new Food("(1. Godis Kniv, )", 10, 10.00);
        Food Skelett = new Food("(2. Godis Skelett) ", 20, 20.70);
        Food Pumpa = new Food("(3. Pumpa, )", 30, 30.50);

        // lägger till objekten i arraylist
        varor.add(Kniv);
        varor.add(Skelett);
        varor.add(Pumpa);


        //50% rabatt på pumpan
        Discount discount = new Discount("", 0, 0);
        // Lägger i Price värdet av Pumpa objektet så att discount.getPrice() vet vad den ska multiplicera med.
        discount.setPrice(Pumpa.getPrice());
        // sätter metoden på Pumpans Price egenskap.
        Pumpa.setPrice(discount.getPrice());

        // Av/på knapp för spelet
        boolean activeGame = true;

        // Medans spelet är true är spelet igång
        while(activeGame){

            // skriver ut listan av varor genom att iterera längden av Arraylistan
            for (int i = 0; i < varor.size(); i++) {
                Food food = varor.get(i);
                System.out.println(food.getName() + food.getPrice() + " SEK " + food.getStock() + " wares left ");
            }

            // Scanner
            Scanner scanner = new Scanner(System.in);
            System.out.print("Buy something: ");
            int input = scanner.nextInt();


            // uppdaterar innehåll, mängd spenderat och lagersaldo
            if (input == 1 ) {
                bag.updateBag(Kniv);
                Kniv.updateStock();
                bag.amountBought();
            }
            else if (input == 2 ) {
                bag.updateBag(Skelett);
                Skelett.updateStock();
                bag.amountBought();
            }
            else if (input == 3 ) {
                bag.updateBag(Pumpa);
                Pumpa.updateStock();
                bag.amountBought();
            }

            // ifall någon annan siffra skrivs ut
            else {
                System.out.println("Wrong number, try again.");
            }
            // om spelaren spenderar för 100 SEK eller mer är det "game over"
            if (input == 4 || bag.getCash() <= 0 ) {
                activeGame = false;
                System.out.println("Game Over. You spent: " + bag.getCost() + " SEK and bought a total of " + bag.getAmount() + " wares!");
                scanner.close();
            }

        }
    }
}
