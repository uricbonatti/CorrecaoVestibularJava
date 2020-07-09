package Resposta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TratamentoArquivos {
    private static String resultadoPath;
    private static List<Vestibulando> vestibulandoList = new ArrayList<Vestibulando>();

    public void setResultadoPath(String path){
        this.resultadoPath=path;
    }
    public static void lerGabarito(String path) throws IOException {
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            String gabarito = file.readLine();
            file.close();
            Vestibulando.setGabarito(gabarito);
        } catch (IOException e){
            System.out.println("Algo esta errado com o arquivo de gabarito");
        }
    }
    public static void lerRespostas(String path) throws IOException{
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            while(file.ready()){
                String resposta = file.readLine();
                vestibulandoList.add(new Vestibulando(resposta));
            }
        } catch (IOException e){
            System.out.println("Algo esta errado com o arquivo de respostas");
        }
    }
    public static String showAll(){
        String respostas = "";
        for (Vestibulando vestibulando: vestibulandoList) {
            respostas=respostas.concat(vestibulando.respostasVestibulando()+"\n");
        }
        return respostas;
    }
    public static void salvarResultado(String path) throws IOException{
        try{
            FileWriter arquivo = new FileWriter(path+".txt");
            PrintWriter gravarResultado = new PrintWriter(arquivo);
            gravarResultado.println(TratamentoArquivos.showAll());
            arquivo.close();
        }catch (IOException e){
            System.out.println("Algo errado com o diretorio");
        }
    }
}
