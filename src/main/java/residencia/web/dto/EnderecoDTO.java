package residencia.web.dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import lombok.AllArgsConstructor;
import residencia.web.controller.EnderecoController;
import residencia.web.model.Endereco;

@AllArgsConstructor
public class EnderecoDTO extends AbstractDTO<Endereco>{
	
	String UF;
	
	String cidade;
	
	String cep;
	
	String rua;
	
	Integer numero;
	String complemento;
	
	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public EnderecoDTO(){
        this.add(linkTo(EnderecoController.class).withRel("allEndereco"));
    }
	@Override
	public Endereco convertToEntity() {
		Endereco e = new Endereco();
		e.setUF(this.UF);
		e.setCidade(this.cidade);
		e.setCep(this.cep);
		e.setRua(this.rua);
		e.setNumero(this.numero);
		e.setComplemento(this.complemento);
		return e;
	}
	
	public void addLinks(Integer id) {
		this.add(linkTo(EnderecoController.class).slash(id).withSelfRel());
	}

}
