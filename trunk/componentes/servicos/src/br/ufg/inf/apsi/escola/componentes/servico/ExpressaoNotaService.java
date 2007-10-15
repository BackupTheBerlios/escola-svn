package br.ufg.inf.apsi.escola.componentes.servico;

/*
 * pacote para que seja possivel utilizar express�es em Java
 */
import java.util.regex.*;

/*
 * Aqui dever� ser importado o pacote que cont�m os servi�os de notas de alunos. 
 */

public class ExpressaoNotaService {

	/*
	 * M�todo para validar a express�o, aqui existe um contrato onde as notas
	 * devem ser o caracter N (maiusculo) necessariamente e s� pode conter 
	 * caracteres para c�lculos matem�ticos (p.ex. (), [], *+-/e os n�meros)
	 */
	public boolean validar(String expressao) throws Exception {

		/* esse la�o verificar� se a express�o t�m caracteres v�lidos...
		 * caso n�o tenha, uma exce��o sera levantada.
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
					|| expressao.substring(i, i + 1).equals("N")) {
			}
			else {
				Exception e = new Exception("ERRO - Express�o com caracteres n�o v�lidos");
				throw e;
			}
		}
		/*
		 * Aqui ser� validado se a express�o � v�lida
		 */
		Pattern padrao = Pattern.compile("\\(|\\)|\\*|\\/|\\+|\\-|0-9|N");
		Matcher pesquisa = padrao.matcher(expressao);

		if (!pesquisa.find()) {
			Exception e = new Exception("ERRO - Express�o inv�lida!");
			throw e;
        }   
		return true;
	}

	/*
	 * Este m�todo, retornar� a nota do aluno na turma, se for possivel, ou seja,
	 * se as notas estiverem todas lan�adas.
	 * obs: Este m�todo deve ser sincronizado com os m�todos corretos dos
	 * outros pacotes de trabalho.
	 */
	public double calcularNotaAlunos(Object turma, Object aluno, String expressao) throws Exception {
		Notas notas = new Notas(aluno, turma);
		if (notas.getValores().length != turma.qtdeNotas()){
			throw new Exception("Notas insuficientes para calcular m�dia final!");
		}		
		int soma = 0;
		for (int i = 0; i < turma.qtdeNotas(); i++) {
			expressao = expressao.replaceAll("N"+(i+1), String.valueOf(notas.getValores()[i]));
		}
		String[] expressaoAux = expressao.split("[\\/0-9]");
		for (int i = 0; i < expressaoAux.length; i++) {
			String string = expressaoAux[i];
		}
		int media = soma/turma.qtdeNotas();
		return media;
	}
}
