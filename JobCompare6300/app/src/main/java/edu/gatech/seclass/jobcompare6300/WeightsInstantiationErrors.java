package edu.gatech.seclass.jobcompare6300;

public class WeightsInstantiationErrors {

    private static final String aysErrorMessage = "The AYS Weight must be a whole number.";
    private static final String aybErrorMessage = "The AYB Weight must be a whole number.";
    private static final String relocationStipendErrorMessage = "The Relocation Stipend Weight must be a whole number.";
    private static final String retirementSavingsMatchPercentageErrorMessage = "The Retirement Savings Match Percent Weight must be a whole number.";
    private static final String restrictedStockAwardErrorMessage = "The Restricted Stock Award Weight must be a whole number.";

    private boolean aysError;
    private boolean aybError;
    private boolean relocationStipendError;
    private boolean retirementSavingsMatchPercentageError;
    private boolean restrictedStockAwardError;
    private boolean hasErrors;

    public WeightsInstantiationErrors(
            boolean _aysError,
            boolean _aybError,
            boolean _relocationStipendError,
            boolean _retirementSavingsMatchPercentageError,
            boolean _restrictedStockAwardError) {

        aysError = _aysError;
        aybError = _aybError;
        relocationStipendError = _relocationStipendError;
        retirementSavingsMatchPercentageError = _retirementSavingsMatchPercentageError;
        restrictedStockAwardError = _restrictedStockAwardError;

        hasErrors = aysError ||
                aybError ||
                relocationStipendError ||
                retirementSavingsMatchPercentageError ||
                restrictedStockAwardError;
    }

    public boolean HasErrors() {
        return hasErrors;
    }

    public boolean HasAysError() {
        return aysError;
    }

    public boolean HasAybError() {
        return aybError;
    }

    public boolean HasRelocationStipendError() {
        return relocationStipendError;
    }

    public boolean HasRetirementSavingsMatchPercentageError() {
        return retirementSavingsMatchPercentageError;
    }

    public boolean HasRestrictedStockAwardError() {
        return restrictedStockAwardError;
    }

    public String GetAysErrorMessage() {
        return aysErrorMessage;
    }

    public String GetAybErrorMessage() {
        return aybErrorMessage;
    }

    public String GetRelocationStipendErrorMessage() {
        return relocationStipendErrorMessage;
    }

    public String GetRetirementSavingsMatchPercentageErrorMessage() {
        return retirementSavingsMatchPercentageErrorMessage;
    }

    public String GetRestrictedStockAwardErrorMessage() {
        return restrictedStockAwardErrorMessage;
    }

}
