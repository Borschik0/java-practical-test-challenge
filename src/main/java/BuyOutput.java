import java.util.Scanner;

public class BuyOutput {
    public void outputBuy(){
        System.out.println("============================================");
        System.out.println("<< Buy products:");
        System.out.println("--------------------------------------------");
        System.out.println("Please enter your User ID and Product ID:");
    }
    public String outputBuyUserId(Scanner scanner){
        System.out.print("User ID: ");
        String buyUserId = scanner.nextLine();
        return buyUserId;
    }
    public String outputBuyProductId(Scanner scanner){
        System.out.print("Product ID: ");
        String buyProductId = scanner.nextLine();
        return buyProductId;
    }
}
