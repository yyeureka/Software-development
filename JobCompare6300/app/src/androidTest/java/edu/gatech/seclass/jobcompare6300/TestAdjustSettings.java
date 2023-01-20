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

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAdjustSettings {
    @Rule
    public ActivityTestRule<ConfigureSettingsActivity> tActivityRule = new ActivityTestRule<>(
            ConfigureSettingsActivity.class);

    private DataModel dataModel = Global.getDataModel();

    // wipe data before testing

    @Test
    public void adjust01() {
        Weights weights;

        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(1, weights.getAysWeight(), 0);
        assertEquals(1, weights.getAybWeight(), 0);
        assertEquals(1, weights.getRelocationStipendWeight(), 0);
        assertEquals(1, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void adjust02() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("3"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("2"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void adjust03() {
        Weights weights;

        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidAys01() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("test"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("3"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("2"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidAys02() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("3"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("2"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidAyb01() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("test"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("3"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("2"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidAyb02() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText(""));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("3"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("2"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidRelocation01() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("test"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("2"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidRelocation02() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText(""));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("2"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidRetirement01() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("3"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("test"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidRetirement02() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("3"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText(""));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidStock01() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("3"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("2"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText("test"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }

    @Test
    public void invalidStock02() {
        Weights weights;

        onView(withId(R.id.editAysWeight)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.editAybWeight)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.editRelocationStipendWeight)).perform(clearText(),
                replaceText("3"));
        onView(withId(R.id.editRetirementSavingsMatchPercentageWeight)).perform(clearText(),
                replaceText("2"));
        onView(withId(R.id.editRestrictedStockAwardWeight)).perform(clearText(),
                replaceText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.assignWeightsButton)).perform(click());

        weights = dataModel.GetWeights();
        assertEquals(5, weights.getAysWeight(), 0);
        assertEquals(4, weights.getAybWeight(), 0);
        assertEquals(3, weights.getRelocationStipendWeight(), 0);
        assertEquals(2, weights.getRetirementSavingsMatchPercentWeight(), 0);
        assertEquals(1, weights.getRestrictedStockAwardWeight(), 0);
    }
}
