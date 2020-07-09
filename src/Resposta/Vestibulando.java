package Resposta;

public class Vestibulando {
    private static String gabarito;
    private String idVestibulando;
    private String respostasVestibulando;
    private String acertosVestibulando;
    private String acertosPorQuestao;
    public Vestibulando(String info)   {
        String[] infoSeparada = info.split(" ");
        this.idVestibulando=infoSeparada[0];
        this.respostasVestibulando=infoSeparada[1];
        this.calcularAcertos();
    }
    public static String getGabarito() {
        return gabarito;
    }

    public static void setGabarito(String gabarito) {
        Vestibulando.gabarito = gabarito;
    }

    public String getIdVestibulando() {
        return idVestibulando;
    }

    public void setIdVestibulando(String idVestibulando) {
        this.idVestibulando = idVestibulando;
    }

    public String getRespostasVestibulando() {
        return respostasVestibulando;
    }

    public void setRespostasVestibulando(String respostasVestibulando) {
        this.respostasVestibulando = respostasVestibulando;

    }

    public String getAcertosVestibulando() {
        return acertosVestibulando;
    }

    public void setAcertosVestibulando(String acertosVestibulando) {
        this.acertosVestibulando = acertosVestibulando;
    }

    public String getAcertosPorQuestao() {
        return acertosPorQuestao;
    }

    public void setAcertosPorQuestao(String acertosPorQuestao) {
        this.acertosPorQuestao = acertosPorQuestao;
    }

    private void calcularAcertos()  throws StringIndexOutOfBoundsException{
        String validarAcertos="";
        int acertos=0;
        for (int i =0; i<gabarito.length();i++) {
            try {
                if (gabarito.charAt(i) == this.respostasVestibulando.charAt(i)) {
                    acertos++;
                    validarAcertos=validarAcertos.concat("r");
                }else{
                    validarAcertos=validarAcertos.concat("f");
                }
            }catch (StringIndexOutOfBoundsException e){
                break;
            }
        }
        this.acertosVestibulando=Integer.toString(acertos);
        this.acertosPorQuestao=validarAcertos;
    }
    public void infoCompleta(){
        System.out.println("gabarito = " + gabarito);
        System.out.println("idVestibulando = " + idVestibulando);
        System.out.println("respostasVestibulando = " + respostasVestibulando);
        System.out.println("acertosPorQuestao = " + acertosPorQuestao);
        System.out.println("acertosVestibulando = " + acertosVestibulando);
    }
    public String respostasVestibulando(){
        return idVestibulando+" "+acertosVestibulando;
    }
}
