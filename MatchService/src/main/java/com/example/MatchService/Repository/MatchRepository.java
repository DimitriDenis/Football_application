package com.example.MatchService.Repository;

import com.example.MatchService.Beans.Matchs;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MatchRepository extends CrudRepository<Matchs, Integer> {
    Optional<Matchs> findById(Integer id);

    boolean existsById(Integer id);

    void deleteById(Integer id);
}
