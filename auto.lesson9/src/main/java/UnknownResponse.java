import java.util.List;

public class UnknownResponse {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Data> data;
    public Support support;

    public static class Data {
        public int id;
        public String name;
        public int year;
        public String color;
        public String pantone_value;
    }

    public static class Support {
        public String url;
        public String text;
    }
}