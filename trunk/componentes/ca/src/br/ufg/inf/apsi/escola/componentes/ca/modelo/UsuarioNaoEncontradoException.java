package br.ufg.inf.apsi.escola.componentes.ca.modelo;

public class UsuarioNaoEncontradoException extends Exception {

	public UsuarioNaoEncontradoException() {
        super("Usuario não encontrado!");
    }
}
