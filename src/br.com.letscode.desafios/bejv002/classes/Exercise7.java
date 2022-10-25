package br.com.letscode.desafios.bejv002.classes;

import br.com.letscode.desafios.bejv002.enums.ExerciseStatement;

public class Exercise7 extends  Exercise {

    public Exercise7(){
        this.createMainStatement();
        this.createSubStatements();
    }

    protected void createMainStatement(){
        StringBuilder sb = new StringBuilder();

        sb.append("Enunciado");
        sb.append("\n\n");
        sb.append("Exercício prof. W. Alexandre");
        sb.append("\n\n");
        sb.append("Uma chapa metálica tem seus quatro lados mantidos a temperaturas constantes, podendo ser diferentes ou não. \n");
        sb.append("A temperatura no interior da chapa, inicialmente valendo 0°C, tem seu valor modificado de acordo com a vizinhança de cada ponto. .\n");
        sb.append("Suponha que, a cada etapa/round, a temperatura de um ponto interno seja a média dos seus quatro vizinhos \n");
        sb.append("(os dois da vertical – acima e abaixo - e os dois da horizontal – à esquerda e à direita). \n");
        sb.append("Nesse problema, todos os pontos serão atualizados ao mesmo tempo, não utilizando as novas temperaturas dos pontos internos enquanto \n");
        sb.append("todos não tiverem sido calculados. Os pontos dessa chapa podem ser representados em uma grade com linhas e colunas. \n");
        sb.append("obs.: O \"erro\" a cada iteração será o maior valor absoluto da diferença das temperaturas da chapa entre duas etapas consecutivas. \n");
        sb.append("O \"erro máximo aceitável\" é o maior \"erro\" - entre etapas consecutivas) que o programa aceita como equilíbrio térmico \n");
        sb.append("erros maiores que esse indicam que a chapa ainda não entrou em equilíbrio térmico). \n");
        sb.append("Para o \"erro máximo aceitável\", pode-se usar valores double do tipo 1e-n, onde n é um número inteiro.\n");
        sb.append("\nA respeito do contexto acima, faça programa(s) em Java para responder às seguintes questões (obs1.: construa métodos auxiliares \n");
        sb.append("que julgar necessários, importantes ou úteis. \n");
        sb.append("Obs2.: utilize os tipos primitivos para exercitar a lógica de programação:\n");

        super.mainStatement = sb.toString();
    }

    protected void createSubStatements(){
        String[] subStmts = new String[3];
        subStmts[0] = createSubStatements_7_1();
        subStmts[1] = createSubStatements_7_2();
        subStmts[2] = createSubStatements_7_3();

        super.subStatements = subStmts;
    }

    private String createSubStatements_7_1(){
        StringBuilder sb = new StringBuilder();
        sb.append("=============================================================================\n");
        sb.append("1- Considere que a temperatura inicial seja dada da seguinte forma: \n");
        sb.append("==> a- Primeira coluna: 100°C \n");
        sb.append("==> b- Última coluna: -3°C \n");
        sb.append("==> c- Primeira linha: 20°C \n");
        sb.append("==> d- Última linha: 20°C \n");
        sb.append("\n");
        sb.append("Para uma chapa com 6 linhas e 5 colunas, após quantas iterações a chapa entrará em equilíbrio térmico, isto é, as temperaturas de todos \n");
        sb.append("os pontos serão constantes? \n");
        sb.append("Considere as temperaturas com duas casas decimais. Obs.: as temperaturas das quinas ou vértices não serão relevantes, e podem assumir \n");
        sb.append("o valor dado inicialmente nas linhas. \n");

        return sb.toString();
    }

    private String createSubStatements_7_2(){
        StringBuilder sb = new StringBuilder();
        sb.append("2- Faça uma versão do programa anterior que, dados um número máximo de iteração e um erro máximo aceitável, itere até um desses dois casos acontecer. \n");
        sb.append("Compare o resultado com o exercício 1;");

        return  sb.toString();
    }

    private String createSubStatements_7_3(){
        StringBuilder sb = new StringBuilder();
        sb.append("3- Faça uma versão dos programas anteriores que permita ao usuário:\n");
        sb.append("==> a- Digitar as dimensões da chapa (linhas e colunas)\n");
        sb.append("==> b- Digitar os valores das temperaturas dos lados\n");
        sb.append("==> c- Digitar o número máximo de iterações\n");
        sb.append("==> d- Digitar o erro máximo aceitável\n");
        sb.append("==> e- Digitar o número de casas decimais que serão mostrados os resultados \n");
        sb.append("\n");
        sb.append("Feito isso, utilizando os dados do exercício 1, após quantas iterações a chapa apresentará um erro máximo aceitável abaixo de 1 e-7?");

        return  sb.toString();
    }

    public void print(ExerciseStatement stmt) throws Exception {
        switch (stmt){
            case CHALLENGE7 -> System.out.println(super.getMainStatement());
            case CHALLENGE7_1 -> System.out.println(super.getSubStatements()[0]);
            case CHALLENGE7_2 -> System.out.println(super.getSubStatements()[1]);
            case CHALLENGE7_3 -> System.out.println(super.getSubStatements()[2]);
            default -> throw new Exception("Exercise loading error");
        }

    }
}
