package Models;

import java.time.LocalDateTime;

public class Senha {
    private String codigo;
    private Categoria categoria;
    private LocalDateTime dataHoraEmissao;
    private LocalDateTime dataHoraChamada;
    private boolean atendida;
    private Guiche guicheChamador;
    
    public Senha(String codigo, Categoria categoria) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.dataHoraEmissao = LocalDateTime.now();
        this.atendida = false;
    }
    
    // Getters e Setters
    public String getCodigo() { return codigo; }

    public Categoria getCategoria() { return categoria; }

    public LocalDateTime getDataHoraEmissao() { return dataHoraEmissao; }

    public LocalDateTime getDataHoraChamada() { return dataHoraChamada; }
    public void setDataHoraChamada(LocalDateTime dataHoraChamada) { this.dataHoraChamada = dataHoraChamada; }
    
    public Guiche getGuicheChamador() { return guicheChamador; }
    public void setGuicheChamador(Guiche guicheChamador) { this.guicheChamador = guicheChamador; }
    
    public boolean isAtendida() { return atendida; }
    public void setAtendida(boolean atendida) { this.atendida = atendida; }
    
    @Override
    public String toString() {
        return "Senha " + codigo + " - " + categoria.getNome();
    }
}
