public class OutputUsers {
    public void outputUsersTitle(){
        System.out.println("============================================");
        System.out.println("<< Users:");
    }
    public void outputUsers(Users user){
        System.out.println("--------------------------------------------");
        System.out.println("      id: " + user.id);
        System.out.println("    Name: " + user.name);
        System.out.println(" Surname: " + user.surName);
        System.out.println("   Money: " + user.money + " грн.");
    }
}
