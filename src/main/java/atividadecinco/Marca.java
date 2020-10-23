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
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
public class Marca implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@OneToMany(mappedBy = "marcas")
	@JoinTable( name="modelo_marca",
	joinColumns = @JoinColumn(name="id"),
	inverseJoinColumns = @JoinColumn(name="modelo_id"))
	
	private List<Modelo> modelos;
	
	private List<Modelo> getModelos(){
		return modelos;
	}
	
	public void addModelos(Modelo m) {
		this.modelos.add(m);
		((List<Modelo>) m.getMarcas()).addAll((Collection<? extends Modelo>) this);
	}

	public void removeModelos(Modelo m) {
		this.modelos.remove(m);
		((List<Modelo>) m.getMarcas()).remove(this);
	}
	
	public Marca(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Marca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Marca other = (Marca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
