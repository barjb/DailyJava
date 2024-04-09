package j22;

public class StringTemplates {
    public static void main(String[] args) {
        String name = "jacob";
        int age = 29;
//        String json = "{" + "\"name\": \"" + name + "\",\n" + "\"age\": " + age + ",\n" + "}";
        String json = STR."""
                {
                "name": "\{name}",
                "age": \{age},
                }
                """;
        System.out.println(json);
    }
}
