import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
class javaswing implements ActionListener {
    public JFrame mainInterface;
    JDialog customerSection;
    JDialog newCustomerIn;
    JDialog viewCustomerD;
    JButton customerInterface;
    JButton employeeInterface;
    JButton managementInterface;
    JButton newCustomer;
    JButton viewCustomer;
    JButton save;
    JPanel panelCustomerSection;
    Container containerNewCustomer;
    JTextArea name;
    JTextArea phoneNo;
    JTextArea roomType;
    JTextArea aadharNo;
    JTextArea paymentConfirmation;
    JTextArea noOfDays;
    JLabel nameLable;
    JLabel phoneNoLable;
    JLabel roomTypeLable;
    JLabel aadharNoLable;
    JLabel paymentConfirmationLable;
    JLabel noOfDaysLable;
    String[][] data = new String[10][10];
    JTable viewButton;
    int i=0;
    public javaswing() {
        mainInterface = new JFrame("Hotel RajBhavan");
        mainInterface.setSize(500, 500);
        mainInterface.setLayout(null);

        customerInterface = new JButton("Customer Section");
        customerInterface.addActionListener(this);
        customerInterface.setBounds(50,200,100,100);

        employeeInterface = new JButton("Employee Section");
        //employeeInterface.addActionListener(this);
        employeeInterface.setBounds(200,200,100,100);

        managementInterface = new JButton("Management Section");
        //managementInterface.addActionListener(this);
        managementInterface.setBounds(350,200,100,100);

        mainInterface.add(customerInterface);
        mainInterface.add(employeeInterface);
        mainInterface.add(managementInterface);

        mainInterface.setDefaultCloseOperation(mainInterface.EXIT_ON_CLOSE);
        mainInterface.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Customer Section")){
            setCustomerSection();
            setNewCustomer();
            setViewCustomer();
        } else if (e.getActionCommand().equals("New Customer")) {
            i++;
            setNewCustomerInput(i);
        } else if (e.getActionCommand().equals("View Customer")) {
            setViewCustomerInput();
        } else if (e.getActionCommand().equals("Save")) {
            setSave();
        }
    }
        private void setCustomerSection(){
            customerSection = new JDialog(mainInterface, "Customer Section");
            customerSection.setSize(500, 500);
            panelCustomerSection = new JPanel();
            customerSection.add(panelCustomerSection);
            customerSection.setVisible(true);
        }
        private void setNewCustomer(){
            newCustomer = new JButton("New Customer");
            newCustomer.addActionListener(this);
            newCustomer.setBounds(50,200,100,100);
            panelCustomerSection.add(newCustomer);

        }
        private void setSave(){
            data[i][0] = name.getText();
            data[i][1] = phoneNo.getText();
            data[i][2] = noOfDays.getText();
            data[i][3] = roomType.getText();
            data[i][4] = aadharNo.getText();
            data[i][5] = paymentConfirmation.getText();
            System.out.println("Data Saved Successfully");
        }
        private void setViewCustomer(){
            viewCustomer = new JButton("View Customer");
            viewCustomer.addActionListener(this);
            viewCustomer.setBounds(200, 200, 100, 100);
            panelCustomerSection.add(viewCustomer);
        }
        private void setNewCustomerInput(int i) {
            newCustomerIn = new JDialog(customerSection, "New Customer");
            newCustomerIn.setSize(500, 500);
            containerNewCustomer = newCustomerIn.getContentPane();
            containerNewCustomer.setLayout(null);
            newCustomerIn.setVisible(true);

            save = new JButton("Save");
            save.addActionListener(this);
            save.setBounds(200,30,100,40);
            containerNewCustomer.add(save);

            name = new JTextArea();
            name.setBounds(200, 100, 250, 30);
            containerNewCustomer.add(name);
            nameLable = new JLabel("Name:");
            nameLable.setBounds(30,100,150,30);
            containerNewCustomer.add(nameLable);

            phoneNo = new JTextArea();
            phoneNo.setBounds(200, 154, 250, 30);
            containerNewCustomer.add(phoneNo);
            phoneNoLable = new JLabel("Phone No.:");
            phoneNoLable.setBounds(30,154,150,30);
            containerNewCustomer.add(phoneNoLable);

            noOfDays = new JTextArea();
            noOfDays.setBounds(200, 208, 250, 30);
            containerNewCustomer.add(noOfDays);
            noOfDaysLable = new JLabel("No. of Days:");
            noOfDaysLable.setBounds(30,208,150,30);
            containerNewCustomer.add(noOfDaysLable);

            roomType = new JTextArea();
            roomType.setBounds(200, 262, 250, 30);
            containerNewCustomer.add(roomType);
            roomTypeLable = new JLabel("Room Type:");
            roomTypeLable.setBounds(30,262,150,30);
            containerNewCustomer.add(roomTypeLable);

            aadharNo = new JTextArea();
            aadharNo.setBounds(200, 316, 250, 30);
            containerNewCustomer.add(aadharNo);
            aadharNoLable = new JLabel("Aadhar No.:");
            aadharNoLable.setBounds(30,316,150,30);
            containerNewCustomer.add(aadharNoLable);

            paymentConfirmation = new JTextArea();
            paymentConfirmation.setBounds(200, 370, 250, 30);
            containerNewCustomer.add(paymentConfirmation);
            paymentConfirmationLable = new JLabel("Payment Confirmation:");
            paymentConfirmationLable.setBounds(30,370,150,30);
            containerNewCustomer.add(paymentConfirmationLable);
        }
        private void setViewCustomerInput(){
            viewCustomerD = new JDialog(customerSection, "New Customer");
            viewCustomerD.setSize(500, 500);
            String[] cols ={"Name", "Phone No.","No. of Days","Room Type","Aadhar No.","Payment Confirmation"};
            viewButton = new JTable(data, cols);
            viewCustomerD.add(new JScrollPane(viewButton));
            viewCustomerD.setVisible(true);
        }
