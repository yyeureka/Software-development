package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PersistenceDataModel {

    private final String weightsPersistedObjectTag = "/WEIGHTS.txt";
    private final String currentJobPersistedObjectTag = "/CURRENTJOB.txt";
    private final String jobOffersPersistedObjectTag = "/JOBOFFERS.txt";

    /*************************************************************************************/
    /* Weights */
    /*************************************************************************************/

    public void PersistWeights(
            Weights weights,
            Context context) {

        JSONObject json;
        try {
            json = new JSONObject(
                    "{" +
                            "aysWeight: \"" + weights.getAysWeight() + "\"," +
                            "aybWeight: \"" + weights.getAybWeight() + "\"," +
                            "relocationStipendWeight: \"" + weights.getRelocationStipendWeight() + "\"," +
                            "retirementSavingsMatchPercentWeight: \"" + weights.getRetirementSavingsMatchPercentWeight()
                            + "\"," +
                            "restrictedStockAwardWeight: \"" + weights.getRestrictedStockAwardWeight() + "\"" +
                            "}");

            File weightsFile = new File(context.getFilesDir() + weightsPersistedObjectTag);
            if (weightsFile.exists()) {
                weightsFile.delete();
                weightsFile = new File(context.getFilesDir() + weightsPersistedObjectTag);
            }

            FileOutputStream stream = new FileOutputStream(weightsFile);
            stream.write(json.toString().getBytes());
            stream.close();

        } catch (Exception e) {
            Log.d("PersistenceDataModel", "failure " + e.toString());
        }
    }

    public void PersistWeights(
            String aysWeight,
            String aybWeight,
            String relocationStipendWeight,
            String retirementSavingsMatchPercentWeight,
            String restrictedStockAwardWeight,
            Context context) {

        JSONObject json;
        try {
            json = new JSONObject(
                    "{" +
                            "aysWeight: \"" + aysWeight + "\"," +
                            "aybWeight: \"" + aybWeight + "\"," +
                            "relocationStipendWeight: \"" + relocationStipendWeight + "\"," +
                            "retirementSavingsMatchPercentWeight: \"" + retirementSavingsMatchPercentWeight + "\"," +
                            "restrictedStockAwardWeight: \"" + restrictedStockAwardWeight + "\"" +
                            "}");

            File weightsFile = new File(context.getFilesDir() + weightsPersistedObjectTag);
            if (weightsFile.exists()) {
                weightsFile.delete();
                weightsFile = new File(context.getFilesDir() + weightsPersistedObjectTag);
            }
            FileOutputStream stream = new FileOutputStream(weightsFile);
            stream.write(json.toString().getBytes());
            stream.close();

        } catch (Exception e) {
            Log.d("PersistenceDataModel", "failure " + e.toString());
        }
    }

    public Weights GetPersistedWeights(Context context) {

        File weightsFile = new File(context.getFilesDir() + weightsPersistedObjectTag);

        if (weightsFile.exists()) {
            int length = (int) weightsFile.length();

            byte[] bytes = new byte[length];

            FileInputStream in = null;
            try {
                in = new FileInputStream(weightsFile);
                in.read(bytes);
                in.close();

                String persistedFileContents = new String(bytes);

                JSONObject json = new JSONObject(persistedFileContents);
                Weights weights = new Weights(
                        json.getString("aysWeight"),
                        json.getString("aybWeight"),
                        json.getString("relocationStipendWeight"),
                        json.getString("retirementSavingsMatchPercentWeight"),
                        json.getString("restrictedStockAwardWeight"));
                return weights;

            } catch (Exception e) {
                Log.d("PersistenceDataModel", "failed: " + e.toString());
            }
        }

        return null;
    }

    /*************************************************************************************/
    /* Current Job */
    /*************************************************************************************/

    public void PersistCurrentJob(
            String title,
            String company,
            String city,
            String state,
            String costOfLivingIndex,
            String yearlySalary,
            String yearlyBonus,
            String retirementSavingsMatchPercent,
            String relocationStipend,
            String restrictedStockAward,
            Context context) {

        JSONObject json;
        try {
            json = new JSONObject(
                    "{" +
                            "title: \"" + title + "\"," +
                            "company: \"" + company + "\"," +
                            "city: \"" + city + "\"," +
                            "state: \"" + state + "\"," +
                            "costOfLivingIndex: \"" + costOfLivingIndex + "\"," +
                            "yearlySalary: \"" + yearlySalary + "\"," +
                            "yearlyBonus: \"" + yearlyBonus + "\"," +
                            "retirementSavingsMatchPercent: \"" + retirementSavingsMatchPercent + "\"," +
                            "relocationStipend: \"" + relocationStipend + "\"," +
                            "restrictedStockAward: \"" + restrictedStockAward + "\"" +
                            "}");

            File currentJobFile = new File(context.getFilesDir() + currentJobPersistedObjectTag);
            if (currentJobFile.exists()) {
                currentJobFile.delete();
                currentJobFile = new File(context.getFilesDir() + currentJobPersistedObjectTag);
            }

            FileOutputStream stream = new FileOutputStream(currentJobFile);
            stream.write(json.toString().getBytes());
            stream.close();

        } catch (Exception e) {
            Log.d("PersistenceDataModel", "failure " + e.toString());
        }
    }

    public Job GetPersistedCurrentJob(Context context, Weights weights) {

        File currentJobFile = new File(context.getFilesDir() + currentJobPersistedObjectTag);

        if (currentJobFile.exists()) {
            int length = (int) currentJobFile.length();

            byte[] bytes = new byte[length];

            FileInputStream in = null;
            try {
                in = new FileInputStream(currentJobFile);
                in.read(bytes);
                in.close();

                String persistedFileContents = new String(bytes);

                JSONObject json = new JSONObject(persistedFileContents);
                Job job = new Job(
                        json.getString("title"),
                        json.getString("company"),
                        json.getString("city"),
                        json.getString("state"),
                        json.getString("costOfLivingIndex"),
                        json.getString("yearlySalary"),
                        json.getString("yearlyBonus"),
                        json.getString("retirementSavingsMatchPercent"),
                        json.getString("relocationStipend"),
                        json.getString("restrictedStockAward"),
                        true,
                        weights);
                return job;

            } catch (Exception e) {
                Log.d("PersistenceDataModel", "failed: " + e.toString());
            }
        }

        return null;
    }

    /*************************************************************************************/
    /* Job Offers */
    /*************************************************************************************/

    public void PersistJobOffers(
            ArrayList<Job> jobs,
            Context context) {

        String s = "{jobOffers: [";

        boolean haveAlreadyAddedJob = false;

        for (Job job : jobs) {
            if (haveAlreadyAddedJob) {
                s = s + ",";
            }
            haveAlreadyAddedJob = true;
            s = s + "{" +
                    "title: \"" + job.getTitle() + "\"," +
                    "company: \"" + job.getCompany() + "\"," +
                    "city: \"" + job.getCity() + "\"," +
                    "state: \"" + job.getState() + "\"," +
                    "costOfLivingIndex: \"" + job.getCostOfLivingIndex() + "\"," +
                    "yearlySalary: \"" + job.getYearlySalary() + "\"," +
                    "yearlyBonus: \"" + job.getYearlyBonus() + "\"," +
                    "retirementSavingsMatchPercent: \"" + job.getRetirementSavingsMatchPercentage() + "\"," +
                    "relocationStipend: \"" + job.getRelocationStipend() + "\"," +
                    "restrictedStockAward: \"" + job.getRestrictedStockAward() + "\"" +
                    "}";
        }

        s = s + "]}";

        JSONObject json;
        try {
            json = new JSONObject(s);

            File jobOffersFile = new File(context.getFilesDir() + jobOffersPersistedObjectTag);
            if (jobOffersFile.exists()) {
                jobOffersFile.delete();
                jobOffersFile = new File(context.getFilesDir() + jobOffersPersistedObjectTag);
            }

            FileOutputStream stream = new FileOutputStream(jobOffersFile);
            stream.write(json.toString().getBytes());
            stream.close();

        } catch (Exception e) {
            Log.d("PersistenceDataModel", "failure " + e.toString());
        }
    }

    public ArrayList<Job> GetPersistedJobOffers(Context context, Weights weights) {

        File jobOffersFile = new File(context.getFilesDir() + jobOffersPersistedObjectTag);

        if (jobOffersFile.exists()) {
            int length = (int) jobOffersFile.length();

            byte[] bytes = new byte[length];

            FileInputStream in = null;
            try {
                in = new FileInputStream(jobOffersFile);
                in.read(bytes);
                in.close();

                String persistedFileContents = new String(bytes);

                JSONObject json = new JSONObject(persistedFileContents);
                ArrayList<Job> jobs = new ArrayList<Job>();

                JSONArray jobsJsonArray = json.getJSONArray("jobOffers");

                for (int i = 0; i < jobsJsonArray.length(); i++) {
                    JSONObject jobJson = jobsJsonArray.getJSONObject(i);
                    Job job = new Job(
                            jobJson.getString("title"),
                            jobJson.getString("company"),
                            jobJson.getString("city"),
                            jobJson.getString("state"),
                            jobJson.getString("costOfLivingIndex"),
                            jobJson.getString("yearlySalary"),
                            jobJson.getString("yearlyBonus"),
                            jobJson.getString("retirementSavingsMatchPercent"),
                            jobJson.getString("relocationStipend"),
                            jobJson.getString("restrictedStockAward"),
                            false,
                            weights);

                    jobs.add(job);
                }

                return jobs;

            } catch (Exception e) {
                Log.d("PersistenceDataModel", "failed: " + e.toString());
            }
        }

        return null;
    }
}
