package residencia.web.dto;

import residencia.web.controller.PessoaJuridicaController;
import residencia.web.model.PessoaFisica;
import residencia.web.model.PessoaJuridica;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaJuridicaDTO extends AbstractDTO<PessoaJuridica> {
	
	String cnpj;
	String nome;
	List<PessoaFisicaDTO> associados;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PessoaFisicaDTO> getAssociados() {
		return associados;
	}

	public void setAssociados(List<PessoaFisicaDTO> list) {
		this.associados = list;
	}

	public PessoaJuridicaDTO(){
        this.add(linkTo(PessoaJuridicaController.class).withRel("allPessoaJuridica"));
    }

    @Override
    public PessoaJuridica convertToEntity() {
        PessoaJuridica p = new PessoaJuridica();
        p.setCnpj(this.cnpj);
        p.setNome(this.nome);
        p.setAssociados(this.associados.stream().map(dto -> (PessoaFisica) dto.convertToEntity()).collect(Collectors.toList()));
        return p;
        
    }
    
    public void addLinks(Integer id) {
		this.add(linkTo(PessoaJuridicaController.class).slash(id).withSelfRel());
	}
}
