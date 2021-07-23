package com;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListPrct {

	public static void main(String[] args) {

		// ==============
		ArrayList<String> trainee = new ArrayList<>();
		trainee.add("Tahir");
		trainee.add("Amjad");
		trainee.add("Rashid");

		String[] arr1 = listToArray(trainee);

		// Array To Array List
		String[] arr2 = { "Java", "Python", "C++" };
		System.out.print("Array: ");
		arraysToList(arr2);

		// ================
		ArrayList<String> person = new ArrayList<>();
		person.add("Altaf");
		person.add("Rashid");
		person.add("Akhter");
		SortArrayList.ascending(person);
		System.out.println("Ascending Order:"+person);
		
		
		SortArrayList.descending(person);
		System.out.println("Descending Order:"+person);
		
		
		Employee emp1=new Employee("Akshay","Male",17);
		Employee emp2=new Employee("Salman","Male",27);
		Employee emp3=new Employee("Rahul","Male",37);
		Employee emp4=new Employee("Amir","Male",19);
		Employee emp5=new Employee("Anum","Female",24);
		Employee emp6=new Employee("Amjad","Male",45);
		Employee emp7=new Employee("Fawad","Male",23);
		Employee emp8=new Employee("Sarmad","Male",67);
		Employee emp9=new Employee("Fatima","Female",23);
		
		ArrayList<Employee> ar=new ArrayList();
		ar.add(emp1);
		ar.add(emp2);
		ar.add(emp3);
		ar.add(emp4);
		ar.add(emp5);
		ar.add(emp6);
		ar.add(emp7);
		ar.add(emp8);
		ar.add(emp9);
	
		EmployeeSorter.getSortedEmployeeByAge(ar);
		System.out.println(ar.toString());
	}

	public static String[] listToArray(ArrayList<String> trainee) {

		System.out.println("Trainee: " + trainee);

		String[] arr = new String[trainee.size()];

		String[] str = trainee.toArray(arr);
		System.out.print("Array: " + str);

		for (String item : str) {
			System.out.print(item + ", ");
		}

		return str;
	}

	public static void arraysToList(Object[] arr) {

		// print array
		for (Object str : arr) {
			System.out.print(str);
			System.out.print(" ");
		}

		// create an ArrayList from an array
		ArrayList<Object> languages = new ArrayList<>(Arrays.asList(arr));
		System.out.println("\nArrayList: " + languages);
	}
}