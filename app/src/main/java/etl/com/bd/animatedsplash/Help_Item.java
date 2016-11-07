package etl.com.bd.animatedsplash;

/**
 * Created by Zulfikar on 10/28/2016.
 */

public class Help_Item {

    private String help_question;
    private String help_answer;

    public Help_Item(String help_question, String help_answer) {
        this.help_question = help_question;
        this.help_answer = help_answer;
    }

    public String getHelp_question() {
        return help_question;
    }

    public void setHelp_question(String help_question) {
        this.help_question = help_question;
    }

    public String getHelp_answer() {
        return help_answer;
    }

    public void setHelp_answer(String help_answer) {
        this.help_answer = help_answer;
    }
}
