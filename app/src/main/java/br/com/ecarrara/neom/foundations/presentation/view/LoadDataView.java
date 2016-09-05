package br.com.ecarrara.neom.foundations.presentation.view;

/**
 * Represents a View that loads Data Asynchronously
 */
public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void showRetry();

    void hideRetry();

    void showError(String message);

    void hideError();

}
