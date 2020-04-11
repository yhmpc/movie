package com.yhmpc.movie.repository;

import com.yhmpc.movie.domain.jpa.MovieDb;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author yhm
 * @Date 4/11/2020 14:49
 */
public interface MovieDbRepository extends JpaRepository<MovieDb, String> {
}
