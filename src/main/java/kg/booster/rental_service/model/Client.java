package kg.booster.rental_service.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@Table(name = "clients")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String surname;
    String name;
    String patronymic;
    String address;

    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    Document document;


}
