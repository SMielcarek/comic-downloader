package com.smcodinglab.xkcd.web;

import com.smcodinglab.xkcd.domain.Comic;
import com.smcodinglab.xkcd.exception.ComicRetrievalException;
import com.smcodinglab.xkcd.services.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comic")
public class ComicController {

    private ComicService comicService;

    @Autowired
    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    @GetMapping
    public ResponseEntity<String> todaysComicTitle() throws ComicRetrievalException {
        return new ResponseEntity<>("the title of today's XKCD comic was: " + comicService.getTodaysComic().getTitle(), HttpStatus.OK);
    }

    @GetMapping("/json")
    public ResponseEntity<Comic> getTodaysComic() throws ComicRetrievalException {
        return new ResponseEntity<>(comicService.getTodaysComic(), HttpStatus.OK);
    }

}
