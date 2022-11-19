package br.com.letscode.estudo.validacao;

import br.com.letscode.estudo.Terceiro;
import br.com.letscode.presenter.exceptions.ValidacaoException;

public class ValidacaoTerceiro implements ValidacaoPessoa<Terceiro> {

    public void validarDocumento(Terceiro terceiro) throws ValidacaoException {
        if (terceiro.getNumeroDocumento().length() != 11){
            throw new ValidacaoException("CPF inválido... precisa conter 11 numeros - sem separadores");
        }

        if (terceiro.getCnpjEmpresaContratante().length() != 14){
            throw new ValidacaoException("CNPJ da empresa inválido... precisa conter 14 numeros - sem separadores");
        }
    }

    @Override
    public String formatarDocumentoCPF(Terceiro terceiro) throws ValidacaoException {
        StringBuilder cpfBlocos = new StringBuilder();
        char[] charBloco = terceiro.getNumeroDocumento().toCharArray();

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

    public String formatarDocumentoCNPJ(Terceiro terceiro) throws ValidacaoException {
        StringBuilder cpfBlocos = new StringBuilder();
        char[] charBloco = terceiro.getCnpjEmpresaContratante().toCharArray();

        for (int i = 0; i < charBloco.length; i++) {
            if (i ==1) {
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 4){
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 7){
                cpfBlocos.append(charBloco[i]).append("/");
            } else if (i == 11){
                cpfBlocos.append(charBloco[i]).append("-");
            } else {
                cpfBlocos.append(charBloco[i]);
            }
        }
        return cpfBlocos.toString();
    }

}
