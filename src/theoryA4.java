import java.util.ArrayList;
/*
Q1

 */
public class theoryA4 {
    /*
		Let opt denote the optimal solution, as well as the name of our memoization table
		I. subproblem. opt(i) = "the number of robots killed on day i to maximize the total number of robots killed"
		II. recurrence. OPT[i] = max{OPT[i-j] + Math.min(function[j], robots[i])}
		III. answer to original question: all OPT[i] i.e. the number of robots killed each day;
		IV. Base cases: opt(0) = 0.
						for all i < 0, OPT(i) = 0, there are no negative days.
		V. implementation: in our implementation, we initialized OPT(0)
	*/
    public static int[] findRobotsKilled(int[] robots, int[] function) // method that decides when to shoot in order to maximize the number of killed robots
    {
        int[] OPT = new int[robots.length]; //OPT is a 1-D array where we save the number of robots killed each day
        OPT[0] = 0;
        for(int i = 1; i < robots.length; i++) {
            int maxOPT = 0;
            for(int j = 2; j <= i; j++) {
                if(OPT[i-j] + Math.min(function[j], robots[i]) > maxOPT) {
                    maxOPT = OPT[i-j] + Math.min(function[j], robots[i]);
                }
            }
            OPT[i] = maxOPT;
        }
        return OPT;
    }
    public static void main(String[] args)
    {
        int[] robots = new int[]{1, 10, 10, 1}; //example: robots coming daily
        int[] function = new int[]{1, 2, 4, 8}; //example: EMP function
        int[] results = findRobotsKilled(robots, function);
        ArrayList<Integer> shootingDays = new ArrayList<Integer>();
        for(int i=0; i<robots.length;i++)
        {
            if(results[i] != 0)
            {
                shootingDays.add(i);
            }
        }
        for(int i=0; i<shootingDays.size() -1;i++)
        {
            System.out.print(shootingDays.get(i)+1 + ", ");
        }
        System.out.print(shootingDays.get(shootingDays.size()-1)+1 + ".");
    }
}
