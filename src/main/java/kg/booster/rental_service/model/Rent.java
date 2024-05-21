package kg.booster.rental_service.model;

import jakarta.persistence.*;
import kg.booster.rental_service.model.enam.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "rent_tb")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date startData;
    Date endDate;
    double price;

    @Enumerated(EnumType.STRING)
    Status status;

    @ManyToOne
    @JoinColumn(name = "id_clints", referencedColumnName = "id")
    Client client;

    @ManyToMany
    @JoinTable(
            name = "operation_products",
            joinColumns = @JoinColumn(name = "operation_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> product;

}
