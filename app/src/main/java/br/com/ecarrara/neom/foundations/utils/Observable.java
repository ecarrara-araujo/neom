package br.com.ecarrara.neom.foundations.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

/**
 * Mutation of java.util.Observable that uses generics to avoid casts.
 * For any un-documented variable, parameter or method, see java.util.Observable
 *
 * @see <a href="Generic Java Observable">http://codereview.stackexchange.com/questions/76924/java-util-observable-but-with-generics-to-avoid-casts</a>
 */
public class Observable<T> {

    public interface Observer<U> {
        public void update(Observable<? extends U> observable, U arg);
    }

    private boolean changed = false;
    private final Collection<Observer<? super T>> observers;

    public Observable() {
        this(new ArrayList<Observer<? super T>>());
    }

    public Observable(Collection<Observer<? super T>> observers) {
        this.observers = observers;
    }

    public void addObserver(final Observer<? super T> observer) {
        synchronized (observers) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    public void removeObserver(final Observer<? super T> observer) {
        synchronized (observers) {
            observers.remove(observer);
        }
    }

    public void clearObservers() {
        synchronized (observers) {
            this.observers.clear();
        }
    }

    public void setChanged() {
        synchronized (observers) {
            this.changed = true;
        }
    }

    public void clearChanged() {
        synchronized (observers) {
            this.changed = false;
        }
    }

    public boolean hasChanged() {
        synchronized (observers) {
            return this.changed;
        }
    }

    public int countObservers() {
        synchronized (observers) {
            return observers.size();
        }
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(final T value) {
        ArrayList<Observer<? super T>> toNotify = null;
        synchronized(observers) {
            if (!changed) {
                return;
            }
            toNotify = new ArrayList<>(observers);
            changed = false;
        }
        for (Observer<? super T> observer : toNotify) {
            observer.update(this, value);
        }
    }
}
