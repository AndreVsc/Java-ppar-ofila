package Views;

import java.util.List;

// Models
import Models.Senha;

public class SenhaView {
    public void exibirSenha(Senha senha) {
        System.out.println("Senha: " + senha.getCodigo());
        System.out.println("Categoria: " + senha.getCategoria().getNome());
        System.out.println("Data/Hora de Emissão: " + senha.getDataHoraEmissao());
        
        if (senha.getDataHoraChamada() != null) {
            System.out.println("Chamada para o guichê: " + senha.getGuicheChamador().getNome());
            System.out.println("Data/Hora da Chamada: " + senha.getDataHoraChamada());
        }
        
        System.out.println("Status: " + (senha.isAtendida() ? "Atendida" : "Em Espera/Atendimento"));
    }
    
    public void exibirListaSenhas(List<Senha> senhas) {
        System.out.println("Lista de Senhas:");
        for (Senha senha : senhas) {
            System.out.println("- " + senha.getCodigo() + " (" + senha.getCategoria().getNome() + ")");
        }
    }
}