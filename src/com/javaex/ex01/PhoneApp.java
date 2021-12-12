package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		List<Person> pList = new ArrayList<Person>();
		
		Reader fr = new FileReader("C:\\javaStudy\\강의자료\\java\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			
			String line = br.readLine();
			
			if(line == null) {
				break;
			}
			
			String[] dataArray = line.split(",");
			Person p = new Person(dataArray[0], dataArray[1], dataArray[2]);
			pList.add(p);
			
		}
		
		
		
		System.out.println("*************************************");
		System.out.println("*          전화번호 관리 프로그램          *");
		System.out.println("*************************************");

		
		
		
		while(true) {
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("-------------------------------------");
			System.out.print(">메뉴번호:");
			
			int code = sc.nextInt();
			
			if(code == 5) {
				System.out.println("");
				System.out.println("*************************************");
				System.out.println("*              감사합니다              *");
				System.out.println("*************************************");
				break;
			}
			
			switch(code) {
				case 1:
					System.out.println("<1.리스트>");
					printList(pList);
					break;
				case 2:
					System.out.println("<2.등록>");
					Person p = new Person();
					
					System.out.print("이름: ");
					sc.nextLine();
					p.setName(sc.nextLine());
					
					System.out.print("휴대전화: ");
					p.setHp(sc.nextLine());
					
					System.out.print("회사전화: ");
					p.setCompany(sc.nextLine());
					
					pList.add(p);
					System.out.println("[등록되었습니다.]");
					
					Writer fw2 = new FileWriter("C:\\javaStudy\\강의자료\\java\\미니프로젝트\\PhoneDB.txt");
					BufferedWriter bw2 = new BufferedWriter(fw2);
					
					for(Person p2 : pList) {
						bw2.write(p2.showInfo());
						bw2.newLine();
					}
					
					bw2.close();
					break;
				case 3:
					System.out.println("<3.삭제>");
					System.out.print(">번호 : ");
					
					int num = sc.nextInt();
					
					pList.remove(num-1);
					System.out.println("[삭제되었습니다.]");
					
					Writer fw3 = new FileWriter("C:\\javaStudy\\강의자료\\java\\미니프로젝트\\PhoneDB.txt");
					BufferedWriter bw3 = new BufferedWriter(fw3);
					
					for(Person p3 : pList) {
						bw3.write(p3.showInfo());
						bw3.newLine();
					}
					
					bw3.close();
					break;
				case 4:
					System.out.println("<4.검색>");
					System.out.print(">이름: ");
					sc.nextLine();
					String search = sc.nextLine();
					
					for(int i=0; i<pList.size(); i++) {
						if(pList.get(i).getName().contains(search)) {
							System.out.println((i+1)+". " + pList.get(i).printInfo());
						}
					}
					
					break;
				default:
					System.out.println("[다시 입력해 주세요.]");
					break;
			}
			
		}
		
		sc.close();
		br.close();
		
		
	}
	
	public static void printList(List<Person> personList) {
		for(int i=0; i< personList.size(); i++) {
			
			System.out.println((i+1) + ".  " +personList.get(i).printInfo());
		}
	}
	


}
