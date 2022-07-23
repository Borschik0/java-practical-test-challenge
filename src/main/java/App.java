import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        boolean exit = false;
        App shop = new App();
        ArrayList<String[]> purchases = new ArrayList<>();


        Products product1 = new Products("1234567890", "Valve", 20);
        Products product2 = new Products("0987654321", "CD Project", 10);
        Products product3 = new Products("1293237423", "Ubisoft", 10.5);

        Users user1 = new Users("1568535433", "Ґейб", "Ньюел", 40.5);
        Users user2 = new Users("1856463522", "Марцін", "Івінський", 10);
        Users user3 = new Users("1293237423", "Крiстiан", "Гiймо", 10.5);

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
                case "/users":
                    OutputUsers outputUsers = new OutputUsers();
                    outputUsers.outputUsersTitle();
                    for (Users user : users) {
                        outputUsers.outputUsers(user);
                    }
                    break;
                case "/products":
                    OutputProducts outputProducts = new OutputProducts();
                    outputProducts.outputProductsTitle();
                    for (Products product : products) {
                        outputProducts.outputProducts(product);
                    }
                    break;
                case "/buy":
                    BuyOutput buyOutput = new BuyOutput();
                    buyOutput.outputBuy();

                    for (Users user : users) {
                        if (buyOutput.outputBuyUserId(scanner).equals(user.id)) {
                            for (Products product : products) {
                                try {
                                    if (buyOutput.outputBuyProductId(scanner).equals(product.id)) {
                                        if (user.money >= product.price) {
                                            System.out.println("You have successfully purchased this item!");
                                            user.money = user.money - product.price;
                                            String[] newPur = new String[]{
                                                    user.toString(),
                                                    product.toString()
                                            };
                                            purchases.add(newPur);
                                        } else {
                                            System.out.println("No money :(");
                                        }
                                        //TO DO
                                    }
                                } catch (Exception e) {
                                    System.out.println("Product with this id not found");
                                }
                            }
                        }
                    }
                    break;
                case "/purchase":
                    PurchaseOutput purchaseOutput = new PurchaseOutput();
                    purchaseOutput.outputPurchaseTitle();
                    try {
                        for (String[] purchase : purchases) {
                            System.out.println(Arrays.toString(purchase));
                        }
                    } catch (Exception e) {
                        System.out.println("Nobody bought the products :(");
                    }
                    ;
                    break;
                case "/exit":
                    System.out.println("Exit program");
                    exit = true;
                    break;

            }
        } while (!exit);

    }

    public String[] purchaseCreator(String[] idUser, String[] idProduct) {
        return new String[]{
                String.valueOf(idUser), String.valueOf(idProduct)
        };
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
