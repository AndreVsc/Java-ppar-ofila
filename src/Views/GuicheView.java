package Views;

import java.util.List;

// Models
import Models.Categoria;
import Models.Guiche;

public class GuicheView {
    public void exibirGuiche(Guiche guiche) {
        System.out.println("Guichê: " + guiche.getNumero() + " - " + guiche.getNome());
        System.out.println("Status: " + (guiche.isAtivo() ? "Ativo" : "Inativo"));
        
        System.out.println("Categorias atendidas:");
        for (Categoria categoria : guiche.getCategoriasAtendidas()) {
            System.out.println("- " + categoria.getNome());
        }
    }
    
    public void exibirListaGuiches(List<Guiche> guiches) {
        System.out.println("Lista de Guichês:");
        for (Guiche guiche : guiches) {
            System.out.println("- Guichê " + guiche.getNumero() + " - " + guiche.getNome() + 
                  " (" + (guiche.isAtivo() ? "Ativo" : "Inativo") + ")");
        }
    }
}
