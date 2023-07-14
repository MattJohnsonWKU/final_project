package comic.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name= "hero")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long heroId;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private String heroName;
    private String heroSecretIdentity;
    private String heroPowers;

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ComicCharacters> comicCharacters;

}
