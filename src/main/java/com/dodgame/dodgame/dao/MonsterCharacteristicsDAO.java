package com.dodgame.dodgame.dao;

import com.dodgame.dodgame.dto.MonsterCharacteristicsDTO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonsterCharacteristicsDAO implements IMonsterCharacteristicsDAO {
    @Autowired NetworkDAO networkDAO;

    /*
    * see com.dodgame.dodgame.dao.IMonsterCharacteristicsDAO#fetchCharacteristics(java.lang.String)
     */
    @Override
    public List<MonsterCharacteristicsDTO> fetchCharacteristics(String endpoint) throws Exception {
        MonsterCharacteristicsDTO monsterCharacteristicsDTO = new MonsterCharacteristicsDTO();
        List<MonsterCharacteristicsDTO> monsterCharacteristicsDAOList = new ArrayList<>();

        String rawJson = networkDAO.request(endpoint);

        JSONObject root = new JSONObject(rawJson);

        String name = root.getString("name");
        monsterCharacteristicsDTO.setName(name);

        monsterCharacteristicsDTO.setSize(root.getString("size"));
        monsterCharacteristicsDTO.setType(root.getString("type"));
        monsterCharacteristicsDTO.setAlignment(root.getString("alignment"));
        monsterCharacteristicsDTO.setArmorClass(root.getInt("armor_class"));
        monsterCharacteristicsDTO.setHitPoints(root.getInt("hit_points"));
        monsterCharacteristicsDTO.setStrength(root.getInt("strength"));
        monsterCharacteristicsDTO.setDexterity(root.getInt("dexterity"));
        monsterCharacteristicsDTO.setConstitution(root.getInt("constitution"));
        monsterCharacteristicsDTO.setIntelligence(root.getInt("intelligence"));
        monsterCharacteristicsDTO.setCharisma(root.getInt("charisma"));
        monsterCharacteristicsDAOList.add(monsterCharacteristicsDTO);

        return monsterCharacteristicsDAOList;
    }
}
