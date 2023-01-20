package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

import java.util.ArrayList;

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEnterJobOffers {
    @Rule
    public ActivityTestRule<EnterJobOffersActivity> tActivityRule = new ActivityTestRule<>(
            EnterJobOffersActivity.class);

    private DataModel dataModel = Global.getDataModel();

    // wipe data before testing

    @Test
    public void enter01() {
        ArrayList<Job> offers;

        offers = dataModel.GetJobsForListing();
        assertEquals(0, offers.size());

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Apple"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Phoenix"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("AZ"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("20"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("10"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(1, offers.size());
        assertEquals("Apple", offers.get(0).getCompany());
    }

    @Test
    public void enter02() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.mainMenuButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(1, offers.size());
        assertEquals("Apple", offers.get(0).getCompany());
    }

    @Test
    public void enter03() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(2, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Apple", offers.get(1).getCompany());
    }

    @Test
    public void enter04() {
        ArrayList<Job> offers;

        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(2, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Apple", offers.get(1).getCompany());
    }

    @Test
    public void enter05() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput01() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput02() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput03() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput04() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput05() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput06() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput07() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput08() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput09() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }

    @Test
    public void invalidInput10() {
        ArrayList<Job> offers;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("70"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        offers = dataModel.GetJobsForListing();
        assertEquals(3, offers.size());
        assertEquals("Amazon", offers.get(0).getCompany());
        assertEquals("Amazon", offers.get(1).getCompany());
        assertEquals("Apple", offers.get(2).getCompany());
    }
}