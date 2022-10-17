package poc.event.anita.eventpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<String> makeReadByLeastDate(Date dt){
        return repo.findNamesByLeastDate(dt);
    }

    public List<Product> makeReadByLotAmount(double user){
        return repo.findAllByGreaterPrice(user);
    }

    public Optional<Product> makeReadByCost(double p){
        return repo.findByPrice(p);
    }

    public List<Product> makeReadByName(String nm){
        return repo.findAllByName(nm);
    }

    public Optional<Product> makeRead(int pkey){
        return repo.findById(pkey);
    }

    public List<Product> makeList(){
        return (List<Product>)repo.findAll();
    }

    public Product makeInsert(Product pro){
        return repo.save(pro);
    }

}
