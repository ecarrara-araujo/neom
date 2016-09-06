package br.com.ecarrara.neom.foundations.domain.interactor;

import java.util.Observer;

import br.com.ecarrara.neom.foundations.utils.Observable;

public abstract class ObservableInteractor<T> extends Observable<T> {

    public abstract void execute();

}
