package Zadanie5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption; 
import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap; 
import java.util.List; 
import java.util.Map;
import java.util.Map.Entry; 

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 

public class Downloader {

	static void savePopularWordsForWebsiteToFile(String site,String filePath){
		Connection connect = Jsoup.connect(site);
		try {
		    Document document = connect.get();
		    Elements links = document.select("span.title");
		    Path file =  Paths.get(filePath);
		    ArrayList<String> list = new ArrayList<>();
		    for (Element elem : links) {
		        System.out.println(elem.text());
		        String[] arr = elem.text().split(" ");
		        for(String s: arr){
		        	list.add(s);
		        }
		    }
		   Files.write(file,list,StandardOpenOption.APPEND);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	static void getMostPopularWordsAndSave(String fileSource,String fileDest){
		Path source = Paths.get(fileSource);
		try {
			List<String> lines = Files.readAllLines(source);
			Map<String, Integer> pairs = new HashMap<>();
			for(String s: lines){
				boolean updated = false;
				if(!findStringInBannedWords(s)){
					for(Map.Entry<String, Integer> entry : pairs.entrySet()){
						if(entry.getKey().equals(s)){
							pairs.put(entry.getKey(), entry.getValue() + 1);
							updated = true;
						}
					}
				}
				if(!updated){
					pairs.put(s, 1);
				}
			}
			
			pairs = sortHashMap(pairs);
			List<String> most_popular = new ArrayList<>();
			for(Map.Entry<String, Integer> entry : pairs.entrySet()){
				if(most_popular.size()<10){
					most_popular.add(entry.getKey());
				}else{
					break;
				}
			}
			Path destination = Paths.get(fileDest);
			Files.write(destination, most_popular);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	static Map<String,Integer> sortHashMap(Map<String,Integer> unsortedMap){
	     
	    List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(unsortedMap.entrySet());
	    Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {

	        @Override
	        public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
	            return obj1.getValue().compareTo(obj2.getValue());
	        }
	    });
	    unsortedMap.clear();
	    Collections.reverse(entryList);
	    for (Entry<String, Integer> entry : entryList) {
	    	unsortedMap.put(entry.getKey(), entry.getValue());
	        System.out.println(entry.getKey() + "   " + entry.getValue());
	    }
	    return unsortedMap;
	}
	static boolean findStringInBannedWords(String s){
		String[] banned = {"się","lub","ten","oraz","jak","dla"};
		if(s.length()<3){
			return true;
		}else{
			for(String comapre: banned){
				if(s.toLowerCase().equals(comapre.toLowerCase())){
					return true;
				}
			}
		}
		return false;
	}
}
