package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Hashtable;

public class CompareJobOffersActivity extends AppCompatActivity {

    Hashtable<Integer, Boolean> selectedJobsDictionary = new Hashtable<Integer, Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_job_offers);

        final Button compareSelectedJobsButton = findViewById(R.id.compareSelectedButton);
        compareSelectedJobsButton.setEnabled(false);

        ListView jobsListView = findViewById(R.id.jobsListView);
        DataModel dataModel = Global.getDataModel();

        ArrayAdapter adapter = new ArrayAdapter<Job>(this, R.layout.list_jobs_layout, dataModel.GetJobsForListing()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Cast the list view each item as text view
                TextView item = (TextView) super.getView(position,convertView,parent);

                if(item.getText().toString().charAt(0) == '>'){
                    item.setTypeface(null, Typeface.BOLD);
                }

                return item;
            }
        };

        jobsListView.setAdapter(adapter);

        jobsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedTextView ctv = (CheckedTextView) view;
               
                Log.d("CompareJobOffersActivity", "string? " + String.valueOf(position));

                if (!ctv.isChecked()) {
                    selectedJobsDictionary.put(position, true);
                } else {
                    selectedJobsDictionary.remove(position);;
                }
                if (selectedJobsDictionary.size() >= 3) {
                    validateCheckedItems(position, ctv);
                }
                ctv.setChecked(!ctv.isChecked());
                compareSelectedJobsButton.setEnabled(selectedJobsDictionary.size() == 2);
            }
        });

    }

    private void validateCheckedItems(int position, CheckedTextView checkedTextView) {
        selectedJobsDictionary.remove(position);
        checkedTextView.setChecked(!checkedTextView.isChecked());
        Toast.makeText(CompareJobOffersActivity.this, "Select only two jobs ", Toast.LENGTH_LONG).show();
    }

    public void eventHandler(View view) {
        switch (view.getId()) {
            case R.id.compareSelectedButton:
                if (!compareJobOffers()) {
                    String intentString = "{jobIndeces: [";
                    boolean addedFirstItem = false;
                    for (Integer jobIndex : selectedJobsDictionary.keySet()) {
                        if (addedFirstItem) {
                            intentString = intentString + ",";
                        }
                        addedFirstItem = true;
                        intentString = intentString + jobIndex;
                    }
                    intentString = intentString + "]}";
                    startActivity(
                            new Intent(this,
                                    DetailedJobsComparisonActivity.class
                            ).putExtra(
                                    "JobComparisonIndeces",
                                    intentString
                            )
                    );
                    break;
                }
                break;
            case R.id.cancelButton:
                Intent mainActivityIntent = new Intent(this, MainActivity.class);
                startActivity(mainActivityIntent);
                break;
        }
    }

    private boolean compareJobOffers() {
        if (selectedJobsDictionary.size() != 2) {
            Toast.makeText(CompareJobOffersActivity.this, "Select exactly two jobs ", Toast.LENGTH_LONG).show();
        }
        //startActivity(new Intent(this, DetailedJobsComparisonActivity.class));
        return false;
    }
}