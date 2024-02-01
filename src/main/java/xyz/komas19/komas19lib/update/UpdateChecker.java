package xyz.komas19.komas19lib.update;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UpdateChecker {
    private final String latestVersionUrl;

    public UpdateChecker(String latestVersionUrl) {
        this.latestVersionUrl = latestVersionUrl;
    }

    public boolean isNewVersionAvailable(String currentVersion) {
        try {
            String latestVersion = getLatestVersion(); // Retrieve latest version from the URL
            return compareVersions(currentVersion, latestVersion) < 0;
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Assume no update available in case of error
        }
    }




    // Simple version comparison method assuming versions are in x.y.z format
    private int compareVersions(String version1, String version2) {
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");
        for (int i = 0; i < Math.min(v1Parts.length, v2Parts.length); i++) {
            int part1 = Integer.parseInt(v1Parts[i]);
            int part2 = Integer.parseInt(v2Parts[i]);
            if (part1 != part2) {
                return Integer.compare(part1, part2);
            }
        }
        return Integer.compare(v1Parts.length, v2Parts.length);
    }

    public String getLatestVersion() throws IOException {
        URL url = new URL(latestVersionUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String latestVersion = reader.readLine();
        reader.close();
        return latestVersion;
    }
}
