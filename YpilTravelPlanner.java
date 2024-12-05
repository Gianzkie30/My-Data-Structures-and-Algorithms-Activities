import java.util.*;

public class YpilTravelPlanner {
    // I used Adjacency list to represent the graph
    private Map<String, List<String>> citiesGraph;

    public YpilTravelPlanner() {
        citiesGraph = new HashMap<>();
    }

    // Method to add a route between two cities
    public void addRoute(String city1, String city2) {
        if (!citiesGraph.containsKey(city1)) {
            citiesGraph.put(city1, new ArrayList<String>());
        }
        if (!citiesGraph.containsKey(city2)) {
            citiesGraph.put(city2, new ArrayList<String>());
        }

        citiesGraph.get(city1).add(city2);
        citiesGraph.get(city2).add(city1);
    }

    // Method to find the shortest route between two cities using BFS
    public List<String> findShortestRoute(String startCity, String destinationCity) {
        if (!citiesGraph.containsKey(startCity) || !citiesGraph.containsKey(destinationCity)) {
            System.out.println("City not found in the graph.");
            return new ArrayList<>();
        }

        Set<String> visited = new HashSet<>();
        Map<String, String> previousCity = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>(); // Change Queue to LinkedList if Queue doesn't work

        visited.add(startCity);
        queue.add(startCity);

        while (!queue.isEmpty()) {
            String currentCity = queue.poll();

            if (currentCity.equals(destinationCity)) {
                List<String> path = new ArrayList<>();
                for (String city = destinationCity; city != null; city = previousCity.get(city)) {
                    path.add(city);
                }
                Collections.reverse(path);
                return path;
            }

            for (String neighbor : citiesGraph.get(currentCity)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    previousCity.put(neighbor, currentCity);
                }
            }
        }

        System.out.println("No route found between " + startCity + " and " + destinationCity);
        return new ArrayList<>();
    }

    // Display available routes from a city
    public void displayRoutes(String city) {
        if (citiesGraph.containsKey(city)) {
            System.out.println("Routes from " + city + ": " + citiesGraph.get(city));
        } else {
            System.out.println("City " + city + " not found.");
        }
    }

    // Method to show the main menu
    public void showMenu() {
        System.out.println("\nGian Travel Planner Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a routes");
        System.out.println("2. Display available routes from a city");
        System.out.println("3. Find the shortest route between two cities");
        System.out.println("4. Exit");
    }

    // Main method with menu-driven interface
    public static void main(String[] args) {
        YpilTravelPlanner planner = new YpilTravelPlanner();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            planner.showMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: //To enter the two city
                    System.out.print("Enter the first city: ");
                    String city1 = scanner.nextLine();
                    System.out.print("Enter the second city: ");
                    String city2 = scanner.nextLine();
                    planner.addRoute(city1, city2);
                    System.out.println("Route between " + city1 + " and " + city2 + " added.");
                    break;

                case 2: //Enter the city you've input
                    System.out.print("Enter the city to view available routes: ");
                    String city = scanner.nextLine();
                    planner.displayRoutes(city);
                    break;

                case 3:
                    System.out.print("Enter the starting city: ");
                    String startCity = scanner.nextLine();
                    System.out.print("Enter the destination city: ");
                    String destinationCity = scanner.nextLine();
                    List<String> route = planner.findShortestRoute(startCity, destinationCity);
                    if (!route.isEmpty()) {
                        System.out.println("Shortest route from " + startCity + " to " + destinationCity + ": " + route);
                    }
                    break;

                case 4:
                    System.out.println("Travel Safe. Goodbye!");
                    return;

                default:
                    System.out.println("Incorrect choice. Please try again.");
            }
        }
    }
}
