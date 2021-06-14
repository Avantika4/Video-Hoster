package com.Fileuploading.Fileuploading.Modle;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Videopost {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private Long size;
    private Date uploadDate;

    private byte[] content;


    @OneToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Videopost() {
    }

    public Videopost(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadTime) {
        this.uploadDate = uploadTime;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Integer getPost() {
        return post.getPostId();
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getUser() {
        return user.getUser_id();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
