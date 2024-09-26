public class Main {
    public static void main(String[] args) {
        FitnessTracker ft = new FitnessTracker("Adisson", 0, 0, 0, 100);
        ft.ToString();
        System.out.println();

        ft.CheckGoal();
        ft.SetStepGoal(1000);
        ft.CheckGoal();
        System.out.println();

        ft.AddSteps(100);
        ft.CheckGoal();
        System.out.println();

        ft.AddSteps(900);
        ft.CheckGoal();
        System.out.println();

        ft.AddSteps(100);
        ft.CheckGoal();
        System.out.println();

        ft.CalculateDistanceWalked();
        ft.CalculateCaloriesBurned();
        ft.UpdateHeartRate(120);
        ft.ToString();
        System.out.println();

        try {
            ft.AddSteps(-1);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            ft.UpdateHeartRate(-1);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println();
        ft.ResetDailyStats();
        ft.ToString();
    }
}
