package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class MainServer {

    /**
     * Puerto 
     */
    private final static int PORT = 5000;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            //Socket de servidor para esperar peticiones de la red
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor> Servidor iniciado");    
            System.out.println("Servidor> En espera de cliente...");    
            //Socket de cliente
            Socket clientSocket;
            while(true){
                //en espera de conexion, si existe la acepta
                clientSocket = serverSocket.accept();
                //Para leer lo que envie el cliente
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                //para imprimir datos de salida                
                PrintStream output = new PrintStream(clientSocket.getOutputStream());
                //se lee peticion del cliente
                String request = input.readLine();
                System.out.println("Cliente> petici�n [" + request +  "]");
                //se procesa la peticion y se espera resultado
                String strOutput = process(request);                
                //Se imprime en consola "servidor"
                System.out.println("Servidor> Resultado de petici�n");                    
                System.out.println("Servidor> \"" + strOutput + "\"");
                //se imprime en cliente
                output.flush();//vacia contenido
                output.println(strOutput);                
                //cierra conexion
                clientSocket.close();
            }    
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * procesa peticion del cliente y retorna resultado
     * @param request peticion del cliente
     * @return String
     */
    public static String process(String request){
        String result="";        
        //frases
        String[] phrases = {
            "La tecnolog�a se alimenta a si misma. La tecnolog�a hace posible m�s tecnolog�a.-Alvin Toffler.",
            "La tecnolog�a es s�lo una herramienta. En t�rminos de llevar a los ni�os a trabajar juntos y motivarlos, el profesor es el m�s importante.-Bill Gates.",
            "La m�quina tecnol�gicamente m�s eficiente que el hombre ha inventado es el libro.-Northrop Frye.",
            "Ya no hacen m�s los bugs como bunny - Olav Mjelde",
            "Un lenguaje de programaci�n es de bajo nivel cuando requiere que prestes atencion a lo irrelevante.-Alan J. Perlis.",
            "Hablar es barato. Ens��ame el c�digo.-Linus Torvalds ",
            "No me importa si funciona en su m�quina! No me env�an su m�quina!.-Vidiu Platon",
            "Siempre codifica como si la persona que finalmente mantendr� tu c�digo fuera un psic�pata violento que sabe d�nde vives.-Martin Golding"};
	ArrayList<String> phrasesList = new ArrayList<>();
	Collections.addAll(phrasesList, phrases);
        //libros
        String[] books = {
            "Divina Comedia - Dante Alighieri", 
            "Don Quijote de la Mancha - Miguel de Cervantes",
            "Cien a�os de soledad - Gabriel Garc�a M�rquez",
            "Moby Dick - Herman Melville",
            "Ana Karenina - Lev Tolst�i",
            "Eneida - Virgilio",
            "Otelo - William Shakespeare",
            "El viejo y el mar - Ernest Hemingway",
            "Orgullo y prejuicio - Jane Austen"};
	ArrayList<String> booksList = new ArrayList<>();
	Collections.addAll(booksList, books);        
        
        if(request!=null) switch(request){
            case "frase":
                Collections.shuffle(phrasesList);
                result = phrasesList.get(0);
                break;
            case "libro":
                Collections.shuffle(booksList);
                result = booksList.get(0);
                break;
            case "exit":                
                result = "bye";
                break;
            default:
                result = "La peticion no se puede resolver.";
                break;
        }
        return result;
    }
    
}