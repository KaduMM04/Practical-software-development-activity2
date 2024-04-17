package entities;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDePessoas {
	
	private static List<Pessoa> list = new ArrayList<>(); 
	
	public static void addPessoa(Pessoa pessoa) {
		list.add(pessoa);
	}
	
	public static List<Pessoa> allList() {
		return list;
	}
	
	public static boolean excluir(String name) {

        for (Pessoa tempP : list){
            if (tempP.getName().equals(name)) {
                list.remove(tempP);
                return true;
            }
        }

        return false;

    }
	
	public static void excluirAllList() {
		
		list.removeAll(list);
		
	}
	
	// Para criar essa função fiquei quebrando a cabeça para achar um jeito de fazer a edição com base na busca do nome da pessoa
	// Recorri ao chat para ter uma ideia de como fazer e ele mostrou essa função que faz um casting para pooder pegar os atributos das classes "Professor, aluno e bolsista"
	// Seu que essa parte é mais avança mas ja casting no curso de java que fiz, tive que relembrar um pouco mas sei esta sendo feito.
	
	public static boolean editarPessoa(String searchName, String name, Integer idade, String doc) {
		for(Pessoa p : list) {
			if (p instanceof Professor && p.getName().equals(searchName)) {
				Professor professor = (Professor) p;
				professor.setName(name);
				professor.setIdade(idade);
				return true;
			} else if (p instanceof Aluno && p.getName().equals(searchName)) {
				Aluno aluno = (Aluno) p;
				aluno.setName(name);
				aluno.setIdade(idade);
				aluno.setRgm(doc);
				return true;
			} 
		}
		
		return false;	
		
	}
	public static boolean editarPessoa(String searchName, String name, Integer idade, String doc, Double novoV) {
		for(Pessoa p : list) {
			if (p instanceof Bolsista && p.getName().equals(searchName)) {
				Bolsista bol = (Bolsista) p;
				bol.setName(name);
				bol.setIdade(idade);
				bol.setRgm(doc);
				if (novoV != null) {
					bol.setValorB(novoV);
				}
				
				return true;
			}
		}
		return false;	
	}
}	

