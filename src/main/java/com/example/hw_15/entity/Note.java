package com.example.hw_15.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private Long id;
    private String title;
    private String content;

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

}