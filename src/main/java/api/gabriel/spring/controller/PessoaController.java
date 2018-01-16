package api.gabriel.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoClient;

import api.gabriel.spring.dao.DaoImpleDB;
import api.gabriel.spring.modelo.Pessoa;
import api.gabriel.spring.servico.PessoaService;

@RestController
public class PessoaController {

//@Autowired
//private PessoaService servico;	
@Autowired
private PessoaService service ;	
	
	
@RequestMapping("/pessoas")	
public List<Pessoa> getAllPessoas(){
	
	return  service.getPessoas();
}


@RequestMapping(method=RequestMethod.POST,value="/addpessoa")
public void addPessoa(@RequestBody Pessoa pessoa){
	
	service.addPessoa(pessoa);
	
}

//get busca
@RequestMapping(value="/pessoas/{id}")
public Pessoa buscaPessoa(@PathVariable int id){
	
return	  service.getOne(id);
	
}

@RequestMapping(method=RequestMethod.PUT,value="/update")
public void updatePessoa(@RequestBody Pessoa pessoa){
	
	service.updatePessoa(pessoa);
}


@RequestMapping(method=RequestMethod.DELETE,value="/delete/{id}")
public void deletePessoa(@PathVariable int id){
	
	service.deletePessoa(id);
}



public PessoaService getService() {
	return service;
}


public void setService(PessoaService service) {
	this.service = service;
}

}
