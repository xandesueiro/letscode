package br.com.letscode.presenter.interfaces;

import br.com.letscode.estudo.Banco;
import br.com.letscode.presenter.exceptions.PresenterException;

import java.util.Map;

public interface PresenterKeyValue <T extends Map, U extends Banco> extends Presenter {

    String execute(U banco) throws PresenterException;
}
