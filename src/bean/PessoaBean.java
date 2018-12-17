package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;
import modelo.Sexo;

@ManagedBean
@SessionScoped
public class PessoaBean {

	private Pessoa pessoaSelecionada;
	private List<Pessoa> pessoas;
	private String tipoPessoa;

	public PessoaBean() {
		pessoaSelecionada = null;
		pessoas = new ArrayList<Pessoa>();
	}

	public void criar() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (tipoPessoa == null) {
			context.addMessage("tipoPessoa",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Tipo de pessoa deve ser especificado", null));
			return;
		}

		if (tipoPessoa.equals("PF")) {
			pessoaSelecionada = new PessoaFisica();
		} else if (tipoPessoa.equals("PJ")) {
			pessoaSelecionada = new PessoaJuridica();
		}
		tipoPessoa = null;
	}

	public void salvar() {
		if (!pessoas.contains(pessoaSelecionada)) {
			pessoas.add(pessoaSelecionada);
		}
		pessoaSelecionada = null;
		tipoPessoa = null;
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa editada", null));
	}

	public void excluir() {
		pessoas.remove(pessoaSelecionada);
		pessoaSelecionada = null;
		tipoPessoa = null;
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro cancelado", null));
	}

	public String cancelar() {
		pessoaSelecionada = null;
		tipoPessoa = null;
		return "index.jsf";
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public boolean isPessoaFisica() {
		return pessoaSelecionada instanceof PessoaFisica;
	}

	public boolean isPessoaJuridica() {
		return pessoaSelecionada instanceof PessoaJuridica;
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}

}
