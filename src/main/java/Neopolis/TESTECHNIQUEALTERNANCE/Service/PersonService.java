package Neopolis.TESTECHNIQUEALTERNANCE.Service;

import Neopolis.TESTECHNIQUEALTERNANCE.messages.mailvalidation;
import org.springframework.stereotype.Service;

import Neopolis.TESTECHNIQUEALTERNANCE.Entity.person;
import Neopolis.TESTECHNIQUEALTERNANCE.Repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personrepository;
	
	public ResponseEntity<?> AddPerson(person p){
        return new ResponseEntity<>(personrepository.save(p), HttpStatus.OK);
    }
	
	 public ResponseEntity<?> UpdatePerson(person p,Long id){
	        if(!personrepository.findById(id).isPresent()){
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        else{
	            person p1=personrepository.findById(id).get();

	            p1.setNom(p.getNom());

	            p1.setPrenom(p.getPrenom());

	            p1.setAddress(p.getAddress());

	            p1.setCivilite(p.getCivilite());

	            p1.setVille(p.getVille());

	            p1.setCode_postal(p.getCode_postal());

	            p1.setCommentaire(p.getCommentaire());

	            p1.setComplement_address(p.getComplement_address());

	            p1.setNumero_Rue(p.getNumero_Rue());

	            p1.setNombre_enfont(p.getNombre_enfont());

	            p1.setDatenaiss(p.getDatenaiss());

	            p1.setEmail(p.getEmail());

	            p1.setNumero_tel1(p.getNumero_tel1());

	            p1.setNumero_tel2(p.getNumero_tel2());

	            p1.setMobile(p.getMobile());

	            p1.setMot_cle(p.getMot_cle());

	            p1.setSituation_Familial(p.getSituation_Familial());

	            p1.setRue(p.getRue());

				p1.setPays(p.getPays());

				p1.setRelation(p.getRelation());

	            return new ResponseEntity<>(personrepository.save(p1),HttpStatus.OK);
	        }
	    }

	public ResponseEntity<?> GetPerson(Long id){
		if(!personrepository.findById(id).isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<>(personrepository.findById(id),HttpStatus.OK);
		}
	}

	public ResponseEntity<?> ExisteByMail(String Email){
		mailvalidation v=new mailvalidation(personrepository.existsByEmail(Email));
		return new ResponseEntity<>(v,HttpStatus.OK);
	}

	public ResponseEntity<?> DeletePerson(Long id){
		if(!personrepository.findById(id).isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else{
			personrepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	public ResponseEntity<?> GetAll(){
		if(personrepository.findAll().isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else{
			return new ResponseEntity<>(personrepository.findAll(),HttpStatus.OK);
		}
	}

}
