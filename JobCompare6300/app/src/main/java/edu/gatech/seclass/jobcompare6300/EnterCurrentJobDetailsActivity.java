package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnterCurrentJobDetailsActivity extends AppCompatActivity {

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
        setContentView(R.layout.enter_current_job_details);

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
        Job currentJob = dataModel.GetCurrentJob();

        if (currentJob != null) {
            titleEditText.setText(currentJob.getTitle());
            companyEditText.setText(currentJob.getCompany());
            cityEditText.setText(currentJob.getCity());
            stateEditText.setText(currentJob.getState());
            costOfLivingIndexEditText.setText("" + currentJob.getCostOfLivingIndex());
            yearlySalaryEditText.setText("" + currentJob.getYearlySalary());
            yearlyBonusEditText.setText("" + currentJob.getYearlyBonus());
            retirementSavingsMatchPercentageEditText.setText("" + currentJob.getRetirementSavingsMatchPercentage());
            relocationStipendEditText.setText("" + currentJob.getRelocationStipend());
            restrictedStockAwardEditText.setText("" + currentJob.getRestrictedStockAward());
        }
    }
    
    public void eventHandler(View view) {
        switch (view.getId()) {
            case R.id.saveJobDetailsButton:
                JobInstantiationErrors jobErrors = dataModel.updateCurrentJob(
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
                    Toast.makeText(EnterCurrentJobDetailsActivity.this, "Job was saved successfully",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    if (jobErrors.HasTitleError()) {
                        titleEditText.setError(jobErrors.GetTitleErrorMessage());
                    }

                    if (jobErrors.HasCompanyError()) {
                        companyEditText.setError(jobErrors.GetCompanyErrorMessage());
                    }

                    if (jobErrors.HasCityError()) {
                        cityEditText.setError(jobErrors.GetCityErrorMessage());
                    }

                    if (jobErrors.HasStateError()) {
                        stateEditText.setError(jobErrors.GetStateErrorMessage());
                    }

                    if (jobErrors.HasCostOfLivingIndexError()) {
                        costOfLivingIndexEditText.setError(jobErrors.GetCostOfLivingErrorMessage());
                    }

                    if (jobErrors.HasYearlySalaryError()) {
                        yearlySalaryEditText.setError(jobErrors.GetYearlySalaryErrorMessage());
                    }

                    if (jobErrors.HasYearlyBonusError()) {
                        yearlyBonusEditText.setError(jobErrors.GetYearlyBonusErrorMessage());
                    }

                    if (jobErrors.HasRetirementSavingsMatchPercentageError()) {
                        retirementSavingsMatchPercentageEditText
                                .setError(jobErrors.GetRetirementSavingsMatchPercentageErrorMessage());
                    }

                    if (jobErrors.HasRelocationStipendError()) {
                        relocationStipendEditText.setError(jobErrors.GetRelocationStipendErrorMessage());
                    }

                    if (jobErrors.HasRestrictedStockAwardError()) {
                        restrictedStockAwardEditText.setError(jobErrors.GetRestrictedStockAwardErrorMessage());
                    }
                }
                break;
            case R.id.mainMenuButton:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}