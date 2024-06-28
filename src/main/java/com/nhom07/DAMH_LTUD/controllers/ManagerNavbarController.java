package com.nhom07.DAMH_LTUD.controllers;

import com.nhom07.DAMH_LTUD.model.Tournament;
import com.nhom07.DAMH_LTUD.service.LeagueClubService;
import com.nhom07.DAMH_LTUD.service.TeamClubService;
import com.nhom07.DAMH_LTUD.service.TournamentCategoryService;
import com.nhom07.DAMH_LTUD.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class ManagerNavbarController {
    @Autowired
    private TournamentCategoryService tournamentCategoryService;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private LeagueClubService leagueClubService;

    @Autowired
    private TeamClubService teamClubService;


    @GetMapping("/home1")
    public String navbar(Model model) {

        model.addAttribute("categories", tournamentCategoryService.getAllTournamentCategory());
        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        model.addAttribute("leagues", leagueClubService.getAllLeagueClubs());
        model.addAttribute("teamclubs", teamClubService.getAllTeamClubs());
        return "shop";
    }
}
