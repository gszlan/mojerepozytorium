package pl.domena.myLearningProject1.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Interfajs {

	static final String MENU_ADD_CAT = "1";
	static final String MENU_DISPLAY_CATS = "2";
	static final String MENU_END = "x";
	
	static Scanner sc = new Scanner(System.in);
	static CatDAO cats = new CatDAO();
	
	public static void main(String args[]) {

		String userResponse;
		Menu menu = new Menu();
		
		do {
			menu.display();
			userResponse = collectUserResponse();
			
			if (userResponse.equals(MENU_ADD_CAT)) {
				cats.addCat(collectCatData());
		
			} else if (userResponse.equals(MENU_DISPLAY_CATS)) {
				cats.displayInShortFormat();
				displayFullCatInfo(cats.getCat(collectCatNumber()));				
			}
			
		} while (!userResponse.equalsIgnoreCase(MENU_END));
			
		System.out.println("Koniec");	
	}

	
	public static String collectUserResponse() {
		
		String userResponse;
	
		do {
			System.out.print("\nWybierz opjce (1,2 lub x) :");
			userResponse = getUserInput();
		} while (!Pattern.matches("[12x]", userResponse));
		
		return userResponse;	
	}
	
	
	public static Cat collectCatData() {
		
		Cat cat = new Cat();

		cat.setName(collectCatName());
		cat.setKeeperName(collectCatKeeperName());
		cat.setWeight(collectCatWeigth());
		cat.setBirthDate(collectCatBirthDate());

		return cat;
	}
	
	
	public static void displayFullCatInfo(Cat cat) {
		
		System.out.println(cat.introduceYourself() + "\n");
	}
	
	
	public static int collectCatNumber() {
		
		Integer inputtedCatNumber = null;
		Integer catsQuantity = cats.getQuantity();
		String userResponse;
		
		do {
			do {
				System.out.print("Teraz wyswietlimy dane kota. Podaj jego numer:");
				userResponse = getUserInput();
			} while (!Pattern.matches("[0-9]+", userResponse));
			
			inputtedCatNumber = Integer.parseInt(userResponse);
			if (inputtedCatNumber >= catsQuantity) {
				System.out.println("Nie ma takiego kota. Spróbuj jeszcze raz");
			}
		} while (inputtedCatNumber >= catsQuantity);
		
		return inputtedCatNumber;
	}
	
	
	private static String collectCatName() {
		
		System.out.print("Podaj moje imie: ");
		return getUserInput();
	}
	
	
	private static String collectCatKeeperName() {
		
		System.out.print("\nPodaj imie opiekuna: ");
		return getUserInput();
	}
	
	
	private static Float collectCatWeigth() {
		
		String userResponse;
		
		do {
			System.out.print("\nPodaj wage: ");
			userResponse = getUserInput();
			if (Pattern.matches("[0-9]+\\.?[0-9]*", userResponse)) {
				return (Float.valueOf(userResponse));
			} else {
				System.out.print("\nNieprawidlowy format wagi");
			}
		} while (true);
	}
	
	
	private static Date collectCatBirthDate() {
		
		String userResponse;
		Date catBirthDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		do {
			System.out.print("\nPodaj date urodzenia: ");
			userResponse = getUserInput();
			if (Pattern.matches("[12][09][019][0-9]-[01][0-9]-[0-3][0-9]", userResponse)) {
				try {
					catBirthDate = sdf.parse(userResponse);
				} catch (Exception e) {
					System.out.print("Wyjatek - nieprawidlowy format daty");
				}
			} else {
				System.out.print("Nieprawidlowy format daty. Prawidlowy format to yyyy-MM-dd");
			}
		} while (catBirthDate == null);
		
		return catBirthDate;
	}
	

	public static String getUserInput() {
		
		return sc.nextLine();
	}

}




