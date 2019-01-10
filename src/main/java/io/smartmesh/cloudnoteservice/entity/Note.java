package io.smartmesh.cloudnoteservice.entity;

import lombok.Data;

/**
 * @author Mr ifan/詹奕凡
 * @version 1.0
 * @date 2019/1/4
 */
@Data
public class Note {
    private Integer id;
    private String user_id;
    private String user_head;
    private String name;
    private String code;
}
