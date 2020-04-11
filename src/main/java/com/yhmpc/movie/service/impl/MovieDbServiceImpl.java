package com.yhmpc.movie.service.impl;

import com.yhmpc.movie.repository.MovieDbRepository;
import com.yhmpc.movie.service.MovieDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yhm
 * @Date 4/11/2020 14:50
 */
@Service
public class MovieDbServiceImpl implements MovieDbService {

    @Autowired
    private MovieDbRepository movieDbRepository;

}
