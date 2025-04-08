import Controllers.*;
import Models.*;
import Views.*;

public class App {
    public static void main(String[] args) {
        // Criando o local
        Local local = new Local(1, "Central de Atendimento", "Rua Principal, 123");

        // Criando controladores
        CategoriaController categoriaController = new CategoriaController(local);
        GuicheController guicheController = new GuicheController(local);
        SenhaController senhaController = new SenhaController();

        // Criando categorias
        Categoria preferencial = new Categoria(1, "Preferencial", 1, 10, true);
        Categoria normal = new Categoria(2, "Normal", 2, 20, false);

        categoriaController.adicionarCategoria(preferencial);
        categoriaController.adicionarCategoria(normal);

        // Criando guichês
        Guiche guiche1 = new Guiche(1, "Guichê 1");
        Guiche guiche2 = new Guiche(2, "Guichê 2");

        guicheController.adicionarGuiche(guiche1);
        guicheController.adicionarGuiche(guiche2);

        // Associando categorias aos guichês
        guicheController.associarCategoriaAoGuiche(preferencial, guiche1);
        guicheController.associarCategoriaAoGuiche(normal, guiche2);

        // Emitindo senhas
        Senha senha1 = senhaController.emitirSenha(preferencial);
        Senha senha2 = senhaController.emitirSenha(normal);
        Senha senha3 = senhaController.emitirSenha(preferencial);

        // Chamando senhas
        Senha chamada1 = senhaController.chamarProximaSenha(guiche1);
        Senha chamada2 = senhaController.chamarProximaSenha(guiche2);

        // Finalizando atendimento
        senhaController.finalizarAtendimento(chamada1);

        // Exibindo informações
        CategoriaView categoriaView = new CategoriaView();
        GuicheView guicheView = new GuicheView();
        SenhaView senhaView = new SenhaView();

        System.out.println("\nCategorias:");
        categoriaView.exibirListaCategorias(categoriaController.listarCategorias());

        System.out.println("\nGuichês:");
        guicheView.exibirListaGuiches(guicheController.listarGuichesAtivos());

        System.out.println("\nSenhas em espera:");
        senhaView.exibirListaSenhas(senhaController.listarSenhasEmEspera());

        System.out.println("\nSenhas em atendimento:");
        senhaView.exibirListaSenhas(senhaController.listarSenhasEmAtendimento());

        System.out.println("\nSenhas atendidas:");
        senhaView.exibirListaSenhas(senhaController.listarSenhasAtendidas());
    }
}
