package temp;

import java.util.Collection;

public abstract class Checker {

    public static void isNull(Object o) {
        if (o == null) {
            throw new ValidationException("Input object is null");
        }
    }

    public static void checker(Object o, Object o1) {
        if (o instanceof String) {
            if (((String) o).isEmpty()) {
                throw new ValidationException("Input cannot be empty");
            }
        } else if (o == null) {
            throw new ValidationException("Input object is null");
        } else if (o instanceof Integer) {
            if ((Integer) o < 0) {
                throw new ValidationException("Input number cannot be less or equal 0");
            }
        } else if (o.equals(o1)) {
            throw new ValidationException(o + " is already set");
        }
    }

    public static void checkerForAddAndRemove(Object o, Collection<?> objects) {
        if (o instanceof String) {
            if (((String) o).isEmpty()) {
                throw new ValidationException("Input cannot be empty");
            }
        }
        if (o instanceof Integer) {
            if ((Integer) o < 0) {
                throw new ValidationException("Input number cannot be less or equal 0");
            }
        }
        if (o == null) {
            throw new ValidationException("Input object is null");
        }
        if (!objects.contains(o)) {
            throw new ValidationException(o + " already exists in the collection");
        }
    }

    public static void checker(Collection<?> objects, Collection<?> objects1) {

        if (objects == null) {
            throw new ValidationException("Input cannot be null");
        }
        if (objects.contains(null)) {
            throw new ValidationException("There is null object in input collection");
        }
        for (Object o : objects) {
            if (objects1.contains(o)) {
                throw new ValidationException(o.toString() + " is already in the collection");
            }
        }
    }

    public static void throwValExp(String s) {
        throw new ValidationException(s);
    }

    static class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }
}