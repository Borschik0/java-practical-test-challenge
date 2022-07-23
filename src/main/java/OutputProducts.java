public class OutputProducts {
    public void outputProductsTitle(){
        System.out.println("============================================");
        System.out.println("<< Products:");
    }
    public void outputProducts(Products product){
        System.out.println("--------------------------------------------");
        System.out.println("      id: " + product.id);
        System.out.println("    Name: " + product.name);
        System.out.println("   Price: " + product.price + " грн.");
    }
}
