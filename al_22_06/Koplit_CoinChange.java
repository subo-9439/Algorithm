package al_22_06;

import java.util.*;

//코인체인지 알고리즘
//dp개념
/*
* target 목표와 동전의 종류가 주어졌을 때
* 만들 수 있는 모든 조합을 구해라
* ex)50, new int[]{10, 20, 50});
 * */
public class Koplit_CoinChange {

    //1차원 배열로 구현
    public long ocean1(int target, int[] type) {
        // TODO:
        Arrays.sort(type);
        long[] dp = new long[target+1];
        for (int coin = 0; coin < type.length; coin++){
            for (int j = 1; j < dp.length; j++){
                if(j - type[coin] > 0)  dp[j] = dp[j] + dp[j-type[coin]];
                else if(j - type[coin] == 0){
                    dp[j]++;
                }
            }
        }
        return dp[target];
    }

    //2차원 배열로 구현
    public long ocean2(int target, int[] type) {
        // TODO:
        Arrays.sort(type);
        long[][] dp = new long[type.length][target+1];

        for (int coinIdx = 0; coinIdx < type.length; coinIdx++){
            for (int goal = 0; goal <= target; goal++) {
                if(coinIdx == 0 && goal%type[coinIdx] == 0 && goal!=0) dp[coinIdx][goal] = 1;
                if(goal == type[coinIdx]) dp[coinIdx][goal] = 1;
            }
        }
        for (int coinIdx = 1; coinIdx < type.length; coinIdx++){
            for (int goal = 0; goal <= target; goal++){
                if(goal>=type[coinIdx]) dp[coinIdx][goal] += dp[coinIdx-1][goal] + dp[coinIdx][goal-type[coinIdx]];
                else dp[coinIdx][goal] += dp[coinIdx-1][goal];
            }
//            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[type.length-1][target];
    }

}
