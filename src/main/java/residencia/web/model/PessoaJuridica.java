package residencia.web.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import residencia.web.dto.AbstractDTO;
import residencia.web.dto.PessoaFisicaDTO;
import residencia.web.dto.PessoaJuridicaDTO;

@Entity
@Table(name="PESSOAJURIDICA")
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PessoaJuridica extends AbstractEntity{
	
	String cnpj;
	String nome;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "pessoajuridica_associados",
            joinColumns = @JoinColumn(name = "pessoajuridica_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pessoafisica_id")
    )
    List<PessoaFisica> associados;
	
	
	public AbstractDTO convertToDto() {
		PessoaJuridicaDTO dto = new PessoaJuridicaDTO();
        dto.setCnpj(this.cnpj);
        dto.setNome(this.nome);
        dto.setAssociados(this.associados.stream().map(entity -> (PessoaFisicaDTO) entity.convertToDto()).collect(Collectors.toList()));
        dto.addLinks(this.getId());

        return dto;
	}


	public List<PessoaFisica> getAssociados() {
		return associados;
	}


	public void setAssociados(List<PessoaFisica> associados) {
		this.associados = associados;
	}


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

}
