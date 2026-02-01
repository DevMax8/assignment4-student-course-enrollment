public interface Validatable<T> {
    void validate(T obj);

    default void requireNonBlank(String v, String field) {
        if (v == null || v.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " cannot be blank");
        }
    }
}
