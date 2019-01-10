package io.smartmesh.cloudnoteservice;

import io.smartmesh.cloudnoteservice.dao.NoteDao;
import io.smartmesh.cloudnoteservice.entity.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudnoteserviceApplicationTests {
    @Autowired
    private NoteDao noteDao;
    @Test
    public void contextLoads() {
        Note note = new Note();
        note.setName("hello");
        note.setUser_id("*");
        note.setUser_head("1.png");
//        note.setCode(transactionHash);
        int i = noteDao.addNote(note);
        System.out.println("id="+note.getId());
        System.out.println("i="+i);
        noteDao.updateNoteCode("123",note.getId());
    }
}

