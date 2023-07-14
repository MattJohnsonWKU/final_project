package comic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comic.dao.ComicDAO;
import comic.dao.HeroDAO;
import comic.dao.PublisherDAO;
import comic.dao.VillainDAO;
import comic.entity.Comic;
import comic.entity.Hero;
import comic.entity.Publisher;
import comic.entity.Villain;

@Service
public class ComicService {
	 private final PublisherDAO publisherDAO;
	 private final ComicDAO comicDAO;
	 private final HeroDAO heroDAO;
	 private final VillainDAO villainDAO;
	    
	    @Autowired
	    public ComicService(ComicDAO comicDAO, HeroDAO heroDAO, VillainDAO villainDAO, PublisherDAO publisherDAO) {
	        this.comicDAO = comicDAO;
	        this.heroDAO = heroDAO;
	        this.villainDAO = villainDAO;
	        this.publisherDAO = publisherDAO;
	    }
    //Method to create a publisher//
	public Publisher createPublisher(Publisher publisher) {
		return publisherDAO.save(publisher);
	}

	//Method to update a publisher.//
	public Publisher updatePublisher(Long id, Publisher publisher) {
		 Publisher existingPublisher = publisherDAO.findById(id).orElse(null);
		    if (existingPublisher == null) {
		        throw new RuntimeException("Publisher with ID " + id + " not found.");
		    }
		    publisher.setPublisherId(id);
		    return publisherDAO.save(publisher);
		}

	//Method to retrieve publisher by Id//
	public Publisher getPublisherById(Long id) {
		return publisherDAO.findById(id).orElse(null);
	}

	public List<Publisher> getAllPublishers() {
		 return publisherDAO.findAll();
	}

	//Method to delete Publisher by ID//
	@Transactional
	public boolean deletePublisherById(Long id) {
	    try {
	        publisherDAO.deleteById(id);
	        return true;
	    } catch (DataIntegrityViolationException e) {
	        // Handle foreign key constraint violation
	        return false;
	    }
	}


	 //Method to create a comic//
	 public Comic createComic(Comic comic) {
		 return comicDAO.save(comic);
	}
	 
	 //Method to create hero//
	 public Hero createHero(Hero hero) { 
	     return heroDAO.save(hero);
	    }
	 
	 //Method to create villain//
	 public Villain createVillain(Villain villain) {
		 return villainDAO.save(villain);	 
	 }
	 
	 
	
}

