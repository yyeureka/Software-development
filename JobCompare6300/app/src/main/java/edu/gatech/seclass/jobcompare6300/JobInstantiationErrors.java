package edu.gatech.seclass.jobcompare6300;

public class JobInstantiationErrors {

    private static final String titleErrorMessage = "The Job Tile must be a non empty string.";
    private static final String companyErrorMessage = "The Company must be a non empty string.";
    private static final String cityErrorMessage = "The City must be a non empty string.";
    private static final String stateErrorMessage = "The State must be a non empty string.";
    private static final String costOfLivingIndexErrorMessage = "The Cost of Living Index must be an integer with three or less digits.";
    private static final String yearlySalaryErrorMessage = "The Yearly Salary must be an integer greater than or equal to zero.";
    private static final String yearlyBonusErrorMessage = "The Yearly Bonus must be an integer greater than or equal to zero.";
    private static final String retirementSavingsMatchPercentageErrorMessage = "The Retirement Savings Match Percentage must be an integer between 0 and 100 inclusive.";
    private static final String relocationStipendErrorMessage = "The Relocation Stipend must be an integer greater than or equal to zero.";
    private static final String restrictedStockAwardErrorMessage = "The Restricted Stock Award must be a number greater than or equal to zero.";

    private boolean titleError;
    private boolean companyError;
    private boolean cityError;
    private boolean stateError;
    private boolean costOfLivingIndexError;
    private boolean yearlySalaryError;
    private boolean yearlyBonusError;
    private boolean retirementSavingsMatchPercentageError;
    private boolean relocationStipendError;
    private boolean restrictedStockAwardError;

    private boolean hasErrors;

    public JobInstantiationErrors(
            boolean _titleError,
            boolean _companyError,
            boolean _cityError,
            boolean _stateError,
            boolean _costOfLivingIndexError,
            boolean _yearlySalaryError,
            boolean _yearlyBonusError,
            boolean _retirementSavingsMatchPercentageError,
            boolean _relocationStipendError,
            boolean _restrictedStockAwardError) {

        titleError = _titleError;
        companyError = _companyError;
        cityError = _cityError;
        stateError = _stateError;
        costOfLivingIndexError = _costOfLivingIndexError;
        yearlySalaryError = _yearlySalaryError;
        yearlyBonusError = _yearlyBonusError;
        retirementSavingsMatchPercentageError = _retirementSavingsMatchPercentageError;
        relocationStipendError = _relocationStipendError;
        restrictedStockAwardError = _restrictedStockAwardError;

        hasErrors = titleError ||
                companyError ||
                cityError ||
                stateError ||
                costOfLivingIndexError ||
                yearlySalaryError ||
                yearlyBonusError ||
                retirementSavingsMatchPercentageError ||
                relocationStipendError ||
                restrictedStockAwardError;
    }

    public boolean HasErrors() {
        return hasErrors;
    }

    /******************************************/

    public boolean HasTitleError() {
        return titleError;
    }

    public boolean HasCompanyError() {
        return companyError;
    }

    public boolean HasCityError() {
        return cityError;
    }

    public boolean HasStateError() {
        return stateError;
    }

    public boolean HasCostOfLivingIndexError() {
        return costOfLivingIndexError;
    }

    public boolean HasYearlySalaryError() {
        return yearlySalaryError;
    }

    public boolean HasYearlyBonusError() {
        return yearlyBonusError;
    }

    public boolean HasRetirementSavingsMatchPercentageError() {
        return retirementSavingsMatchPercentageError;
    }

    public boolean HasRelocationStipendError() {
        return relocationStipendError;
    }

    public boolean HasRestrictedStockAwardError() {
        return restrictedStockAwardError;
    }
    
    /******************************************/

    public String GetTitleErrorMessage() {
        return titleErrorMessage;
    }

    public String GetCompanyErrorMessage() {
        return companyErrorMessage;
    }

    public String GetCityErrorMessage() {
        return cityErrorMessage;
    }

    public String GetStateErrorMessage() {
        return stateErrorMessage;
    }

    public String GetCostOfLivingErrorMessage() {
        return costOfLivingIndexErrorMessage;
    }

    public String GetYearlySalaryErrorMessage() {
        return yearlySalaryErrorMessage;
    }

    public String GetYearlyBonusErrorMessage() {
        return yearlyBonusErrorMessage;
    }

    public String GetRetirementSavingsMatchPercentageErrorMessage() {
        return retirementSavingsMatchPercentageErrorMessage;
    }

    public String GetRelocationStipendErrorMessage() {
        return relocationStipendErrorMessage;
    }

    public String GetRestrictedStockAwardErrorMessage() {
        return restrictedStockAwardErrorMessage;
    }
}
