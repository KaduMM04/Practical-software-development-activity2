package view;

import java.util.Scanner;

import entities.Aluno;
import entities.Bolsista;
import entities.GerenciadorDePessoas;
import entities.Pessoa;
import entities.Professor;

public class MenuCadastro {
	
    public static Scanner sc = new Scanner(System.in);

	private static void exibirMenu() {
		
		System.out.println("\nCadastro de alunos e Professores!!");
		System.out.println("1) Cadastrar Aluno ou professor");
		System.out.println("2) Buscar pessoa pelo nome");
		System.out.println("3) Exibir todos os cadastrados");
		System.out.println("4) Editar dados de pessoa cadastrados");
		System.out.println("5) Excluir pessoa cadastrada");
		System.out.println("6) Excluir todas as pessoa cadastrados");
		System.out.println("0) Finalizar ");
		
	}
	
	private static void verificarOp(int op) {
		
		boolean find = false;
		String txt = "";
		String searchName = "";
		
		switch(op) {
		
			case 1:
					
				System.out.print("\nDigite (p) para professor e (a) para aluno: ");
				char f = sc.next().charAt(0);
				sc.nextLine();
				System.out.print("\nDigite o nome: ");
				String name = sc.nextLine();
				System.out.print("Digite a idade: ");
				int idade = sc.nextInt();
				sc.nextLine();
					
				if (f == 'p') {
					
					System.out.print("Digite o numero de matricula: ");
					String num = sc.nextLine();
					Professor prof = new Professor(name, idade , num);
					GerenciadorDePessoas.addPessoa(prof);
					System.out.println("\nProfessor cadastrado com sucesso!!");
						
				} else if (f == 'a') {
						
					System.out.print("Digite o numero do RGM: ");
					String rgm = sc.nextLine();
					System.out.print("O aluno é bolsista se sim digite (s) se não digite(n): ");
					char b = sc.next().charAt(0);
					sc.nextLine();
						
						
					if (b == 's') {
						
						System.out.print("Digite o valor da bolsa: ");
						double v = sc.nextDouble();
						Bolsista bolsista = new Bolsista(name, idade, rgm, v);
						GerenciadorDePessoas.addPessoa(bolsista);
						System.out.println("\nAluno bolsista cadastrado com sucesso!!");
							
					} else {
							
						Aluno aluno = new Aluno(name, idade, rgm);
						GerenciadorDePessoas.addPessoa(aluno);
						System.out.println("\nAluno cadastrado com sucesso!!");
							
					   }
					}
	
					break;
					
				case 2:
					
					System.out.print("\nDigite um nome para pesquisar: ");
					searchName = sc.nextLine();
			
					
					for(Pessoa p : GerenciadorDePessoas.allList()) {
						if(p.getName().equals(searchName)) {
							txt += p.toString();
							 find = true;
						} 
					}
					if (find) {
						
						System.out.println(txt);
						
					} else { 
						
						System.out.println( "\nPessoa nâo encontrada...");
						
					}
		
					break;
					
				case 3:
					
					if (GerenciadorDePessoas.allList().size() == 0) {
						System.out.println("\nNão há pessoas cadastradas..");
						break;
					}
					
					System.out.println("\nTodas as pessoas cadastradas: ");
					for (Pessoa tempP : GerenciadorDePessoas.allList()) {
						System.out.println(tempP);
					}
					
					break;
					
				case 4:
					
					System.out.print("\nDigite um nome para pesquisar: ");
					searchName = sc.nextLine();
					
					Pessoa findP = null;

					for (Pessoa tempP : GerenciadorDePessoas.allList()) {
						if (tempP.getName().equals(searchName)) {
							findP = tempP;
						}
					}
					
					if(findP != null) {
						
						System.out.println("\nPessoa encontrada!!");

						System.out.println("\nDigite os novos dados de " + searchName);

						System.out.print("\nNovo nome: ");
						String novoNome = sc.nextLine();

						System.out.print("Nova idade: ");
						int novaIdade = sc.nextInt();
						sc.nextLine();

						System.out.print("Novo documento(matrícula ou RGM): ");
						String doc = sc.nextLine();

						if (findP instanceof Bolsista) {
							System.out.print("Digite o valor da bolsa: ");
							double novoV = sc.nextDouble();
							sc.nextLine();
							GerenciadorDePessoas.editarPessoa(searchName, novoNome, novaIdade, doc, novoV);
						} else {
							GerenciadorDePessoas.editarPessoa(searchName, novoNome, novaIdade, doc);
						}
						
						System.out.println("\nDados de " + novoNome + " atualizados");
						
					} else {
						System.out.println("\nPessoa não encontrada!!");
					}
					
					break;
					
				case 5:
					
					System.out.print("\nDigite um nome para pesquisar: ");
				    searchName = sc.nextLine();
					
					if(GerenciadorDePessoas.excluir(searchName)) {
						
						System.out.println("\nPessoa foi removida com sucesso!!");
						
					} else {
						
						System.out.println("\nPessoa " + searchName + " foi removida com sucesso!!");
						
					}
					
					break;
					
				case 6:
					
					GerenciadorDePessoas.excluirAllList();
					
					System.out.println("\nTodas as pessoas foram removidas com sucesso!!");
					
					break;
					
				case 0:
					
					System.out.println("\nPrograma finalizado!!");
					
					break;
					
				default:
					
					System.out.println("\nNumero foi digitado errado!!");
					
					break;
		}
		
		System.out.println();
		
	}
	
	public static void executar() {
		
		int op;
		
		do {
			
			exibirMenu();
			op = sc.nextInt();
			sc.nextLine();
			verificarOp(op);
			
		} while (op != 0);
		
	}
}
