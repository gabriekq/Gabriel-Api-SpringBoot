package api.gabriel.spring.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import api.gabriel.spring.dao.DaoImpleDB;
import api.gabriel.spring.modelo.Pessoa;


@Service
public class PessoaService {

@Autowired	
private DaoImpleDB dao;
	
	

public void insert(Pessoa pessoa){
		
	dao.getTemplete().save(pessoa);		
}

	
public List<Pessoa> getPessoas(){
	
return (List<Pessoa>)	dao.getTemplete().findAll(Pessoa.class);	
}	
	



	
	
	// metodos dao
	
	public DaoImpleDB getDao() {
		return dao;
	}

	public void setDao(DaoImpleDB dao) {
		this.dao = dao;
	}


	public void addPessoa(Pessoa pessoa) {
		dao.getTemplete().save(pessoa);
		
	}


	public Pessoa getOne(int id) {
	 Pessoa ObjPessoa;
		// dao.getTemplete()).update(pessoa);
	//	Update update = new Update();
		Query query = new Query(Criteria.where("idPessoa").is(id) );
        ObjPessoa  =  dao.getTemplete().findOne(query, Pessoa.class, "pessoas");
         
        
		return ObjPessoa;
	}

	
	public void updatePessoa(Pessoa pessoa){
		
		
		Pessoa pessoaNova;
	
	    pessoaNova = getOne(pessoa.getIdPessoa());
		pessoaNova.setIdade(pessoa.getIdade());
		pessoaNova.setNome(pessoa.getNome());
		dao.getTemplete().save(pessoaNova);
		
		
		
	}


	public void deletePessoa(int idPessoa) {	
	dao.getTemplete().remove(getOne(idPessoa));
	}
	

}