//            customer Pratham = new customer();
//            customer Krishna = new customer();
//            customer Venkatesh = new customer();
//            customer Shiv = new customer();
//            System.out.println("Pratham Start: ");
//            customer.inputData(Pratham);
//            System.out.println("Krishna Start: ");
//            customer.inputData(Krishna);
//            System.out.println("Venkatesh Start: ");
//            customer.inputData(Venkatesh);
//            System.out.println("Shiv Start: ");
//            customer.inputData(Shiv);
//            System.out.println("Pratham Out: ");
//            customer.outputData(Pratham);


//            String[] byName = {Pratham.name, Krishna.name, Venkatesh.name, Shiv.name};
//            Arrays.sort(byName);
//            System.out.println(Arrays.toString(byName));
//
//            BigInteger[] byPhoneNo = {Pratham.phoneNo, Krishna.phoneNo, Venkatesh.phoneNo, Shiv.phoneNo};
//            Arrays.sort(byPhoneNo);
//            System.out.println(Arrays.toString(byPhoneNo));
//
//            String[] byRoomType = {Pratham.roomType, Krishna.roomType, Venkatesh.roomType, Shiv.roomType};
//            Arrays.sort(byRoomType);
//            System.out.println(Arrays.toString(byRoomType));
    }
class customer{

    String name;
    BigInteger phoneNo;
    int noOfDays;
    String roomType;
    BigInteger aadharNo;
    String paymentConfirm;

    public static void inputData(customer newCustomer){
        //Taking Input of New User and Storing them in the newCoustomer.
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");//
        String nameInp = sc.nextLine();
        System.out.print("Phone No: ");//
        BigInteger phoneNoInp = sc.nextBigInteger();
        System.out.print("Room Type: ");//
        String roomTypeInp = sc.next();
        System.out.print("No. of Days: ");//
        int noOfDaysInp = sc.nextInt();
        System.out.print("Aadhar No.: ");//
        BigInteger aadharNoInp = sc.nextBigInteger();
        System.out.print("Payment Confirmation: ");//
        String paymentConfirmInp = sc.next();

        newCustomer.name = nameInp;
        newCustomer.phoneNo = phoneNoInp;
        newCustomer.noOfDays = noOfDaysInp;
        newCustomer.roomType = roomTypeInp;
        newCustomer.aadharNo = aadharNoInp;
        newCustomer.paymentConfirm = paymentConfirmInp;
    }

    public static void outputData(customer newCustomer){
        System.out.println("Name: " + newCustomer.name);
        System.out.println("Phone no.: " + newCustomer.phoneNo);
        System.out.println("No. of Days: " + newCustomer.noOfDays);
        System.out.println("Room Type: " + newCustomer.roomType);
        System.out.println("Aadhar No.: " + newCustomer.aadharNo);
        System.out.println("Payment Confirmation: " + newCustomer.paymentConfirm);
    }

    public static void complaint(customer newCustomer){
        Scanner sc = new Scanner(System.in);
        String description = sc.nextLine();
    }

}
class Employee{
    int attended;
    public static void attendence(Employee employeeName){
        Scanner sc = new Scanner(System.in);
        String attendencew = sc.next();
        if (attendencew.equals("P")){
            employeeName.attended = employeeName.attended+1;
        }
        return;

    }
}
public class Main {
    public static void main(String[] args) {
        javaswing rajBhavan = new javaswing();
    }
}