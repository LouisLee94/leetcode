public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int res = 0;
            int amount = 0;
            for (int j = 0; j < gas.length; j++) {
                int pos = (i+j)%(gas.length);
                amount += gas[pos] - cost[pos];
                if (amount < 0) {
                    res = -1;
                    break;
                }
            }
            if (res != -1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        new GasStation().canCompleteCircuit(new int[]{1,2}, new int[]{2,1});
    }
}
