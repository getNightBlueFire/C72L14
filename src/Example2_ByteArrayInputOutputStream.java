import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example2_ByteArrayInputOutputStream {
	public static void main (String[] args) {


	}

	private static void output () {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String text = "Hello Wolrd!";
		byte[] buffer = text.getBytes();
		try{
			baos.write(buffer);
		}
		catch(Exception ex){

			System.out.println(ex.getMessage());
		}
		// превращаем массив байтов в строку
		System.out.println(baos.toString());

		// получаем массив байтов и выводим по символьно
		byte[] array = baos.toByteArray();
		for(byte b: array){

			System.out.print((char)b);
		}
		System.out.println();
	}

	private static void writeTo () {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String text = "Hello Wolrd!";
		byte[] buffer = text.getBytes();
		try{
			baos.write(buffer);
		}
		catch(Exception ex){

			System.out.println(ex.getMessage());
		}
		try(FileOutputStream fos = new FileOutputStream("hello.txt")){

			baos.writeTo(fos);
		}
		catch(IOException e){

			System.out.println(e.getMessage());
		}
	}

	private static void input () {
		byte[] array1 = new byte[]{1, 3, 5, 7};
		ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1);
		int b;
		while((b=byteStream1.read())!=-1){

			System.out.println(b);
		}

		String text = "Hello world!";
		byte[] array2 = text.getBytes();
		// считываем 5 символов
		ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 0, 5);
		int c;
		while((c=byteStream2.read())!=-1){

			System.out.println((char)c);
		}
	}

	private static void bais(){
		String text = "Hello world!";
		byte[] buffer = text.getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(buffer);

		try(BufferedInputStream bis = new BufferedInputStream(in)){

			int c;
			while((c=bis.read())!=-1){

				System.out.print((char)c);
			}
		}
		catch(Exception e){

			System.out.println(e.getMessage());
		}
		System.out.println();
	}

	private static void bos(){
		String text = "Hello world!"; // строка для записи
		try(FileOutputStream out=new FileOutputStream("notes.txt");
			BufferedOutputStream bos = new BufferedOutputStream(out))
		{
			// перевод строки в байты
			byte[] buffer = text.getBytes();
			bos.write(buffer, 0, buffer.length);
		}
		catch(IOException ex){

			System.out.println(ex.getMessage());
		}
	}
}
