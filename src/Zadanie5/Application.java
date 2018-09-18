package Zadanie5;
  

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Downloader.savePopularWordsForWebsiteToFile("http://www.onet.pl/","./src/Zadanie5/popular_words.txt");
		Downloader.savePopularWordsForWebsiteToFile("http://www.wp.pl/","./src/Zadanie5/popular_words.txt");
		Downloader.savePopularWordsForWebsiteToFile("http://www.interia.pl/","./src/Zadanie5/popular_words.txt");
		Downloader.getMostPopularWordsAndSave("./src/Zadanie5/popular_words.txt", "./src/Zadanie5/most_popular_words.txt");
	}
	
}
