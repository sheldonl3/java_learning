package ui;

import bean.Customer;
import service.CustomerList;
import util.CMUtility;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        Customer cu=new Customer("asd",'m',23,"24324235","aewqe@gamil.com");
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
                    System.out.println("quit Y/N?");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        flag = false;
                    }
            }
        }
    }

    private void addNewCustomer() {
        System.out.println("addNewCustomer");

    }

    private void modifyCustomer() {
        System.out.println("modifyCustomer");
    }

    private void deleteCustomer() {
        System.out.println("deleteCustomer");
    }

    private void listAllCustomers() {
        System.out.println("--------------Customers List----------------");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("no Customer");
        } else {
            System.out.println("no\tname\tgrade\tage\t\ttele\t\tmail");
            Customer[] cut = customerList.getAllCustomers();
            for(int i=0;i<cut.length;i++){
                System.out.println((i+1)+"\t"+cut[i].getName()+"\t\t"+ cut[i].getGender()+"\t\t"+cut[i].getAge()+"\t\t"+cut[i].getPhone()+"\t"+cut[i].getEmail());

            }
        }
        System.out.println("-----------Customers List End---------------");
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
