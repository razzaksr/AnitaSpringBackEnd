package poc.event.anita.eventpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductControl {

    @Autowired
    ProductService service;

    @DeleteMapping("/delby/{dt}")
    public List<String> callDeleteMore(@PathVariable("dt") String dt) throws ParseException {
        Date d=new SimpleDateFormat("yyyy-MM-dd").parse(dt);
        return service.makeDeleteMultiple(d);
    }

    @DeleteMapping("/del/{num}")
    public String callDeleteId(@PathVariable("num") int num){
        return service.makeDeleteById(num);
    }

    @PutMapping("/upby/{cost}")
    public void callUpdateByCost(@PathVariable("cost") double cost){
        service.makeUpdateByCost(cost);
    }

    @PutMapping("/up")
    public Product callUpdate(@RequestBody Product product){
        return service.makeInsert(product);
    }

    @GetMapping("/small/{dt}")
    public List<String> callReadByLeastDate(@PathVariable("dt") String dt) throws ParseException {
        Date d=new SimpleDateFormat("yyyy-MM-dd").parse(dt);
        System.out.println(d.toLocaleString());
        return service.makeReadByLeastDate(d);
    }

    @GetMapping("/amt/{data}")
    public List<Product> callReadByLot(@PathVariable("data") double data){
        return service.makeReadByLotAmount(data);
    }

    @GetMapping("/cost/{data}")
    public Optional<Product> callReadByCost(@PathVariable("data") double data){
        return service.makeReadByCost(data);
    }

    @GetMapping("/name/{match}")
    public List<Product> callReadByName(@PathVariable("match") String match){
        return service.makeReadByName(match);
    }

    @GetMapping("/{one}")
    public Optional<Product> callRead(@PathVariable("one") int one){
        return service.makeRead(one);
    }

    @GetMapping("/")
    public List<Product> callList(){
        return service.makeList();
    }

    @PostMapping("/ins")
    public Product callInsert(@RequestBody Product product){
        return service.makeInsert(product);
    }

    @GetMapping("/hi")
    public void callSimple(){
        System.out.println("Simple Rest call happened");
    }

    @GetMapping("/hello")
    public String callContent(){
        return "Simple Content display";
    }

    @GetMapping("/hey/{data1}/{data2}/{data3}")
    public int callPaths(@PathVariable("data1") int data1,@PathVariable("data2") int data2,@PathVariable("data3") int data3){
        return data1*data2*data3;
    }

    @PostMapping("/passing")
    public String callParams(@RequestParam("myname") String myname,@RequestParam("myctc") double myctc,@RequestParam("myexp") int myexp){
        if(myexp>=5){
            myctc+=(myctc*5)/100;
        }
        return myname+" "+myexp+" "+myctc;
    }

    @PostMapping("/secure")
    public String callBody(@RequestBody Anita anita){
        return "Value is "+(anita.getHai()*anita.getHey());
    }
}
