package Models;

import java.util.ArrayList;
import java.util.List;

public class Guiche {
    private int numero;
    private String nome;
    private boolean ativo;
    private List<Categoria> categoriasAtendidas;
    
    public Guiche(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        this.ativo = true;
        this.categoriasAtendidas = new ArrayList<>();
    }
    
    // Getters e Setters
    public int getNumero() { return numero; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public List<Categoria> getCategoriasAtendidas() { return categoriasAtendidas; }
    
    public void adicionarCategoria(Categoria categoria) {
        if (!categoriasAtendidas.contains(categoria)) {
            categoriasAtendidas.add(categoria);
        }
    }
    
    public void removerCategoria(Categoria categoria) {
        categoriasAtendidas.remove(categoria);
    }
    
    @Override
    public String toString() {
        return "Guichê " + numero + " - " + nome;
    }
}