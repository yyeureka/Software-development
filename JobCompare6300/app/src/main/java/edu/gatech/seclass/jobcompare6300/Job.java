package edu.gatech.seclass.jobcompare6300;

import static edu.gatech.seclass.jobcompare6300.Settings.*;

import android.util.Log;

public class Job {
    private String title;
    private String company;
    private String city;
    private String state;
    private int costOfLivingIndex;
    private int yearlySalary;
    private int yearlyBonus;
    private int retirementSavingsMatchPercentage;
    private int relocationStipend;
    private int restrictedStockAward;
    private boolean isCurrentJob;

    private double AYB;
    private double AYS;
    private double jobRankScore;

    private JobInstantiationErrors errorsObject;

    private boolean validateString(String s) {
        return s.length() > 0;
    }

    private int getWholeNumber(String s) {
        return Integer.parseInt(s);
    }

    private boolean validateIntegerBounds(int x, int min, int max) {
        return (max >= x) && (x >= min);
    }

    private boolean validatePositiveWholeNumber(int x) {
        return x >= 0;
    }

    private boolean validatePositiveNumber(double x) {
        return x >= 0;
    }

    public Job(
            String title,
            String company,
            String city,
            String state,
            String _costOfLivingIndex,
            String _yearlySalary,
            String _yearlyBonus,
            String _retirementSavingsMatchPercent,
            String _relocationStipend,
            String _restrictedStockAward,
            boolean _isCurrentJob,
            Weights currentWeights) {

        boolean titleError = !validateString(title);
        boolean companyError = !validateString(company);
        boolean cityError = !validateString(city);
        boolean stateError = !validateString(state);

        int costOfLivingIndex = 0;
        boolean costOfLivingIndexError = false;
        try {
            costOfLivingIndex = getWholeNumber(_costOfLivingIndex);
            costOfLivingIndexError = !validateIntegerBounds(costOfLivingIndex, 0, 999);
        } catch (Exception e) {
            costOfLivingIndexError = true;
        }

        int yearlySalary = 0;
        boolean yearlySalaryError = false;
        try {
            yearlySalary = getWholeNumber(_yearlySalary);
            yearlySalaryError = !validatePositiveWholeNumber(yearlySalary);
        } catch (Exception e) {
            yearlySalaryError = true;
        }

        int yearlyBonus = 0;
        boolean yearlyBonusError = false;
        try {
            yearlyBonus = getWholeNumber(_yearlyBonus);
            yearlyBonusError = !validatePositiveWholeNumber(yearlyBonus);
        } catch (Exception e) {
            yearlyBonusError = true;
        }

        int retirementSavingsMatchPercent = 0;
        boolean retirementSavingsMatchPercentError = false;
        try {
            retirementSavingsMatchPercent = getWholeNumber(_retirementSavingsMatchPercent);
            retirementSavingsMatchPercentError = !validateIntegerBounds(retirementSavingsMatchPercent, 0, 100);
        } catch (Exception e) {
            retirementSavingsMatchPercentError = true;
        }

        int relocationStipend = 0;
        boolean relocationStipendError;
        try {
            relocationStipend = getWholeNumber(_relocationStipend);
            relocationStipendError = !validatePositiveWholeNumber(relocationStipend);
        } catch (Exception e) {
            relocationStipendError = true;
        }

        int restrictedStockAward = 0;
        boolean restrictedStockAwardError;
        try {
            restrictedStockAward = getWholeNumber(_restrictedStockAward);
            restrictedStockAwardError = !validateIntegerBounds(restrictedStockAward, 0, 100);
        } catch (Exception e) {
            restrictedStockAwardError = true;
        }

        errorsObject = new JobInstantiationErrors(
                titleError,
                companyError,
                cityError,
                stateError,
                costOfLivingIndexError,
                yearlySalaryError,
                yearlyBonusError,
                retirementSavingsMatchPercentError,
                relocationStipendError,
                restrictedStockAwardError);

        if (!errorsObject.HasErrors()) {
            this.AYB = yearlyBonus / (((double) costOfLivingIndex) / 100);
            this.AYS = yearlySalary / (((double) costOfLivingIndex) / 100);
            this.title = title;
            this.company = company;
            this.city = city;
            this.state = state;
            this.costOfLivingIndex = costOfLivingIndex;
            this.yearlySalary = yearlySalary;
            this.yearlyBonus = yearlyBonus;
            this.retirementSavingsMatchPercentage = retirementSavingsMatchPercent;
            this.relocationStipend = relocationStipend;
            this.restrictedStockAward = restrictedStockAward;
            this.isCurrentJob = _isCurrentJob;
            this.calculateJobScore(currentWeights);
        }
    }

    public void calculateJobScore(Weights weights) {
        if (weights != null) {
            jobRankScore = AYS * weights.getAysWeight() +
                    AYB * weights.getAybWeight() +
                    relocationStipend * weights.getRelocationStipendWeight() +
                    (retirementSavingsMatchPercentage * AYS / 100) * weights.getRetirementSavingsMatchPercentWeight() +
                    (restrictedStockAward / 4) * weights.getRestrictedStockAwardWeight();
            jobRankScore /= (weights.getAysWeight() + weights.getAybWeight()
                    + weights.getRelocationStipendWeight()
                    + weights.getRetirementSavingsMatchPercentWeight()
                    + weights.getRestrictedStockAwardWeight());

        } else {
            jobRankScore = 0;
        }
    }

    public JobInstantiationErrors getErrors() {
        return errorsObject;
    }

    public double getJobRankScore() {
        return jobRankScore;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getLocation() {
        return city+" , "+state;
    }

    public int getCostOfLivingIndex() {
        return costOfLivingIndex;
    }

    public int getYearlySalary() {
        return yearlySalary;
    }

    public int getYearlyBonus() {
        return yearlyBonus;
    }

    public int getRetirementSavingsMatchPercentage() {
        return retirementSavingsMatchPercentage;
    }

    public int getRelocationStipend() {
        return relocationStipend;
    }

    public int getRestrictedStockAward() {
        return restrictedStockAward;
    }

    @Override
    public String toString() {
        String s = title + " at " + company;

        if (isCurrentJob) {
            return "> "+ s;
        }
        else {
            return s;
        }
    }
}
