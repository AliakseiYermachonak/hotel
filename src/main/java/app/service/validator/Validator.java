package app.service.validator;

public interface Validator<T> {
    boolean validate(T ob);
}
