package com.dev.delta.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.delta.pharmalife.entities.Type;
import com.dev.delta.pharmalife.services.TypeService;

@RestController
@RequestMapping("/pharmalife/type")
@CrossOrigin
public class TypeController {
	@Autowired
	TypeService typeService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Type projectType, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Type newPT = typeService.saveOrUpdate(projectType);

	        return new ResponseEntity<Type>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Type> getAllTypes()
   {
	   return typeService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Type> getTypeById(@PathVariable Long id)
   {
	   Type type=typeService.findById(id);
	   return new ResponseEntity<Type>(type,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteType(@PathVariable Long id)
   {
	   typeService.delete(id);
	   return new ResponseEntity<String>("type was deleted",HttpStatus.OK);
   }
}
