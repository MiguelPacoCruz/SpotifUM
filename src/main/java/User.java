/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miguel
 */

// constantes

enum Plan {
    Free,
    PremiumBase,
    PremiumTop,
}

// metodos de criaçao

public class User {
    private static int lastId = 0; // Static variable to keep track of the last assigned id
    private final int id;
    private String name;
    private String email;
    private String address;
    private Plan plan;
    private Playlist listened;

    public User(){
        this.id = ++lastId;
        this.name = "";
        this.email = "";
        this.address = "";
        this.plan = Plan.Free;
    }

    public User(User x){
        this.id = ++lastId;
        this.name = x.name;
        this.email = x.email;
        this.address = x.address;
        this.plan = x.plan;
    }

    public User(String name, String email, String address, Plan plan){
        this.id = ++lastId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.plan = plan;
    }

    // metodos set/get

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    public void setPlan(Plan plan){
        this.plan = plan;
    }

    public Plan getPlan() {
        return this.plan;
    }

    // metodos obrigatorios

    public String toString() {
        return "User[id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", address=" + this.address + ", plan=" + this.plan + "]";
    }

    public User clone() {
        return new User (this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o == null || this.getClass() != o.getClass()) return false;

        User m = (User) o;

        return this.id == m.id;
    }
}
