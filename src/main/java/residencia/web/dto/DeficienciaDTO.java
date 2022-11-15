package residencia.web.dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import residencia.web.controller.DeficienciaController;
import residencia.web.controller.PessoaFisicaController;
import residencia.web.model.Deficiencia;
import residencia.web.model.PessoaFisica;

public class DeficienciaDTO extends AbstractDTO<Deficiencia>{
	String natureza;
	String doenca;
	PessoaFisica pessoafisica;
	
		public DeficienciaDTO(){
        this.add(linkTo(DeficienciaController.class).withRel("allDeficiencia"));
    }
	@Override
	public Deficiencia convertToEntity() {
		Deficiencia e = new Deficiencia();
		e.setNatureza(this.natureza);
		e.setDoenca(this.doenca);
		e.setPessoafisica(this.pessoafisica);
		return e;
	}
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
	
	public void addLinks(Integer id) {
		this.add(linkTo(DeficienciaController.class).slash(id).withSelfRel());
	}
	

}
