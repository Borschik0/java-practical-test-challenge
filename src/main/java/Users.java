public class Users {
    int id;
    String name;
    String surName;
    double money;

    Users(int id, String name, String surName, double money)
    {
       this.id = id;
       this.name = name;
       this.surName = surName;
       this.money = money;
    }
    public String toString() {
        return ("User info: id:" + id + ", Name:" + name);
    }

}
