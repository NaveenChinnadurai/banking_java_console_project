package utils;

public class encrypt {

    public static String encryptPassword(String p) {

        StringBuilder encryptedPassword = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'Z') {
                encryptedPassword.append('A');
            } else if (p.charAt(i) == 'z') {
                encryptedPassword.append('a');
            } else if (p.charAt(i) == '9') {
                encryptedPassword.append('1');
            } else if ((p.charAt(i) >= 'a' && p.charAt(i) < 'z') || ((int) p.charAt(i) > 48 && (int) p.charAt(i) < 57) || (p.charAt(i) >= 'A' && p.charAt(i) < 'Z')) {
                int a = ((int) p.charAt(i)) + 1;
                encryptedPassword.append((char) a);
            } else {
                encryptedPassword.append(p.charAt(i));
            }
        }
        return encryptedPassword.toString();
    }
}
