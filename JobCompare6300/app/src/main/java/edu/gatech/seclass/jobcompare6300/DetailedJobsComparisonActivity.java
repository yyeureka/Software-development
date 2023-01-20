package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailedJobsComparisonActivity extends AppCompatActivity {

    private TextView title1;
    private TextView title2;
    private TextView company1;
    private TextView company2;
    private TextView location1;
    private TextView location2;
    private TextView costOfLiving1;
    private TextView costOfLiving2;
    private TextView AYS1;
    private TextView AYS2;
    private TextView AYB1;
    private TextView AYB2;
    private TextView retirementBenefits1;
    private TextView retirementBenefits2;
    private TextView relocationStipend1;
    private TextView relocationStipend2;
    private TextView rsua1;
    private TextView rsua2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_jobs_comparison);

        DataModel dataModel = Global.getDataModel();

        ArrayList<Job> jobs = dataModel.GetJobsForListing();
        Job job1 = null;
        Job job2 = null;

        title1 = findViewById(R.id.title1);
        company1 = findViewById(R.id.company1);
        location1 = findViewById(R.id.location1);
        costOfLiving1 = findViewById(R.id.costOfLiving1);
        AYS1 = findViewById(R.id.AYS1);
        AYB1 = findViewById(R.id.AYB1);
        retirementBenefits1 = findViewById(R.id.retirementBenefits1);
        relocationStipend1 = findViewById(R.id.relocationStipend1);
        rsua1 = findViewById(R.id.rsua1);

        title2 = findViewById(R.id.title2);
        company2 = findViewById(R.id.company2);
        location2 = findViewById(R.id.location2);
        costOfLiving2 = findViewById(R.id.costOfLiving2);
        AYS2 = findViewById(R.id.AYS2);
        AYB2 = findViewById(R.id.AYB2);
        retirementBenefits2 = findViewById(R.id.retirementBenefits2);
        relocationStipend2 = findViewById(R.id.relocationStipend2);
        rsua2 = findViewById(R.id.rsua2);

        Bundle extras = getIntent().getExtras();
        String intentString = "";
        if (extras != null) {
            intentString = extras.getString("JobComparisonIndeces");
            Log.d("DetailedJobsComparisonActivity", intentString);
        }

        try {
            JSONObject intentJson = new JSONObject(intentString);
            JSONArray jobIndeces = intentJson.getJSONArray("jobIndeces");

            for (int i = 0; i < jobIndeces.length(); i++) {
                int jobIndex = jobIndeces.getInt(i);
                if (job1 == null) {
                    job1 = jobs.get(jobIndex);
                } else if (job2 == null) {
                    job2 = jobs.get(jobIndex);
                }
            }

            title1.setText(job1.getTitle());
            company1.setText(job1.getCompany());
            location1.setText(job1.getLocation());
            costOfLiving1.setText(Integer.toString(job1.getCostOfLivingIndex()));
            AYS1.setText(Integer.toString(job1.getYearlySalary()));
            AYB1.setText(Integer.toString(job1.getYearlyBonus()));
            retirementBenefits1.setText(Integer.toString(job1.getRetirementSavingsMatchPercentage()));
            relocationStipend1.setText(Integer.toString(job1.getRelocationStipend()));
            rsua1.setText(Integer.toString(job1.getRestrictedStockAward()));

            title2.setText(job2.getTitle());
            company2.setText(job2.getCompany());
            location2.setText(job2.getLocation());
            costOfLiving2.setText(Integer.toString(job2.getCostOfLivingIndex()));
            AYS2.setText(Integer.toString(job2.getYearlySalary()));
            AYB2.setText(Integer.toString(job2.getYearlyBonus()));
            retirementBenefits2.setText(Integer.toString(job2.getRetirementSavingsMatchPercentage()));
            relocationStipend2.setText(Integer.toString(job2.getRelocationStipend()));
            rsua2.setText(Integer.toString(job2.getRestrictedStockAward()));
        } catch (Exception e) {
            Log.d("DetailedJobsComparisonActivity", "JSON Error: " + e.toString());
        }
    }

    public void handleClick(View view) {
        switch (view.getId()) {
            case R.id.mainMenu:
                Intent mainActivityIntent = new Intent(this, MainActivity.class);
                startActivity(mainActivityIntent);
                break;
            case R.id.backToJobsView:
                Intent compareJobOffersActivity = new Intent(this, CompareJobOffersActivity.class);
                startActivity(compareJobOffersActivity);
                break;
        }
    }

}