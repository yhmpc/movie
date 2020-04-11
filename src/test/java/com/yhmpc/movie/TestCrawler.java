package com.yhmpc.movie;

import com.yhmpc.movie.crawler.MovieCrawler;
import com.yhmpc.movie.domain.jpa.MovieDb;
import com.yhmpc.movie.repository.MovieDbRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author yhm
 * @Date 4/11/2020 16:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCrawler {

    @Autowired
    private MovieCrawler movieCrawler;

    @Autowired
    private MovieDbRepository movieDbRepository;

    @Test
    public void runCrawler() {
        List<MovieDb> list = movieCrawler.crawler();
        movieDbRepository.saveAll(list);
    }
}
