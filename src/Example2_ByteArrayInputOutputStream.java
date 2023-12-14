import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example2_ByteArrayInputOutputStream {
	public static void main (String[] args) {

		fileOutputStream();
		fileInputStream();
		fileInputStream2();
	}

	private static void fileOutputStream () {
		String text = "Hello world!"; // строка для записи
		try (FileOutputStream fos = new FileOutputStream("notes.txt")) {
			// перевод строки в байты
			byte[] buffer = text.getBytes();

			fos.write(buffer, 0, buffer.length);
			System.out.println("The file has been written");
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}

	private static void fileInputStream () {
		try (FileInputStream fin = new FileInputStream("notes.txt")) {
			int i;
			while ((i = fin.read()) != -1) {

				System.out.print((char) i);
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}

	private static void fileInputStream2 () {
		try (FileInputStream fin = new FileInputStream("notes.txt")) {
			byte[] buffer = new byte[256];
			System.out.println("File data:");

			int count;
			while ((count = fin.read(buffer)) != -1) {

				for (int i = 0; i < count; i++) {

					System.out.print((char) buffer[i]);
				}
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}

	private static void fileInputStreamWithClose () {
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("notes.txt");

			int i = -1;
			while ((i = fin.read()) != -1) {

				System.out.print((char) i);
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		} finally {

			try {

				if (fin != null)
					fin.close();
			} catch (IOException ex) {

				System.out.println(ex.getMessage());
			}
		}
	}
	private static void fileInputStreamWithCloseNew (){
		try(FileInputStream fin=new FileInputStream("notes.txt"))
		{
			int i=-1;
			while((i=fin.read())!=-1){

				System.out.print((char)i);
			}
		}
		catch(IOException ex){

			System.out.println(ex.getMessage());
		}
	}
}
