package com.example.jetbrainskotlincommits;

import android.content.Intent;


import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.jetbrainskotlincommits.model.ApiInterface;
import com.example.jetbrainskotlincommits.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


/**
 * @author rebeccafranks
 * @since 15/10/25.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {}
//        extends InstrumentationTestCase {
//
//
//    @Rule
//    public ActivityTestRule<MainActivity> mActivityRule =
//            new ActivityTestRule<>(MainActivity.class, true, false);
//    private MockWebServer server;
//
//    @Before
//    public void setUp() throws Exception {
//        super.setUp();
//        server = new MockWebServer();
//        server.start();
//        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
//        ApiInterface.BASE_URL = server.url("/").toString();
//    }
//
//    @Test
//    public void testQuoteIsShown() throws Exception {
//        String fileName = "quote_200_ok_response.json";
//        server.enqueue(new MockResponse()
//                .setResponseCode(200)
//                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
//
//        Intent intent = new Intent();
//        mActivityRule.launchActivity(intent);
//
//        onView(withId(R.id.button_retry)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
//        onView(withText("I came from a real tough neighborhood. Once a guy pulled a knife on me. I knew he wasn't a professional, the knife had butter on it.")).check(matches(isDisplayed()));
//    }
//
//
//    @Test
//    public void testRetryButtonShowsWhenError() throws Exception {
//        String fileName = "quote_404_not_found.json";
//
//        server.enqueue(new MockResponse()
//                .setResponseCode(404)
//                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));
//
//        Intent intent = new Intent();
//        mActivityRule.launchActivity(intent);
//
//        onView(withId(R.id.button_retry)).check(matches(isDisplayed()));
//        onView(withText("Quote Not found")).check(matches(isDisplayed()));
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        server.shutdown();
//    }

//}
