package ucu.edu.ua.apps;

public enum FlowerColor {
    RED("#FF0000"), GREEN("#008000"), BLUE("#0000FF"),
    WHITE("#FFFFFF"), YELLOW("#FFFF00");

    private String hexColor;

    FlowerColor(String hexColor) {
        this.hexColor = hexColor;
    }

    @Override
    public String toString() {
        return hexColor;
    }
}
