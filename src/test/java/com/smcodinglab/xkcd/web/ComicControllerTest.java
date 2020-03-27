package com.smcodinglab.xkcd.web;

import com.smcodinglab.xkcd.domain.Comic;
import com.smcodinglab.xkcd.exception.ComicRetrievalException;
import com.smcodinglab.xkcd.services.ComicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ComicController.class)
public class ComicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ComicService comicService;

    @Test
    public void todaysComicTitleTest_returns200() throws Exception {
        Comic comic = new Comic();
        comic.setTitle("Test title");
        Mockito.when(comicService.getTodaysComic()).thenReturn(comic);
        mockMvc.perform(get("/comic"))
                .andExpect(content().string("the title of today's XKCD comic was: Test title"))
                .andExpect(status().isOk());
    }

    @Test
    public void todaysComicTitleTest_returns503() throws Exception {
        Mockito.when(comicService.getTodaysComic()).thenThrow(new ComicRetrievalException("Test Exception"));
        mockMvc.perform(get("/comic"))
                .andExpect(content().string("Test Exception"))
                .andExpect(status().isServiceUnavailable());
    }
}