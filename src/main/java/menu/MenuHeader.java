package menu;

public class MenuHeader {
    private String appName;
    private String developerName;
    private String developerEmail;

    public MenuHeader(String appName, String developerName, String developerEmail) {
        this.appName = appName;
        this.developerName = developerName;
        this.developerEmail = developerEmail;
    }

    public String generateHeader() {
        String result = "";
        result += appName + "\n";
        for (int i = 0; i < appName.length(); i++) {
            result += "-";
        }
        result += "\nDeveloped by: " + developerName + " - " + developerEmail + "\n";
        return result;
    }
}
