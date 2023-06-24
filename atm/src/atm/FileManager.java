
package atm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {

	private File file;
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	private FileManager() {
	}

	private static FileManager instance = new FileManager();

	public static FileManager getInstace() {
		return instance;
	}

	public void saveFile(ArrayList<User> arrayList) {
		System.out.println(arrayList.isEmpty());
		arrayList.get(0).setAccs(null);
		System.out.println(arrayList.get(0).getAccs());
		System.out.println();
//		if(!arrayList.isEmpty()) {
//			saveUser();
//		}

		
		
	}

	private void saveUser() {
		String data = "";
		try {
			String userFile = "user.txt";
			file = new File(userFile);
			fileWriter = new FileWriter(file);

			fileWriter.close();
			System.out.println("유저파일 저장 성공");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void saveAccount() {
		try {
			String accountFile = "account.txt";

			fileWriter = new FileWriter(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void loadFile() {

	}

}