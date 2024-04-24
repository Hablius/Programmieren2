package OneTimePad;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CipherModel {
    private List<Integer> oneTimePad;
    private int currentPosition = 0;

    public CipherModel(String padFilePath) throws Exception {
        oneTimePad = Files.lines(Paths.get(padFilePath))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .flatMapToInt(String::chars)
                .boxed()
                .collect(Collectors.toList());
    }

    public String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (currentPosition >= oneTimePad.size()) {
                throw new IllegalStateException("One-Time Pad exhausted.");
            }
            int messageValue = character - 32;
            int padValue = oneTimePad.get(currentPosition++) - 32;
            char encryptedChar = (char) (((messageValue + padValue) % 95) + 32);
            encrypted.append(encryptedChar);
        }
        return encrypted.toString();
    }

    public String decrypt(String encryptedMessage) {
        StringBuilder decrypted = new StringBuilder();
        for (char character : encryptedMessage.toCharArray()) {
            if (currentPosition >= oneTimePad.size()) {
                throw new IllegalStateException("One-Time Pad exhausted.");
            }
            int encryptedValue = character - 32;
            int padValue = oneTimePad.get(currentPosition++) - 32;
            char decryptedChar = (char) (((encryptedValue - padValue + 95) % 95) + 32);
            decrypted.append(decryptedChar);
        }
        return decrypted.toString();
    }

    public void resetPad() {
        currentPosition = 0;
    }
}
