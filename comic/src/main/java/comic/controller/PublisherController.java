package comic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import comic.entity.Publisher;
import comic.service.ComicService;
import java.util.List;

@RestController
@RequestMapping("/comic")

public class PublisherController {
	@Autowired  
    private final ComicService comicService;

    public PublisherController(ComicService comicService) {
        this.comicService = comicService;
    }

    @PostMapping("/publishers")
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        Publisher createdPublisher = comicService.createPublisher(publisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPublisher);
    }

    @PutMapping("/publishers/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher) {
        Publisher updatedPublisher = comicService.updatePublisher(id, publisher);
        return ResponseEntity.ok(updatedPublisher);
    }

    @GetMapping("/publishers/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id) {
        Publisher publisher = comicService.getPublisherById(id);
        if (publisher != null) {
            return ResponseEntity.ok(publisher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/publishers")
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = comicService.getAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @DeleteMapping("/publishers/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable Long id) {
        try {
            comicService.deletePublisherById(id);
            String responseMessage = "Publisher with ID " + id + " has been deleted.";
            return ResponseEntity.ok(responseMessage);
        } catch (DataIntegrityViolationException e) {
            String responseMessage = "Cannot delete publisher with ID " + id + " due to associated comics.";
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseMessage);
        }
    }
}
