import java.util.*;

public class ZigZagAppointmentReordering {
    public static List<Integer> zigZagOrder(List<Integer> appointments) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = appointments.size() - 1;
        while (left <= right) {
            if (left == right) {
                result.add(appointments.get(left));
            } else {
                result.add(appointments.get(left));
                result.add(appointments.get(right));
            }
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read input as space-separated integers
        String[] tokens = sc.nextLine().trim().split("\\s+");
        List<Integer> appointments = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty())
                appointments.add(Integer.parseInt(token));
        }
        List<Integer> reordered = zigZagOrder(appointments);
        System.out.println(reordered);
    }
}