package edu.gatech.seclass.jobcompare6300;

public class Settings {

    private int id;
    private static int retirementBenefitsWeight = 1;
    private static int yearlyBonusWeight = 1;
    private static int yearlySalaryWeight = 1;

    public Settings(int yearlySalaryWeight, int yearlyBonusWeight, int retirementBenefitsWeight) {
        Settings.retirementBenefitsWeight = retirementBenefitsWeight;
        Settings.yearlyBonusWeight = yearlyBonusWeight;
        Settings.yearlySalaryWeight = yearlySalaryWeight;
    }

    public Settings(int id, int yearlySalaryWeight, int yearlyBonusWeight,
            int retirementBenefitsWeight) {
        this.id = id;
        Settings.retirementBenefitsWeight = retirementBenefitsWeight;
        Settings.yearlyBonusWeight = yearlyBonusWeight;
        Settings.yearlySalaryWeight = yearlySalaryWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getYearlySalaryWeight() {
        return yearlySalaryWeight;
    }

    public static void setYearlySalaryWeight(int yearlySalaryWeight) {
        Settings.yearlySalaryWeight = yearlySalaryWeight;
    }

    public static int getYearlyBonusWeight() {
        return yearlyBonusWeight;
    }

    public static void setYearlyBonusWeight(int yearlyBonusWeight) {
        Settings.yearlyBonusWeight = yearlyBonusWeight;
    }

    public static int getRetirementBenefitsWeight() {
        return retirementBenefitsWeight;
    }

    public static void setRetirementBenefitsWeight(int retirementBenefitsWeight) {
        Settings.retirementBenefitsWeight = retirementBenefitsWeight;
    }

    @Override
    public String toString() {
        return "Weight{" +
                ", yearlySalaryWeight=" + yearlySalaryWeight +
                ", yearlyBonusWeight=" + yearlyBonusWeight +
                ", retirementBenefitsWeight=" + retirementBenefitsWeight +
                '}';
    }
}
