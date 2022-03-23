package ui;

import bean.Customer;
import service.CustomerList;
import util.CMUtility;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer cu = new Customer("asd", 'm', 23, "24324235", "aewqe@gamil.com");
        customerList.addCustomer(cu);
    }

    /**
     * enter the program MainMenu
     */
    public void enterMainMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n\n_______________Customer Management_________________");
            System.out.println("             1.add New Customer");
            System.out.println("             2.modify Customer");
            System.out.println("             3.delete Customer");
            System.out.println("             4.list All Customers");
            System.out.println("             5.quit");
            System.out.print("             chose 1-5:");
            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("quit Y/N?");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        flag = false;
                    }
            }
        }
    }

    private void addNewCustomer() {
        System.out.println("-----------------add New Customer------------");
        System.out.print("name:");
        String name = CMUtility.readString(10);
        System.out.print("gender:");
        char gender = CMUtility.readChar();
        System.out.print("age:");
        int age = CMUtility.readInt();
        System.out.print("tele:");
        String tele = CMUtility.readString(13);
        System.out.print("email:");
        String email = CMUtility.readString(30);

        Customer cu = new Customer(name, gender, age, tele, email);
        boolean res = customerList.addCustomer(cu);
        if (res) {
            System.out.println("-----------------add success------------");
        } else {
            System.out.println("-----------------add unsuccess!------------");
        }
    }

    private void modifyCustomer() {
        System.out.println("--------------modify Customer----------------");
        Customer cu;
        int num;
        for (; ; ) {
            System.out.print("modify Customer ...(-1 quit):");
            num = CMUtility.readInt();
            if (num == -1) {
                return;
            }
            cu = customerList.getCustomer(num - 1);
            if (cu == null) {
                System.out.print("no Customer to modify!");
            } else {
                break;
            }
        }
        System.out.println("name(" + cu.getName() + "):");
        String name = CMUtility.readString(10, cu.getName());
        System.out.println("gender(" + cu.getGender() + "):");
        char gender = CMUtility.readChar(cu.getGender());
        System.out.println("age(" + cu.getAge() + "):");
        int age = CMUtility.readInt(cu.getAge());
        System.out.println("Phone(" + cu.getPhone() + "):");
        String tele = CMUtility.readString(13, cu.getPhone());
        System.out.println("email(" + cu.getEmail() + "):");
        String email = CMUtility.readString(30, cu.getEmail());

        Customer newCu = new Customer(name, gender, age, tele, email);
        boolean res = customerList.replaceCustomer(num-1,newCu);
        if(res){
            System.out.println("------------------modify success----------------");
        }else {
            System.out.println("----------------modify unsuccess-----------------");
        }

    }

    private void deleteCustomer() {
        System.out.println("--------------Delete Customer--------------");
        int num;
        for(;;) {
            System.out.print("select customer:");
            num = CMUtility.readInt();
            if (num == -1) {
                return;
            }
            Customer cu=customerList.getCustomer(num-1);
            if(cu==null){
                System.out.println("no this people");
            }else {
                break;
            }
        }
        System.out.print("Sure to delete(Y/N)");
        char isDelete=CMUtility.readConfirmSelection();
        if(isDelete=='Y'){
            boolean isSuccess=customerList.deleteCustomer(num-1);
            if(isSuccess==true){
                System.out.println("Delete Customer Success");
            }else {
                System.out.println("Wrong in Customer Success");
            }
        }else {
            return;
        }
    }

    private void listAllCustomers() {
        System.out.println("--------------Customers List----------------");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("no Customer");
        } else {
            System.out.println("no\tname\tgrade\tage\t\ttele\t\tmail");
            Customer[] cut = customerList.getAllCustomers();
            for (int i = 0; i < cut.length; i++) {
                System.out.println((i + 1) + "\t" + cut[i].getName() + "\t\t" + cut[i].getGender() + "\t\t" + cut[i].getAge() + "\t\t" + cut[i].getPhone() + "\t" + cut[i].getEmail());

            }
        }
        System.out.println("-----------Customers List End---------------");
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
