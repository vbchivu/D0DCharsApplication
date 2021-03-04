package com.dodgame.dodgame.controllers;

import com.dodgame.dodgame.dao.IMonsterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MonsterController {
    @Autowired
    final IMonsterDAO monsterDAO;

    public MonsterController(IMonsterDAO monsterDAO) {
        this.monsterDAO = monsterDAO;
    }


    @RequestMapping("/monsters")
    public String getMonsters(Model model) throws Exception {
        model.addAttribute("monsters", monsterDAO.fetchManual());
        return "monsters";
    }

}
