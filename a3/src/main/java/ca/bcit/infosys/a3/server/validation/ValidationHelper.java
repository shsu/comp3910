package ca.bcit.infosys.a3.server.validation;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Hibernate validator helper.
 */
public class ValidationHelper {
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = factory.getValidator();

    public static Validator getValidator() {
        return validator;
    }
}
