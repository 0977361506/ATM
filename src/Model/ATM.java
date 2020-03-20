package Model;

public class ATM {
  private String card_name;
  private Integer money;
  private String pass;
public String getPass() {
	return pass;
}
public ATM(String card_name, String pass) {
	super();
	this.card_name = card_name;
	this.pass = pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getCard_name() {
	return card_name;
}
public void setCard_name(String card_name) {
	this.card_name = card_name;
}
public Integer getMoney() {
	return money;
}
public void setMoney(Integer money) {
	this.money = money;
}
public ATM(String card_name, Integer money, String pass) {
	super();
	this.card_name = card_name;
	this.money = money;
	this.pass = pass;
}
public ATM(String card_name, Integer money) {
	super();
	this.card_name = card_name;
	this.money = money;
}
public ATM() {
	super();
}
  
}
