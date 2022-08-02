/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 20/03/2021
* Ultima alteracao.: 25/03/2022
* Nome.............: Gerenciador de Peocessos Trem
* Funcao...........: O programa e utilizado gerencia os procesos que fazem com que os trens se colidam em momentos criticos
*************************************************************** */
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Threads{
  Button btStart;
  Rotas rotas = new Rotas();

  public Threads(Button btStart) {
    this.btStart = btStart;
  }

  /*********************************************************************
  * Metodo: atribuiBandeiras
  * Funcao: Atribui as bandeiras a variaveis para serem levantadas quando necessario 
  * Parametros: Label Bandeiras direita e esquerda
  * Retorno: void
  ******************************************************************* */
  public void atribuiBandeiras(javafx.scene.control.Label dir, javafx.scene.control.Label esq ){
    rotas.atribuiBandeiras(dir, esq);
  }

  /*********************************************************************
  * Metodo: voltaInicial
  * Funcao: Volta com os trens para a posicao inicial 
  * Parametros: ImageView referente ao trem 1 e 2
  * Retorno: void
  ******************************************************************* */
  public void voltaInicial(javafx.scene.image.ImageView  trem1,javafx.scene.image.ImageView  trem2 ){
    Rotas rotas = new Rotas();
    try {
      rotas.volta(trem1, -810, 0);
      rotas.volta(trem2, -810, 0);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /*********************************************************************
  * Classe: Trem1 
  * Funcao: Agrupa os metodos para que o trem percorra o trilho 
  * Parametros: 
  * Retorno: 
  ******************************************************************* */
  public class Trem1 extends Thread{
    private ImageView trem;
    private int velocidade;

  /*********************************************************************
  * Metodo: Trem1(Construtor)
  * Funcao: Inicia as variaveis que são passadas pela classe acima 
  * Parametros: ImageView do trem, int com a velocidade do trem
  * Retorno: void
  ******************************************************************* */
    public Trem1(javafx.scene.image.ImageView  trem , int velocidade){
      this.trem = trem;
      this.velocidade = velocidade;
    }

  /*********************************************************************
  * Metodo: run
  * Funcao: percorrer pelos trilhos passados 
  * Parametros: sem parametros
  * Retorno: void
  ******************************************************************* */
    @Override
    public void run() {
  
      try {

        rotas.animacao1(trem, velocidade, btStart);
        
      } catch (Exception e) {
        System.out.println("Erro trem 1");
      }

    }    
  }
  
  /*********************************************************************
  * Classe: Trem2
  * Funcao: Agrupa os metodos para que o trem percorra o trilho 
  * Parametros: 
  * Retorno: 
  ******************************************************************* */
  public class Trem2 extends Thread{
    
    private ImageView trem;
    private int velocidade;

    /*********************************************************************
    * Metodo: Trem2(Construtor)
    * Funcao: Inicia as variaveis que são passadas pela classe acima 
    * Parametros: ImageView do trem, int com a velocidade do trem
    * Retorno: void
    ******************************************************************* */
    public Trem2(javafx.scene.image.ImageView  trem , int velocidade){
      this.trem = trem;
      this.velocidade = velocidade;
    }

    /*********************************************************************
    * Metodo: run
    * Funcao: percorrer pelos trilhos passados 
    * Parametros: sem parametros
    * Retorno: void
    ******************************************************************* */
    @Override
    public void run() {
  
      try {

        rotas.animacao2(trem, velocidade, btStart);
  
      } catch (Exception e) {
        System.out.println("Erro trem 2");
      }

    }    
  }
}
