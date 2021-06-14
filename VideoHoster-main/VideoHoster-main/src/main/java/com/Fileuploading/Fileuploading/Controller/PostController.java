package com.Fileuploading.Fileuploading.Controller;


import com.Fileuploading.Fileuploading.Modle.Post;
import com.Fileuploading.Fileuploading.Modle.User;
import com.Fileuploading.Fileuploading.Repository.PostRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PostController {

    @Autowired
    private PostRepo postRepo;


    @PostMapping("/create/{id}")
    public Integer createpost(@RequestBody String data,@PathVariable("id") String id) throws JsonProcessingException
    {

        Post post=new Post();
        post=new ObjectMapper().readValue(data,Post.class);
        User user=new User(id);
        post.setUser(user);
        try {
            Post post1 = postRepo.save(post);
        return post1.getPostId();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return 0;
        }

    }


    @GetMapping("/getallpost")
    private List<Post> getallpost()
    {
        return postRepo.getallpots();
    }


}
