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

@Entity(name= "comic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comicId;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private String comicName;
    private double comicOriginalPrice;
    private double comicCurrentValue;

    @OneToMany(mappedBy = "comic", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ComicCharacters> comicCharacters;
}
