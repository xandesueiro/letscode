package br.com.letscode.estudo.validacao;

import br.com.letscode.estudo.Funcionario;
import br.com.letscode.estudo.Pessoa;
import br.com.letscode.presenter.exceptions.ValidacaoException;

public class ValidacaoFuncionario implements ValidacaoPessoa<Funcionario> {

    public void validarDocumento(Funcionario funcionario) throws ValidacaoException {
        if (funcionario.getNumeroDocumento().length() != 11){
            throw new ValidacaoException("CPF inválido... precisa conter 11 numeros - sem separadores");
        }
    }

    @Override
    public String formatarDocumentoCPF(Funcionario funcionario) throws ValidacaoException {
        StringBuilder cpfBlocos = new StringBuilder();
        char[] charBloco = funcionario.getNumeroDocumento().toCharArray();

        for (int i = 0; i < charBloco.length; i++) {
            if (i ==2) {
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 5){
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 8){
                cpfBlocos.append(charBloco[i]).append("-");
            } else {
                cpfBlocos.append(charBloco[i]);
            }
        }
        return cpfBlocos.toString();
    }
}
