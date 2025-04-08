package Models;

import java.util.ArrayList;
import java.util.List;

public class Local {
    private int id;
    private String nome;
    private String endereco;
    private List<Categoria> categorias;
    private List<Guiche> guiches;
    
    public Local(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.categorias = new ArrayList<>();
        this.guiches = new ArrayList<>();
    }
    
    // Getters e Setters
    public int getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    
    public List<Categoria> getCategorias() { return categorias; }
    public void adicionarCategoria(Categoria categoria) { categorias.add(categoria); }
    
    public List<Guiche> getGuiches() { return guiches; }
    public void adicionarGuiche(Guiche guiche) { guiches.add(guiche); }

}