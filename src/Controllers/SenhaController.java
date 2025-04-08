package Controllers;

import Models.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SenhaController {
    private List<Senha> senhasEmEspera;
    private List<Senha> senhasEmAtendimento;
    private List<Senha> senhasAtendidas;
    private int contadorSenhas;
    
    public SenhaController() {
        this.senhasEmEspera = new ArrayList<>();
        this.senhasEmAtendimento = new ArrayList<>();
        this.senhasAtendidas = new ArrayList<>();
        this.contadorSenhas = 0;
    }
    
    public Senha emitirSenha(Categoria categoria) {
        contadorSenhas++;
        String prefixo = categoria.getNome().substring(0, 1).toUpperCase();
        String codigo = prefixo + String.format("%03d", contadorSenhas);
        
        Senha novaSenha = new Senha(codigo, categoria);
        senhasEmEspera.add(novaSenha);
        
        return novaSenha;
    }
    
    public Senha chamarProximaSenha(Guiche guiche) {
        if (!guiche.isAtivo()) {
            return null;
        }
        
        List<Categoria> categoriasGuiche = guiche.getCategoriasAtendidas();
        if (categoriasGuiche.isEmpty()) {
            return null;
        }
        
        List<Senha> senhasElegiveis = senhasEmEspera.stream()
                .filter(s -> categoriasGuiche.contains(s.getCategoria()))
                .collect(Collectors.toList());
        
        if (senhasElegiveis.isEmpty()) {
            return null;
        }
        
        Comparator
                .comparingInt(s -> ((Senha) s).getCategoria().getPrioridade());
        // Ordena por prioridade e tempo de espera
        Senha proximaSenha = senhasElegiveis.stream()
                .sorted(Comparator
                        .comparing(Senha::getDataHoraEmissao))
                .findFirst()
                .orElse(null);
        
        if (proximaSenha != null) {
            senhasEmEspera.remove(proximaSenha);
            senhasEmAtendimento.add(proximaSenha);
            proximaSenha.setDataHoraChamada(LocalDateTime.now());
            proximaSenha.setGuicheChamador(guiche);
        }
        
        return proximaSenha;
    }
    
    public void finalizarAtendimento(Senha senha) {
        if (senhasEmAtendimento.contains(senha)) {
            senhasEmAtendimento.remove(senha);
            senha.setAtendida(true);
            senhasAtendidas.add(senha);
        }
    }
    
    public List<Senha> listarSenhasComTempoExcedido() {
        LocalDateTime agora = LocalDateTime.now();
        
        return senhasEmEspera.stream()
                .filter(senha -> {
                    int tempoMaximo = senha.getCategoria().getTempoMaximoEspera();
                    long minutosEspera = Duration.between(senha.getDataHoraEmissao(), agora).toMinutes();
                    return minutosEspera > tempoMaximo;
                })
                .collect(Collectors.toList());
    }
    
    public List<Senha> listarSenhasEmEspera() {
        return new ArrayList<>(senhasEmEspera);
    }
    
    public List<Senha> listarSenhasEmAtendimento() {
        return new ArrayList<>(senhasEmAtendimento);
    }
    
    public List<Senha> listarSenhasAtendidas() {
        return new ArrayList<>(senhasAtendidas);
    }
}