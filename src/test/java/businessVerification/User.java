package businessVerification;

/**
 * @Auther ChenShuHong
 * @Date 2022-02-09 14:29
 */
public class User {
  private String id;
  private String userName ;
  private String userEmail;
  private String telPhone;

  public User() {
  }

  public User(String id, String userName, String userEmail, String telPhone) {
    this.id = id;
    this.userName = userName;
    this.userEmail = userEmail;
    this.telPhone = telPhone;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getTelPhone() {
    return telPhone;
  }

  public void setTelPhone(String telPhone) {
    this.telPhone = telPhone;
  }
}
