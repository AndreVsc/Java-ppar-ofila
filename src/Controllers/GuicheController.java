package Controllers;

import Models.*;

import java.util.List;
import java.util.stream.Collectors;

public class GuicheController {
    private Local local;
    
    public GuicheController(Local local) {
        this.local = local;
    }
    
    public void adicionarGuiche(Guiche guiche) {
        local.adicionarGuiche(guiche);
    }
    
    public void associarCategoriaAoGuiche(Categoria categoria, Guiche guiche) {
        guiche.adicionarCategoria(categoria);
    }
    
    public void desassociarCategoriaDoGuiche(Categoria categoria, Guiche guiche) {
        guiche.removerCategoria(categoria);
    }
    
    public List<Guiche> listarGuichesAtivos() {
        return local.getGuiches().stream()
                .filter(Guiche::isAtivo)
                .collect(Collectors.toList());
    }
    
    public List<Guiche> listarGuichesParaCategoria(Categoria categoria) {
        return local.getGuiches().stream()
                .filter(Guiche::isAtivo)
                .filter(g -> g.getCategoriasAtendidas().contains(categoria))
                .collect(Collectors.toList());
    }
}