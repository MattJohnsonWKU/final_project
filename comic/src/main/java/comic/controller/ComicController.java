package comic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comic.entity.Comic;
import comic.service.ComicService;

@RestController
@RequestMapping("comic/comics")
public class ComicController {

	private final ComicService comicService;

    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    @PostMapping
    public ResponseEntity<Comic> createComic(@RequestBody Comic comic) {
        Comic createdComic = comicService.createComic(comic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComic);
    }

}
