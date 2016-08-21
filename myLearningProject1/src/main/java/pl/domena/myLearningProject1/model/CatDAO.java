package pl.domena.myLearningProject1.model;

import java.util.ArrayList;

public class CatDAO {

	ArrayList<Cat> cats = new ArrayList<Cat>();
	
	public ArrayList<Cat> getCats() {
		return cats;
	}

	public void addCat(Cat cat) {
		cats.add(cat);
	}
	
	public int getQuantity() {
		return cats.size();
	}
	
	public Cat getCat(int index) {
		return this.cats.get(index);
	}
	
	public void displayInShortFormat() {
		int i;
		System.out.println("\nOto lista kotow: \n");
		for (i = 0 ; i < this.getQuantity() ; i++) {
			System.out.println("Imie :" + this.getCats().get(i).getName() + " [" + i + "]");
		}
	}
}

