package com.dodgame.dodgame.dao;

import com.dodgame.dodgame.dto.MonsterDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMonsterDAO extends CrudRepository<MonsterDTO, String> {
//    List<MonsterDTO> fetchManual(String endpoint) throws Exception;
}
