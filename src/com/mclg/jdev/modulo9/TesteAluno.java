package com.mclg.jdev.modulo9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import com.mclg.constantes.modulo9.StatusAluno;

public class TesteAluno {

	public static void main(String[] args) {
		
		//Aula 35 - Simples validação de permissão
		String login = JOptionPane.showInputDialog("Informe o login");
		String senha = JOptionPane.showInputDialog("Informe a senha");
		
		if(login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			
			List<Aluno> alunos = new ArrayList<Aluno>();
			
			//Aula 34 - é uma lista que dentro dela temos uma chave que identifica uma sequencia de valore também.
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
			
			/*Aula 33 - Criando lista de alunos aprovados, reprovados e em recuperação
			List<alunoEquals> alunosAprovados = new ArrayList<alunoEquals>();
			List<alunoEquals> alunosRecuperacao = new ArrayList<alunoEquals>();
			List<alunoEquals> alunosReprovados = new ArrayList<alunoEquals>();*/
			
			for (int qtd = 1; qtd <= 3; qtd++) {
			
				String nome = JOptionPane.showInputDialog("Qual o nome do aluno "+ qtd +" ?");
				/*
				String idade = JOptionPane.showInputDialog("Qual a sua idade?");
				String dataNascimento = JOptionPane.showInputDialog("Qual a sua data de nascimento?");
				String rg = JOptionPane.showInputDialog("Informe seu registro geral.");
				String cpf = JOptionPane.showInputDialog("Informe seu CPF:");
				String mae = JOptionPane.showInputDialog("Digite o nome da mãe:");
				String pai = JOptionPane.showInputDialog("Digite o nome do pai:");
				String matricula = JOptionPane.showInputDialog("Informe a data da matricula?");
				String escola = JOptionPane.showInputDialog("Digite o nome da escola:");
				String serie = JOptionPane.showInputDialog("Digite a série do aluno:");*/
				
				Aluno aluno = new Aluno();
				
				aluno.setNome(nome);
			
				/*
				aluno.setIdade(Integer.valueOf(idade));
				aluno.setDataNascimneto(dataNascimento);
				aluno.setRegistroGeral(rg);
				aluno.setNumeroCpf(cpf);
				aluno.setNomeMae(mae);
				aluno.setNomePai(pai);
				aluno.setDataMatricula(matricula);
				aluno.setNomeEscola(escola);
				aluno.setSerieMatriculado(serie);*/
				
				for (int pos = 1; pos <= 2; pos++) {
					
					String nomeDisciplina = JOptionPane.showInputDialog("Nome da Disciplina"+ pos+" ?");
					String notaDisciplina = JOptionPane.showInputDialog("Nota da Disciplina"+ pos+" ?");
					
					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));
					
					aluno.getDisciplina().add(disciplina);
					
				}
				
				int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
				
				if (escolha == 0) {/*Opção SIM e ZERO*/
					
					int continuarRemover = 0;
					int posicao = 1;
					
					while(continuarRemover == 0) {
						String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4?");
						aluno.getDisciplina().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
						posicao++;
						continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja continuar removendo?");
					}
				}
				
				alunos.add(aluno);
			}
				
			//Aula 34 - Separando as listas com HashMap.
			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				
			//Aula 33 - Criando lista de alunos parovados e em recuperação
			for (Aluno aluno : alunos) { //Separado em listas
				if(aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno);
						
				} else if(aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
						
				} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.REPROVADO)){
						maps.get(StatusAluno.REPROVADO).add(aluno);
				}
			}
			System.out.println();
			System.out.println("=============== Lista dos Aprovados ===============");
			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println("Resultado = " + aluno.getNome() + " está "
						+ aluno.getAlunoAprovado() +			
					" com média de = "+ aluno.getMediaNota());
			}	
			System.out.println();
			System.out.println("=============== Lista dos em Recuperação ===============");
			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println("Resultado = " + aluno.getNome() + " está em "
						+ aluno.getAlunoAprovado() +
						" com média de = "+ aluno.getMediaNota());
			}
			System.out.println();
			System.out.println("=============== Lista dos Reprovados ==============");
			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println("Resultado = " + aluno.getNome() + " está em "
						+ aluno.getAlunoAprovado() +
						" com média de = "+ aluno.getMediaNota());
			}
				
			/* Aula 30 - Percorrendo lista pelas posições.
			for (int pos = 0; pos < alunos.size(); pos++) {
				
				alunoEquals aluno = alunos.get(pos);
				
				//Aula 31 - Substituindo um aluno na lista
				if(aluno.getNome().equalsIgnoreCase("Marcelo")) {
					alunoEquals trocar = new alunoEquals();
					trocar.setNome("Aluno foi trocado");
					
					DisciplinaEquals disciplinaEquals = new DisciplinaEquals();
					disciplinaEquals.setDisciplina("Matemática");
					disciplinaEquals.setNota(96);
					
					trocar.getDisciplinas().add(disciplinaEquals);
					
					alunos.set(pos, trocar);
					aluno = alunos.get(pos);
				}
				//Aula 30 - Percorrendo lista pelas posições.
				System.out.println("Aluno = "+ aluno.getNome());
				System.out.println("Media do aluno = "+ aluno.getMediaNota());
				System.out.println("Resultado = "+ aluno.getAlunoAprovado());
				System.out.println("================================================");
				
				for (int posd = 0; posd < aluno.getDisciplinas().size(); posd++) {
					
					DisciplinaEquals disc = aluno.getDisciplinas().get(posd);
					System.out.println("Materia = " +disc.getDisciplina() + ", Nota = "+ disc.getNota());
				}
			}
			*/
			/* Aulas 28 - Procurando um aluno na lista e calculando a média.
			 * ...
			for (alunoEquals aluno : alunos) {
				
				if(aluno.getNome().equalsIgnoreCase("Marcelo")) {
					alunos.remove(aluno);
					break;
				} else {
					System.out.println(aluno.toString());//Decrição do objeto na memória.
					System.out.println("Média do aluno = "+ aluno.getMediaNota());
					System.out.println("Resultado = "+ aluno.getAlunoAprovado() );
					//System.out.println("Você removeu a disciplina: "+ aluno.getDisciplinas());
					System.out.println("=========================================================");
				}
			}
			Aulas 29 - Procurando e removendo um aluno da lista
			for (alunoEquals aluno : alunos) {
				System.out.println("Alunos que sobraram na lista!");
				System.out.println(aluno.getNome());
				System.out.println("Suas Materias são: ");
				
				for (DisciplinaEquals disciplina : aluno.getDisciplinas()) {
					System.out.println(disciplina.getDisciplina());
				}
			} */
		}
	}
}
