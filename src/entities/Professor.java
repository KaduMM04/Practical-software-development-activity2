package entities;

public class Professor extends Pessoa{
	
	private String matricula;

	
	public Professor(String name, Integer idade, String matricula) {
		super(name, idade);
		this.matricula = matricula;
	}

	public Professor(String matricula) {
		super();
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "\nProfessor: "
				+ super.toString()
				+"\nMatricula:" + matricula;
	}
}
