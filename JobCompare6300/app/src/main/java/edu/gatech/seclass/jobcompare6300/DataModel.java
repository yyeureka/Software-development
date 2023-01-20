package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Comparator;

public class DataModel {

    private Job currentJob;
    private Weights weights;
    private ArrayList<Job> jobOffers;
    private PersistenceDataModel persistenceModel;
    boolean hasGatheredPersistedData;

    public DataModel(PersistenceDataModel _persistenceModel) {
        jobOffers = new ArrayList<Job>();
        weights = new Weights();
        persistenceModel = _persistenceModel;
        hasGatheredPersistedData = false;
    }

    public void GatherPersistedData(Context context) {
        if (!hasGatheredPersistedData) {
            Weights newWeights = persistenceModel.GetPersistedWeights(context);
            if (newWeights == null) {
                persistenceModel.PersistWeights(weights, context);
            } else {
                weights = newWeights;
            }

            Job newCurrentJob = persistenceModel.GetPersistedCurrentJob(context, weights);
            if (newCurrentJob != null) {
                currentJob = newCurrentJob;
            }

            ArrayList<Job> newJobOffers = persistenceModel.GetPersistedJobOffers(context, weights);
            if (newJobOffers != null) {
                jobOffers = newJobOffers;
            }
        }
        hasGatheredPersistedData = true;
    }

    public Weights GetWeights() {
        return weights;
    }

    public Job GetCurrentJob() {
        return currentJob;
    }

    public WeightsInstantiationErrors updateWeights(
            String aysWeight,
            String aybWeight,
            String relocationStipendWeight,
            String retirementSavingsMatchPercentWeight,
            String restrictedStockAwardWeight,
            Context context) {

        Weights newWeights = new Weights(
                aysWeight,
                aybWeight,
                relocationStipendWeight,
                retirementSavingsMatchPercentWeight,
                restrictedStockAwardWeight);

        WeightsInstantiationErrors weightErrors = newWeights.GetErrors();

        if ((!weightErrors.HasErrors())) {
            weights = newWeights;
            persistenceModel.PersistWeights(
                    aysWeight,
                    aybWeight,
                    relocationStipendWeight,
                    retirementSavingsMatchPercentWeight,
                    restrictedStockAwardWeight,
                    context);

            if (currentJob != null) {
                currentJob.calculateJobScore(weights);
            }
            for (Job job : jobOffers) {
                job.calculateJobScore(weights);
            }
        }

        return weightErrors;
    }

    public JobInstantiationErrors updateCurrentJob(
            String title,
            String company,
            String city,
            String state,
            String costOfLiving,
            String yearlySalary,
            String yearlyBonus,
            String retirementSavingsMatchPercent,
            String relocationStipend,
            String restrictedStockAward,
            Context context) {

        Job newCurrentJob = new Job(
                title,
                company,
                city,
                state,
                costOfLiving,
                yearlySalary,
                yearlyBonus,
                retirementSavingsMatchPercent,
                relocationStipend,
                restrictedStockAward,
                true,
                weights);

        if (!newCurrentJob.getErrors().HasErrors()) {
            persistenceModel.PersistCurrentJob(
                    title,
                    company,
                    city,
                    state,
                    costOfLiving,
                    yearlySalary,
                    yearlyBonus,
                    retirementSavingsMatchPercent,
                    relocationStipend,
                    restrictedStockAward,
                    context);

            currentJob = newCurrentJob;
        }

        return newCurrentJob.getErrors();
    }

    public JobInstantiationErrors addJobOffer(
            String title,
            String company,
            String city,
            String state,
            String costOfLiving,
            String yearlySalary,
            String yearlyBonus,
            String retirementSavingsMatchPercent,
            String relocationStipend,
            String restrictedStockAward,
            Context context) {

        Job newJobOffer = new Job(
                title,
                company,
                city,
                state,
                costOfLiving,
                yearlySalary,
                yearlyBonus,
                retirementSavingsMatchPercent,
                relocationStipend,
                restrictedStockAward,
                false,
                weights);

        if (!newJobOffer.getErrors().HasErrors()) {
            jobOffers.add(newJobOffer);

            jobOffers.sort(new Comparator<Job>() {
                @Override
                public int compare(Job a, Job b) {
                    return (int) (b.getJobRankScore() - a.getJobRankScore());
                }
            });

            persistenceModel.PersistJobOffers(jobOffers, context);
        }

        return newJobOffer.getErrors();
    }

    public ArrayList<Job> GetJobsForListing() {
        ArrayList<Job> jobs = new ArrayList<Job>(jobOffers.size() + 1);
        for (Job j : jobOffers) {
            jobs.add(j);
        }

        jobs.add(currentJob);

        jobs.sort(new Comparator<Job>() {
            @Override
            public int compare(Job a, Job b) {
                return (int) (b.getJobRankScore() - a.getJobRankScore());
            }
        });

        return jobs;
    }
}
