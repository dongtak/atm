package atm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;

	private int sel;
	private final int QUIT = 5;

	private FileManager() {
	}

	private static FileManager instance = new FileManager();

	public static FileManager getInstance() {
		return instance;
	}

	private boolean isRun() {
		if (this.sel == QUIT) {
			System.out.println("-뿅-");
			return false;
		}
		return true;
	}

}
