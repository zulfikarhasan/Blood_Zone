package etl.com.bd.animatedsplash;

/**
 * Created by Zulfikar on 10/28/2016.
 */

public class TipsForDonar_Item {

    private String s_number;
    private String tips;

    public TipsForDonar_Item(String s_number, String tips) {
        this.s_number = s_number;
        this.tips = tips;
    }

    public String getS_number() {
        return s_number;
    }

    public void setS_number(String s_number) {
        this.s_number = s_number;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
