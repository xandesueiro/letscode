package br.com.letscode.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static final String DATA_FORMATO_DD_MM_YYY_HH_MM_SS_SEPARADOR_BARRA = "dd/MM/yyyy HH:mm:ss";

    public static String pegarDataAtual(String formato){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat(formato);
        return formatador.format(data);
    }
}
