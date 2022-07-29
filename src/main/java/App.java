import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class App {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        boolean exit = false;
        App shop = new App();
        ArrayList<Purchases> purchases = new ArrayList<>();

        Products product1 = new Products(1234567890, "Valve", 20);
        Products product2 = new Products(1687654321, "CD Project", 10);
        Products product3 = new Products(1293237423, "Ubisoft", 10.5);

        Users user1 = new Users(1568535433, "Ґейб", "Ньюел", 40.5);
        Users user2 = new Users(1856463522, "Марцін", "Івінський", 10);
        Users user3 = new Users(1293237423, "Крiстiан", "Гiймо", 10.5);

        ArrayList<Users> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        ArrayList<Products> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        //Console Menu output
        do {
            shop.Menu();
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            switch (command) {
                case "/users" -> {
                    OutputUsers outputUsers = new OutputUsers();
                    outputUsers.outputUsersTitle();
                    for (Users user : users) {
                        outputUsers.outputUsers(user);
                    }
                }
                case "/products" -> {
                    OutputProducts outputProducts = new OutputProducts();
                    outputProducts.outputProductsTitle();
                    for (Products product : products) {
                        outputProducts.outputProducts(product);
                    }
                }
                case "/buy" -> {
                    BuyOutput buyOutput = new BuyOutput();
                    buyOutput.outputBuy();
                    int idUserInput = buyOutput.outputBuyUserId(scanner);
                    int idProductInput = buyOutput.outputBuyProductId(scanner);

                    for (Users user : users) {
                           if(user.id == idUserInput){
                               for (Products product : products) {
                                   if(product.id == idProductInput) {
                                       if(user.money >= product.price) {
                                           user.money = user.money - product.price;
                                           System.out.println("Excellent! " + user.name + " " +user.surName +" has purchased " + product.name + "!");
                                           Purchases newPur = new Purchases(user, product);
                                           purchases.add(newPur);
                                       } else {
                                           System.out.println("Not enough money :(");
                                       }
                                   }
                                   }
                               }
                       }
                    }
                case "/purchase" -> {
                    PurchaseOutput purchaseOutput = new PurchaseOutput();
                    purchaseOutput.outputPurchaseTitle();
                    int numberDisplay = scanner.nextInt();
                     if (numberDisplay == 1){
                         System.out.print("Enter User ID: ");
                         int userID = scanner.nextInt();
                         System.out.println("User shopping: ");
                         for (Purchases purchase : purchases) {
                           if(userID == purchase.getUserId()){
                               System.out.println(purchase.getProduct());
                           }
                         }
                     } else if (numberDisplay == 2){
                         System.out.print("Enter Product ID: ");
                         int productID = scanner.nextInt();
                         System.out.println("Purchased items:");
                         for (Purchases purchase : purchases) {
                             if(productID == purchase.getProductId()){
                                 System.out.println(purchase.getUser());
                             }
                         }
                     }
                }
                case "/exit" -> {
                    System.out.println("Exit program");
                    exit = true;
                }
            }
        } while (!exit);

    }

    public void Menu() {
        System.out.println("====================" + ANSI_RED + "Menu" + ANSI_RESET + "====================");
        System.out.println("1. " + ANSI_CYAN + "/users" + ANSI_RESET + " - Display list of all users.");
        System.out.println("2. " + ANSI_CYAN + "/products" + ANSI_RESET + " - Display list of all products.");
        System.out.println("3. " + ANSI_CYAN + "/buy" + ANSI_RESET + " - Buy products.");
        System.out.println("4. " + ANSI_CYAN + "/purchase" + ANSI_RESET + " - Display list of all purchases.");
        System.out.println("5. " + ANSI_CYAN + "/exit" + ANSI_RESET + " - Exit program.");
        System.out.println("============================================");
        System.out.print("Enter command: ");
    }
}
