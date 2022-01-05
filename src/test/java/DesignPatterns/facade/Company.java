package DesignPatterns.facade;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 14:30
 */
public class Company {
  String companyId;
  String bankAccount;
  String taxCode;
  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public Company(String companyId) {
    this.companyId = companyId;
  }

  public String getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }

  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  @Override
  public String toString() {
    return "Company{" +
        "companyId='" + companyId + '\'' +
        ", bankAccount='" + bankAccount + '\'' +
        ", taxCode='" + taxCode + '\'' +
        '}';
  }
}
