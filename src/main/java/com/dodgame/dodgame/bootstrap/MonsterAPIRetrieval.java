package com.dodgame.dodgame.bootstrap;

import com.dodgame.dodgame.dao.IMonsterDAO;
import com.dodgame.dodgame.dao.NetworkDAO;
import com.dodgame.dodgame.dto.MonsterDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonsterAPIRetrieval implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    NetworkDAO networkDAO;

    private final IMonsterDAO iMonsterDAO;

    public MonsterAPIRetrieval(IMonsterDAO iMonsterDAO) {
        this.iMonsterDAO = iMonsterDAO;
    }

    private final String endpoint = "https://www.dnd5eapi.co/api/monsters/";

    /* (non-Javadoc)
    * see com.dodgame.dodgame.dao.IMonsterDAO#fetch(java.lang.String)
     */
    private void fetchManual() throws Exception {
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
        iMonsterDAO.saveAll(allMonsters);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            fetchManual();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
