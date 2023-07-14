package comic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comic.entity.Hero;
import comic.service.ComicService;

@RestController
@RequestMapping("/comic/heroes")
public class HeroController {

    private final ComicService comicService;

    @Autowired
    public HeroController(ComicService comicService) {
        this.comicService = comicService;
    }

    @PostMapping
    public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
        Hero createdHero = comicService.createHero(hero);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHero);
    }
}