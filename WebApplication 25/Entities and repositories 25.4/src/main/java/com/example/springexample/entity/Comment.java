package com.example.springexample.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "text")
    private String text;
    @Column(name = "author")
    private  String author;
    @CreationTimestamp
    @Column(name = "creation_time")
    private LocalDateTime time;
}
