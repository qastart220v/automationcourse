package config;

public class Environment {

    public static final String HOST = System.getProperty("hostname");

    public static final String FRONT_BASE_URL_LOCAL = "http://localhost/litecart/";
    public static final String FRONT_BASE_URL_PROD = "http://demo.litecart.net/";



    public static String getEnvironment() {
        if (HOST.equals("local")) {
            return FRONT_BASE_URL_LOCAL;
        } else if (HOST.equals("prod")) {
            return FRONT_BASE_URL_PROD;
        }
        return HOST;
    }
}
