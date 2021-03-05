package com.dodgame.dodgame.dao;

import com.dodgame.dodgame.dto.MonsterDTO;

import java.util.List;

public interface IMonsterDAO {
    List<MonsterDTO> fetchManual(String endpoint) throws Exception;
}
