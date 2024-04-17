package entities;

import java.util.Objects;

public abstract class Pessoa {
	
	protected String name;
	protected Integer idade;
	
	public Pessoa() {
	}

	public Pessoa(String name, Integer idade) {
		super();
		this.name = name;
		this.idade = idade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idade, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(idade, other.idade) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "\nName: " + name 
				+ "\nIdade: " + idade;
	}
}
