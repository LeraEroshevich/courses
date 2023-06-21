public enum Colors {
    BLUE("rgba(0, 0, 255, 1)");
    private final String code;
    Colors(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}