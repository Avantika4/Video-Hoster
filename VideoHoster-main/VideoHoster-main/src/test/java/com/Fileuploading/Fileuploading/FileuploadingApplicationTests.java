package com.Fileuploading.Fileuploading;

import com.Fileuploading.Fileuploading.Modle.Videopost;
import com.Fileuploading.Fileuploading.Repository.FileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FileuploadingApplicationTests {

	@Autowired
	public FileRepository fileRepository;

	@Autowired
	public TestEntityManager testEntityManager;

	@Test
	@Rollback(value = false)
	void testInsertVidepost() throws IOException {
		File file=new File("C:\\Users\\DilbagSingh\\Downloads\\full video freshers.mp4");
		Videopost videopost=new Videopost();
		videopost.setName(file.getName());
		byte[] bytes=Files.readAllBytes(file.toPath());
		videopost.setContent(bytes);
		videopost.setSize((long) bytes.length);
		videopost.setUploadDate(new Date());

		Videopost save_o=fileRepository.save(videopost);

		Videopost esits=testEntityManager.find(Videopost.class,save_o.getId());
		long  size=bytes.length;
		long expted=esits.getSize();
		assertEquals(expted,size);

	}

}
