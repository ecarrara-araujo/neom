package br.com.ecarrara.neom.nearearthobjects.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.ecarrara.neom.R;
import br.com.ecarrara.neom.nearearthobjects.data.entity.NearEarthObject;
import br.com.ecarrara.neom.nearearthobjects.presentation.view.NearEarthObjectsListView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NearEarthObjectsListActivity extends AppCompatActivity
        implements NearEarthObjectsListView {

    @BindView(R.id.neo_recycler_view) RecyclerView neoRecyclerView;
    @BindView(R.id.loading_view) View loadingview;
    @BindView(R.id.retry_view) View retryView;
    @BindView(R.id.retry_button) Button retryButton;
    @BindView(R.id.error_view) View errorView;
    @BindView(R.id.error_message_text_view) TextView errorMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neo_list_activity);
        ButterKnife.bind(this);
    }

    @Override
    public void renderNearEarthObjectsList(List<NearEarthObject> nearEarthObjectModels) {

    }

    @Override
    public void showLoading() {
        this.loadingview.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        this.loadingview.setVisibility(View.GONE);

    }

    @Override
    public void showRetry() {
        this.retryView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideRetry() {
        this.retryView.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.errorView.setVisibility(View.VISIBLE);
        this.errorMessageTextView.setText(message);
    }

    @Override
    public void hideError() {
        this.errorView.setVisibility(View.GONE);
        this.errorMessageTextView.setText(R.string.empty_string);
    }
}
