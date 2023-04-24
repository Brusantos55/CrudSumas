package com.crudSumas.inf.inputAdapter;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crudSumas.dom.Usuario;
import com.crudSumas.inf.inputPort.UsuarioInP;

@RestController
@RequestMapping("/v1")
public class UserController {
    
    // @Autowired
    // UsuarioInP usuarioInP;

    // @GetMapping("/users")
    // public List<Usuario> getUsers(){
    //     return usuarioInP.getAll();
    // }

    // @PostMapping("/user/{name}/{email}/{prio}")
    // public Usuario setUser(
    //     @PathVariable("name") String name,
    //     @PathVariable("name") String email,
    //     @PathVariable("email") Integer prio
    //     ){ return this.usuarioInP.createUser(name, email, prio); }

    @GetMapping("/user/{id}") //Optional<Usuario>?
    public void getById(@PathVariable("id") BigInteger id){
        // return this.usuarioInP.getById(id);
    }

    // @GetMapping("/query")
    // public ArrayList<Usuario> getByPrioridad(@RequestParam("prioridad") Integer prioridad){
    //     return this.usuarioInP.getByPrioridad(prioridad); // suma?prioridad=1
    // }

    // @DeleteMapping(path ="/{id}")
    // public String deleteUser(@PathVariable("id") long id){
    //     boolean ok = this.usuarioInP.deleteUser(id);
    //     if(ok){
    //         return "Se elimino el usuario con id = "+id;
    //     } else {
    //         return "no se pudo eliminar el usuario con id = "+id;
    //     }
    // }
    
}
