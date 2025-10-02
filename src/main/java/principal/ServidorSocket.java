package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

    ControladorVoo controlador = new ControladorVoo();

    public int calcularCodigoStatus(String mensagem) {
        int resultado;
        String[] partes = mensagem.split(";", 3);

        String p1 = partes.length > 0 ? partes[0].trim() : "";
        String p2 = partes.length > 1 ? partes[1].trim() : "";
        String p3 = partes.length > 2 ? partes[2].trim() : "";

        if (p2.isEmpty()) {
            return 2;
        }

        if (p3.isEmpty()) {
            return 3;
        }
        int assento;
        try {
            assento = Integer.parseInt(p3);
        } catch (NumberFormatException e) {
            return 3;
        }

        return switch (p1) {
            case "C" ->
                controlador.verificarStatus(p2, assento);
            case "M" ->
                controlador.marcarVoo(p2, assento);
            default ->
                5;
        };

    }

    public void rodarServidor() {
        try {
            //server
            ServerSocket servidor = new ServerSocket(4444);
            System.out.println("Aguardando cliente!!");
            Socket socket = servidor.accept(); // espera
            System.out.println("Chegou o cliente :" + socket.getInetAddress().getHostAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensagem = "";
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while ((mensagem = in.readLine()) != null) {
                int resultado = calcularCodigoStatus(mensagem);
                out.println(resultado);
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}
