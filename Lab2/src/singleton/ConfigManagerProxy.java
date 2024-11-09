package singleton;

public class ConfigManagerProxy {
    private ConfigManager configManager;

    public ConfigManagerProxy() {
        this.configManager = ConfigManager.getInstance();
    }

    public void setFont(String font) {
        System.out.println("Setting font to: " + font);
        configManager.setFont(font);
    }

    public String getFont() {
        return configManager.getFont();
    }

    public void setTextSize(double textSize) {
        System.out.println("Setting text size to: " + textSize);
        configManager.setTextSize(textSize);
    }

    public double getTextSize() {
        return configManager.getTextSize();
    }
}
