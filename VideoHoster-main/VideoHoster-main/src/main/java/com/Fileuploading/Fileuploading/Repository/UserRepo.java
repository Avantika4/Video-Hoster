package com.Fileuploading.Fileuploading.Repository;

import com.Fileuploading.Fileuploading.Modle.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

}
