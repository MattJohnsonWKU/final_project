package comic.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import comic.entity.Hero;

public interface HeroDAO extends JpaRepository<Hero, Long> {
   
}