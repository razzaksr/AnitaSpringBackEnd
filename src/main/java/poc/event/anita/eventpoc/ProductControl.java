package poc.event.anita.eventpoc;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductControl {

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
