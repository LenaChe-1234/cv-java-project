package config;

import java.io.InputStream;
import java.util.Properties;

public final class Config {
<<<<<<< HEAD

    private static final Properties P = new Properties();

    static {

        try (InputStream in = Config.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (in != null) {
                P.load(in);
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to load config.properties",
                    e
            );
        }
    }

    private Config() {
    }

    private static String get(String key, String def) {

        String sys = System.getProperty(key);

        if (sys != null && !sys.isBlank()) {
            return sys;
        }

        String env =
                System.getenv(
                        key.replace('.', '_').toUpperCase()
                );

        if (env != null && !env.isBlank()) {
            return env;
        }

=======
    private static final Properties P = new Properties();

    static {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in != null) P.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private static String get(String key, String def) {
        String sys = System.getProperty(key);
        if (sys != null && !sys.isBlank()) return sys;
        String env = System.getenv(key.replace('.', '_').toUpperCase());
        if (env != null && !env.isBlank()) return env;
>>>>>>> origin/main
        return P.getProperty(key, def);
    }

    public static String baseUrl() {
<<<<<<< HEAD
        return get(
                "baseUrl",
//                "https://juice-shop.herokuapp.com"
                "http://localhost:3000"
        );
    }

    public static String browser() {
        return get(
                "browser",
                "chrome"
        );
    }

    public static boolean headless() {
        return Boolean.parseBoolean(
                get("headless", "false")
        );
    }

    public static long timeoutMs() {
        return Long.parseLong(
                get("timeoutMs", "10000")
        );
    }

    public static String remoteUrl() {
        return get("remoteUrl", "");
    }
}
=======
        return get("baseUrl", "http://localhost:8080");
    }
}


>>>>>>> origin/main
