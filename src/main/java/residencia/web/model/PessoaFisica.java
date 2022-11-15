package residencia.web.model;

import residencia.web.dto.AbstractDTO;
import residencia.web.dto.EnderecoDTO;
import residencia.web.dto.PessoaFisicaDTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Table(name="PESSOAFISICA")
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PessoaFisica extends AbstractEntity{
	
	String cpf;
	String name;
	Date birthday;
	@OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    Endereco endereco;

	public Date getBirthday() {
		return birthday;
	}
	@JsonFormat(pattern="dd/MM/yyyy")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public AbstractDTO<PessoaFisica> convertToDto() {
		/*if(this.getDeleted()) {
			return null;
		}*/
        PessoaFisicaDTO dto = new PessoaFisicaDTO();
        dto.setName(this.name);
        dto.setCpf(this.cpf);
        dto.setBirthday(this.birthday);
        dto.setEndereco((EnderecoDTO) this.endereco.convertToDto());
        dto.addLinks(this.getId());
        

        return dto;
    }
	public PessoaFisica() {}
	
	public PessoaFisica(String cpf, String name, Date birthday, Endereco endereco) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.birthday = birthday;
		this.endereco = endereco;
	}
	
}
