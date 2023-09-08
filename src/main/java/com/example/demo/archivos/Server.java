package com.example.demo.archivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private final Integer PORT = 13;
	
	public Server() {
		Socket clientSocket;
		try {
			ServerSocket serverSocket = new ServerSocket(PORT); 
			while(true) {
				System.out.println("--------1 Iniciando serverSocket Adriano --------------");
				System.out.println("--------2 A la espera del clientSocket --------");
				clientSocket = serverSocket.accept();
				System.out.println("--------3 Llegó el clientSocket ---------------");
				
				File fileOrigen = new File("C://server/Java-Adriano-1.png");
				FileInputStream fis = new FileInputStream(fileOrigen);
				DataOutputStream salida = new DataOutputStream(clientSocket.getOutputStream());
				
				int byteLeidos;
				while( (byteLeidos = fis.read()) != -1) {
					salida.write(byteLeidos);
				}
				
				fis.close();
				salida.close();
				
				System.out.println("--------4 Finaliza la atención clientSocket ---");
				clientSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
	
}