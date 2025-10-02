package principal;

import java.util.ArrayList;

public class Voo {
    // constante

    public static final int NUMERO_DE_ASSENTOS = 50;

    // atributos
    private String codigoVoo;
    private ArrayList<Assento> assentos = new ArrayList<>();

    // construtor
    public Voo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
        this.assentos = new ArrayList<>();
    }

    // getter e setter do código do voo
    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    // getter e setter da lista de assentos
    public ArrayList<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<Assento> assentos) {
        this.assentos = assentos;
    }

    // procurar assento pelo número
    public Assento procurarAssento(int numero) {
        return null;
    }
}

