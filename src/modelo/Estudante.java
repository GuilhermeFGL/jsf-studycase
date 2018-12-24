package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.sun.istack.internal.NotNull;

@Entity
public class Estudante implements Serializable {

	private static final long serialVersionUID = -5672552369471183952L;

	@Id
	@GeneratedValue(generator = "estudante_seq")
	@SequenceGenerator(sequenceName = "estudante_id_seq", name = "estudante_seq")
	private Long id;

	@NotNull
	private String nome;

	private String sobrenome;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
