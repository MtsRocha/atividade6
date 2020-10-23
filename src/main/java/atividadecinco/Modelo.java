package atividadecinco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Modelo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer modelo_id;
	
	private String descricao;
	private Integer potencia;
	
	@OneToMany(mappedBy = "modelos")
	@JoinTable( name="automovel_modelo",
	joinColumns = @JoinColumn(name="modelo_id"),
	inverseJoinColumns = @JoinColumn(name="id"))
	
	private List<Automovel> automoveis;
	
	private List<Automovel> getAutomoveis(){
		return automoveis;
	}
	
	public void addAutomovel(Automovel a) {
		this.automoveis.add(a);
		((List<Automovel>) a.getModelos()).add(a);
	}

	public void removeAutomovel(Automovel a) {
		this.automoveis.remove(a);
		((List<Automovel>) a.getModelos()).remove(this);
	}
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	
	private Marca marcas;
	
	public Marca getMarcas() {
		return marcas;
	}

	public void setMarcas(Marca marcas) {
		this.marcas = marcas;
	}

	public Modelo(Integer modelo_id, String descricao, Integer potencia) {
		super();
		this.modelo_id = modelo_id;
		this.descricao = descricao;
		this.potencia = potencia;
	}

	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return modelo_id;
	}

	public void setId(Integer id) {
		this.modelo_id = modelo_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((modelo_id == null) ? 0 : modelo_id.hashCode());
		result = prime * result + ((potencia == null) ? 0 : potencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (modelo_id == null) {
			if (other.modelo_id != null)
				return false;
		} else if (!modelo_id.equals(other.modelo_id))
			return false;
		if (potencia == null) {
			if (other.potencia != null)
				return false;
		} else if (!potencia.equals(other.potencia))
			return false;
		return true;
	}

	
}
