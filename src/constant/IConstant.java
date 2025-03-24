package constant;

public interface IConstant {
    String VALID_ID = "^[a-zA-Z0-9]+$";
    String REGULAR_STRING = "^[a-zA-Z\\s]+$";
    String VALID_DATE = "^\\d{4}-\\d{2}-\\d{2}$";
    String VALID_EMAIL = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$";
    String VALID_PHONE_NUMBER = "^0[0-9]{9}$";
    String UP_DOWN = "^(?i)(up|down)$";
}
