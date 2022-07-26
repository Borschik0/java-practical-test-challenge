import java.util.Scanner;

public class BuyOutput {
    public void outputBuy(){
        System.out.println("============================================");
        System.out.println("<< Buy products:");
        System.out.println("--------------------------------------------");
        System.out.println("Please enter your User ID and Product ID:");
    }
    public int outputBuyUserId(Scanner scanner){
        System.out.print("User ID: ");
        int buyUserId = scanner.nextInt();
        return buyUserId;
    }
    public int outputBuyProductId(Scanner scanner){
        System.out.print("Product ID: ");
        int buyProductId = scanner.nextInt();
        return buyProductId;
    }
}
