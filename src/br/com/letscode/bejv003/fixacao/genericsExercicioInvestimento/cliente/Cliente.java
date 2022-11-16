package br.com.letscode.bejv003.fixacao.genericsExercicioInvestimento.cliente;

import br.com.letscode.bejv003.fixacao.genericsExercicioInvestimento.investimento.Investimento;
import br.com.letscode.bejv003.fixacao.genericsExercicioInvestimento.perfil.ClientePerfil;

public abstract class Cliente<T extends ClientePerfil, U extends Investimento> {


    public void contratarInvestimento(U investimento) {
        System.out.println("contratando = " + investimento.getClass());
    }


}
