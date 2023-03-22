package com.ems.employeeManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*; 
//
//import java.util.HashMap;
//import java.util.Map;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

}

@RestController
class EmployeeController {
	
   HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
   
   @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
   public ResponseEntity<Object> getEmployee(@RequestParam("id") int id) {
	  String name = map.get(id);
	  if(name==null) {
		  System.out.println(map);
		  return new ResponseEntity<>("Employee doesn't exists - " + id + ", " + name, HttpStatus.CREATED);
	   }
	  System.out.println(map);
      return new ResponseEntity<>("Employee Details - " + id + ", " + name, HttpStatus.CREATED);
   }
   
   @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
   public ResponseEntity<Object> createEmployee(@RequestParam("id") int id, @RequestParam("name") String name) {   
	   if(map.get(id)==null) {
		   map.put(id,name);  //Put elements in Map 
		   System.out.println(map);
		   return new ResponseEntity<>("Employee created successfully - " + id + ", " + name, HttpStatus.CREATED);
	   }
	   System.out.println(map);
	   return new ResponseEntity<>("Employee already exists - " + id + ", " + name, HttpStatus.CREATED);   
   }
   
   @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateEmployee(@RequestParam("id") int id, @RequestParam("name") String name) {
	   if(map.get(id)==null) {
		   System.out.println(map);
		   return new ResponseEntity<>("Employee doesn't exists - " + id + ", " + name, HttpStatus.CREATED);
	   }
	   map.put(id,name);  //Put elements in Map 
	   System.out.println(map);
	   return new ResponseEntity<>("Employee updated successfully - " + id + ", " + name, HttpStatus.CREATED);
   }
   
   @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
   public ResponseEntity<Object> deleteEmployee(@RequestParam("id") int id) {
	   String name = map.get(id);
	   if(name==null) {
		   System.out.println(map);
		   return new ResponseEntity<>("Employee doesn't exists - " + id + ", " + name, HttpStatus.CREATED);
	   }
	   
	   map.remove(id);  //Put elements in Map 
	   System.out.println(map);
	   return new ResponseEntity<>("Employee deleted successfully - " + id + ", " + name, HttpStatus.CREATED);
   }
   
   
}
