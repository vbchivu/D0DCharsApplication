package com.dodgame.dodgame.dao;

import com.dodgame.dodgame.dto.MonsterCharacteristicsDTO;

import java.util.List;

public interface IMonsterCharacteristicsDAO {
    List<MonsterCharacteristicsDTO> fetchCharacteristics(String endpoint) throws Exception;
}
