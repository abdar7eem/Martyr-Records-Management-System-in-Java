package application;

import java.util.Date;

import javafx.scene.control.DatePicker;

public class List{
	
	int s=16;// initial array size
	Martyr []arr=new Martyr[s];

	//method to add martyrs to array
	public void add(Martyr m) {
		int n=index();
		if(n != -1) {
			arr[n]=m;
		}
		else {
			s*=2;
			arr=copy();
			int x=index();
			arr[x]=m;
		}
	}
	//method to return first empty index
	public int index() {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==null) {
				return i;
			}
		}
		return -1;
	}
	
	//method to copy old array to new array with double size
	public Martyr[] copy(){
		Martyr []array=new Martyr[s];
		for(int i=0;i<arr.length;i++) {
			array[i]=arr[i];
		}
		return array;
	}

	//method to delete martyr from array by his name
	public void delete(String name) {
		Martyr []new_Array =new Martyr[arr.length];
		int k=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] !=null) {
				if(!(arr[i].getName().equalsIgnoreCase(name))) {
					new_Array[k]=arr[i];
					k++;
				}
			}
		}
		arr=new_Array;
	}
	
	//method to check if martyr exist in array
	public boolean checkToDelete(String name) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=null) {
				if(arr[i].getName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	//method to search for a martyr by his name
	public Martyr search(String name) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i].getName().equalsIgnoreCase(name)){
				return arr[i];	
			}
		}
		return null;
	}

	//method to count martyr by age
	public int count(int age) {
		int counter=0;

		for(int i=0;i<arr.length;i++) {
			if(arr[i] !=null) {
				if(arr[i].getAge() == age) {
					counter++;
				}
			}
		}
		return counter;

	}
	
	//method to count martyr by gender
	public int count(String gender) {
		int counter=0;

		for(int i=0;i<arr.length;i++) {
			if(arr[i] !=null) {
				if(arr[i].getGender().equalsIgnoreCase(gender)) {
					counter++;
				}
			}
		}
		return counter;

	}
	
	//method to count martyr by date
	public int count(Date date) {
		int counter=0;

		for(int i=0;i<arr.length;i++) {
			if(arr[i] !=null) {
				if(arr[i].getDof().compareTo(date)==0) {
					counter++;
				}
			}
		}
		return counter;

	}

	//method to return array
	public Martyr[] get(){
		return arr;
	}

	
	//method to return list length 
	public int lenght() {
		return arr.length;
	}
}
