package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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
public class TestCompareOffers {
    @Rule
    public ActivityTestRule<CompareJobOffersActivity> tActivityRule = new ActivityTestRule<>(
            CompareJobOffersActivity.class);

    @Test
    public void cancel() {
        onView(withId(R.id.cancelButton)).perform(click());
        // TODO: to main menu
    }

    @Test
    public void select01() {
        // TODO: select 1 invalid compareSelectedButton
    }

    @Test
    public void select02() {
        // TODO: select 3 invalid compareSelectedButton
    }

    @Test
    public void select03() {
        // TODO: select 2
        onView(withId(R.id.compareSelectedButton)).perform(click());
        onView(withId(R.id.mainMenu)).perform(click());
    }

    @Test
    public void select04() {
        // TODO: select 2
        onView(withId(R.id.compareSelectedButton)).perform(click());
        onView(withId(R.id.backToJobsView)).perform(click());
    }
}