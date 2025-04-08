package Models;

public class Categoria {
    private int id;
    private String nome;
    private int prioridade;
    private int tempoMaximoEspera;
    private boolean preferencial;
    
    public Categoria(int id, String nome, int prioridade, int tempoMaximoEspera, boolean preferencial) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.tempoMaximoEspera = tempoMaximoEspera;
        this.preferencial = preferencial;
    }
    
    // Getters e Setters
    public int getId() { return id; }

    public String getNome() { return nome; }

    public int getPrioridade() { return prioridade; }
    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }

    public int getTempoMaximoEspera() { return tempoMaximoEspera; }
    public void setTempoMaximoEspera(int tempoMaximoEspera) { this.tempoMaximoEspera = tempoMaximoEspera; }

    public boolean isPreferencial() { return preferencial; }

    
    @Override
    public String toString() {
        return nome + (preferencial ? " (Preferencial)" : "");
    }
}