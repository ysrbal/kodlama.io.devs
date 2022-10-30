package kodlama.io.devs.webApi.controllers;


import kodlama.io.devs.business.abstracts.LanguageService;

import kodlama.io.devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class BrandsControllers {
    private LanguageService languageService;

    @Autowired
    public BrandsControllers(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public String add(Language language) {
        return languageService.add(language);
    }

    @PostMapping("/update")
    public String update(Language language) {
        return languageService.update(language);
    }

    @DeleteMapping("/remove")
    public void remove(Language language) {
        languageService.remove(language);
    }

    @GetMapping("/getbyid")
    public Language getById(int id) {
        return languageService.getById(id);
    }

    @GetMapping("/getall")
    public List<Language> getAll() {
        return languageService.getAll();
    }
}
