package br.com.ecarrara.neom.nearearthobjects.presentation.presenter;

import java.util.List;

import br.com.ecarrara.neom.foundations.domain.interactor.ObservableInteractor;
import br.com.ecarrara.neom.foundations.presentation.presenter.Presenter;
import br.com.ecarrara.neom.foundations.utils.Observable;
import br.com.ecarrara.neom.foundations.utils.Observable.Observer;
import br.com.ecarrara.neom.nearearthobjects.data.entity.NearEarthObject;
import br.com.ecarrara.neom.nearearthobjects.presentation.view.NearEarthObjectsListView;

public class NearEarthObjectListPresenter
        implements Presenter<NearEarthObjectsListView>, Observer<List<NearEarthObject>> {

    private NearEarthObjectsListView nearEarthObjectsListView;
    private ObservableInteractor<List<NearEarthObject>> nearEarthObjectListingInteractor;

    public NearEarthObjectListPresenter(
            ObservableInteractor<List<NearEarthObject>> nearEarthObjectListingInteractor) {
        this.nearEarthObjectListingInteractor = nearEarthObjectListingInteractor;
    }

    @Override
    public void resume() { /* no-op */ }

    @Override
    public void pause() {  /* no-op */ }

    @Override
    public void destroy() {
        this.nearEarthObjectListingInteractor.removeObserver(this);
    }

    @Override
    public void attachTo(NearEarthObjectsListView view) {
        this.nearEarthObjectsListView = view;
        initialize();
    }

    private void initialize() {
        this.nearEarthObjectsListView.hideRetry();
        this.nearEarthObjectsListView.showLoading();
        this.nearEarthObjectListingInteractor.addObserver(this);
        this.nearEarthObjectListingInteractor.execute();
    }

    @Override
    public void update(Observable<? extends List<NearEarthObject>> observable,
                       List<NearEarthObject> nearEarthObjectList) {
        this.nearEarthObjectsListView.renderNearEarthObjectsList(nearEarthObjectList);
        this.nearEarthObjectsListView.hideLoading();
    }

}
