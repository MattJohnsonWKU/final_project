package comic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name= "comic_characters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComicCharacters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comicCharactersId;

    @ManyToOne
    @JoinColumn(name = "comic_id")
    private Comic comic;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;

    @ManyToOne
    @JoinColumn(name = "villain_id")
    private Villain villain;
}
