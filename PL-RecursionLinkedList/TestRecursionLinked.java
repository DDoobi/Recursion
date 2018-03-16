
// 201402415 , 장진우

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestRecursionLinked {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		RecursionLinkedList list = new RecursionLinkedList();
		FileReader fr;

		try {
			fr = new FileReader("C://hw01.txt");
			BufferedReader br = new BufferedReader(fr);
			String inputString = br.readLine();
			for (int i = 0; i < inputString.length(); i++)
				list.add(inputString.charAt(i));
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(list);
		list.add(3, 'b');
		System.out.println(list);
		list.reverse();
		System.out.println(list);
		
	}

}
