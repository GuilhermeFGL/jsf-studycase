package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.PessoaFisica;

@ManagedBean
@SessionScoped
public class PessoaBean {

	private PessoaFisica pessoaSelecionada;
	private List<PessoaFisica> pessoas;

	public PessoaBean() {
		pessoaSelecionada = new PessoaFisica();
		pessoas = new ArrayList<PessoaFisica>();
	}

	public void salvar() {
		if (!pessoas.contains(pessoaSelecionada)) {
			pessoas.add(pessoaSelecionada);
		}
		pessoaSelecionada = new PessoaFisica();
	}

	public void excluir() {
		pessoas.remove(pessoaSelecionada);
		pessoaSelecionada = new PessoaFisica();
	}

	public PessoaFisica getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(PessoaFisica pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public List<PessoaFisica> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaFisica> pessoas) {
		this.pessoas = pessoas;
	}

}
