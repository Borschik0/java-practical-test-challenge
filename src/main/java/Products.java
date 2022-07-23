public class Products {
        String id;
        String name;
        double price;

     Products(String id, String name, double price)
        {
            this.id = id;
            this.name = name;
            this.price = price;
        }

    public String toString() {
        return ("Product info: id:" + id + ", Name: " + name);
    }
}
