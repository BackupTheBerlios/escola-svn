package hibernate;

public class Jogo {
    private Long id;
    private int numero;
    private String dzns;

     public String getDzns() {
        return dzns;
    }

    public void setDzns(String dzns) {
        this.dzns = dzns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
