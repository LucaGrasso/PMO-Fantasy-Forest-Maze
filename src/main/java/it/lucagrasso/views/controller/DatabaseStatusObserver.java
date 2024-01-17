package it.lucagrasso.views.controller;

import javafx.application.Platform;

import java.util.Observable;
import java.util.Observer;

/**
 * Questa classe astratta funge da observer per monitorare lo stato di un database.
 * Implementa l'interface {@code Observer} di Java e definisce un comportamento comune per tutti
 * gli observer dello stato del database.
 *
 * Quando lo stato del database cambia (es. passa da online a offline o viceversa),
 * {@code DatabaseStatusObserver} viene notificato dall'oggetto {@code Observable} che rappresenta il database.
 * Dopo aver ricevuto la notifica, {@code DatabaseStatusObserver} esegue un'azione specifica
 * definita nel metodo astratto {@code handleDatabaseStatusChanged()}.
 *
 * Le sottoclassi concrete di {@code DatabaseStatusObserver} devono implementare {@code handleDatabaseStatusChanged()}
 * per specificare l'azione da eseguire quando lo stato del database cambia.
 *
 * <p>Ad esempio, un {@code DatabaseStatusObserver} potrebbe aggiornare un indicatore dell'interfaccia utente
 * per riflettere il nuovo stato del database.</p>
 *
 * <p>Uso:</p>
 * <pre>{@code
 * Database observableDatabase = ...
 * DatabaseStatusObserver observer = new ConcreteDatabaseStatusObserver();
 * observableDatabase.addObserver(observer);
 * }</pre>
 *
 * @author Luca Grasso
 * @version 1.0
 * @see Observer
 */
public abstract class DatabaseStatusObserver implements Observer {
    @Override
    public final void update(Observable o, Object arg) {
        if (arg instanceof Boolean) {
            boolean isDatabaseOnline = (Boolean) arg;
//            Platform.runLater(() -> handleDatabaseStatusChanged(isDatabaseOnline));
            handleDatabaseStatusChanged(isDatabaseOnline);
        }
    }

    /**
     * Questo metodo astratto deve essere implementato dalle sottoclassi
     * per definire l'azione da eseguire quando
     */
    public abstract void handleDatabaseStatusChanged(boolean isDatabaseOnline);
}
