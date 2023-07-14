package comic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import comic.entity.Villain;

public interface VillainDAO extends JpaRepository<Villain, Long> {
    
}
