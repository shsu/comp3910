package ca.bcit.infosys.a1.messages;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ResourceBundle;

/**
 * Created by shsu on 11/8/2013.
 */
@SessionScoped
public class MessagesHelper implements Serializable {

    public static String getMessages(String key) {
        ResourceBundle res = ResourceBundle.getBundle(
                "ca.bcit.infosys.a1.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        return res.getString(key);
    }
}