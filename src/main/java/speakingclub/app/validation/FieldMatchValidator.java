package speakingclub.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Objects;
import speakingclub.app.exception.FieldsMatchException;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String password;
    private String repeatPassword;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        password = constraintAnnotation.password();
        repeatPassword = constraintAnnotation.repeatPassword();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Field passwordField = value.getClass().getDeclaredField(password);
            passwordField.setAccessible(true);
            Object passwordValue = passwordField.get(value);
            Field repeatPasswordField = value.getClass().getDeclaredField(repeatPassword);
            repeatPasswordField.setAccessible(true);
            Object repeatPasswordValue = repeatPasswordField.get(value);
            return Objects.equals(passwordValue, repeatPasswordValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new FieldsMatchException("Password and Repeat password fields do not match");
        }
    }
}
