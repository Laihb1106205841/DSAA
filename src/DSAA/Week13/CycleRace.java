package DSAA.Week13;

public class CycleRace {

    public static int minimalStops(int[] distances, int raceDistance, int runDistance) {
        int remainDistance = raceDistance;
        int currentPosition = 0;
        int stops = 0;
        while (currentPosition < remainDistance){
            int farthestReach = currentPosition; // Farthest reachable station position
            int maxDistance = 0; // Maximum distance

            // the farthest reachable station from current position
            while (distances[farthestReach] - distances[currentPosition] <= raceDistance
                    && distances[farthestReach + 1] <= raceDistance) {
                farthestReach++;
                maxDistance = distances[farthestReach];
            }

            currentPosition = farthestReach; // Move to the farthest reachable station
            remainDistance = maxDistance + raceDistance - distances[currentPosition]; // Update remaining distance
            stops++; // Increment the number of stops
        }
        return stops;
    }

    public static void main(String[] args) {
        int[] distances = { 10, 20, 30, 40 }; // Distances between stations
        int totalDistance = 120; // Total race distance
        int runDistance = 90;

        int minStops = minimalStops(distances, totalDistance,runDistance);
        System.out.println("Minimum number of stops: " + minStops);
    }
}
