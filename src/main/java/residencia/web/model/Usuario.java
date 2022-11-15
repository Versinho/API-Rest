package residencia.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import residencia.web.dto.AbstractDTO;

@Entity
@Table(name="USUARIO")
@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Usuario extends AbstractEntity{
	
	@Column(unique=true)
	String username;
    String password;
    String role;
	@Override
	public AbstractDTO convertToDto() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Usuario(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Usuario() {}
	

}
