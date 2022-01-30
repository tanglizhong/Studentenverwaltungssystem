package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<Student> student = new ArrayList<>();  //Studentenlist erstellen
    private static Scanner eingabe = new Scanner(System.in);        // Scanner zum Erhalten der Eingabe aus dem Konsole
    private static Scanner eingabe1 = new Scanner(System.in);       // Scanner zum Erhalten der Eingabe von Namen
    private static char[] SEX = {'m','w','d'};
    static {
        Student s1 = new Student(20220129,"zhong gang" ,'m', 25, "18654622351@gmail.com","18562565121");
        student.add(s1);
        Student s2 = new Student(20220130,"Sen Zang" ,'w', 18, "185456465351@163.com","151754646431");
        student.add(s2);
        Student s3 = new Student(20220131,"Sa wang" ,'w', 20, "2903856465810@126.com","1835461312");
        student.add(s3);
        Student s4 = new Student(20220201,"San Li" ,'m', 22, "273988663889@qq.com","017856447212");
        student.add(s4);
    }                                                   // ein Paar Studenten initialisieren
    public static void main(String[] args) {
        hauptseite();
    }
    private static void hauptseite(){
        Boolean schleife = true;
        while(schleife){
            try{
                System.out.println();
                System.out.println("********** Studentenverwaltungssystem **********");
                System.out.println("1 --- Studenten hinzufügen\n2 --- Studenten verändern\n3 --- Studenten löschen\n4 --- Studentenliste\n5 --- Exit");
                System.out.println("************************************************");
                System.out.print("Geben Sie bitte Ihre Option ein: ");
                Integer option = eingabe.nextInt();
                switch (option){
                    case 1:
                        add();
                        break;
                    case 2:     //Studenten Verändern
                        System.out.print("Matrikelnummer: ");
                        Integer studyId1 = eingabe.nextInt();
                        Student studentClass1 = suche(studyId1);  // an der Matrikelnummer erkennen
                        change(studentClass1);
                        break;
                    case 3:  // Studenten Löschen
                        System.out.print("Matrikelnummer: ");  // an der Matrikelnummer erkennen
                        Integer studyId2 = eingabe.nextInt();
                        Student studentClass2 = suche(studyId2);
                        remove(studentClass2);
                        break;
                    case 4: //Studentenlist
                        studentenList();
                        break;
                    case 5: // Exit
                        schleife = false;
                        break;
                    default:
                        System.out.println("Bitte Geben Sie von 1 - 5 ein!!!");
                }
            }
            catch (Exception error){
                System.out.println("Bitte geben Sie nur Zahlen ein!!!");
                eingabe.next();//clear scanner wrong input -- leeren Scanner falsche Eingabe


            }
        }
    }                          //Hauptprogramm
    private static void add(){
        System.out.print("Matrikelnummer: ");
        Integer id = eingabe.nextInt();
        System.out.print("Name: ");
        String name = eingabe1.nextLine();
        System.out.print("Age: ");
        Integer age = eingabe.nextInt();
        System.out.print("Sex: ");
        String s = eingabe.next();
        char sex = s.charAt(0); //first Zeichen von s
        if(sexUrteilen(sex)){
            System.out.print("E-Mail Addresse: ");
            String addr = eingabe.next();
            System.out.print("Tel: ");
            String tel = eingabe.next();
            System.out.println("Die neue Information ist schon hinzugefügt");
            Student neuStudent = new Student(id,name,sex,age,addr,tel);
            student.add(neuStudent);
        }
        else {
            System.out.println("Geben Sie bitte nur 'm','w',oder 'd' ein!!!");
        }
    }                                 //Studenten hinzufügen
    private static Student suche(Integer matrikelnummer){
        for (int i = 0; i < student.size(); i++) {
            Student studentClass = student.get(i);
            if(studentClass.getId()==matrikelnummer){
                return studentClass;
            }
        }
        return null;
    }      //Suche nach der Matrikelnummer
    private static void change(Student studentClass){
        if(studentClass != null){
            String id = "Matrikelnummer",name ="Name",age="Age",sex="Sex",addr="E-Mail Addresse",tel="Telefonnummer";
            System.out.println();
            System.out.println("********************************* Studentenlist **************************************************");
            System.out.println(String.format("%15s",id)+ "\t" + String.format("%15s",name)+"\t   "+String.format("%2s",age)+"\t  "+String.format("%1s",sex)+"\t"+String.format("%25s",addr)+"\t"+String.format("%20s",tel));
            System.out.println(String.format("%15d",studentClass.getId())+"\t" + String.format("%15s",studentClass.getName())+"\t    "+String.format("%2s",studentClass.getAge())+"\t    "+String.format("%1s",studentClass.getSex())+"\t"+String.format("%25s",studentClass.getAddr())+"\t"+String.format("%20s",studentClass.getTel()));
            System.out.println("************************************* fertig gezeigt *********************************************");
            boolean schleife = true;
            while(schleife){
                System.out.println("Welche Daten möchten Sie verändern?\n1 --- Matrikelnummer\n2 --- Name\n3 --- Age\n4 --- Sex\n5 --- E-Mail Addresse\n6 --- Telefonnummer\n7 --- Zurück");
                System.out.print("Geben Sie Ihre Option ein: ");
                int option = eingabe.nextInt();
                switch (option){
                    case 1:
                        System.out.print("Geben Sie die neue Matrikelnummer ein: ");
                        Integer neuId = eingabe.nextInt();
                        studentClass.setId(neuId);
                        break;
                    case 2:
                        System.out.print("Geben Sie den neuen Name ein: ");
                        String neuName = eingabe1.nextLine();
                        studentClass.setName(neuName);
                        break;
                    case 3:
                        System.out.print("Geben Sie die neue Alter ein: ");
                        Integer neuAge = eingabe.nextInt();
                        studentClass.setAge(neuAge);
                        break;
                    case 4:
                        System.out.print("Geben Sie das neue Geschlecht ein: ");
                        String s = eingabe.next();
                        char neuSex = s.charAt(0);
                        if(sexUrteilen(neuSex)){
                            studentClass.setSex(neuSex);
                        }
                        else {
                            System.out.println("Geben Sie bitte nur 'm','w',oder 'd' ein!!!");
                        }
                        break;
                    case 5:
                        System.out.print("Geben Sie das neue E-Mail Addresse ein: ");
                        String neuAddr = eingabe.next();
                        studentClass.setAddr(neuAddr);
                        break;
                    case 6:
                        System.out.print("Geben Sie die neue Telefonnummer ein: ");
                        String neuTel = eingabe.next();
                        studentClass.setTel(neuTel);
                        break;
                    case 7:
                        schleife = false;
                        break;
                    default:
                        System.out.println("ungültige Eingabe!!!");

                }
            }
        }
        else{
            System.out.println("Diese Matrikelnummer existiert nicht!!");
        }
    }          //Studenteninfo verändern
    private static void remove(Student studentClass){
        if(studentClass != null){
            student.remove(studentClass);
            System.out.println("Alle Daten dieses Students sind gelöscht");
        }
    }          //Studenteninfo löschen
    private static void studentenList(){
        String key="ID",id = "Matrikelnummer",name ="Name",age="Age",sex="Sex",addr="E-Mail Addresse",tel="Telefonnummer";
        System.out.println();
        System.out.println("********************************* Studentenlist *******************************************************");
        System.out.println(String.format("%2s",key)+"\t"+String.format("%15s",id)+ "\t" + String.format("%15s",name)+"\t   "+String.format("%2s",age)+"\t  "+String.format("%1s",sex)+"\t"+String.format("%25s",addr)+"\t"+String.format("%20s",tel));
        for (int i = 0; i < student.size(); i++) {
            Student studentClass = student.get(i);
            System.out.println(String.format("%2d",i+1)+"\t"+String.format("%15d",studentClass.getId())+"\t" + String.format("%15s",studentClass.getName())+"\t    "+String.format("%2s",studentClass.getAge())+"\t    "+String.format("%1s",studentClass.getSex())+"\t"+String.format("%25s",studentClass.getAddr())+"\t"+String.format("%20s",studentClass.getTel()));
        }
        System.out.println("************************************* fertig gezeigt **************************************************");
    }                       //Studentenlist
    private static boolean sexUrteilen(char sex){
        boolean urteilen=true;
        for (int i = 0; i < SEX.length; i++) {
            if(sex == SEX[i]){
                urteilen = true;
                break;
            }
            else {urteilen = false;}
        }
        return urteilen;
    }
}





