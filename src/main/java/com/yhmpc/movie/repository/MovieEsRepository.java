package com.yhmpc.movie.repository;

import com.yhmpc.movie.domain.es.MovieEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @Author yhm
 * @Date 4/15/2020 14:15
 */
public interface MovieEsRepository extends ElasticsearchCrudRepository<MovieEs, String> {
}
