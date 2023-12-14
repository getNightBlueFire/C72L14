import example.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	public static void main (String[] args) throws IOException {
		//System.out.println("Hello world!");
		//File f = new File("D:\\IDEAPRO\\C72L14");
		//print(f);
//		for (File s : f.listFiles()) {
//			print(f);
//		}
		//File f = new File("example", "     ");
		//File f = new File(file, "example");
		// System.out.println(f.isAbsolute());
		//fileOutputStream();

		//fileInputStream();

		//files();

		User[] users = new User[3];
		int i = 0;

		int[] ints = new int[3];

		Object[] list = Files.lines(Path.of("example.txt")).toArray();
		for(Object s: list){
			String s1 = (String) s;
			//System.out.println(s1);

			String[] s2 = s1.split(" ");

			User user = new User(s2[0], s2[1]);
			users[i] = user;

			ints[i++] = s2[1].length();


			System.out.println(user);
		}


		System.out.println(users[0].getName().equals(users[2].getName()));

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

	private static void pw(){
		try(FileWriter pw = new FileWriter("notes1.txt"))
		{
			pw.write("Hello world!");
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	private static void print(File file){
		if (file.isDirectory()){
			for (File listFile : file.listFiles()) {
				print(listFile);
			}
		}
		System.out.println(file);
	}


	private static void fileReader () {
		try (FileReader fin = new FileReader("notes.txt")) {
			int i;
			while ((i = fin.read()) != -1) {

				System.out.print((char) i);
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void files() {

        try {
			Stream<String> lines = Files.lines(Path.of("notes.txt"));
			List<String> list = lines.toList();


			for (String s: list){
				System.out.println(s.startsWith("Test"));
			}


		} catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
