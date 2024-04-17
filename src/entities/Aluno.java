package entities;

public class Aluno extends Pessoa{
	
	protected String rgm;

	public Aluno(String rgm) {
		super();
		this.rgm = rgm;
	}

	public Aluno(String name, Integer idade, String rgm) {
		super(name, idade);
		this.rgm = rgm;
	}

	public String getRgm() {
		return rgm;
	}

	public void setRgm(String rgm) {
		this.rgm = rgm;
	}

	@Override
	public String toString() {
		return "\nAluno: "
				+ super.toString()
				+"\nRGM:" + rgm ;
	}
}
