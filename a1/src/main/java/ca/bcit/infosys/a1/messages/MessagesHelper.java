package ca.bcit.infosys.a1.messages;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Helper class used for retrieving localized messages from resource bundles.
 * <p/>
 * http://docs.oracle.com/javaee/6/tutorial/doc/bnaxw.html
 * 
 * @author shsu
 * @version 0.2
 */
public class MessagesHelper implements Serializable {

    /**
     * Gets the messages from the message properties.
     * 
     * @param key
     *            the key
     * @param locale
     *            the locale
     * @return the messages
     */
    public static String getMessages(String key, Locale locale) {
        return ResourceBundle.getBundle("ca.bcit.infosys.a1.messages", locale)
                .getString(key);
    }
}
