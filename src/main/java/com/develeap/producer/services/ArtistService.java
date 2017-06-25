package com.develeap.producer.services;

import com.develeap.producer.domain.Artist;

import com.develeap.producer.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArtistService {

  private final Map<Long,Artist> artistById = new HashMap<>();

  public Artist addArtist(Artist artist) {
    artist.setId(System.currentTimeMillis());
    artistById.put(artist.getId(),artist);
    return artist;
  }

  public Artist getArtistById(Long id) {
    Artist ret = artistById.get(id);
    if (ret==null) throw new ObjectNotFoundException("Artist",id);
    return ret;
  }

  public Collection<Artist> getArtistsByName(String q, int page, int pageSize) {
    int i=0;
    int first = page*pageSize;
    int last = (page+1)*pageSize-1;
    Collection<Artist> ret = new ArrayList<>();
    String qq = q.toLowerCase();
    for (Artist a: artistById.values()) {
      String name = a.getName();
      if (name!=null && name.length()>0 && name.toLowerCase().contains(qq)) {
        if (first<= i && i<last) ret.add(a);
        i++;
        if (i>last) break;
      }
    }
    return ret;
  }
}
