package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {
    static void main() throws IOException {
        HttpServer servidor = HttpServer.create
                (new InetSocketAddress(8081),0);
        servidor.createContext("/api/ingressos", IngressoController::calcular);
        servidor.createContext("/",Main::abrirPagina);
        servidor.start();
        System.out.println("Bilheteiria disponivel em http://localhost:8081");
    }
    private static void abrirPagina(HttpExchange troca) throws IOException{
        if (!troca.getRequestURI().getPath().equals("/")){
            responderPagina(troca,404,"Página não encontrada".getBytes(StandardCharsets.UTF_8),"text/plain");
        return;
        }
    }
}
