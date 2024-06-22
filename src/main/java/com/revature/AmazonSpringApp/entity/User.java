package com.revature.AmazonSpringApp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;
    private String email;
    private String password;
    @OneToOne
    @JoinColumn(name = "profileId")
    private Profile profileId;
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cartId;
    private String otp;
    private String token;
    private boolean isAdmin;

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    User(){}
    @Override
    public int hashCode(){
        return this.id;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        User that = (User) obj;
        return this.id == that.id;
    }
    @Override
    public String toString(){
        return "User "+ id+ " "+ isAdmin+ ": "+ email;
    }
}
