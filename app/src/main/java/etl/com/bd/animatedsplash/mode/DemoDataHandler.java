package etl.com.bd.animatedsplash.mode;

/**
 * Created by Zulfikar on 10/28/2016.
 */

public class DemoDataHandler {

    String full_name;
    String email;
    String gender;
    String phone_number;
    String address;
    String blood_group;
    String age;

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

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
