package app.service.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * User Tag class to suggest a discount for a User.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class CountDiscountTag extends TagSupport {

    private String totalOrders;

    public void setTotalOrders(String totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int doStartTag() throws JspException {
            JspWriter out = pageContext.getOut();
            double total = Double.parseDouble(totalOrders);
            double discount = total/100.0;
        try {
            out.print(discount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }


    public int doEndTag() throws JspException {
        return SKIP_BODY;
    }
}
