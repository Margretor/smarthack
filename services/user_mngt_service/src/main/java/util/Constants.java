package util;

public class Constants {
    // used in persistence package
    public static final String db = "jdbc:postgresql://localhost:5432/IonBarbu";
    public static final String dbUser = "postgres";
    public static final String dbPassw = "DB1605";
    public static final int maxConn = 60;

    // used in service package (util.PasswordHandler)
    public static final char[] hexArray = "0123456789abcdef".toCharArray();
    public static final int passwSize = 6;

    // // used in service package (Function)
    public static final String alfabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public static final int lungimeAlfabet = alfabet.length();

    //
    public static final int semestru = 2;
    public static final boolean calculeazaMedii = true;

    //
    public static final int sessionInterval = 60 * 60 * 24;

    // administration level
    public static final int administrareParinte = 1;
    public static final int administrareAdmin = 2;

    // redirectare
    public static final String redirectareParinte = "http://notalog.xyz/note?idElev=0&semestru=" + semestru;
    public static final String redirectareAdmin = "http://notalog.xyz/admin";
    public static final String loginPage = "login.html";
}
