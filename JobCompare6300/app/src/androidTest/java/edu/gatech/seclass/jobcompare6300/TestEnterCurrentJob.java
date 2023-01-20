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

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEnterCurrentJob {
    @Rule
    public ActivityTestRule<EnterCurrentJobDetailsActivity> tActivityRule = new ActivityTestRule<>(
            EnterCurrentJobDetailsActivity.class);

    private DataModel dataModel = Global.getDataModel();

    @Test
    public void enter01() {
        Job job;

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

        job = dataModel.GetCurrentJob();
        assertEquals("Engineer", job.getTitle());
        assertEquals("Apple", job.getCompany());
        assertEquals("Phoenix", job.getCity());
        assertEquals("AZ", job.getState());
        assertEquals(100, job.getCostOfLivingIndex(), 0);
        assertEquals(100000, job.getYearlySalary(), 0);
        assertEquals(10000, job.getYearlyBonus(), 0);
        assertEquals(4, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(20, job.getRelocationStipend(), 0);
        assertEquals(10, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void enter02() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Manager"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.mainMenuButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Engineer", job.getTitle());
        assertEquals("Apple", job.getCompany());
        assertEquals("Phoenix", job.getCity());
        assertEquals("AZ", job.getState());
        assertEquals(100, job.getCostOfLivingIndex(), 0);
        assertEquals(100000, job.getYearlySalary(), 0);
        assertEquals(10000, job.getYearlyBonus(), 0);
        assertEquals(4, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(20, job.getRelocationStipend(), 0);
        assertEquals(10, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void enter03() {
        Job job;

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

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void enter04() {
        Job job;

        onView(withId(R.id.mainMenuButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidTitle() {
        Job job;

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

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidCompany() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
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

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidCity() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
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

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidState() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
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

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidInputCostOfLiving01() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("test"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidInputCostOfLiving02() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
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

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidInputCostOfLiving03() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("1000"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidInputCostOfLiving04() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("-1"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("90000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidSalary01() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("test"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidSalary02() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidSalary03() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("-1"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("30000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidBonus01() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("test"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidBonus02() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidBonus03() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("-1"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidRetirement01() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("test"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidRetirement02() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidRetirement03() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("101"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidRetirement04() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("-1"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidRelocation01() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("test"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidRelocation02() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidRelocation03() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("101"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidRelocation04() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("-1"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("12"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidStock01() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("test"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidStock02() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidStock03() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("101"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }

    @Test
    public void invalidStock04() {
        Job job;

        onView(withId(R.id.editTitle)).perform(clearText(), replaceText("Engineer"));
        onView(withId(R.id.editCompany)).perform(clearText(), replaceText("Amazon"));
        onView(withId(R.id.editCity)).perform(clearText(), replaceText("Atlanta"));
        onView(withId(R.id.editState)).perform(clearText(), replaceText("GA"));
        onView(withId(R.id.editCostOfLivingIndex)).perform(clearText(), replaceText("100"));
        onView(withId(R.id.editYearlySalary)).perform(clearText(), replaceText("100000"));
        onView(withId(R.id.editYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editRetirementSavingsMatchPercentage)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editRelocationStipend)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editRestrictedStockAward)).perform(clearText(), replaceText("-1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobDetailsButton)).perform(click());

        job = dataModel.GetCurrentJob();
        assertEquals("Manager", job.getTitle());
        assertEquals("Amazon", job.getCompany());
        assertEquals("Atlanta", job.getCity());
        assertEquals("GA", job.getState());
        assertEquals(70, job.getCostOfLivingIndex(), 0);
        assertEquals(90000, job.getYearlySalary(), 0);
        assertEquals(30000, job.getYearlyBonus(), 0);
        assertEquals(5, job.getRetirementSavingsMatchPercentage(), 0);
        assertEquals(30, job.getRelocationStipend(), 0);
        assertEquals(12, job.getRestrictedStockAward(), 0);
    }
}
