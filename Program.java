package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContracts;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String departamentName = sc.nextLine();
		
		System.out.println("Entre Work Data ");
		System.out.print("Name: ");
		 String WorkerName = sc.nextLine();
		System.out.print("Level: ");
		 String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		Double WorkerBS = sc.nextDouble();
		
		Worker worker = new Worker(WorkerName, WorkerLevel.valueOf(workerLevel), WorkerBS, new Departament(departamentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			System.out.println("Enter contract #" + (1+i) + "data ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration: ");
			int hours = sc.nextInt();
			HourContracts contract = new HourContracts(contractDate, valuePerHour, hours);
			worker.AddContract(contract);
		}
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthYear = sc.next();
		int month = Integer.parseInt(monthYear.substring(0, 2));
		int year = Integer.parseInt(monthYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Icome for "+ monthYear +" :"+ String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
}
