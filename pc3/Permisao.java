/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 20/03/2021
* Ultima alteracao.: 25/03/2022
* Nome.............: Gerenciador de Peocessos Trem
* Funcao...........: O programa e utilizado gerencia os procesos que fazem com que os trens se colidam em momentos criticos
*************************************************************** */
import javafx.scene.control.Label;

public class Permisao {
 
  private int[] interesse = new int[2];
  private int vez;
  private Label direita, esquerda;

  /*********************************************************************
  * Metodo: entraTunel
  * Funcao: alterar a variavel vez de quem esta dentro do tunel 
  * para que o outro elemto não entrem na regiao critica
  * Parametros: int referenciando o processo que deseja entrar na regiao critica
  * Retorno: void
  ******************************************************************* */
  public void entraTunel(int processo){
    direita.setVisible(true);//levanta a bandeira
    esquerda.setVisible(true);//levanta a bandeira
    int outro = 1-processo;//altera o valor da variavel outro para o oposto do processo attual 
    interesse[processo] = 1;//deixa o interesse em estar na regiao critica igual a 1 = TRUE
    vez = processo;// coloca a vez como o processo atual
    while(vez == processo && interesse[outro] == 1){//espera enquanto a vez for do outro processo e quando o outro processo tiver interesse 
      System.out.println("interesse "+(1-processo));
    }
  }

  /*********************************************************************
  * Metodo: entraTunel
  * Funcao: Retira o elemento da regiao critica possibiliando a entrada do outro 
  * Parametros: int referenciando o processo que deseja sair na regiao critica
  * Retorno: void
  ******************************************************************* */
  public void saiTunel(int processo){
      interesse[processo] = 0;//deixa o interesse em estar na regiao critica igual a 0 = FALSO
      esquerda.setVisible(false);//abaixa a bandeira
      direita.setVisible(false);//abaixa a bandeira
  }

  /*********************************************************************
  * Metodo: atribuiBandeiras
  * Funcao: Atribui as bandeiras a variaveis para serem levantadas quando necessario 
  * Parametros: Label Bandeiras direita e esquerda
  * Retorno: void
  ******************************************************************* */
  public void atribuiBandeiras(javafx.scene.control.Label dir, javafx.scene.control.Label esq ){
    direita = dir;
    esquerda = esq;
  }
}
