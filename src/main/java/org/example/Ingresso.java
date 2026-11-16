package org.example;

//Model: Representa a escolha e garante as regras da bilheteria
public class Ingresso {

    private final String filme;
    private final int quantidade;
    private final String tipo;

    public Ingresso(String filme, int quantidade, String tipo) {
        if (!"orbita".equalsIgnoreCase(filme) && !"codigo".equalsIgnoreCase(filme) && !"oceano".equalsIgnoreCase(filme)) {
            throw new IllegalArgumentException("Escolha um filme válido.");
        }
        if (quantidade < 1 || quantidade > 10) {
            throw new IllegalArgumentException("Escolha de 1 a 10 ingressos.");
        }
        if (!"inteira".equalsIgnoreCase(tipo) && !"meia".equalsIgnoreCase(tipo)) {
            throw new IllegalArgumentException("Escolha inteira ou meia.");
        }
        this.filme = filme;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return switch (filme) {
            case "orbita" -> "Além da Órbita";
            case "codigo" -> "Código Secreto";
            default -> "Oceano Vivo";
        };
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public int getPrecoUnitarioCentavos(){
        return tipo.equalsIgnoreCase("meia") ? 1500: 3000;
    }
    public int calcularTotalCentavos(){
        return quantidade * getPrecoUnitarioCentavos();
    }


}
