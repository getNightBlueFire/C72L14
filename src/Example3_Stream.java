import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Example3_Stream {
	public static void main (String[] args) {
		ps_toFile();
	}

	private static void ps_toFile(){
		try(PrintStream printStream = new PrintStream("notes3.txt"))
		{
			printStream.print("Hello World!");
			printStream.println("Welcome to Java!");

			printStream.printf("Name: %s Age: %d \n", "Tom", 34);

			String message = "PrintStream";
			byte[] message_toBytes = message.getBytes();
			printStream.write(message_toBytes);

			System.out.println("The file has been written");
		}
		catch(IOException ex){

			System.out.println(ex.getMessage());
		}
	}
	private static void pw(){
		try(PrintWriter pw = new PrintWriter(System.out))
		{
			pw.println("Hello world!");
		}
	}
}
