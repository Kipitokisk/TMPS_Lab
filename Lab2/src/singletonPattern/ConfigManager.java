package singletonPattern;

public class ConfigManager {
    private static ConfigManager instance;
    private String font;
    private double textSize;

    private ConfigManager() {
        this.font = "Arial";
        this.textSize = 14.0;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public double getTextSize() {
        return textSize;
    }

    public void setTextSize(double textSize) {
        this.textSize = textSize;
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            return new ConfigManager();
        }
        return instance;
    }
}
