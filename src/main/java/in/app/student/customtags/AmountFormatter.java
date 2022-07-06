package in.app.student.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Ref links
 * http://www.journaldev.com/2099/jsp-custom-tags-example-tutorial
 * https://www.tutorialspoint.com/jsp/jsp_custom_tags.htm
 * http://viralpatel.net/blogs/tutorial-create-custom-tag-library-taglib-in-jsp/
 */
public class AmountFormatter extends SimpleTagSupport {

    private String number;
    private String format;

    public AmountFormatter() {
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public void setFormat(String format) {
        this.format = format;
    }


    @Override
    public void doTag() throws JspException, IOException {
        String output = "";

        if (number != null && !number.trim().equals("")) {
            String arr[] = number.split("\\.");
            if (arr.length == 2) {
                if (arr[1].equals("0")) {
                    output = arr[0];
                } else {
                    output = number;
                }
            }
        }

        getJspContext().getOut().write(output);

    }

}
