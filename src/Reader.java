import java.io.*;
import java.util.*;
public class Reader {
	
	public static ArrayList<String> read(String filename) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		FileReader fReader = new FileReader(filename);
		BufferedReader bReader = new BufferedReader(fReader);
		String line;
		while((line = bReader.readLine()) != null)
			list.add(line);
		fReader.close();
		bReader.close();
		return list;
	}

	public static void main(String[] args) throws IOException {

		read("src//Products.txt").forEach(product -> System.out.println(product));

	}

}
