package menu;

public class MenuHeader {

  private final String appName;
  private final String developerName;
  private final String developerEmail;

  public MenuHeader(String appName, String developerName, String developerEmail) {
    this.appName = appName;
    this.developerName = developerName;
    this.developerEmail = developerEmail;
  }

  public String generateHeader() {
    StringBuilder result = new StringBuilder();
    result.append(appName).append("\n");
    for (int i = 0; i < appName.length(); i++) {
      result.append("-");
    }
    result.append("\nDeveloped by: ")
        .append(developerName)
        .append(" - ")
        .append(developerEmail)
        .append("\n");
    return result.toString();
  }
}
