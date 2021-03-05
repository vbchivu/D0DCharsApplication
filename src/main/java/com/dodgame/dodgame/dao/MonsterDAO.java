package com.dodgame.dodgame.dao;

import com.dodgame.dodgame.dao.IMonsterDAO;
import com.dodgame.dodgame.dao.NetworkDAO;
import com.dodgame.dodgame.dto.MonsterDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonsterDAO implements IMonsterDAO {
    @Autowired
    NetworkDAO networkDAO;

    /* (non-Javadoc)
    * see com.dodgame.dodgame.dao.IMonsterDAO#fetch(java.lang.String)
     */
    public List<MonsterDTO> fetchManual(String endpoint) throws Exception {
        List<MonsterDTO> allMonsters = new ArrayList<>();

        String rawJson = networkDAO.request(endpoint);

        JSONObject root = new JSONObject(rawJson);

        JSONArray monsters = root.getJSONArray("results");

        for(int i = 0; i < monsters.length(); i++) {
            // the JSON data
            JSONObject jsonMonster = monsters.getJSONObject(i);
            // Monster Object that we will populate from JSON data
            MonsterDTO monster = new MonsterDTO();
            String index = jsonMonster.getString("index");
            String name = jsonMonster.getString("name");
            String url = jsonMonster.getString("url");

            // populate our DTO with this information
            monster.setIndex(index);
            monster.setName(name);
            monster.setUrl(url);

            // add the populated monster to our collection
            allMonsters.add(monster);
        }
        return allMonsters;
    }

}
