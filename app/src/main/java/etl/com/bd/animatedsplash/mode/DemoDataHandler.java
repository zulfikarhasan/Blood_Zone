package etl.com.bd.animatedsplash.mode;

/**
 * Created by Zulfikar on 10/28/2016.
 */

public class DemoDataHandler {

    String full_name;
    String phone_number;
    String address;

    public DemoDataHandler(){

    }

//    public DemoDataHandler(String address, String email, String username) {
//        Address = address;
//        this.email = email;
//        this.username = username;
//    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
