package de.moviemanager.ui.movie;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.GrantPermissionRule;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.moviemanager.R;
import de.moviemanager.data.MovieTransformations;
import de.moviemanager.ui.MasterActivity;
import de.util.DateUtils;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static androidx.test.core.app.ActivityScenario.launch;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.rule.GrantPermissionRule.grant;
import static de.moviemanager.ui.util.UiTestUtils.STORAGE;
import static de.moviemanager.ui.util.UiTestUtils.checkPermissionState;
import static de.moviemanager.ui.util.UiTestUtils.childAtPosition;
import static de.moviemanager.ui.util.UiTestUtils.clearStorage;
import static de.moviemanager.ui.util.UiTestUtils.selectMenuItemAndEnterEdit;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest

public class LoanMovieTest {



        @Rule
        public ActivityScenarioRule<MasterActivity> activityActivityScenarioRule =
                new ActivityScenarioRule<>(MasterActivity.class);
        @ClassRule
        public static final GrantPermissionRule PERMISSION_RULE = grant(WRITE_EXTERNAL_STORAGE);

        @BeforeClass
        public static void initStorage() {
            ActivityScenario<MasterActivity> activityScenario = launch(MasterActivity.class);
            activityScenario.onActivity(activity -> {
                checkPermissionState(activity);
                clearStorage();
                populateStorageWithMovie();
            });
        }

        private static void populateStorageWithMovie() {
            STORAGE.newMovie().addOperation(MovieTransformations.setTitle("Star Wars")).commit();

        }

        @AfterClass
        public static void clearStorageAfterClass() {
            clearStorage();
        }

        @Test
        public void testLoanMovieNoCancellationWithConfirmation() {
            selectMenuItemAndEnterEdit("Star Wars");


            enterDueDatePicker();



            onView(withId(R.id.calendar))
                    .perform(PickerActions.setDate(2021, 9, 13));
            onView(withText(R.string.confirm)).perform(click());
            onView(withId(R.id.commit)).perform(click());
            onView(withId(R.id.due_date))
                    .check(matches(hasDescendant(withText("13.09.2021"))));
        }



        @Test
        public void testLoanMovieNoCancellationWithoutConfirmation() {
            selectMenuItemAndEnterEdit("Star Wars");

            enterDueDatePicker();

            onView(withId(R.id.calendar))
                    .perform(PickerActions.setDate(2020, 4, 22));
            onView(withText(R.string.confirm)).perform(click());
            pressBack();
            onView(withText(R.string.yes)).inRoot(isDialog()).perform(click());

            onView(withId(R.id.due_date))
                    .check(matches(not(hasDescendant(withText("22.04.2020")))));
        }

        @Test
        public void testLoanMovieWithCancellation() {
            selectMenuItemAndEnterEdit("Star Wars");

            enterDueDatePicker();

            onView(withId(R.id.calendar))
                    .perform(PickerActions.setDate(2020, 2, 19));
            onView(withText("CANCEL")).perform(click());

            pressBack();
            onView(withId(R.id.due_date))
                    .check(matches(not(hasDescendant(withText("19.02.2020")))));
        }




        private void enterDueDatePicker() {
            onView(allOf(withId(R.id.select_date), withContentDescription("Select a date."),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.edit_due_date),
                                    0),
                            2),
                    isDisplayed())).perform(click());
        }

    }

