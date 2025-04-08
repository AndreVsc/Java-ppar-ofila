package Views;

import java.util.List;

// Models
import Models.Categoria;

public class CategoriaView {
    public void exibirCategoria(Categoria categoria) {
        System.out.println("Categoria: " + categoria.getNome());
        System.out.println("Prioridade: " + categoria.getPrioridade());
        System.out.println("Tempo Máximo de Espera: " + categoria.getTempoMaximoEspera() + " minutos");
        System.out.println("Preferencial: " + (categoria.isPreferencial() ? "Sim" : "Não"));
    }
    
    public void exibirListaCategorias(List<Categoria> categorias) {
        System.out.println("Lista de Categorias:");
        for (Categoria categoria : categorias) {
            System.out.println("- " + categoria.getNome() + 
                  " (Prioridade: " + categoria.getPrioridade() + 
                  (categoria.isPreferencial() ? ", Preferencial" : "") + ")");
        }
    }
}