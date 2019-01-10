package io.smartmesh.cloudnoteservice.service;

import io.smartmesh.cloudnoteservice.dao.NoteDao;
import io.smartmesh.cloudnoteservice.entity.Note;
import io.smartmesh.cloudnoteservice.solidity.Cloudnoteservice;
import io.smartmesh.cloudnoteservice.util.EtherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Mr ifan/詹奕凡
 * @version 1.0
 * @date 2019/1/4
 */
@Service
public class NoteService implements Runnable {
    @Autowired
    private NoteDao noteDao;
    private String id;
    private String user_head;
    private String name;
    private String content;
    private Integer generatedKeys;
    public int addNote(String id,String user_head,String name,String content){
        this.setProperties(id,user_head,name,content);
        Note note = new Note();
        note.setName(name);
        note.setUser_id(id);
        note.setUser_head(user_head);
//        note.setCode(transactionHash);
        noteDao.addNote(note);
        generatedKeys = note.getId();
        Thread thread = new Thread(this);
        thread.start();
        return generatedKeys;
    }
    public String getNote(String id,String name){
        Cloudnoteservice contract = EtherUtil.getContract();
        String send = null;
        try {
            send = contract.getNote(id, name).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return send;
    }
    public int getStatus(String transactionHash){
        int i = 0;
        try {
            EthGetTransactionReceipt send = EtherUtil.getWeb3j().ethGetTransactionReceipt(transactionHash).send();
            Optional<TransactionReceipt> transactionReceipt = send.getTransactionReceipt();
            TransactionReceipt transactionReceipt1 = transactionReceipt.get();
            String status = transactionReceipt1.getStatus();
            i = Integer.parseInt(status.substring(2), 16);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
    public List<Note> getList(String id){
        return noteDao.getNotesByUser(id);
    }
    public List<Note> getAllNote(){
        return noteDao.getAllNotes();
    }
    private void setProperties(String id,String user_head,String name,String content){
        this.id = id;
        this.user_head = user_head;
        this.name = name;
        this.content = content;
    }
    @Override
    public void run() {
        Cloudnoteservice contract = EtherUtil.getContract();
        TransactionReceipt transactionReceipt=null;
        String transactionHash="";
        try {
            transactionReceipt = contract.addNote( id, name, content).send();
            transactionHash = transactionReceipt.getTransactionHash();
            noteDao.updateNoteCode(transactionHash,this.generatedKeys);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
