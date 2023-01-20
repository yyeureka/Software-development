package edu.gatech.seclass.jobcompare6300;

public class Weights {
    private int aysWeight;
    private int aybWeight;
    private int relocationStipendWeight;
    private int retirementSavingsMatchPercentWeight;
    private int restrictedStockAwardWeight;

    private boolean aysWeightError;
    private boolean aybWeightError;
    private boolean relocationStipendWeightError;
    private boolean retirementSavingsMatchPercentWeightError;
    private boolean restrictedStockAwardWeightError;

    private WeightsInstantiationErrors errorsObject;

    private int getWholeNumber(String s) {
        return Integer.parseInt(s);
    }

    public Weights() {
        aysWeight = 1;
        aybWeight = 1;
        relocationStipendWeight = 1;
        retirementSavingsMatchPercentWeight = 1;
        restrictedStockAwardWeight = 1;
    }

    public Weights(
            String ays,
            String ayb,
            String relocationStipend,
            String retirementSavingsMatchPercent,
            String restrictedStockAward) {

        try {
            aysWeight = getWholeNumber(ays);
            aysWeightError = false;
        } catch (Exception e) {
            aysWeightError = true;
        }

        try {
            aybWeight = getWholeNumber(ayb);
            aybWeightError = false;
        } catch (Exception e) {
            aybWeightError = true;
        }

        try {
            relocationStipendWeight = getWholeNumber(relocationStipend);
            relocationStipendWeightError = false;
        } catch (Exception e) {
            relocationStipendWeightError = true;
        }

        try {
            retirementSavingsMatchPercentWeight = getWholeNumber(retirementSavingsMatchPercent);
            retirementSavingsMatchPercentWeightError = false;
        } catch (Exception e) {
            retirementSavingsMatchPercentWeightError = true;
        }

        try {
            restrictedStockAwardWeight = getWholeNumber(restrictedStockAward);
            restrictedStockAwardWeightError = false;
        } catch (Exception e) {
            restrictedStockAwardWeightError = true;
        }

        errorsObject = new WeightsInstantiationErrors(
                aysWeightError,
                aybWeightError,
                relocationStipendWeightError,
                retirementSavingsMatchPercentWeightError,
                restrictedStockAwardWeightError);
    }

    public WeightsInstantiationErrors GetErrors() {
        return errorsObject;
    }

    public int getAysWeight() {
        return aysWeight;
    }

    public int getAybWeight() {
        return aybWeight;
    }

    public int getRelocationStipendWeight() {
        return relocationStipendWeight;
    }

    public int getRetirementSavingsMatchPercentWeight() {
        return retirementSavingsMatchPercentWeight;
    }

    public int getRestrictedStockAwardWeight() {
        return restrictedStockAwardWeight;
    }
}