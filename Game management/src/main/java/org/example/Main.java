package org.example;
import org.example.dao.EchipaDao;
import org.example.dao.MeciDao;
import org.example.database.model.EchipaEntity;
import org.example.database.model.MeciEntity;

import java.util.List;
import java.util.Scanner;

/// fn+alt+ins

public class Main {
    private static Scanner scanner= new Scanner(System.in);
    private static boolean isRunning = true;

    public static void main(String[] args) {

        while (isRunning) {
            String s;
            s = scanner.nextLine();
            showMenu();
            getChoice();
        }
    }


    public static void getChoice() {
        int choice;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            choice = 10;
        }
        switch (choice) {
            case 1:
                addEchipa();
                break;
            case 2:
                addMeci();
                break;
            case 3:
                statisticaEchipa();
                break;
            case 4:
                leaderBoard();
                break;
            case 0:
                isRunning = false;
                break;
            default:
                //clearScreen();
                System.out.println("INVALID CHOICE");
                scanner.nextLine();
        }
    }

    private static void leaderBoard() {
        //clearScreen();
        String s;
        s= scanner.nextLine();
        EchipaDao echipaDao = new EchipaDao();
        List<EchipaEntity> echipaEntities = echipaDao.getAllOrderedByPuncte();
        for(EchipaEntity e:echipaEntities)
            System.out.println(e.getNume()+" "+e.getPuncte());
    }

    private static void statisticaEchipa() {
        //clearScreen();
        String s;
        s= scanner.nextLine();
        System.out.println("INTRODU NUMELE ECHIPEI:");
        EchipaDao echipaDao = new EchipaDao();
        String nume = scanner.nextLine();
        nume = nume.toUpperCase();
        EchipaEntity echipa = echipaDao.getByNume(nume);
        if(echipa == null){
            System.out.println("ECHIPA NOT FOUND");
            return;
        }
        printBar();
        showEchipa(echipa);
    }
    static void showEchipa(EchipaEntity movie){
        System.out.println("NUME: " + movie.getNume());
        System.out.println("GOLAVERAJ: " + movie.getGolaveraj());
        System.out.println("PUNCTE: " + movie.getPuncte());
        printBar();
    }
    static void printBar(){
        System.out.println("------------------------------");
    }
    private static void addMeci() {
        scanner.nextLine();
        //clearScreen();
        MeciEntity meci = new MeciEntity();
        System.out.println("ADD MECI");
        System.out.print("ID ECHIPA1:");
        int id1 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID ECHIPA2:");
        int id2 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("REZULTAT:");
        String rezultat = scanner.nextLine();
        meci.setIdechipa1(id1);
        meci.setIdechipa2(id2);
        meci.setRezultat(rezultat);

        MeciDao movieDao = new MeciDao();
        movieDao.create(meci);
        System.out.println("MECI ADDED SUCCESFULLY");
    }

    private static void addEchipa() {
        scanner.nextLine();
        //clearScreen();
        EchipaEntity echipa = new EchipaEntity();
        System.out.println("ADD ECHIPA");
        System.out.print("NUME ECHIPA:");
        String nume = scanner.nextLine();
        nume = nume.toUpperCase();
        System.out.print("NR. PUNCTE:");
        int nrPuncte = scanner.nextInt();
        scanner.nextLine();
        System.out.print("GOLAVERAJ:");
        String golaveraj = scanner.nextLine();
        echipa.setNume(nume);
        echipa.setPuncte(nrPuncte);
        echipa.setGolaveraj(golaveraj);

        EchipaDao movieDao = new EchipaDao();
        movieDao.create(echipa);
        System.out.println("ECHIPA ADDED SUCCESFULLY");
    }

    public static void showMenu() {
        System.out.println("1.ADD ECHIPA");
        System.out.println("2.ADD MECI");
        System.out.println("3.STATISTICA ECHIPA");
        System.out.println("4.LEADERBOARD");
        System.out.println("0.EXIT");
    }

    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}