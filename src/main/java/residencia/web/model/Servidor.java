package residencia.web.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import residencia.web.dto.AbstractDTO;
import residencia.web.dto.ServidorDTO;

@Entity
@Table(name="SERVIDOR")
@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Servidor extends PessoaFisica{
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


	public AbstractDTO convertToDto() {
		ServidorDTO dto = new ServidorDTO();
        dto.setName(this.name);
        dto.setCpf(this.cpf);
        dto.setBirthday(this.birthday);
        dto.setEndereco(this.endereco.convertToDto());
        dto.setAdmissao(this.admissao);
        dto.setCargo(this.cargo);
        dto.setSalario(salario);
        dto.addLinks(this.getId());
        

        return dto;
	}


	public Servidor(double salario, String cargo, Date admissao) {
		super();
		this.salario = salario;
		this.cargo = cargo;
		this.admissao = admissao;
	}


	public Servidor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Servidor(String cpf, String name, Date birthday, Endereco endereco) {
		super(cpf, name, birthday, endereco);
		// TODO Auto-generated constructor stub
	}
	
	

}
