package com.theultimateplaylist.demo.songs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SongController {

    List<Song> songList = new ArrayList<>();

    @RequestMapping("/")
    public String indexGet() {
        return "song/index";
    }

    @RequestMapping("/addDefaultPlaylist")
    public String addDefaultPlaylist() {
        songList.add(new Song(1, "Linkin Park", "Numb", "Meteora", 2003, SongRating.LOVE));
        songList.add(new Song(2, "Limp Bizkit", "Rollin'",
                "Chocolate Starfish and the Hot Dog Flavored Water", 2000, SongRating.LOVE));
        songList.add(new Song(3, "Format:B", "Chunky", "Chunky", 2015, SongRating.LIKE));
        return "song/add-default-playlist";
    }

    @RequestMapping("/view-songs")
    public ModelAndView viewSongs(Model model) {
        return new ModelAndView("song/view-songs", "songList", songList);
    }


//    private Song getSongById(@RequestParam int id) {
//        return songList.stream().filter(f -> f.getId() == id).findFirst().get();
//    }


}
