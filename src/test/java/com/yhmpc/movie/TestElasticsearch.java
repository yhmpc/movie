package com.yhmpc.movie;

import com.yhmpc.movie.domain.es.MovieEs;
import com.yhmpc.movie.domain.jpa.MovieDb;
import com.yhmpc.movie.repository.MovieDbRepository;
import com.yhmpc.movie.repository.MovieEsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yhm
 * @Date 4/15/2020 14:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestElasticsearch {

    @Autowired
    private MovieEsRepository movieEsRepository;

    @Autowired
    private MovieDbRepository movieDbRepository;

    @Test
    public void syncDB2ES() {
        List<MovieDb> dbList = movieDbRepository.findAll();
        List<MovieEs> esList = new ArrayList<>();
        for (MovieDb movieDb : dbList) {
            MovieEs movieEs = new MovieEs();
            BeanUtils.copyProperties(movieDb, movieEs);
            esList.add(movieEs);
        }
        movieEsRepository.saveAll(esList);
    }
}
