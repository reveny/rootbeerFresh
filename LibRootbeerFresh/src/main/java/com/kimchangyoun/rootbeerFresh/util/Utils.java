package com.kimchangyoun.rootbeerFresh.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public final class Utils {

    private Utils() throws InstantiationException {
        throw new InstantiationException("This class is not for instantiation");
    }

    /**
     * In Development - an idea of ours was to check the if selinux is enforcing - this could be disabled for some rooting apps
     * Checking for selinux mode
     *
     * @return true if selinux enabled
     */
    public static boolean isSelinuxFlagInEnabled() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("getenforce");
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            reader.close();
            process.waitFor();
            return !"Enforcing".equalsIgnoreCase(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
