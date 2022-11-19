package br.com.letscode.estudo.validacao;

import br.com.letscode.estudo.Pessoa;
import br.com.letscode.presenter.exceptions.ValidacaoException;

public interface ValidacaoPessoa <T extends Pessoa>{

    void validarDocumento(T pessoa) throws ValidacaoException;

    String formatarDocumentoCPF(T pessoa) throws  ValidacaoException;

}
