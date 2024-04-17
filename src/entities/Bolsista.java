package entities;

public class Bolsista extends Aluno{
	
	private Double valorB;
	
	
	public Bolsista(String name, Integer idade, String rgm, Double valorB) {
		super(name, idade, rgm);
		this.valorB = valorB;
	}
	
	public Double getValorB() {
		return valorB;
	}


	public void setValorB(Double valorB) {
		this.valorB = valorB;
	}

	@Override
	public String toString() {
		return "\nBolsista: "
				+ "\nName: " + name
				+ "\nIdade: " + idade
				+ "\nRGM: " + rgm
				+ "\nvalor da bolsa: " + String.format("%.2f", valorB);
	}
}
