package io.smartmesh.cloudnoteservice.controller;

import io.smartmesh.cloudnoteservice.entity.Note;
import io.smartmesh.cloudnoteservice.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Mr ifan/詹奕凡
 * @version 1.0
 * @date 2019/1/4
 */
@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;
    @RequestMapping("/addNote")
    public Map<String,Integer> addNote(String id,String user_head,String name,String content){

        Map<String,Integer> map = new HashMap<>(0);
//        System.out.println("id= "+id+" user_head=="+user_head+" name="+name+ " content="+content);
        if(!id.equals("")&&!user_head.equals("")&&!name.equals("")&&!content.equals("")){
            int i = noteService.addNote(id, user_head, name, content);
            map.put("insertId",i);
        }else{
            map.put("insertId",0);
        }
        return map;
    }
    @RequestMapping("/getNote")
    public String queryNote(String id,String name){
        String note = noteService.getNote(id, name);
        return note;
    }
    @RequestMapping("/getList")
    public List<Note> getList(String id){
        //return [{"id":1,"user_id":"*","name":"hello","code":"world"}]
        List<Note> list = noteService.getList(id);
        System.out.println(list);
        return list;
    }
    @RequestMapping("/status")
    public Map<String,Integer> getStatus(HttpServletRequest request){
        String hash = request.getParameter("hash");
        int status = noteService.getStatus(hash);
        Map<String,Integer> map = new HashMap<>();
        map.put("info",status);
        return map;
    }
    @RequestMapping("/getAllNote")
    public List<Note> getAllNote(){
       return noteService.getAllNote();
    }
}
