package com.theultimateplaylist.demo.songs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/add-default-playlist")
    public String addDefaultPlaylist() {
//        songList.add(new Song(1, "Linkin Park", "Numb", "Meteora", 2003, SongRating.LOVE));
//        songList.add(new Song(2, "Limp Bizkit", "Rollin'",
//                "Chocolate Starfish and the Hot Dog Flavored Water", 2000, SongRating.LOVE));
//        songList.add(new Song(3, "Format:B", "Chunky", "Chunky", 2015, SongRating.LIKE));
        songList.add(new Song(1, "Linkin Park", "Numb", "Meteora", 2003));
        songList.add(new Song(1, "Limp Bizkit", "Rollin'",
                "Chocolate Starfish and the Hot Dog Flavored Water", 2000));
        songList.add(new Song(2, "Format:B", "Chunky", "Chunky", 2015));
        return "song/add-default-playlist";
    }

    @RequestMapping("/view-songs")
    public ModelAndView viewSongs(Model model) {
        return new ModelAndView("song/view-songs", "songList", songList);
    }

    @RequestMapping("/remove-song")
    public ModelAndView removeSong(@RequestParam(value = "song_id") String stringId) {
        int intId = Integer.parseInt(stringId);
        songList.remove(getSongById(intId));
        return new ModelAndView("redirect:/view-songs");
    }

    @RequestMapping(value = "/add-song", method = RequestMethod.GET)
    public ModelAndView addSong(Model model) {
        return new ModelAndView("song/add-song", "song", new Song());
    }

    @RequestMapping(value = "/save-song")
    public ModelAndView saveSong(@ModelAttribute(value = "song") Song song, BindingResult result) {
        if (song.getId() == 0) {
            System.out.println("Adding a New Song");
            int index = songList.size();
            song.setId(index + 1);
            songList.add(song);
        } else {
            Song songTemp = getSongById(song.getId());
            songTemp.setArtist(song.getArtist());
            songTemp.setTitle(song.getTitle());
            songTemp.setAlbum(song.getAlbum());
            songTemp.setYear(song.getYear());
//            songTemp.setSongRating(SongRating.NONE); //default value set to NONE - improve later
         //   songList.add(songTemp);
        }
        return new ModelAndView("redirect:/view-songs");
    }

    @RequestMapping(value = "/edit-song")
    public ModelAndView editSong(@RequestParam(value = "song_id") String song_id) {
        Song song = getSongById(Integer.parseInt(song_id));
        return new ModelAndView("song/add-song", "song", song);
    }


    private Song getSongById(@RequestParam int id) {
        return songList.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }


}
