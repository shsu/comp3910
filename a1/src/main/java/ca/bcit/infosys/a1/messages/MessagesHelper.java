package ca.bcit.infosys.a1.messages;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Helper class used for retrieving localized messages from resource bundles.
 * <p/>
 * http://docs.oracle.com/javaee/6/tutorial/doc/bnaxw.html
 */
public class MessagesHelper implements Serializable {

    public static String getMessages(String key, Locale locale) {
        return ResourceBundle.getBundle("ca.bcit.infosys.a1.messages", locale).getString(key);
    }
}