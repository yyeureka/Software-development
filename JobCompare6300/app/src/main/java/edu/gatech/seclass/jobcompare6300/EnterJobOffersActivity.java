package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnterJobOffersActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText companyEditText;
    private EditText cityEditText;
    private EditText stateEditText;
    private EditText costOfLivingIndexEditText;
    private EditText yearlySalaryEditText;
    private EditText yearlyBonusEditText;
    private EditText retirementSavingsMatchPercentageEditText;
    private EditText relocationStipendEditText;
    private EditText restrictedStockAwardEditText;

    private DataModel dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_job_offers);
        titleEditText = findViewById(R.id.editTitle);
        companyEditText = findViewById(R.id.editCompany);
        cityEditText = findViewById(R.id.editCity);
        stateEditText = findViewById(R.id.editState);
        costOfLivingIndexEditText = findViewById(R.id.editCostOfLivingIndex);
        yearlySalaryEditText = findViewById(R.id.editYearlySalary);
        yearlyBonusEditText = findViewById(R.id.editYearlyBonus);
        retirementSavingsMatchPercentageEditText = findViewById(R.id.editRetirementSavingsMatchPercentage);
        relocationStipendEditText = findViewById(R.id.editRelocationStipend);
        restrictedStockAwardEditText = findViewById(R.id.editRestrictedStockAward);
        dataModel = Global.getDataModel();
    }

    private void clearForm() {
        titleEditText.getText().clear();
        companyEditText.getText().clear();
        cityEditText.getText().clear();
        stateEditText.getText().clear();
        costOfLivingIndexEditText.getText().clear();
        yearlySalaryEditText.getText().clear();
        yearlyBonusEditText.getText().clear();
        retirementSavingsMatchPercentageEditText.getText().clear();
        relocationStipendEditText.getText().clear();
        restrictedStockAwardEditText.getText().clear();
    }

    public void eventHandler(View view) {
        switch (view.getId()) {
            case R.id.saveOfferDetails:
                JobInstantiationErrors jobErrors = dataModel.addJobOffer(
                        titleEditText.getText().toString(),
                        companyEditText.getText().toString(),
                        cityEditText.getText().toString(),
                        stateEditText.getText().toString(),
                        costOfLivingIndexEditText.getText().toString(),
                        yearlySalaryEditText.getText().toString(),
                        yearlyBonusEditText.getText().toString(),
                        retirementSavingsMatchPercentageEditText.getText().toString(),
                        relocationStipendEditText.getText().toString(),
                        restrictedStockAwardEditText.getText().toString(),
                        this);

                if (!jobErrors.HasErrors()) {
                    Toast.makeText(EnterJobOffersActivity.this, "Job was saved successfully",
                            Toast.LENGTH_SHORT).show();
                    clearForm();
                }
                else {
                    if(jobErrors.HasTitleError()) {
                        titleEditText.setError(jobErrors.GetTitleErrorMessage());
                    }
                
                    if(jobErrors.HasCompanyError()) {
                        companyEditText.setError(jobErrors.GetCompanyErrorMessage());
                    }
                
                    if(jobErrors.HasCityError()) {
                        cityEditText.setError(jobErrors.GetCityErrorMessage());
                    }
                
                    if(jobErrors.HasStateError()) {
                        stateEditText.setError(jobErrors.GetStateErrorMessage());
                    }
                
                    if(jobErrors.HasCostOfLivingIndexError()) {
                        costOfLivingIndexEditText.setError(jobErrors.GetCostOfLivingErrorMessage());
                    }
                
                    if(jobErrors.HasYearlySalaryError()) {
                        yearlySalaryEditText.setError(jobErrors.GetYearlySalaryErrorMessage());
                    }
                
                    if(jobErrors.HasYearlyBonusError()) {
                        yearlyBonusEditText.setError(jobErrors.GetYearlyBonusErrorMessage());
                    }

                    if(jobErrors.HasRetirementSavingsMatchPercentageError()) {
                        retirementSavingsMatchPercentageEditText.setError(jobErrors.GetRetirementSavingsMatchPercentageErrorMessage());
                    }

                    if(jobErrors.HasRelocationStipendError()) {
                        relocationStipendEditText.setError(jobErrors.GetRelocationStipendErrorMessage());
                    }

                    if(jobErrors.HasRestrictedStockAwardError()) {
                        restrictedStockAwardEditText.setError(jobErrors.GetRestrictedStockAwardErrorMessage());
                    }
                }
                break;
            case R.id.cancelButton:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}