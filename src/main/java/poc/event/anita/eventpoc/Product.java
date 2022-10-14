package poc.event.anita.eventpoc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int pid;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_cost")
    private double price;
    @Column(name = "product_date_of_manufactured")
    private Date dom;
}
