package com.Fileuploading.Fileuploading.Service;


import com.Fileuploading.Fileuploading.Modle.User;
import com.Fileuploading.Fileuploading.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    public  String createuser(User user)
    {
        try {
            userRepo.save(user);
            return user.getUser_id();
        }
        catch (Exception e)
        {
            return "false";
        }
    }


    public String checkuser(User user)
    {
        try{
            Optional<User> user1=userRepo.findById(user.getUser_id());
            if(user1.isPresent()&&user1.get().getUser_id().equals(user.getUser_id())) {
                return user1.get().getUser_id();
            }
            else
            {
                return "false";
            }
        }
        catch (Exception e)
        {
            return "false";
        }
    }
}
