package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button compareJobsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compareJobsButton = findViewById(R.id.compareJobOffersButton);

        DataModel dataModel = Global.getDataModel();
        dataModel.GatherPersistedData(this);
        ArrayList<Job> jobs = dataModel.GetJobsForListing();
        if(jobs.size() < 2){
            toggleCompareJobOffersButton(false);
        }
    }

    private void toggleCompareJobOffersButton(boolean b) {
        compareJobsButton.setEnabled(b);
    }

    public void eventHandler(View view) {
        switch (view.getId()) {
            case R.id.enterCurrentJobButton:
                startActivity(new Intent(this, EnterCurrentJobDetailsActivity.class));
                break;
            case R.id.enterJobOffersButton:
                startActivity(new Intent(this, EnterJobOffersActivity.class));
                break;
            case R.id.configureSettingsButton:
                startActivity(new Intent(this, ConfigureSettingsActivity.class));
                break;
            case R.id.compareJobOffersButton:
                if (compareJobsButton.isEnabled()) {
                    startActivity(new Intent(this, CompareJobOffersActivity.class));
                }
                break;
        }
    }


}
