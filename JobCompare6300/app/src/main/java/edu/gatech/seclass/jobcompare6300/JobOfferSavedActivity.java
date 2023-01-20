package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JobOfferSavedActivity extends AppCompatActivity {

    private Button compareOfferButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_offer_saved);
        compareOfferButton = (Button) findViewById(R.id.compareOfferWithCurrentJob);
        // TO DO: Toggle Comparison button active/inactive
    }

    public void eventHandler(View view) {
        switch (view.getId()) {
            case R.id.enterAnotherOfferDetails:
                Intent intentEnterJobOffer = new Intent(this, EnterJobOffersActivity.class);
                startActivity(intentEnterJobOffer);
                break;
            case R.id.compareOfferWithCurrentJob:
                /*if(compareOfferButton.isEnabled()) {
                    Intent intentDetailedComparison = new Intent(this, DetailedComparisonActivity.class);
                    intentDetailedComparison.putExtra("FROM_ACTIVITY", "JobOfferSavedActivity");
                    startActivity(intentDetailedComparison);
                }*/
                break;
            case R.id.mainMenuButton:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

}