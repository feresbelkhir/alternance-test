package Neopolis.TESTECHNIQUEALTERNANCE.Controller;

import Neopolis.TESTECHNIQUEALTERNANCE.Entity.person;
import Neopolis.TESTECHNIQUEALTERNANCE.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/person")
public class personController {

    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<?> addperson(@Validated @RequestBody person p) {

        return personService.AddPerson(p);
    }

    @GetMapping("/showall")
    public ResponseEntity<?> showperson() {
        return personService.GetAll();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateperson(@Validated @RequestBody person p, @PathVariable(value = "id") Long id) {
        return personService.UpdatePerson(p,id);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getperson(@PathVariable(value = "id") Long id) {
        return personService.GetPerson(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteperson(@PathVariable(value = "id") Long id) {
        return personService.DeletePerson(id);
    }

    @GetMapping(value = "/existbymail/{email}")
    public ResponseEntity<?> existbymail(@PathVariable(value = "email") String email){
        return personService.ExisteByMail(email);
    }
}
