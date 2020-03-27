package com.smcodinglab.xkcd.services;

import com.smcodinglab.xkcd.domain.Comic;
import com.smcodinglab.xkcd.exception.ComicRetrievalException;

public interface ComicService {

    Comic getTodaysComic() throws ComicRetrievalException;
}
