package edu.nyu.cs.nsh263.Assignment4NicholasHyland;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Nicholas Hyland
 * @version 1.0
 * @assignment Assignment Number 4
 *
 */

public class Assignment4NicholasHyland {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String[][] list = new String[1174][6];
		String line = "";
		
		// Link to website - https://data.cityofnewyork.us/Education/School-Progress-Reports-All-Schools-2010-11/yig9-9zum
		// Columns used include District, School, Principal, School Level, 2010-2011 Overall Grade, and 2010-2011 Overall Score
		
		Scanner textScan = new Scanner(new File("src/SchoolProgressReports2010-2011"));
		int row = 0;
		while (textScan.hasNextLine()) {
			line = textScan.nextLine();
			String[] oneRow = line.split("\t!");
			for (int i = 0; i < 6; i ++) {
				list[row][i] = oneRow[i];
			}
			row += 1;
			}

		System.out.print("Enter a grade (A-F) to see which schools received that grade: ");
		Scanner input = new Scanner(System.in);
		String grade = input.nextLine();
		
		while (true) {
		if ((grade.equals("A")) || (grade.equals("B")) || (grade.equals("C")) || (grade.equals("D")) || (grade.equals("E")) || (grade.equals("F"))) {
			break;
		}
		else {
			System.out.print("Please enter a letter grade from (A-F): ");
			grade = input.nextLine();
		}
	}

		int count = 0;
		for (int i = 0; i < 1174; i++) {
			if (list[i][4].equals(grade)) {
				count += 1;
			}
		}
			System.out.println();
			System.out.println("There are " + count + " schools with letter grade " + grade + ", and here are the results: ");
			System.out.println();
			
		for (int i = 0; i < 1174; i++) {
			if (list[i][4].equals(grade)) {
				System.out.println(list[i][1]);
			}
		}

		System.out.println();
		System.out.print("Please enter the name of the school you wish to get data for: ");
		String school = input.nextLine();
		
		boolean isSchool = false;
		
		while (!isSchool) {
			for (int i = 0; i < 1174; i++) {
				if (list[i][1].equals(school)) {
					isSchool = true;
					break;
				}
			}
			if (!isSchool) {
				System.out.print("Please enter a valid school name: ");
				school = input.nextLine();
			}
		}
		
		for (int i = 0; i < 1174; i++) {
			if (list[i][1].equals(school)) {
				System.out.println();
				System.out.printf("%-25s %-25s %-25s\n","District","Principal","School Level");
				System.out.printf("%-25s %-25s %-25s", list[i][0], list[i][2], list[i][3]);
				System.out.println();
			}

		}
		
		System.out.println();
		System.out.print("Please enter a grade (0-100), and we will search for the schools that received a higher or equal grade: ");
		float numberGrade = input.nextFloat();
		
		while (true) {
			if ((numberGrade >= 0) && (numberGrade <= 100)) {
				break;
			}
			else {
				System.out.print("Please enter a number grade from 0-100: ");
				numberGrade = input.nextFloat();
			}
		}
		
		int count3 = 0;
		for (int i = 0; i < 1174; i++) {
			if (Float.parseFloat(list[i][5]) >= numberGrade) {
				count3 += 1;
			}
		}
			System.out.println();
			System.out.println("There are " + count3 + " schools with number grade " + numberGrade + " and higher, and here are the results: ");
			System.out.println();
			
		for (int i = 0; i < 1174; i++) {
			if (Float.parseFloat(list[i][5]) >= numberGrade) {
				System.out.println(list[i][1]);
				
			}
		}	
	}	
}

