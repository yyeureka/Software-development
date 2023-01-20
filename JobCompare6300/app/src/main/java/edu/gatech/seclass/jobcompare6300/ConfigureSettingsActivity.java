package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigureSettingsActivity extends AppCompatActivity {

    private EditText aysWeightEditText;
    private EditText aybWeightEditText;
    private EditText relocationStipendWeightEditText;
    private EditText retirementSavingsMatchPercentageWeightEditText;
    private EditText restrictedStockAwardWeightEditText;

    private DataModel dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configure_settings);

        dataModel = Global.getDataModel();
    
        Weights weights = dataModel.GetWeights();

        aysWeightEditText = findViewById(R.id.editAysWeight);
        aysWeightEditText.setText("" + weights.getAysWeight());

        aybWeightEditText = findViewById(R.id.editAybWeight);
        aybWeightEditText.setText("" + weights.getAybWeight());

        relocationStipendWeightEditText = findViewById(R.id.editRelocationStipendWeight);
        relocationStipendWeightEditText.setText("" + weights.getRelocationStipendWeight());

        retirementSavingsMatchPercentageWeightEditText = findViewById(R.id.editRetirementSavingsMatchPercentageWeight);
        retirementSavingsMatchPercentageWeightEditText.setText("" + weights.getRetirementSavingsMatchPercentWeight());
        
        restrictedStockAwardWeightEditText = findViewById(R.id.editRestrictedStockAwardWeight);
        restrictedStockAwardWeightEditText.setText("" + weights.getRestrictedStockAwardWeight());
    }

    public void eventHandler(View view) {
        switch (view.getId()) {
            case R.id.assignWeightsButton:

                WeightsInstantiationErrors weightsErrors = dataModel.updateWeights(
                        aysWeightEditText.getText().toString(),
                        aybWeightEditText.getText().toString(),
                        relocationStipendWeightEditText.getText().toString(),
                        retirementSavingsMatchPercentageWeightEditText.getText().toString(),
                        restrictedStockAwardWeightEditText.getText().toString(),
                        getApplicationContext());

                if (!weightsErrors.HasErrors()) {
                    Toast.makeText(ConfigureSettingsActivity.this, "Weights saved successfully",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    if (weightsErrors.HasAysError()) {
                        aysWeightEditText.setError(weightsErrors.GetAysErrorMessage());
                    }

                    if (weightsErrors.HasAybError()) {
                        aybWeightEditText.setError(weightsErrors.GetAybErrorMessage());
                    }

                    if (weightsErrors.HasRelocationStipendError()) {
                        relocationStipendWeightEditText.setError(weightsErrors.GetRelocationStipendErrorMessage());
                    }

                    if (weightsErrors.HasRetirementSavingsMatchPercentageError()) {
                        retirementSavingsMatchPercentageWeightEditText.setError(weightsErrors.GetRetirementSavingsMatchPercentageErrorMessage());
                    }

                    if (weightsErrors.HasRestrictedStockAwardError()) {
                        restrictedStockAwardWeightEditText.setError(weightsErrors.GetRestrictedStockAwardErrorMessage());
                    }
                }
        }
    }
}