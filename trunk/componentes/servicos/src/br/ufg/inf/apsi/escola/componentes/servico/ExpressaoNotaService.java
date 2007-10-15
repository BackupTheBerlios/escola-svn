package br.ufg.inf.apsi.escola.componentes.servico;

/*
 * pacote para que seja possivel utilizar expressões em Java
 */
import java.util.regex.*;

/*
 * Aqui deverá ser importado o pacote que contém os serviços de notas de alunos. 
 */

public class ExpressaoNotaService {

	/*
	 * Método para validar a expressão, aqui existe um contrato onde as notas
	 * devem ser o caracter N (maiusculo) necessariamente e só pode conter 
	 * caracteres para cálculos matemáticos (p.ex. (), [], *+-/e os números)
	 */
	public boolean validar(String expressao) throws Exception {

		/* esse laço verificará se a expressão têm caracteres válidos...
		 * caso não tenha, uma exceção sera levantada.
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
				Exception e = new Exception("ERRO - Expressão com caracteres não válidos");
				throw e;
			}
		}
		/*
		 * Aqui será validado se a expressão é válida
		 */
		Pattern padrao = Pattern.compile("\\(|\\)|\\*|\\/|\\+|\\-|0-9|N");
		Matcher pesquisa = padrao.matcher(expressao);

		if (!pesquisa.find()) {
			Exception e = new Exception("ERRO - Expressão inválida!");
			throw e;
        }   
		return true;
	}

	/*
	 * Este método, retornará a nota do aluno na turma, se for possivel, ou seja,
	 * se as notas estiverem todas lançadas.
	 * obs: Este método deve ser sincronizado com os métodos corretos dos
	 * outros pacotes de trabalho.
	 */
	public double calcularNotaAlunos(Object turma, Object aluno, String expressao) throws Exception {
		Notas notas = new Notas(aluno, turma);
		if (notas.getValores().length != turma.qtdeNotas()){
			throw new Exception("Notas insuficientes para calcular média final!");
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
