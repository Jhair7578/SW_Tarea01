package com.example.demo.archivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private final Integer PORT = 13;
	private final String IP = "localhost";
	
	public Client() {
		try {
			Socket clientServer = new Socket(IP, PORT);
			System.out.println("-------- 1 Iniciando comunicación ----------");
			
			File fileDestino = new File("C:/cliente/Java-Adriano-2.png");
			FileOutputStream fos = new FileOutputStream(fileDestino);
			DataInputStream entrada = new DataInputStream(clientServer.getInputStream());
			
			
			
			int byteLeidos;
			while( (byteLeidos = entrada.read()) != -1) {
				fos.write(byteLeidos);
			}
			
			fos.close();
			entrada.close();
			
			System.out.println("-------- 2 Finalizando comunicación --------");
			clientServer.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();
	}
	
}