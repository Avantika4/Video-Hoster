package com.Fileuploading.Fileuploading.Modle;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String user_id;
    private String UserName;
    private String password;
    @Column(unique = true)
    private String email;

    private String mobileno;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();



    public User() {
    }



    public User(String user_id) {
        this.user_id = user_id;
    }

    public User(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public User(String user_id, String userName, String password, String email, String mobileno ) {
        this.user_id = user_id;
        UserName = userName;
        this.password = password;
        this.email = email;
        this.mobileno = mobileno;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", UserName='" + UserName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobileno='" + mobileno + '\'' +
                '}';
    }
}
