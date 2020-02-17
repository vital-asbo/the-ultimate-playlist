package com.theultimateplaylist.demo.songs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "song")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "artist")
    @NonNull
    private String artist;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "album")
    @NonNull
    private String Album;

    @Column(name = "year")
    @NonNull
    private int year;


    //private SongRating songRating; //add later


}
