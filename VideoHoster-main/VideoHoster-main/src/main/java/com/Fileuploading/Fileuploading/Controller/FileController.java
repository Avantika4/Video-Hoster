package com.Fileuploading.Fileuploading.Controller;


import com.Fileuploading.Fileuploading.Modle.Post;
import com.Fileuploading.Fileuploading.Modle.User;
import com.Fileuploading.Fileuploading.Modle.Videopost;
import com.Fileuploading.Fileuploading.Repository.PostRepo;
import com.Fileuploading.Fileuploading.Service.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class FileController {

    @Autowired
    public FileService fileService;

    @Autowired
    public PostController postController;

    @GetMapping("/")
    public String mainpage()
    {
        return "Hello There";
    }

    @PostMapping("{userid}/upload/{enc}")
    public String Uploadvideo(@RequestBody MultipartFile file,@PathVariable("enc") String boi,@PathVariable("userid") String uid) throws IOException {
        System.out.println(boi);
        byte[] decodedBytes = Base64.getDecoder().decode(boi);
        String data = new String(decodedBytes);
        System.out.println(data);
        String name= StringUtils.cleanPath(file.getOriginalFilename());
        Integer ss=postController.createpost(data,uid);
        if(ss==0)
        {
            return "Sorry";
        }

        Videopost videopost=new Videopost();
        System.out.println("file recived:"+name);
        videopost.setName(name);
        videopost.setContent(file.getBytes());
        videopost.setSize(file.getSize());
        videopost.setUploadDate(new Date());
        videopost.setPost(new Post(ss));



        UUID id=fileService.uploadvideo(videopost);



        if (id.equals("00000000-0000-0000-0000-000000000000"))
        {
            return "sorry";
        }
        else{
            return id.toString();
        }

    }
    @GetMapping("/getallfiles")
    public List<Videopost> allfiles()
    {
        return fileService.allpsots();
    }

    @GetMapping("/video/{id}")
    public byte[] findvideo(@PathVariable("id") UUID id)
    {
        return fileService.sendvideo(id);
    }
}
