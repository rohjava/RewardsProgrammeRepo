package com.charter.RewardsProgramme.Utilities;

public final class RewardsUtility {

    public static Integer calculateRewardsForPurchase(Integer cost) {


        if(cost<=50){
         return 0;
        }
        else if(cost<=100){
           return (cost-50);
        }
        else{
            int twoRewardComponent = cost-100;
            int oneRewardComponent = cost-50-twoRewardComponent;
            return (twoRewardComponent*2 + oneRewardComponent);
        }

    }

}
