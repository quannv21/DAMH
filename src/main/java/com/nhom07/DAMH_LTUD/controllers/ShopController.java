package com.nhom07.DAMH_LTUD.controllers;

import com.nhom07.DAMH_LTUD.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
    @Autowired
    private ProductService productService;

    @Autowired
    private TournamentCategoryService tournamentCategoryService;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private LeagueClubService leagueClubService;


    @Autowired
    private TeamClubService teamClubService;
    @GetMapping()
    public String shop(Model model) {
        model.addAttribute("categories", tournamentCategoryService.getAllTournamentCategory());
        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        model.addAttribute("leagues", leagueClubService.getAllLeagueClubs());
        model.addAttribute("teamclubs", teamClubService.getAllTeamClubs());
        model.addAttribute("products", productService.getAllProducts());
        return "shop"; // Tên tệp HTML bạn muốn trả về (không cần đuôi .html)
    }
}
