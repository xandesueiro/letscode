package br.com.letscode.presenter.implementation;

import br.com.letscode.estudo.Banco;
import br.com.letscode.presenter.exceptions.PresenterException;
import br.com.letscode.presenter.interfaces.Presenter;
import br.com.letscode.utilitarios.UtilitarioString;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Scanner;

public class KeyValueImp implements Presenter<Map, Banco> {

    @Override
    public void print(Banco banco) throws PresenterException {
        System.out.println(banco.toString());
    }

    @Override
    public String interagirPerguntas(Scanner scanner, String pergunta) throws PresenterException {

        throw new PresenterException("Esta classe " + this.getClass() + " não implementa este comportamento");
        //return null;
    }

    @Override
    public String prepare(Banco banco) throws PresenterException {
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
