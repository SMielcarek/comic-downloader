package com.smcodinglab.xkcd;

import com.smcodinglab.xkcd.web.ComicController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class ComicDownloaderApplicationTest {

    @Autowired
    private ComicController comicController;

    @Test
    void contextLoads() {
        assertThat(comicController).isNotNull();
    }
}