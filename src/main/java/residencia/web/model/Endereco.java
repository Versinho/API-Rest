package residencia.web.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import residencia.web.dto.AbstractDTO;
import residencia.web.dto.EnderecoDTO;

@Entity
@Table(name="ENDERECO")
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Endereco extends AbstractEntity{
	
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



	public AbstractDTO convertToDto() {
		EnderecoDTO dto = new EnderecoDTO();
		dto.setUF(this.UF);
		dto.setCidade(this.cidade);
		dto.setCep(this.cep);
		dto.setRua(this.rua);
		dto.setNumero(this.numero);
		dto.setComplemento(this.complemento);
		dto.addLinks(this.getId());
        

        return dto;
	}

}
