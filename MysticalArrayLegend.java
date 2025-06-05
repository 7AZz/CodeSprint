import java.util.*;

public class MysticalArrayLegend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] nge = new int[n]; // index of next greater element
        Arrays.fill(nge, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        int[] nse = new int[n]; // index of next smaller element
        Arrays.fill(nse, -1);
        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int nextG = nge[i];
            if (nextG == -1) {
                res[i] = -1;
            } else {
                int nextS = nse[nextG];
                if (nextS == -1)
                    res[i] = -1;
                else
                    res[i] = arr[nextS];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i]);
            if (i != n - 1)
                System.out.print(" ");
        }
    }
}
