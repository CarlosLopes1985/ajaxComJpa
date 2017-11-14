package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private   Integer idCliente;
	@Column(length=50)
	private   String   nome;
	@Column(unique=true,length=50)
	private   String   email;
	@Temporal(TemporalType.DATE)
	private   Date  dataNascimento;
	
	
	public Cliente() {
	 
	}
	
	
	
	public Cliente(Integer idCliente, String nome, String email, Date dataNascimento) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}


	

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", dataNascimento="
				+ dataNascimento + "]";
	}



	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	
}
