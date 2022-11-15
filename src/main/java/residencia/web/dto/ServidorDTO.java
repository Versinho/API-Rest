package residencia.web.dto;

import residencia.web.controller.ServidorController;
import residencia.web.controller.ServidorController;
import residencia.web.model.Endereco;
import residencia.web.model.Servidor;
import residencia.web.model.Servidor;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServidorDTO extends AbstractDTO<Servidor> {

	String cpf;
	String name;
	@JsonFormat(pattern="dd/MM/yyyy")
	Date birthday;
	EnderecoDTO endereco;
	double salario;
	String cargo;
	@JsonFormat(pattern="dd/MM/yyyy")
	Date admissao;
	
	


	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(AbstractDTO endereco) {
		this.endereco = (EnderecoDTO) endereco;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ServidorDTO(){
        this.add(linkTo(ServidorController.class).withRel("allServidor"));
    }
	
	public void addLinks(Integer id) {
		this.add(linkTo(ServidorController.class).slash(id).withSelfRel());
	}

    @Override
    public Servidor convertToEntity() {
        Servidor p = new Servidor();
        p.setCpf(this.cpf);
        p.setName(this.name);
        p.setBirthday(this.birthday);
        p.setAdmissao(this.admissao);
        p.setCargo(this.cargo);
        p.setSalario(this.salario);
        p.setEndereco(this.endereco.convertToEntity());
        return p;
        
    }

    
}
