package etl.com.bd.animatedsplash;

/**
 * Created by Zulfikar on 10/27/2016.
 */

public class FAQs_Item  {
    private String serial_number;
    private String question;
    private String ans;
    private String Answer;

    //Constroctor
    public FAQs_Item(String serial_number,String question,String ans,String Answer){
        this.serial_number = serial_number;
        this.question = question;
        this.ans = ans;
        this.Answer = Answer;

    }


    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
