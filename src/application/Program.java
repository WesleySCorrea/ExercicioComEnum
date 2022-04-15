package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdft = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departamentName = sc.nextLine();
        System.out.println("Enter work data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName,
                WorkerLevel.valueOf(workerLevel),
                baseSalary,
                new Departament(departamentName));

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdft.parse(sc.next());
            System.out.print("Value por hour: ");
            double valorPerHour = sc.nextDouble();
            System.out.print("Duration of the contract (Hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valorPerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String mmandyear = sc.next();
        int month = Integer.parseInt(mmandyear.substring(0,2));
        int year = Integer.parseInt(mmandyear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + mmandyear + ": " + String.format("%.2f" ,worker.income(year, month)));

    }
}