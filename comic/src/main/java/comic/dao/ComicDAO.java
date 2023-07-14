package comic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import comic.entity.Comic;

public interface ComicDAO extends JpaRepository<Comic, Long> {
   
}
