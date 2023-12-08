import java.util.*;
// Tagit bort boilerplate text
public class Main {

    public static void main(String[] args) {

        // Tagit bort "bag.inBag();" behövs inte
        // Info om inventory
        Inventory bag = new Inventory("", 0.00, 100.00, 0);


        // Fixat lite med texten samt lagt till "(4. Quite )" inom loopen
        // Arraylist med objekt för varorna
        ArrayList<Food> varor = new ArrayList<>();
        Food Kniv = new Food("(1. Godis Kniv,) ", 10, 10.00);
        Food Skelett = new Food("(2. Godis Skelett,) ", 20, 20.70);
        Food Pumpa = new Food("(3. Pumpa,) ", 30, 30.50);

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


        // Flyttat "scanner" utanför loopen för att undvika omdeklaration
        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Optimerat while-loopen. Skriv "true" om loopen ska gå för-evigt, tills användaren trycker på "4"
        // eller har överstigit 100 SEK

        while (true) {

            // skriver ut listan av varor genom att iterera längden av Arraylistan
            for (int i = 0; i < varor.size(); i++) {
                Food food = varor.get(i);
                System.out.println(food.getName() + food.getPrice() + " SEK " + food.getStock() + " wares left ");
            }

            System.out.println("(4. Quite ) ");
            System.out.print("Buy something: ");

            // Lagt till try-catch för att varna användaren har matat in fel indata
            int input = 0;
            try {
                input = scanner.nextInt();
            } catch (Exception e) {
                System.err.println("Only Numbers Allowed. Please Try Again ");
            }
            // Detta hoppar tillbaka till listan
            scanner.nextLine();

            // Optimerat if-else satser. Lagt till "Out of Bounds" om användaren matar in för lågt eller för högt
            // indata.
            if (input < 0 || input > 4) {
                System.err.println("Out of Bounds. Please Try Again");
            }

            // uppdaterar innehåll, mängd spenderat och lagersaldo
            if (input == 1) {
                bag.updateBag(Kniv);
                Kniv.updateStock();
                bag.amountBought();
            } else if (input == 2) {
                bag.updateBag(Skelett);
                Skelett.updateStock();
                bag.amountBought();
            } else if (input == 3) {
                bag.updateBag(Pumpa);
                Pumpa.updateStock();
                bag.amountBought();

                // Lagt till en "system exit" om användaren trycker på "4", samt printar ut resultatet
            } else if (input == 4) {
                System.out.println("You spent: " + bag.getCost() + " SEK and bought a total of " + bag.getAmount() + " wares!");
                System.exit(0);
            }
            // Optimerat koden. Jag kunde inte få "bag.getCash" att funka, jag bytte ut det till "bag.getCost()"
            if (bag.getCost() < -100) { // om spelaren spenderar för 100 SEK eller mer är det "game over"
                System.err.println("Game Over. You spent: " + bag.getCost() + " SEK and bought a total of " + bag.getAmount() + " wares!");
                System.exit(0);
            }
        }
    }
}