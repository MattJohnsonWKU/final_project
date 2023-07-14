package comic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import comic.entity.ComicCharacters;

public interface ComicCharacterDAO extends JpaRepository<ComicCharacters, Long> {
    
}
