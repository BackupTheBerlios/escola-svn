package br.ufg.inf.apsi.escola.componentes.nf.modelo;

public class TipoConfiguracaoNota {
	
	private int id;
	private String descricao;
	
	public static TipoConfiguracaoNota Default = new TipoConfiguracaoNota(1,"DEFAULT");
	public static TipoConfiguracaoNota Customizado = new TipoConfiguracaoNota(2,"CUSTOMIZADO");
	
	private TipoConfiguracaoNota(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getID() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		return ((TipoConfiguracaoNota) obj).id == this.id;
	}

	@Override
	public String toString() {
		return this.descricao;
	}
	
}