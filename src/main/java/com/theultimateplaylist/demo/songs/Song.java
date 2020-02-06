package com.theultimateplaylist.demo.songs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    private int id;
    private String artist;
    private String title;
    private String Album;
    private int year;
    //private SongRating songRating; //add later


}
