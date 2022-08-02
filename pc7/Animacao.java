/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 13/05/2022
* Ultima alteracao.: 21/05/2022
* Nome.............: Transito Automato
* Funcao...........: O programa e utilizado resolver o problema de gerenciamento de procesos 
em um transito automato com 7 carros e varias regioes criticas
*************************************************************** */

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Animacao extends Thread{
  private double velocidade = 1;

  /***********************
    * Metodo: run
    * Funcao: inicia o metodo para ser herdado
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
  @Override
  public void run(){}
  
  /***********************
  * Metodo: setVelocidade
  * Funcao: seta a velocidade do carro que esta sendo chamado
  * Parametros: Double velocidade
  * Retorno: void
  *********************** */  
  public void setVelocidade(double vel) {
    velocidade = vel;
  }

  /***********************
  * Metodo: rota
  * Funcao: chamado pela classe para que possa chegar ao fim da rota passada
  * Parametros: double x para qual posicao do x ele ira, double y para qual posicao do y ele ira,
  * int i com o indice do vetor  para algumas alteracoes, ImageView carro que movimenta
  * Retorno: void
  *********************** */
  public void rota(double x, double y, int i, ImageView carro) throws InterruptedException {
    while(carro.getLayoutX() != x || carro.getLayoutY() != y){//condição de parada(para quando a posicao passada e do carro é igual)
      //System.out.println(carro.getLayoutX()+", "+x+"   "+carro.getLayoutY()+", "+y);
      if(x != carro.getLayoutX()){//movimenta x se a posicao passada é diferente da atual
        if(x>carro.getLayoutX()){//aumenta quando tem que auentar
          Platform.runLater( () -> carro.setLayoutX(carro.getLayoutX()+1));
        }else{//diminui quando tem que diminuir
          Platform.runLater( () -> carro.setLayoutX(carro.getLayoutX()-1));
        }
      }
      if(y != carro.getLayoutY()){//movimenta y se a posicao passada é diferente da atual
        if(y>carro.getLayoutY()){//aumenta quando tem que auentar
          Platform.runLater( () -> carro.setLayoutY(carro.getLayoutY()+1));
        }else{//diminui quando tem que diminuir
          Platform.runLater( () -> carro.setLayoutY(carro.getLayoutY()-1));
        }        
      }
      Thread.sleep((long) ((55)-(velocidade*5)));//espera por tempo menor quando a velocidade é maior
    }
  }
}
