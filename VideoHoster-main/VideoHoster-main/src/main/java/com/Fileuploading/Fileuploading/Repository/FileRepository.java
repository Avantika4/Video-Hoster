package com.Fileuploading.Fileuploading.Repository;

import com.Fileuploading.Fileuploading.Modle.Videopost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface FileRepository extends JpaRepository<Videopost, UUID> {

}
