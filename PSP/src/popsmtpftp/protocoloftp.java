package popsmtpftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;



public class protocoloftp {

	public static void main(String[] args) throws IOException {

		String sFTP = "ftp.cfgslosnaranjos.net";
		String sUser = "veroisrael";
		String sPassword = "morcilla1";
		FTPClient client = new FTPClient();
		String tipos[] = { "Fichero", "Directorio", "Enlace simb." };
		
		
		
		try {
			client.setStrictReplyParsing(false);
			
			client.connect(sFTP);
			boolean login = client.login(sUser, sPassword);

			if (login) {
				System.out.println("login correcto");
				System.out.println("Directorio actual: " + client.printWorkingDirectory());

				FTPFile[] files = client.listFiles();

				System.out.println("Ficheros en el directorio actual:" + files.length);

				//array para visualizar el tipo de fichero.


				for (int i = 0; i < files.length; i++) {

					System.out.println("\t" + files[i].getName() + " => " + tipos[files[i].getType()]);

				}
				
			} else {
				System.out.println("login incorrecto");
			
			}

			

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			client.disconnect();

		}

	}

}