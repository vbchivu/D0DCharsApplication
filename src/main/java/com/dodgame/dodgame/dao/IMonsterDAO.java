package com.dodgame.dodgame.dao;

import com.dodgame.dodgame.dto.MonsterDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMonsterDAO {

    List<MonsterDTO> fetchManual(String endpoint) throws Exception;
}
