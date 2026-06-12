public class Main {
    public static void main(String[] args) {
    String day = "SATURDAY";
    boolean isWeekend = switch (day) {
    case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
    case "SATURDAY", "SUNDAY" -> true;
    default -> throw new IllegalArgumentException("Invalid day: " + day);
};
    System.out.println(isWeekend);
    }
}