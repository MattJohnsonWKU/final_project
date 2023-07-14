package comic.controller.model;

import comic.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherData {
    private String publisherName;
    private String publisherStreet;
    private String publisherState;
    private String publisherZip;
    private String publisherPhone;
    private String publisherEmail;

    public PublisherData(Publisher publisher) {
        this.publisherName = publisher.getPublisherName();
        this.publisherStreet = publisher.getPublisherStreet();
        this.publisherState = publisher.getPublisherState();
        this.publisherZip = publisher.getPublisherZip();
        this.publisherPhone = publisher.getPublisherPhone();
        this.publisherEmail = publisher.getPublisherEmail();
    }


}
