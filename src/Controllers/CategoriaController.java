package Controllers;

import Models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaController {
    private Local local;
    
    public CategoriaController(Local local) {
        this.local = local;
    }
    
    public void adicionarCategoria(Categoria categoria) {
        local.adicionarCategoria(categoria);
    }
    
    public List<Categoria> listarCategorias() {
        return new ArrayList<>(local.getCategorias());
    }
    
    public List<Categoria> listarCategoriasPreferenciais() {
        return local.getCategorias().stream()
                .filter(Categoria::isPreferencial)
                .collect(Collectors.toList());
    }
    
    public List<Categoria> listarCategoriasPorPrioridade() {
        return local.getCategorias().stream()
                .sorted(Comparator.comparingInt(Categoria::getPrioridade))
                .collect(Collectors.toList());
    }
}