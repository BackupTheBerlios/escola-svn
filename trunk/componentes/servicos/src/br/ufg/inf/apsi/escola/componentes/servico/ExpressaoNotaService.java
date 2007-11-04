package src.br.ufg.inf.apsi.escola.componentes.servico;

import gnu.jel.CompilationException;
import gnu.jel.CompiledExpression;
import gnu.jel.Evaluator;
import gnu.jel.Library;

/**
 * Classe de servi�o do Escola 1.0 cuja finalidade � validar uma expressao,
 * ela retornar� true ou uma exce��o dependendo da an�lise da express�o.
 * @author Gerson Rodrigues
 * @version 1.0
 *
 */
public class ExpressaoNotaService {

	/**
	 * M�todo que valida a express�o passada como parametro. 
	 * Observa��es:
	 * 1- Neste m�todo � verificado se a express�o � nula ou em branco, 
	 * caso seja, uma exce��o ser� retornada.
	 * 2- Num pr�ximo momento � verificado se a express�o cont�m caracteres 
	 * n�o v�lidos, pois s� s�o v�lidos caracters de express�es matem�ticas e
	 * a letra N ou n. Caso exista um caracter n�o v�lido uma exce��o � retornada.
	 * 3- Por fim, a express�o ser� validada atrav�s do componente JEL.
	 * @param expressao
	 * @return true ou uma exce��o
	 * @throws Exception
	 */
	public boolean validar(String expressao) throws Exception {

		/*
		 * Verifica se foi passado null.
		 */
		if (expressao == null) {
			Exception e = new Exception("Uma Express�o deve ser informada!");
			throw e;
		}
		
		if (expressao.length() == 0) {
			Exception e = new Exception("Uma Express�o deve ser informada!");
			throw e;
		}
		
		/*
		 * Este la�o verifica se a express�o passada cont�m caracteres n�o 
		 * v�lidos para a express�o (conforme defini��o), p.ex. uma letra A ou B etc., 
		 * sendo que a �nica letra permitida � a letra N(maiscula ou minuscula), definido
		 * juntamente com o gerente de projeto. Caso exista caracteres invalidos um exce��o ser� levantada.  
		 */
		for (int i = 0; i < expressao.length(); i++) {
			if (expressao.substring(i, i + 1).equals("(")
					|| expressao.substring(i, i + 1).equals(")")
					|| expressao.substring(i, i + 1).equals("[")
					|| expressao.substring(i, i + 1).equals("]")
					|| expressao.substring(i, i + 1).equals("*")
					|| expressao.substring(i, i + 1).equals("+")
					|| expressao.substring(i, i + 1).equals("-")
					|| expressao.substring(i, i + 1).equals("/")
					|| expressao.substring(i, i + 1).equals("^")
					|| expressao.substring(i, i + 1).equals("%")
					|| expressao.substring(i, i + 1).equals("0")
					|| expressao.substring(i, i + 1).equals("1")
					|| expressao.substring(i, i + 1).equals("2")
					|| expressao.substring(i, i + 1).equals("3")
					|| expressao.substring(i, i + 1).equals("4")
					|| expressao.substring(i, i + 1).equals("5")
					|| expressao.substring(i, i + 1).equals("6")
					|| expressao.substring(i, i + 1).equals("7")
					|| expressao.substring(i, i + 1).equals("8")
					|| expressao.substring(i, i + 1).equals("9")
					|| expressao.substring(i, i + 1).equals("n")
					|| expressao.substring(i, i + 1).equals("N")) {
			}
			else {
				Exception e = new Exception("ERRO - Express�o com caracteres inv�lidos");
				throw e;
			}
		}
	
		/*
		 * Este la�o retirar� a(s) letra(s) Nn da express�o
		 * para submeter ao JEL apenas a expressao pura (limpa de letras),
		 * pois esse componente n�o identifica letras.
		 */
		StringBuffer expressao_sb = new StringBuffer();
		for (int i = 0; i < expressao.length(); i++) {
			if (!expressao.substring(i, i + 1).equals("n") 
					& !expressao.substring(i, i + 1).equals("N")) {
				expressao_sb.append(expressao.substring(i, i + 1));
			}
		}
		String expressao_limpa = expressao_sb.toString();
		
		/*
		 * Aqui se Verifica se a express�o � v�lida
		 * Monta a biblioteca
		 */

		Class[] staticLib = new Class[1];
		try {
			staticLib[0] = Class.forName("java.lang.Math");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		
		Library lib = new Library(staticLib, null, null, null, null);
		try {
			lib.markStateDependent("random", null);
		} catch (CompilationException e) {
			throw e;
		}

		// Compila a expressao
		CompiledExpression compilaExpressao = null;
		try {
			compilaExpressao = Evaluator.compile(expressao_limpa, lib);
		} catch (CompilationException ce) {
			throw ce;
		}
		return true;
	}

	/**
	 * Este m�todo, retornar� a nota do aluno na turma, se for possivel, ou seja,
	 * se as notas estiverem todas lan�adas.
	 * Obs: Este m�todo deve ser sincronizado com os m�todos corretos dos
	 * outros pacotes de trabalho (especificamente notas e frequencia) no momento da integra��o dos componentes
	 * por esse motivo ele esta comentado.
	 * @param turma
	 * @param aluno
	 * @return a nota do aluno ou uma exce��o
	 * @throws Exception
	 * 
	 */
	
	/*public double calcularNotaAlunos(int turma, int aluno) throws Exception {
		Notas notas = new Notas(aluno, turma);
		if (notas.getValores().length != turma.qtdeNotas()){
			throw new Exception("Notas insuficientes para calcular m�dia final!");
		}		
		int soma = 0;
		for (int i = 0; i < turma.qtdeNotas(); i++) {
			turma.expressao = turma.expressao.replaceAll("N"+(i+1), String.valueOf(notas.getValores()[i]));
		}
		String[] expressaoAux = turma.expressao.split("[\\/0-9]");
		for (int i = 0; i < expressaoAux.length; i++) {
			String string = expressaoAux[i];
		}
		int media = soma/turma.qtdeNotas();
		return media;
	}*/
}
