package residencia.web.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import residencia.web.dto.AbstractDTO;
import residencia.web.dto.DeficienciaDTO;

@Entity
@Table(name="DEFICIENCIA")
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Deficiencia extends AbstractEntity{
	String natureza;
	String doenca;
	
	@ManyToOne
    @JoinColumn(name = "pessoafisica_id")
    PessoaFisica pessoafisica;
	
	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}
	

	public PessoaFisica getPessoafisica() {
		return pessoafisica;
	}

	public void setPessoafisica(PessoaFisica pessoafisica) {
		this.pessoafisica = pessoafisica;
	}

	public AbstractDTO convertToDto() {
		DeficienciaDTO dto = new DeficienciaDTO();
        dto.setNatureza(this.natureza);
        dto.setDoenca(this.doenca);
        dto.setPessoafisica(this.pessoafisica);
        dto.addLinks(this.getId());
        return dto;
	}

}
