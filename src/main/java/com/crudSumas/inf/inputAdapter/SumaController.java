package com.crudSumas.inf.inputAdapter;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crudSumas.dom.Suma;
import com.crudSumas.inf.inputPort.SumaInP;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class SumaController{

    // @Autowired
    // SumaInP SumaInP;

    // @PostMapping("suma/{n1}/{n2}/{userId}")
    // public Suma setUser(
    //     @PathVariable("n1") BigInteger n1,
    //     @PathVariable("n2") BigInteger n2,
    //     @PathVariable("userId") BigInteger userId
    // ){ return this.SumaInP.createSuma(n1, n2, userId); }

    // @GetMapping("/suma")
    // public List<Suma> getSumas(){
    //     return this.SumaInP.getAll();
    // }

    // @GetMapping("/suma/{id}") //Optional<Suma>
    // public Suma getSumaById(@PathVariable("id") BigInteger id){
    //     return this.SumaInP.getById(id);
    // }

    @GetMapping("/userSumas/{userId}")
    public void getByUserId(@RequestParam("userId") BigInteger id){
        // return this.SumaInP.getByUserId(id);
    }

    // @DeleteMapping("/suma/{id}")
    // public String deleteUser(@PathVariable("id") BigInteger id){
    //     boolean ok = this.SumaInP.deleteSuma(id);
    //     if(ok){
    //         return "Se elimino la suma con id = "+id;
    //     } else {
    //         return "no se pudo eliminar la suma con id = "+id;
    //     }
    // }
}
