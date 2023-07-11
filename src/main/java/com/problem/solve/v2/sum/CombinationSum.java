package com.problem.solve.v2.sum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> wrapper = new ArrayList<>();
        helper(wrapper, candidates, candidates.length, target, 0, 0, new ArrayList<>());
        return wrapper;
    }

    private void helper(List<List<Integer>> wrapper, int[] arr, int n, int target, int currSum, int i, List<Integer> probableAnsList) {
        if (i >= n) {
            // Base-case 1
            if (currSum == target)
                wrapper.add(new ArrayList<>(probableAnsList));
            /* cloning arraylist (adding new Arraylist) because java references same object here which we are in future going to mutate and if the cloned list is not added then mutated changes will be seen here as well. */
            return;
        }
        if (currSum > target) // base-case 2
            return;

        // Including the i-th indexed number
        currSum += arr[i];
        probableAnsList.add(arr[i]);
        helper(wrapper, arr, n, target, currSum, i, probableAnsList);

        // excluding the i-th indexed number
        currSum -= arr[i];
        probableAnsList.remove(probableAnsList.size() - 1);
        helper(wrapper, arr, n, target, currSum, i + 1, probableAnsList);

        return;
    }

    public List<List<Integer>> combinationSumV2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int sum = 0;
        for (int i=0;i<candidates.length;i++) {
            if(target >= candidates[i]) {
                if (target % candidates[i] == 0) {
                    List<Integer> ncom = new ArrayList<>();
                    for (int k = 0; k < target / candidates[i]; k++)
                        ncom.add(candidates[i]);
                    res.add(ncom);
                }
                if (candidates[i] < target) {
                    sum = sum + candidates[i];
                    if (sum == target) {
                        combination.add(candidates[i]);
                        res.add(combination);
                        combination =  new ArrayList<>();
                        sum = 0;
                    } else if(sum < target) {
                        int diff = target - sum;
                        for (int k = 0; k < combination.size(); k++) {
                            sum = sum + combination.get(k);
                            if(sum > target) {
                                sum = sum - combination.get(k);
                            }
                            //else if(sum) {

                            //}
                        }
                        combination.add(candidates[i]);
                    } else if(sum > target) {
                        sum = sum - candidates[i];
                        int targetDiff = target - sum;

                        //loop around all previous values
                        for (int k = 0; k < combination.size(); k++) {
                            sum = sum + combination.get(k);
                            if(sum > target) {
                                sum = sum - combination.get(k);
                            }
                            //else if(sum) {

                            //}
                        }
                    } else {// if sum i greater than target
                        //search for small element to make equal to target
                        if(combination.size()>0){

                        } else { // reset sum and combination
                            sum = 0;
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}
