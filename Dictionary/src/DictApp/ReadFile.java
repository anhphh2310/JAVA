package DictApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class ReadFile {

	public static String filePath = "D:\\data1.txt";
	public static HashMap<String, String> map = new HashMap<>();

	public ReadFile() throws IOException {
		readFile();
	}

	public HashMap<String, String> readFile() throws IOException {
		// HashMap<String, String> hMap = new HashMap<String, String>();
		File f = new File(filePath);
		if (f.exists()) {
			FileReader fr = new FileReader(filePath);
			String line;
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"));
			if ((line = bf.readLine()) != null) {
				while ((line = bf.readLine()) != null) {
					String[] split = line.split(":");
					map.put(split[0], split[1]);
				}
			}
			fr.close();
			bf.close();

		}
		return map;
	}

	public HashMap<String, String> readMoreFile(File f) throws IOException {
		// File f = new File(path);
		if (f.exists()) {
			String line;
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"));
			while ((line = bf.readLine()) != null) {
				String[] split = line.split(":");
				// if(!map.containsKey(split[0])) {
				map.put(split[0], split[1]);
				// }
			}
			bf.close();
		}
		return map;
	}

	public void updateFile(String key, String value) {

	}

	public ArrayList<String> find(String s) throws IOException {

		ArrayList<String> list = new ArrayList<>();
		String temp;
		File f = new File(filePath);
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
		while ((temp = bf.readLine()) != null) {
			if (temp.startsWith(s)) {
				list.add(temp);
			}
		}
		bf.close();
		Collections.sort(list);
		return list;
	}

	public static ArrayList<String> find2(String s) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		for (String string : map.keySet()) {
			list.add(string + " : " + map.get(string));
			System.out.println(string);
		}
		Collections.sort(list);
		return list;
	}

	public String search(String s) throws IOException {
		HashMap<String, String> readF = readFile();
		if (!readF.containsKey(s))
			return "Dictionary doesn't cotain this word!";
		else
			return readF.get(s);
	}

	public ArrayList<String> search2(String s) {
		HashMap<String, String> mainMap = map;
		ArrayList<String> result = new ArrayList<String>();
		for (String string : mainMap.keySet()) {
			if (equalStrings(s, string)) {
				result.add(string + " : " + mainMap.get(string));
			}
		}
		return result;

	}

	public boolean equalStrings(String s1, String s2) {
		boolean result = true;
		int k = (s1.length() > s2.length()) ? s2.length() : s1.length();
		for (int i = 0; i < k; i++) {
			if (s1.charAt(i) != s2.charAt(i))
				result = false;
		}
		return result;

	}

	public String getArr(ArrayList<String> list) {
		String a = "";
		if (list.size() == 0) {
			a = "Dictionary doesn't cotain this word!";
		} else {
			for (int i = 0; i < list.size(); i++) {
				a += list.get(i) + "\n";
			}
		}
		return a;
	}

	public boolean updateMap(String key, String value) throws IOException {
		boolean updated = false;
		for (String k : map.keySet()) {
			if (key.equals(k)) {
				map.put(key, value);
				System.out.println(map.get(key));
				updated = true;
			}
		}
		if (updated == false) {
			map.put(key, value);
		}
		return updated;
	}

	public static void main(String[] args) throws IOException {
		/*
		 * ReadFile r = new ReadFile(); r.readFile(); HashMap<String,String> map =
		 * r.map; for(String k : map.keySet()) { System.out.println(k + ";" +
		 * map.get(k)); }
		 */

	}
}
