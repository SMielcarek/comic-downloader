package com.smcodinglab.xkcd.services.impl;

import com.smcodinglab.xkcd.domain.Comic;
import com.smcodinglab.xkcd.exception.ComicRetrievalException;
import com.smcodinglab.xkcd.properties.XKCDProperties;
import com.smcodinglab.xkcd.services.ComicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@Qualifier("RestTemplate")
public class XKCDComicServiceRT implements ComicService {

    private final RestTemplate restTemplate;
    private final XKCDProperties xkcdProperties;

    @Autowired
    public XKCDComicServiceRT(RestTemplate restTemplate, XKCDProperties xkcdProperties) {
        this.restTemplate = restTemplate;
        this.xkcdProperties = xkcdProperties;
    }

    public Comic getTodaysComic() throws ComicRetrievalException {
        log.info("Retrieving using RestTemplate");
        Comic comic = restTemplate.getForObject(xkcdProperties.getDownloadUrl(), Comic.class);
        //comic.setTitle("DUMMY!!!");
        return comic;
    }
}
