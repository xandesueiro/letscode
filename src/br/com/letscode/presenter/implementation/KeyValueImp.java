package br.com.letscode.presenter.implementation;

import br.com.letscode.estudo.Banco;
import br.com.letscode.estudo.Funcionario;
import br.com.letscode.estudo.Terceiro;
import br.com.letscode.estudo.services.PessoaService;
import br.com.letscode.presenter.exceptions.PresenterException;
import br.com.letscode.presenter.exceptions.ValidacaoException;
import br.com.letscode.presenter.interfaces.PresenterKeyValue;
import br.com.letscode.utilitarios.UtilitarioString;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

public class KeyValueImp implements PresenterKeyValue<Map, Banco> {

    @Override
    public void print(Banco banco) throws PresenterException {
        PessoaService pessoaService = new PessoaService();

        StringBuffer sb = new StringBuffer();
        try {
            if (banco instanceof Funcionario) {
                sb.append("Nome                : ").append(((Funcionario) banco).getNome()).append("\n");
                sb.append("Documento           : ").append(pessoaService.formatarDocumentoCPF((Funcionario) banco)).append("\n");
                sb.append("Salário             : ").append(pessoaService.formatarSalarioEmMoedaLocal(((Funcionario) banco).getSalario())).append("\n");
                sb.append("Salário Proporcional: ").append(pessoaService.formatarSalarioEmMoedaLocal(((Funcionario) banco).getSalarioProporcional())).append("\n");

            } else if (banco instanceof Terceiro) {
                sb.append("Nome                : ").append(((Terceiro) banco).getNome()).append("\n");
                sb.append("Documento           : ").append(pessoaService.formatarDocumentoCPF((Terceiro) banco)).append("\n");
                sb.append("Documento Empresa   : ").append(pessoaService.formatarDocumentoCNPJ((Terceiro) banco)).append("\n");
            } else {
                System.out.println(banco.toString());
            }
        }catch (ValidacaoException validacaoException){
            throw new PresenterException(validacaoException.getMessage());
        }
    }

    @Override
    public String execute(Banco banco) throws PresenterException {
        StringBuffer sb = new StringBuffer();

        try {
            sb.append("{\n");
            mergeListFields(banco.getClass(), banco, sb);

            sb.append("}");
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        //remove última virgula
        sb.replace(sb.length()-3, sb.length()-2, " ");
        return sb.toString();
    }

    private void mergeListFields(Class<?> bancoClass, Banco banco, StringBuffer sb){
        Class<?> superclass;

        if(bancoClass.getSuperclass() != null){
            superclass = bancoClass.getSuperclass();
            mergeListFields(superclass, banco, sb);
        }

        Field fieldlist[] = bancoClass.getDeclaredFields();
        Method getMethod = null;

        for (int i = 0; i < fieldlist.length; i++) {
            Field fld = fieldlist[i];
            int mod = fld.getModifiers();

            if (!UtilitarioString.contemAPalavra(Modifier.toString(mod), "static")){
                try {
                    getMethod = banco.getClass().getDeclaredMethod("get" + UtilitarioString.converterPrimeiraLetraParaMaiuscula(fld.getName()));
                    getMethod.setAccessible(true);
                    Object resultadoMetodo = getMethod.invoke(banco, null);

                    char virgula = (i == (fieldlist.length-1)) ? ' ' : ',';

                    sb.append("    \"").append(fld.getName())
                            .append("\"")
                            .append(" : ")
                            .append("\"")
                            .append(resultadoMetodo)
                            .append("\"")
                            .append(virgula)
                            .append("\n");
                }catch (Exception exception){
                    //System.out.println(exception.getMessage() + " - " + exception.getCause());
                }
            }
        }
    }

}
