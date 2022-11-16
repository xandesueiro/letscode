package br.com.letscode.bejv002.fixacao;

import br.com.letscode.utilitarios.UtilitarioString;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;

public class MainTestes {
    public static void main(String args[]) {
        MainTestes.imprimirEstruturaClasse("br.com.letscode.bejv002.fixacao.Funcionario");
        Funcionario funcionario = null;
        try {
            String nome = "joao da silva";
            String cpf = "22233344455";
            BigDecimal salario = new BigDecimal("8500.87");
            int diasReaisTrabalhados = 22;
            funcionario = new Funcionario(nome, cpf, salario, diasReaisTrabalhados);
            System.out.println(funcionario);
            funcionario.imprimirHollerite(Funcionario.DATA_FORMATO_DD_MM_YYY_HH_MM_SS_SEPARADOR_BARRA);

            System.out.println("===========================================================\n\n");
            Class<?> classObj = funcionario.getClass();
            Method getMethod = classObj.getDeclaredMethod("get"+"Nome");
            System.out.println("Valor do método executado: " + getMethod.invoke(funcionario, null) );

        }catch (Exception ex){
            System.out.println(ex);
        }

        System.out.println("\n================================================\n");
        MainTestes.imprimirChaveValor(funcionario.getClass(), funcionario);
    }

    private static void imprimirEstruturaClasse(String strClass){
        try {
            Class cls = Class.forName(strClass);

            Field fieldlist[] = cls.getDeclaredFields();
            for (int i = 0; i < fieldlist.length; i++) {
                Field fld = fieldlist[i];
                System.out.println("name = " + fld.getName() );
                System.out.println("name = " + UtilitarioString.converterPrimeiraLetraParaMaiuscula( fld.getName() ));
                System.out.println("decl class = " + fld.getDeclaringClass());
                System.out.println("type = " + fld.getType());
                int mod = fld.getModifiers();
                System.out.println("modifiers = " + Modifier.toString(mod));
                System.out.println("modifiers contem static? : " + UtilitarioString.contemAPalavra(Modifier.toString(mod), "static"));
                System.out.println("-----");
            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }

    private static void imprimirChaveValor(Class<?> classObj, Object object){
        StringBuffer sb = new StringBuffer();

        try {
            sb.append("{\n");

            Field fieldlist[] = classObj.getDeclaredFields();
            Method getMethod = null;

            for (int i = 0; i < fieldlist.length; i++) {
                Field fld = fieldlist[i];
                int mod = fld.getModifiers();

                if (!UtilitarioString.contemAPalavra(Modifier.toString(mod), "static")){
                    try {
                        getMethod = classObj.getDeclaredMethod("get" + UtilitarioString.converterPrimeiraLetraParaMaiuscula(fld.getName()));
                        Object obj = getMethod.invoke(object, null);

                        char virgula = (i == (fieldlist.length-1)) ? ' ' : ',';

                        sb.append("    \"").append(fld.getName())
                                .append("\"")
                                .append(" : ")
                                .append("\"")
                                .append(obj)
                                .append("\"")
                                .append(virgula)
                                .append("\n");
                    }catch (Exception exception){
                        //System.out.println(exception.getMessage() + " - " + exception.getCause());
                    }
                }
            }
            sb.append("}");
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        //remove última virgula
        sb.replace(sb.length()-3, sb.length()-2, " ");
        System.out.println(sb);
    }
}
