/**
 * Fitness Tracker class for Module 4.
 * This Fitness Tracker class has the ability to track you steps, distance
 * walked and heart rate over a day. It can then be reset daily.
 *
 * @author Adisson Buchanan
 */
public class FitnessTracker {
    public static final double KILOMETER_PER_STEP = 0.000762;
    public static final double CALORIES_PER_STEP = 0.04;

    private String Name;
    private int DailySteps;
    private double DistanceWalked;
    private double CaloriesBurned;
    private int HeartRate;
    private int StepGoal = 0;

    /**
     * Default constructor for FitnessTracker object.
     * Sets all properties to 0 and leaves the name as an empty string.
     */
    FitnessTracker() {
        Name = "";
        DailySteps = 0;
        DistanceWalked = 0;
        CaloriesBurned = 0;
        HeartRate = 0;
    }

    /**
     * Parameterized constructor for FitnessTracker object.
     *
     * @param name                  Name of the user.
     * @param dailySteps            The amount of steps taken since reset.
     * @param distanceWalked        The distance walked since reset.
     * @param caloriesBurned        The total calories burned since reset.
     * @param heartRate             The current heart rate of the user.
     */
    FitnessTracker(String name, int dailySteps, double distanceWalked, double caloriesBurned, int heartRate) {
        Name = name;
        DailySteps = dailySteps;
        DistanceWalked = distanceWalked;
        CaloriesBurned = caloriesBurned;
        HeartRate = heartRate;
    }

    /**
     * Adds the amount of steps passed to the FitnessTracker.
     *
     * @param steps Amount of steps to add. Must be positive
     */
    public void AddSteps(int steps) {
        if (steps > 0) {
            DailySteps += steps;
        } else {
            throw new IllegalArgumentException("Steps must be greater than 0");
        }
    }

    /**
     * Calculates the distance walked based on the amount of steps since reset.
     * Updates the private distance walked variable.
     */
    public void CalculateDistanceWalked() {DistanceWalked = DailySteps * KILOMETER_PER_STEP;}

    /**
     * Calculates the amount of calories burned based on the amount of steps
     * taken since reset. Updates the private calories burned variable.
     */
    public void CalculateCaloriesBurned() {CaloriesBurned = DailySteps * CALORIES_PER_STEP;}

    /**
     * Updates the current heart rate of the user.
     *
     * @param newHeartRate New heart rate to be updated. Must be positive.
     */
    public void UpdateHeartRate(int newHeartRate) {
        if (newHeartRate > 0) {
            HeartRate = newHeartRate;
        } else {
            throw new IllegalArgumentException("HeartRate must be greater than 0");
        }
    }

    /**
     * Resets the amount of daily steps, distance walked and calories burned to 0.
     * Heart rate is not a daily stat.
     */
    public void ResetDailyStats() {
        DailySteps = 0;
        DistanceWalked = 0;
        CaloriesBurned = 0;
    }

    /**
     * Prints a summary of the current stats of the user to the console.
     */
    public void ToString() {
        System.out.println("Name: " + Name);
        System.out.println("DailySteps: " + DailySteps);
        System.out.println("DistanceWalked: " + DistanceWalked + "Km");
        System.out.println("CaloriesBurned: " + CaloriesBurned);
        System.out.println("HeartRate: " + HeartRate);
        System.out.println("StepGoal: " + StepGoal);
    }

    /**
     * Sets a goal for the user for the amount of steps passed.
     *
     * @param stepGoal amount of steps to set as the goal for the user.
     *                 Must be positive.
     */
    public void SetStepGoal(int stepGoal) {
        if (StepGoal >= 0) {
            StepGoal = stepGoal;
        } else {
            throw new IllegalArgumentException("StepGoal must be a positive integer");
        }
    }

    /**
     * Checks the goal set by the user and prints a message to the console.
     */
    public void CheckGoal() {
        if (StepGoal != 0) {
            if (DailySteps > StepGoal) {
                System.out.printf("Good job, you beat your goal by %s steps! %n", DailySteps - StepGoal);
            } else if (DailySteps == StepGoal) {
                System.out.println("Good job, you met your step goal!");
            } else {
                System.out.printf("You haven't met your goal yet. Keep trying! You need %s more steps %n", StepGoal - DailySteps);
            }
        } else {
            System.out.println("You haven't set a step goal yet.");
        }
    }
}
