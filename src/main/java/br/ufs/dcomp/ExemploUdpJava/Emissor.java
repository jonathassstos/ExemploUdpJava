package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;

public class Emissor {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000); // socket udp associado a porta 10000
            System.out.println("[OK] ]");
            
            String msg = "Olá!!!";
            
            byte[] msg_buf = msg.getBytes(); // Pega a representação em bytes do que quer enviar
            int msg_size = msg_buf.length; // pega o tamanho do vetor de bytes e armazena na var do tamanho dele
            InetAddress destination_address = InetAddress.getLocalHost(); // como o receptor e emissor estão
            // na mesma máquina o endereço de destino é colocado como o local
            int destination_port = 20000; // identifica a porta de destino

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack);
            System.out.println("[OK] ]");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}