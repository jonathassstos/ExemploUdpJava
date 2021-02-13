package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;

public class Receptor {

    public static void main(String[] args) throws SocketException {
        try{

            System.out.print("[ Alocando porta UDP                  ..................  ");
    	    DatagramSocket socket = new DatagramSocket(20000); // se associa a um socket na porta 20000
            System.out.println("[OK] ]");

            byte[] buf = new byte[20];
            DatagramPacket pack = new DatagramPacket(buf, buf.length); // cria um pacote vazio 
            // para poder receber a mensagem nesse pacote

            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            socket.receive(pack); // operação bloqueante
            System.out.println("[OK] ]");
            
            //preenchendo o pacote que estava vazio
            byte[] received_data = pack.getData(); // pega os Dados em bytes
            String received_msg = new String(received_data); // transforma os dados em string
            InetAddress origin_address = pack.getAddress(); // pega o endereço de origem
            int origin_port = pack.getPort(); // pega a porta de origem
            
            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
        
        
        

    }
}