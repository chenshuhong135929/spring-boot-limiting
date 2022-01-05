package DesignPatterns.facade;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 14:32
 */
public class Test {

  public static void main(String[] args) {
    Company company = openCompany("恒美集团");
    System.out.println(company.toString());
  }

  public static Company   openCompany(String name){

    AdminOfIndustry adminOfIndustry =new AdminOfIndustry();
    Bank bank = new Bank();
    Taxation taxation= new Taxation();

    Company company = adminOfIndustry.register(name);
    String bankAccount  = bank.openAccount(company.getCompanyId());
    company.setBankAccount(bankAccount);
    String taxCode  = taxation.applyTaxCode(company.getCompanyId());
    company.setTaxCode(taxCode);
      return company;
  }
}
