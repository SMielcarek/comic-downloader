package com.smcodinglab.xkcd.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smcodinglab.xkcd.domain.Comic;
import com.smcodinglab.xkcd.exception.ComicRetrievalException;
import com.smcodinglab.xkcd.properties.XKCDProperties;
import com.smcodinglab.xkcd.services.ComicService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class XKCDComicService implements ComicService {

    private final OkHttpClient httpClient;
    private final XKCDProperties xkcdProperties;
    private final ObjectMapper objectMapper;

    @Autowired
    public XKCDComicService(OkHttpClient httpClient, XKCDProperties xkcdProperties, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.xkcdProperties = xkcdProperties;
        this.objectMapper = objectMapper;
    }

    @Override
    public Comic getTodaysComic() throws ComicRetrievalException {
        try {
            Request request = buildRequest(xkcdProperties.getDownloadUrl());
            ResponseBody responseBody = httpClient.newCall(request).execute().body();
            return parseResponseBody(responseBody);
        }
        catch (IOException exception) {
            log.error("There was a problem with retrieving the comic.", exception);
            throw new ComicRetrievalException("Could not retrieve the comic: " + exception.getClass().getName());
        }
    }

    private Request buildRequest(String url) {
        return new Request.Builder().url(url).build();
    }

    private Comic parseResponseBody(ResponseBody responseBody) throws IOException {
        if (responseBody == null) {
            throw new NullPointerException("OkHttp response is empty");
        }
        return objectMapper.readValue(responseBody.string(), Comic.class);
    }

}
