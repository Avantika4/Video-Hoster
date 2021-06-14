package com.Fileuploading.Fileuploading.Modle;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "post")
public class Post {


    @Id
    @GeneratedValue
    private Integer postId;
    private String postTitle;
    private String postdesc;



    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "post",fetch = FetchType.LAZY)
    private Videopost videopost;



    public Post() {
    }

    public Post(String postTitle,String postdesc) {
        this.postdesc = postdesc;
        this.postTitle = postTitle;
    }

    public Post(Integer postId,String postTitle ,String postdesc,String userid,UUID id) {
        this.postId = postId;
        this.postdesc = postdesc;
        this.postTitle = postTitle;
        this.user = new User(userid);
       this.videopost=new Videopost(id);
    }

    public Post(Integer postId) {
        this.postId=postId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostdesc() {
        return postdesc;
    }

    public void setPostdesc(String postdesc) {
        this.postdesc = postdesc;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getUser() {
        return user.getUser_id();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getVideopost() {
        return videopost.getId();
    }

    public void setVideopost(Videopost videopost) {
        this.videopost = videopost;
    }
}
