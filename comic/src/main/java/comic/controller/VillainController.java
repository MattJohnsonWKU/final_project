package comic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comic.entity.Villain;
import comic.service.ComicService;

@RestController
@RequestMapping("/comic/villains")
public class VillainController {

    private final ComicService comicService;

    @Autowired
    public VillainController(ComicService comicService) {
        this.comicService = comicService;
    }

    @PostMapping
    public ResponseEntity<Villain> createVillain(@RequestBody Villain villain) {
        Villain createdVillain = comicService.createVillain(villain);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVillain);
    }
}