package residencia.web.dto;

import residencia.web.controller.PessoaFisicaController;
import residencia.web.model.Endereco;
import residencia.web.model.PessoaFisica;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PessoaFisicaDTO extends AbstractDTO<PessoaFisica> {
	
	String cpf;
	String name;
	@JsonFormat(pattern="dd/MM/yyyy")
	Date birthday;
	EnderecoDTO endereco;


	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
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

	public PessoaFisicaDTO(){
        this.add(linkTo(PessoaFisicaController.class).withRel("allPessoaFisica"));
    }
	
	public void addLinks(Integer id) {
		this.add(linkTo(PessoaFisicaController.class).slash(id).withSelfRel());
	}

    @Override
    public PessoaFisica convertToEntity() {
        PessoaFisica p = new PessoaFisica();
        p.setCpf(this.cpf);
        p.setName(this.name);
        p.setBirthday(this.birthday);
        p.setEndereco(this.endereco.convertToEntity());
        return p;
        
    }
}
