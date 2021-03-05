package com.dodgame.dodgame.controllers;

import com.dodgame.dodgame.dao.IMonsterCharacteristicsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonsterCharacteristicsController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    final IMonsterCharacteristicsDAO characteristicsDAO;

    static String endpoint ="https://www.dnd5eapi.co";

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public MonsterCharacteristicsController(IMonsterCharacteristicsDAO characteristicsDAO) {
        this.characteristicsDAO = characteristicsDAO;
    }

    @RequestMapping("/")
    public String index (@RequestParam(value = "index") String index, Model model) throws Exception {
        model.addAttribute("characteristics", characteristicsDAO.fetchCharacteristics(endpoint+index));
        return "characteristics";
    }

}
