package poc.event.anita.eventpoc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {

    // default custom methods using entity properties, no HQL required
    public List<Product> findAllByName(String name);
    public Optional<Product> findByPrice(double price);


    // customize required columns or rows by condition
    @Query("from Product where price>=:amount")
    public List<Product> findAllByGreaterPrice(double amount);
    @Query("Select name from Product where dom<=:dt")
    public List<String> findNamesByLeastDate(Date dt);
}
