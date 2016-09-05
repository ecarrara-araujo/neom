package br.com.ecarrara.neom.nearearthobjects.presentation.view.activity;

import android.os.Build;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import br.com.ecarrara.neom.BuildConfig;
import br.com.ecarrara.neom.R;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static butterknife.ButterKnife.findById;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class NearEarthObjectsListActivityTest {

    private NearEarthObjectsListActivity nearEarthObjectsListActivity;

    @Before
    public void setup() {
        nearEarthObjectsListActivity =
                Robolectric.setupActivity(NearEarthObjectsListActivity.class);
    }

    @Test
    public void testErrorMessageDisplay() {
        final String expectedErrorMessage = "Error message";

        nearEarthObjectsListActivity.showError(expectedErrorMessage);

        View errorView = findById(nearEarthObjectsListActivity, R.id.error_view);
        TextView errorTextView = findById(nearEarthObjectsListActivity,
                R.id.error_message_text_view);

        assertThat(errorView.getVisibility(), is(VISIBLE));
        assertThat(errorTextView.getText().toString(), is(expectedErrorMessage));
    }

    @Test
    public void testErrorMessageHidden() {
        nearEarthObjectsListActivity.hideError();
        View errorView = findById(nearEarthObjectsListActivity, R.id.error_view);
        assertThat(errorView.getVisibility(), is(GONE));
    }

    @Test
    public void testLoadingDisplay() {
        nearEarthObjectsListActivity.showLoading();
        View loadingView = findById(nearEarthObjectsListActivity, R.id.loading_view);
        assertThat(loadingView.getVisibility(), is(VISIBLE));
    }

    @Test
    public void testLoadingHidden() {
        nearEarthObjectsListActivity.hideLoading();
        View loadingView = findById(nearEarthObjectsListActivity, R.id.loading_view);
        assertThat(loadingView.getVisibility(), is(GONE));
    }

    @Test
    public void testRetryDisplay() {
        nearEarthObjectsListActivity.showRetry();
        View retryView = findById(nearEarthObjectsListActivity, R.id.retry_view);
        assertThat(retryView.getVisibility(), is(VISIBLE));
    }

    @Test
    public void testRetryHidden() {
        nearEarthObjectsListActivity.hideRetry();
        View retryView = findById(nearEarthObjectsListActivity, R.id.retry_view);
        assertThat(retryView.getVisibility(), is(GONE));
    }

}