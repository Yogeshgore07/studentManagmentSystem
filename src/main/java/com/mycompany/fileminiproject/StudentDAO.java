package com.mycompany.fileminiproject;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.*;
import java.io.ObjectOutputStream;
import java.util.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xssf.usermodel.*;

public class StudentDAO {

    static void DisplayAllStudent() throws Exception {
        int is = 0;
        ArrayList<student> s = new ArrayList<>();
        if (new File("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt").exists() && new File("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt").length() > 0) {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt"));
            s = (ArrayList<student>) obj.readObject();
            obj.close();
        }
        for (student x : s) {
            is = 1;
            System.out.println("Name : " + x.getName());
            System.out.println("Roll : " + x.getRoll());
            System.out.println("Marks : " + x.getMarks());
            System.out.println("-----------------");
        }

        if (is == 0) {
            System.out.println("No student Found");
        }

    }

    static void AddStudent() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Name : ");
        String name = sc.nextLine();
        System.out.print("Enter the Roll No. : ");
        int roll = sc.nextInt();

        System.out.print("Enter the Marks (must be in Range of 1 to 100): ");
        double marks = sc.nextDouble();
        File f = new File("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt");
        ArrayList<student> s = new ArrayList<>();
        if (f.exists() && f.length() > 0) {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(f));
            s = (ArrayList<student>) obj.readObject();
            obj.close();
        }
        if (name.length() == 0) {
            System.out.println("Name should not be empty,Can't Add Student..");
            return;
        }
        if (marks > 100 || marks <= 0) {
            System.out.println("Invalid Marks, Can't Add Student..");
            return;
        }
        for (student x : s) {
            if (x.getRoll() == roll) {
                System.out.println("Cannot Add Student Roll Number Already Exists...");
                return;
            }
        }

        System.out.println("Adding Student..");
        s.add(new student(roll, name, marks));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt"));
        oos.writeObject(s);
        oos.close();
        System.out.println("Student Added Succesfully...");
    }

    static void SearchStudent() throws Exception {
        int roll;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Roll no. : ");
        roll = sc.nextInt();
        ArrayList<student> s = new ArrayList<>();
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt"));
        s = (ArrayList<student>) obj.readObject();
        int found = 0;
        for (student x : s) {
            if (x.getRoll() == roll) {
                found = 1;
                System.out.println("Student Found..");
                System.out.println("Name : " + x.getName());
                System.out.println("Roll : " + x.getRoll());
                System.out.println("Marks : " + x.getMarks());
                return;
            }
        }

        if (found == 0) {
            System.out.println("Student Dosent Exists....");
        }

    }

    static void UpdateStudentName(int roll) throws Exception {
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt");
        int found = 0;
        String name = "";
        ArrayList<student> s = new ArrayList<>();

        if (f.exists() && f.length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            s = (ArrayList<student>) ois.readObject();
            ois.close();
        }

        for (student x : s) {
            if (x.getRoll() == roll) {
                System.out.println("Student Found..");
                System.out.println("Current Roll : " + x.getRoll());
                System.out.println("Current Name : " + x.getName());
                System.out.print("Enter New Name : ");
                name = sc.nextLine();
                x.setName(name);
                System.out.println("Name Updated Succesfully..");
                found = 1;
                break;
            }
        }

        ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(f));
        oss.writeObject(s);
        oss.close();

        if (found == 0) {
            System.out.println("Student Not Found...");
        }
    }

    static void UpdateStudentMarks(int roll) throws Exception {
        int found = 0;
        double marks;
        Scanner sc = new Scanner(System.in);
        ArrayList<student> s = new ArrayList();
        File f = new File("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt");

        if (f.exists() && f.length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            s = (ArrayList<student>) ois.readObject();
            ois.close();
        }

        for (student a : s) {
            if (a.getRoll() == roll) {
                found = 1;
                System.out.println("Student Found..");
                System.out.println("Current Roll : " + a.getRoll());
                System.out.println("Current Name : " + a.getName());
                System.out.println("Current Marks : " + a.getMarks());
                System.out.print("Enter New Marks :");
                marks = sc.nextDouble();
                a.setMarks(marks);
                System.out.println("Marks Updated Succesfully..");
                break;
            }
        }

        ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(f));
        oss.writeObject(s);
        oss.close();

        if (found == 0) {
            System.out.println("Student Not Found...");
        }
    }

    static void DeleteStudent(int roll) throws Exception {
        int found = 0;

        ArrayList<student> s = new ArrayList<>();
        File f = new File("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt");
        if (f.exists() && f.length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            s = (ArrayList<student>) ois.readObject();
            ois.close();
        }

        for (student x : s) {
            if (x.getRoll() == roll) {
                found = 1;
                s.remove(x);
                System.out.println("Student Removed Succesfully..");
                break;
            }
        }

        ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(f));
        oss.writeObject(s);
        oss.close();

        if (found == 0) {
            System.out.println("Student Not Found...");
        }
    }

    static void SortStudentByMarks() throws Exception {
        File f = new File("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt");
        ArrayList<student> s = new ArrayList<>();

        if (f.exists() && f.length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            s = (ArrayList<student>) ois.readObject();
            ois.close();
        }
        if (s.isEmpty()) {
            System.out.println("No students to Sort..");
            return;
        }
        s.sort((a, b) -> Double.compare(b.marks, a.marks));

        for (student a : s) {
            System.out.println("Student Name : " + a.getName());
            System.out.println("Student Roll : " + a.getRoll());
            System.out.println("Student Marks: " + a.getMarks());
            System.out.println("--------------------------------");
        }
    }

    static void SeeTopper() throws Exception {

        File f = new File("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt");
        ArrayList<student> s = new ArrayList<>();

        if (f.exists() && f.length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            s = (ArrayList<student>) ois.readObject();
            ois.close();
        }
        if (s.isEmpty()) {
            System.out.println("No students to Sort..");
            return;
        }
        s.sort((a, b) -> Double.compare(b.marks, a.marks));

        student topper = s.getFirst();

        System.out.println("Topper Information : ");
        System.out.println("Name : " + topper.getName());
        System.out.println("Roll : " + topper.getRoll());
        System.out.println("Marks : " + topper.getMarks());
    }

    static void StudentCount() throws Exception {
        File f = new File("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt");
        ArrayList<student> s = new ArrayList<>();

        if (f.exists() && f.length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            s = (ArrayList<student>) ois.readObject();
            ois.close();
        }

        System.out.println("Total Student : " + s.size());

    }

    static void ExportData() throws Exception {

        System.out.println("1.txt");
        System.out.println("2.pdf");
        System.out.println("3.Excel");
        System.out.print("Selcet format : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\gore2\\Desktop\\Super30\\ex.txt"));
        ArrayList<student> s = new ArrayList<>();
        s = (ArrayList<student>) ois.readObject();
        switch (choice) {
            case 1:
                File f = new File("C:\\Users\\gore2\\Desktop\\Super30\\Output.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                for (student x : s) {
                    bw.write(x.getRoll() + " " + x.getName() + " " + x.getMarks());
                    bw.newLine();
                }
                  bw.close();
                  
                System.out.println("Exported txt Success..");
                break;
            case 2:
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\gore2\\Desktop\\Super30\\students.pdf"));
                doc.open();
                for (student a : s) {
                    doc.add(new Paragraph(
                            a.getRoll() + " " + a.getName() + " " + a.getMarks()
                    ));
                }
                doc.close();
                System.out.println("Pdf Exported Success..");
                break;
            case 3:
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("Students");
                int rowNum = 0;
                for (student a : s) {
                    XSSFRow row = sheet.createRow(rowNum++);

                    row.createCell(0).setCellValue(a.getRoll());
                    row.createCell(1).setCellValue(a.getName());
                    row.createCell(2).setCellValue(a.getMarks());
                }

                wb.write(new FileOutputStream("C:\\Users\\gore2\\Desktop\\Super30\\Output.xlsx"));

                wb.close();
                ois.close();

                System.out.println("Exported to Excel successfully");
                break;
            default:
                System.out.println("Enter Correct choice..");
        }

    }
}
