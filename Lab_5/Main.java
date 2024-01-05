interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}
// Abstract class implementing WaterConservationSystem
abstract class RainySeasonConservation implements WaterConservationSystem {
}
class CityBlockConservation extends RainySeasonConservation {

    public int calculateTrappedWater(int[] blockHeights) {
        int n = blockHeights.length;
        if (n <= 2) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.max(0, Math.min(leftMax[i], rightMax[i]) - blockHeights[i]);
        }
        return trappedWater;
    }
}
// Main class to test the water conservation system
public class Main {
    public static void main(String[] args) {
        // Test Case 1
        int[] blocks1 = {3, 0, 0, 2, 0, 4};
        WaterConservationSystem system1 = new CityBlockConservation();
        System.out.println("Test Case 1: " + system1.calculateTrappedWater(blocks1)); 
        // Test Case 2
        int[] blocks2 = {3, 0, 2, 0, 4};
        WaterConservationSystem system2 = new CityBlockConservation();
        System.out.println("Test Case 2: " + system2.calculateTrappedWater(blocks2));
    }
}