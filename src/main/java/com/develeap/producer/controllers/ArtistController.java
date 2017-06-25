package com.develeap.producer.controllers;

import com.develeap.producer.domain.Artist;
import com.develeap.producer.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@Controller
@RequestMapping("/api/v1/artists")
public class ArtistController {
  @Autowired
  ArtistService artistService;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public Artist addArtist(@RequestBody Artist artist) {
    return artistService.addArtist(artist);
  }

  @RequestMapping(value="{id}", method = RequestMethod.GET)
  @ResponseBody
  public Artist getArtistByID(@PathVariable Long id) {
    return artistService.getArtistById(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public Collection<Artist> getArtistsByName(
      @RequestParam("q") String q,
      @RequestParam(value = "page",required = false, defaultValue = "0") Integer page) {
    return artistService.getArtistsByName(q,page,5);
  }

}