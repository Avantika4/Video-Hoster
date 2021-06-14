package com.Fileuploading.Fileuploading.Service;

import com.Fileuploading.Fileuploading.Modle.Videopost;
import com.Fileuploading.Fileuploading.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    public FileRepository fileRepository;

    public UUID uploadvideo(Videopost videopost)
    {
        try{
            Videopost save=fileRepository.save(videopost);
            return save.getId();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return UUID.fromString("00000000-0000-0000-0000-000000000000");
        }
    }

    public List<Videopost> allpsots()
    {
        return fileRepository.findAll();
    }

    public byte[] sendvideo(UUID id)
    {
        Optional<Videopost> video=fileRepository.findById(id);
        if(video.isPresent())
        {
            return video.get().getContent();
        }
        else
        {
            return null;
        }
    }
}
