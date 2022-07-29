public class Purchases {
    Users user;
    Products product;

    Purchases(Users user, Products product){
        this.user = user;
        this.product = product;
    }

    public int getUserId(){
        return user.id;
    }

    public int getProductId(){
        return product.id;
    }
    public Products getProduct(){
        return product;
    }

    public Users getUser(){
        return user;
    }

}
