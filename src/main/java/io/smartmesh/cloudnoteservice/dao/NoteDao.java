package io.smartmesh.cloudnoteservice.dao;

import io.smartmesh.cloudnoteservice.entity.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Mr ifan/詹奕凡
 * @version 1.0
 * @date 2019/1/4
 */
@Mapper
public interface NoteDao {
    /**
     * 查询出所有笔记
     * @return all note
     */
    @Select("select id,user_id,user_head,name,code from note order by id desc")
    List<Note> getAllNotes();
    /**
     * 添加笔记
     * @param note
     * @return
     */
    @Insert("insert into note(user_id,user_head,name,code) values(#{user_id},#{user_head},#{name},#{code})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int addNote(Note note);
    @Select("select id,user_id,user_head,name,code from note where user_id=#{user_id} order by id desc")
    List<Note> getNotesByUser(String user_id);
    @Update("update note set code=#{code} where id=#{id}")
    int updateNoteCode(String code,int id);
}
