package comic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import comic.entity.Publisher;

public interface PublisherDAO extends JpaRepository<Publisher, Long> {

}
