package api.gabriel.spring.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="pessoas")
public class Pessoa {

@Id
private String id;
private int idPessoa;
private	int idade;
private String nome;





public Pessoa(int idPessoa, int idade, String nome) {
	super();
	this.idPessoa = idPessoa;
	this.idade = idade;
	this.nome = nome;
}



public Pessoa() {
	super();
}



public int getIdPessoa() {
	return idPessoa;
}



public void setIdPessoa(int idPessoa) {
	this.idPessoa = idPessoa;
}






public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public int getIdade() {
	return idade;
}


public void setIdade(int idade) {
	this.idade = idade;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}

	
}
