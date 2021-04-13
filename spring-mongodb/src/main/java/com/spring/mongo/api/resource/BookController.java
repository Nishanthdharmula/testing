package com.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.api.SequenceGeneratorService;
import com.spring.mongo.api.model.Book;
import com.spring.mongo.api.repository.BookRepository;


@RestController
@RequestMapping("/dept")
public class BookController {

	@Autowired
	BookRepository repository;
	
	@Autowired
	private SequenceGeneratorService service; 
	
	@Autowired
	MongoOperations mongo; 

	@PostMapping("/addManager")
	public String saveBook(@RequestBody Book book) {
		
		book.setId(service.getSequenceNum(Book.sequenceName));
		repository.save(book);
		return "Added manager with id: "+book.getId(); 
	}

	@RequestMapping("/findAll")
	public List<Book> getBooks(){
		return repository.findAll();
	}

	@RequestMapping("/findManager/{id}")
	public Optional<Book> getBook(@RequestParam("id") int k){
		return repository.findById(k);
	}


	@RequestMapping("/update/departmentName")
	public String updateDepartmentName(@RequestParam("id") int id, @RequestParam("depName") String name, @RequestParam("managerName") String mname) {

		Query query= new Query();
		Update update=new Update();

		query.addCriteria(Criteria.where("id").is(id));

		update.set("depName", name);

		mongo.updateFirst(query, update, Book.class);
		return "DepName updated successfully";

	}
}	  