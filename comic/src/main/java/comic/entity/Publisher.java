package comic.entity;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "publisher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    private String publisherName;
    private String publisherStreet;
    private String publisherState;
    private String publisherZip;
    private String publisherPhone;
    private String publisherEmail;

    @OneToMany(mappedBy = "publisher", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    private Set<Comic> comics;
}
