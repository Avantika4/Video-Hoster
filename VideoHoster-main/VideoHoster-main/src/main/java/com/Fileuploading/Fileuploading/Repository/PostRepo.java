package com.Fileuploading.Fileuploading.Repository;

import com.Fileuploading.Fileuploading.Modle.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {

    @Query("select new Post(p.postId,p.postTitle,p.postdesc,p.user.user_id,p.videopost.id) from Post p")
    public List<Post> getallpots();

}
