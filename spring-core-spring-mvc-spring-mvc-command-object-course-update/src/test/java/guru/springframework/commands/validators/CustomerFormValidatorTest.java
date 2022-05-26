package guru.springframework.commands.validators;

import guru.springframework.commands.CustomerForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by jt on 12/24/15.
 */
public class CustomerFormValidatorTest {

    private Validator validator;
    private CustomerForm customerForm;
    private Errors errors;

    @BeforeEach
    public void setup(){
        validator = new CustomerFormValidator();
        customerForm = new CustomerForm();
        errors = new BeanPropertyBindingResult(customerForm, "customerForm");
    }

    @Test
    public void testNoErrors(){
        customerForm.setPasswordText("password");
        customerForm.setPasswordTextConf("password");

        validator.validate(customerForm, errors);

        assert !errors.hasErrors();
    }

    @Test
    public void testHasErrors(){
        customerForm.setPasswordText("password");
        customerForm.setPasswordTextConf("asdf");

        validator.validate(customerForm, errors);

        assert errors.hasErrors();
    }
}
