package WebValidator;

public class WebValidatorModel {
    public boolean isValidWebAddress(String newValue) {
        boolean valid = false;
        String[] parts = newValue.split("\\.", -1);

        if (parts.length == 4) {
            valid = true;
            for (String part : parts) {
                try {
                    int value = Integer.parseInt(part);
                    if (value < 0 || value > 255) valid = false;
                } catch (NumberFormatException e) {
                    valid = false;
                }
            }
        }

        if (!valid) {
            if (parts.length >= 2) {
                valid = true;
                for (String part : parts) {
                    if (part.length() < 2) valid = false;
                }
            }
        }

        return valid;
    }

    public boolean isValidPortNumber(String newValue) {
        boolean valid = true;

        try {
            int value = Integer.parseInt(newValue);
            if (value < 1 || value > 65535) valid = false;
        } catch (NumberFormatException e) {
            valid = false;
        }

        return valid;
    }
}
