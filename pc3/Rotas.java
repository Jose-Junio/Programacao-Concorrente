/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 20/03/2021
* Ultima alteracao.: 25/03/2022
* Nome.............: Gerenciador de Peocessos Trem
* Funcao...........: O programa e utilizado gerencia os procesos que fazem com que os trens se colidam em momentos criticos
*************************************************************** */
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Rotas {
  Permisao p = new Permisao();

  /*********************************************************************
  * Metodo: Trilho1
  * Funcao: movimenta o trem recebido como parametro para os locais indicados ao longo do trilho
  * Parametros: ImageView do trem, int com a velocidade do trem e int de distancia que sera percorrida
  * Retorno: void
  ******************************************************************* */
  public void Trilho1(javafx.scene.image.ImageView trem, int velocidade, int distancia, int dist) throws InterruptedException{ 
    long tempo = (1000/velocidade); //inicializa uma variavel com o tempo de execucao da animacao
    int percorrido = 10;
    boolean continua = true;

    while(trem.getX()<dist+distancia && continua){
      if((trem.getX()+percorrido) <= dist+distancia){
        Platform.runLater( () -> trem.setX(trem.getX()+percorrido));
        if(trem.getX()==dist+distancia){
          continua = false;
        }
      }else if(trem.getX()+percorrido>dist+distancia){
        Platform.runLater( () -> trem.setX(trem.getX()+(trem.getX()+percorrido-distancia)));
      }
      Thread.sleep(tempo);
    }
  }

  /*********************************************************************
  * Metodo: Curva
  * Funcao: movimenta o trem recebido como parametro para os locais indicados ao longo da curva
  * Parametros: ImageView do trem, int com a velocidade do trem e int de distancia (x e y) que sera percorrida
  * Retorno: void
  ******************************************************************* */
  public void Curva(javafx.scene.image.ImageView trem, int velocidade, int distanciaX, int distanciaY,int dist) throws InterruptedException{
    long tempo = (1000/velocidade); //inicializa uma variavel com o tempo de execucao da animacao
    int percorrido = 10;
    boolean continua = true;

    while(trem.getX()>=dist && trem.getX()<dist+distanciaX && continua){
      if((trem.getX()+percorrido) <= dist+distanciaX){
        
        if(distanciaX<0){
          Platform.runLater( () ->trem.setX(trem.getX()-percorrido));
        }else if(distanciaX>0){
          Platform.runLater( () ->trem.setX(trem.getX()+percorrido));
        }

        if(distanciaY<0){
          Platform.runLater( () ->trem.setY(trem.getY()-percorrido));
        }else if(distanciaY>0){
          Platform.runLater( () ->trem.setY(trem.getY()+percorrido));
        }
          
        if(trem.getX()==dist+distanciaX){
          continua = false;
        }
      }else if(trem.getX()+percorrido> dist+distanciaX){//////////////////////////////////////
        Platform.runLater( () ->trem.setX(trem.getX()+(trem.getX()+percorrido-distanciaX)));
        Platform.runLater( () ->trem.setY(trem.getY()+(trem.getY()+percorrido-distanciaX)));
      }
      Thread.sleep(tempo);
    }
  }

  /*********************************************************************
  * Metodo: Tunel
  * Funcao: movimenta o trem recebido como parametro para os locais indicados ao longo do Tunel
  * Parametros: ImageView do trem, int com a velocidade do trem e int de distancia que sera percorrida
  * Retorno: void
  ******************************************************************* */
  public void Tunel(javafx.scene.image.ImageView trem, int velocidade, int distanciaX) throws InterruptedException{
    long tempo = (1000/velocidade); //inicializa uma variavel com o tempo de execucao da animacao
    int percorrido = 10;
    boolean continua = true;
    int dist = 170;

    while(trem.getX()<dist+distanciaX && continua){
      if((trem.getX()+percorrido) <= dist+distanciaX){
        
        Platform.runLater( () ->trem.setX(trem.getX()+percorrido));

        if(trem.getX()==dist+distanciaX){
          continua = false;
        }
      }else if(trem.getX()+percorrido> dist+distanciaX){//////////////////////////////////////
        Platform.runLater( () ->trem.setX(trem.getX()+(trem.getX()+percorrido-distanciaX)));
      }
      Thread.sleep(tempo);
    }
    
    
    
    // Double tempo = (double) (1000*10/velocidade);//inicializa uma variavel com o tempo de execucao da animacao
    // TranslateTransition tt = new TranslateTransition();// instancia a classe que faz as animacoes
    // tt.setNode(trem);//adiciona o componente que sofrera as animacoes
    // tt.setDuration(Duration.millis(tempo));//adiciona o tempo deduracao
    // tt.setByX(tt.getByX()+distanciaX);//anima percorrendo o eixo x
    // tt.play();//executa a animacao
    // Thread.sleep((1000*10/velocidade));//espera o tempo da animacao
  }

  /*********************************************************************
  * Metodo: volta
  * Funcao: Atribui as bandeiras a variaveis para serem levantadas quando necessario 
  * Parametros: Label Bandeiras direita e esquerda, int x e y da posicao inicial
  * Retorno: void
  ******************************************************************* */
  public void volta(javafx.scene.image.ImageView trem, int x, int y) throws InterruptedException{
    
    
    Platform.runLater( () ->trem.setX(-130));
    Platform.runLater( () ->trem.setY(0));
    
    
    
    // TranslateTransition tt = new TranslateTransition();// instancia a classe que faz as animacoes
    // tt.setNode(trem);//adiciona o componente que sofrera as animacoes
    // tt.setDuration(Duration.millis(1));//adiciona o tempo deduracao
    // tt.setByX(x);//anima percorrendo o eixo x
    // tt.setByY(y);//anima percorrendo o eixo y
    // tt.play();//executa a animacao
    // Thread.sleep((1000));//espera o tempo da animacao
  }

  public void animacao1(ImageView trem, int velocidade, Button btStart) throws InterruptedException {
    Trilho1(trem, velocidade, 120,0);
    //rotas.Trilho1(trem, velocidade, 120);
    Curva(trem, velocidade, 40, 20,120);
    p.entraTunel(1);
    Tunel(trem, velocidade,250);
    p.saiTunel(1);
    Curva(trem, velocidade, 40, -30,410);
    Trilho1(trem, velocidade, 120,570);

    volta(trem, -130, 0);
    btStart.setDisable(false);
  }

  public void animacao2(ImageView trem, int velocidade, Button btStart) throws InterruptedException {
    Trilho1(trem, velocidade, 120,0);
    //rotas.Trilho1(trem, velocidade, 120);
    Curva(trem, velocidade, 40, -20,120);
    p.entraTunel(0);
    Tunel(trem, velocidade,250);
    p.saiTunel(0);
    Curva(trem, velocidade, 40, 30,410);
    Trilho1(trem, velocidade, 120,570);

    volta(trem, -130, 0);
    btStart.setDisable(false);
  }

  /*********************************************************************
  * Metodo: atribuiBandeiras
  * Funcao: Atribui as bandeiras a variaveis para serem levantadas quando necessario 
  * Parametros: Label Bandeiras direita e esquerda
  * Retorno: void
  ******************************************************************* */
  public void atribuiBandeiras(javafx.scene.control.Label dir, javafx.scene.control.Label esq ){
    p.atribuiBandeiras(dir, esq);
  }
}
