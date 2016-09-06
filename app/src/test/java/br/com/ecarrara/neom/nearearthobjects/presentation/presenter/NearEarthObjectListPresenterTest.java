package br.com.ecarrara.neom.nearearthobjects.presentation.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import br.com.ecarrara.neom.foundations.domain.interactor.ObservableInteractor;
import br.com.ecarrara.neom.foundations.utils.Observable.Observer;
import br.com.ecarrara.neom.nearearthobjects.data.entity.NearEarthObject;
import br.com.ecarrara.neom.nearearthobjects.presentation.view.NearEarthObjectsListView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NearEarthObjectListPresenterTest {

    NearEarthObjectListPresenter presenter;

    @Mock
    private ObservableInteractor<List<NearEarthObject>> mockInteractor;

    @Mock
    private NearEarthObjectsListView mockView;

    @Captor
    private ArgumentCaptor<Observer<List<NearEarthObject>>> observerArgumentCaptor;

    @Before
    private void setUp() {
        presenter = new NearEarthObjectListPresenter(mockInteractor);
    }

    @Test
    public void testSuccessfulPresenterInitialization() {
        presenter.attachTo(mockView);

        verify(mockView).hideRetry();
        verify(mockView).showLoading();
        // Here we capture the observer registration to mock the update call
        verify(mockInteractor, times(1)).addObserver(observerArgumentCaptor.capture());
        verify(mockInteractor).execute();


        observerArgumentCaptor.getValue()
                .update(mockInteractor, new ArrayList<NearEarthObject>());

        verify(mockView).renderNearEarthObjectsList(any(List.class));
        verify(mockView).hideLoading();
    }

}