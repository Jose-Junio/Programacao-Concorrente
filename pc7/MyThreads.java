/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 13/05/2022
* Ultima alteracao.: 21/05/2022
* Nome.............: Transito Automato
* Funcao...........: O programa e utilizado resolver o problema de gerenciamento de procesos 
em um transito automato com 7 carros e varias regioes criticas
*************************************************************** */
import java.util.concurrent.Semaphore;
import javafx.scene.image.ImageView;

/***********************
  * Classe: MyThreads 
  * Funcao: Agrupa os metodos e as classes compartilhadas das threads 
  * Parametros: 
  * Retorno: 
  *********************** */
public class MyThreads {
  //inicia o array de semaforos dos carros 
  public static Semaphore[] vermelho = {new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1)};
  public static Semaphore[] amarelo = {new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1)};
  public static Semaphore[] verde = {new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1)};
  public static Semaphore[] azul = {new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1)};
  public static Semaphore[] roxo = {new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1)};
  public static Semaphore[] marrom = {new Semaphore(1),new Semaphore(1),new Semaphore(1)};

  private ImageView[] carros;//array com as imagens dos carros

  /***********************
  * Metodo: MyThreads(Construtor)
  * Funcao: nenhuma no momento
  * Parametros: 
  * Retorno: void
  *********************** */
  public MyThreads(){
  }

  /***********************
  * Metodo: setCarros
  * Funcao: adiciona as imagens recebidas para o as variaveis das imagens dos carros
  * Parametros: ImageView de imagens
  * Retorno: void
  *********************** */
  public void setCarros(ImageView[] c) {
    carros = c;
  }

  /***********************
  * Classe: Carro1 
  * Funcao: Agrupa os metodos da thread responsavel pelo carro vermelho
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Carro1 extends Animacao{
    /***********************
    * Metodo: run
    * Funcao: executa cada funcao do carro seguir a rota especifica e esperar
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    @Override
    public void run(){
      int i = 0;
      while(true){
        try {
          if(i==0){
            rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+14), 0, carros[0]);   
            i++;
          }
          vermelho[0].acquire();//vermelho e amarelo
          vermelho[11].acquire();//vermelho e marrom
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()-14), 0, carros[0]);   
          rota((carros[0].getLayoutX()-96), carros[0].getLayoutY(), 0, carros[0]);
          rota((carros[0].getLayoutX()-96), carros[0].getLayoutY(), 0, carros[0]);

          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+83), 0, carros[0]);
          vermelho[6].acquire();//vermelho e azul
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+14), 0, carros[0]);
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+83), 0, carros[0]);
          vermelho[13].acquire();//vermelho e roza
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+14), 0, carros[0]);
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+83), 0, carros[0]);
          vermelho[13].release();//vermelho e roza
          vermelho[11].release();//vermelho e marron
          vermelho[6].release();//vermelho e azul
          vermelho[0].release();//vermelho e amarelo
          
          vermelho[5].acquire();//vermelho e verde
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+14), 0, carros[0]);
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+83), 0, carros[0]);

          vermelho[1].acquire();//vermelho e amarelo
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+14), 0, carros[0]);
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()+97), 0, carros[0]);

          rota((carros[0].getLayoutX()+96), carros[0].getLayoutY(), 0, carros[0]);
          rota((carros[0].getLayoutX()+85), carros[0].getLayoutY(), 0, carros[0]);
          vermelho[14].acquire();//vermelho e roza
          rota((carros[0].getLayoutX()+11), carros[0].getLayoutY(), 0, carros[0]);
          rota((carros[0].getLayoutX()+85), carros[0].getLayoutY(), 0, carros[0]);
          vermelho[14].release();//vermelho e roza
          vermelho[9].acquire();//vermelho e roxo
          rota((carros[0].getLayoutX()+11), carros[0].getLayoutY(), 0, carros[0]);
          rota((carros[0].getLayoutX()+96), carros[0].getLayoutY(), 0, carros[0]);
          rota((carros[0].getLayoutX()+96), carros[0].getLayoutY(), 0, carros[0]);
          
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()-97), 0, carros[0]);
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()-83), 0, carros[0]);
          vermelho[9].release();//vermelho e roxo
          vermelho[1].release();//vermelho e amarelo

          vermelho[7].acquire();//vermelho e azul
          vermelho[15].acquire();//vermelho e roza
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()-14), 0, carros[0]);
          rota((carros[0].getLayoutX()-85), carros[0].getLayoutY(), 0, carros[0]);

          vermelho[2].acquire();//vermelho e amarelo
          rota((carros[0].getLayoutX()-11), carros[0].getLayoutY(), 0, carros[0]);
          rota((carros[0].getLayoutX()-85), carros[0].getLayoutY(), 0, carros[0]);
          vermelho[15].release();//vermelho e roza
          vermelho[10].acquire();//vermelho e roxo
          vermelho[12].acquire();//vermelho e marrom
          rota((carros[0].getLayoutX()-11), carros[0].getLayoutY(), 0, carros[0]);
          rota((carros[0].getLayoutX()-85), carros[0].getLayoutY(), 0, carros[0]);
          vermelho[7].release();//vermelho e azul
          vermelho[5].release();//vermelho e verde
          vermelho[10].release();//vermelho e roxo
          vermelho[12].release();//vermelho e marrom
          vermelho[2].release();//vermelho e amarelo

          vermelho[16].acquire();//vermelho e roza
          rota((carros[0].getLayoutX()-11), carros[0].getLayoutY(), 0, carros[0]);
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()-83), 0, carros[0]);
          vermelho[16].release();//vermelho e roza
          vermelho[3].acquire();//vermelho e amarelo
          vermelho[8].acquire();//vermelho e azul
          vermelho[17].acquire();//vermelho e roza
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()-14), 0, carros[0]);
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()-83), 0, carros[0]);
          vermelho[3].release();//vermelho e amarelo
          vermelho[8].release();//vermelho e azul
          vermelho[4].acquire();//vermelho e amarelo
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()-14), 0, carros[0]);
          rota(carros[0].getLayoutX(), (carros[0].getLayoutY()-83), 0, carros[0]);   
          vermelho[4].release();//vermelho e amarelo  
          vermelho[17].release();//vermelho e roza

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      
      }
    }

    /***********************
    * Metodo: setFrequenciaCliente
    * Funcao: adiciona o tempo recebido para as variaveis
    * Parametros: Double tempo de espera
    * Retorno: void
    *********************** */
    public void setVelocidade(double vel) {
      super.setVelocidade(vel);
    }  
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////
  /***********************
  * Classe: Carro2 
  * Funcao: Agrupa os metodos da thread responsavel pelo carro amarelo
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Carro2 extends Animacao{

    /***********************
    * Metodo: run
    * Funcao: executa cada funcao do carro seguir a rota especifica e esperar
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    @Override
    public void run(){
      int i = 0;
      while(true){
        
        try {
          
          amarelo[0].acquire();//amarelo e verde
          if(i == 0){
            amarelo[2].acquire();//amarelo e azul
            amarelo[11].acquire();//amarelo e marrom
            amarelo[14].acquire();//amarelo e roza
            rota(carros[1].getLayoutX(), (carros[1].getLayoutY()-14), 1, carros[1]);
            i++;
          }          
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()+14), 1, carros[1]);
          rota((carros[1].getLayoutX()+96), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[14].release();//amarelo e roza
          vermelho[2].acquire();//vermelho e amarelo
          rota((carros[1].getLayoutX()+11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[11].release();//amarelo e marrom
          amarelo[5].acquire();//amarelo e roxo
          amarelo[15].acquire();//amarelo e roza
          rota((carros[1].getLayoutX()+11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+96), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[15].release();//amarelo e roza
          amarelo[5].release();//amarelo e roxo
          vermelho[2].release();//vermelho e amarelo
          amarelo[0].release();//amarelo e verde
          amarelo[2].release();//amarelo e azul
          
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()+97), 1, carros[1]);

          rota((carros[1].getLayoutX()-85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[16].acquire();//amarelo e roza
          amarelo[6].acquire();//amarelo e roxo
          rota((carros[1].getLayoutX()-11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()-96), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[16].release();//amarelo e roza
          amarelo[6].release();//amarelo e roxo
          rota((carros[1].getLayoutX()-96), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()-85), carros[1].getLayoutY(), 1, carros[1]);

          vermelho[1].acquire();//vermelho e amarelo
          amarelo[1].acquire();//amarelo e verde
          rota((carros[1].getLayoutX()-11), carros[1].getLayoutY(), 1, carros[1]);
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()+97), 1, carros[1]);

          rota((carros[1].getLayoutX()+96), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[17].acquire();//amarelo e roza
          rota((carros[1].getLayoutX()+11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[17].release();//amarelo e roza
          amarelo[7].acquire();//amarelo e roxo
          rota((carros[1].getLayoutX()+11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+96), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+96), carros[1].getLayoutY(), 1, carros[1]);


          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()-97), 1, carros[1]);
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()-83), 1, carros[1]);
          vermelho[1].release();//vermelho e amarelo
          amarelo[1].release();//amarelo e verde
          amarelo[3].acquire();//amarelo e azul
          amarelo[18].acquire();//amarelo e roza

          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()-14), 1, carros[1]);
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()-97), 1, carros[1]);
          amarelo[3].release();//amarelo e azul

          amarelo[7].release();//amarelo e roxo
          rota((carros[1].getLayoutX()-96), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()-85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[18].release();//amarelo e roza
          amarelo[12].acquire();//amarelo e marrom
          rota((carros[1].getLayoutX()-11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()-85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[12].release();//amarelo e marrom
          vermelho[4].acquire();//vermelho e amarelo
          amarelo[19].acquire();//amarelo e roza
          rota((carros[1].getLayoutX()-11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()-96), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[19].release();//amarelo e roza
          vermelho[4].release();//vermelho e amarelo
          
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()-83), 1, carros[1]);
          
          amarelo[4].acquire();//amarelo e azul
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()-14), 1, carros[1]);
          rota((carros[1].getLayoutX()+85), carros[1].getLayoutY(), 1, carros[1]);
          vermelho[4].acquire();//vermelho e amarelo
          amarelo[20].acquire();//amarelo e roza
          amarelo[9].acquire();//amarelo e roxo
          rota((carros[1].getLayoutX()+11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[20].release();//amarelo e roza
          amarelo[9].release();//amarelo e roxo
          vermelho[4].release();//vermelho e amarelo
          amarelo[13].acquire();//amarelo e marrom
          amarelo[21].acquire();//amarelo e roza
          rota((carros[1].getLayoutX()+11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[21].release();//amarelo e roza
          amarelo[13].release();//amarelo e marrom
          amarelo[10].acquire();//amarelo e roxo
          rota((carros[1].getLayoutX()+11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()+85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[10].release();//amarelo e roxo
          amarelo[4].release();//amarelo e azul
          
          amarelo[8].acquire();//amarelo e roxo
          rota((carros[1].getLayoutX()+11), carros[1].getLayoutY(), 1, carros[1]);
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()-97), 1, carros[1]);
          
          rota((carros[1].getLayoutX()-96), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()-85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[8].release();//amarelo e roxo
          amarelo[11].acquire();//amarelo e marrom
          rota((carros[1].getLayoutX()-11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()-85), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[22].acquire();//amarelo e roza
          vermelho[0].acquire();//vermelho e amarelo
          rota((carros[1].getLayoutX()-11), carros[1].getLayoutY(), 1, carros[1]);
          rota((carros[1].getLayoutX()-96), carros[1].getLayoutY(), 1, carros[1]);
          amarelo[22].release();//amarelo e roza
          rota((carros[1].getLayoutX()-96), carros[1].getLayoutY(), 1, carros[1]);

          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()+83), 1, carros[1]);
          amarelo[2].acquire();//amarelo e azul
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()+14), 1, carros[1]);
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()+83), 1, carros[1]);
          amarelo[14].acquire();//amarelo e roza
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()+14), 1, carros[1]);
          rota(carros[1].getLayoutX(), (carros[1].getLayoutY()+83), 1, carros[1]);
          vermelho[0].release();//vermelho e amarelo

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      
      }
    }

    /***********************
    * Metodo: setFrequenciaCliente
    * Funcao: adiciona o tempo recebido para as variaveis
    * Parametros: Double tempo de espera
    * Retorno: void
    *********************** */
    public void setVelocidade(double vel) {
      super.setVelocidade(vel);
    }  
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////
  /***********************
  * Classe: Carro3 
  * Funcao: Agrupa os metodos da thread responsavel pelo carro verde
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Carro3 extends Animacao{

    /***********************
    * Metodo: run
    * Funcao: executa cada funcao do carro seguir a rota especifica e esperar
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    @Override
    public void run(){
      int i = 0;
      while(true){
        try {
          if(i==0){
            vermelho[5].acquire();//vermelho e verde
            rota((carros[2].getLayoutX()-11), carros[2].getLayoutY(), 2, carros[2]);
            i++;
          }
          amarelo[1].acquire();//amarelo e verde
          verde[1].acquire();//verde e roxo
          rota((carros[2].getLayoutX()+11), carros[2].getLayoutY(), 2, carros[2]);
          rota(carros[2].getLayoutX(), (carros[2].getLayoutY()+97), 2, carros[2]);
          rota(carros[2].getLayoutX(), (carros[2].getLayoutY()+97), 2, carros[2]);

          rota((carros[2].getLayoutX()-96), carros[2].getLayoutY(), 2, carros[2]);
          rota((carros[2].getLayoutX()-85), carros[2].getLayoutY(), 2, carros[2]);
          verde[1].release();//verde e roxo
          verde[4].acquire();//verde e roza
          rota((carros[2].getLayoutX()-11), carros[2].getLayoutY(), 2, carros[2]);
          rota((carros[2].getLayoutX()-96), carros[2].getLayoutY(), 2, carros[2]);
          verde[4].release();//verde e roza
          rota((carros[2].getLayoutX()-96), carros[2].getLayoutY(), 2, carros[2]);
          rota((carros[2].getLayoutX()-96), carros[2].getLayoutY(), 2, carros[2]);
          
          rota(carros[2].getLayoutX(), (carros[2].getLayoutY()-97), 2, carros[2]);
          amarelo[1].release();//amarelo e verde
          rota(carros[2].getLayoutX(), (carros[2].getLayoutY()-83), 2, carros[2]);
          
          amarelo[0].acquire();//amarelo e verde
          verde[0].acquire();//verde e azul
          verde[3].acquire();//verde e marrom
          verde[5].acquire();//verde e roza
          vermelho[5].release();//vermelho e verde
          rota(carros[2].getLayoutX(), (carros[2].getLayoutY()-14), 2, carros[2]);
          rota((carros[2].getLayoutX()+96), carros[2].getLayoutY(), 2, carros[2]);
          rota((carros[2].getLayoutX()+85), carros[2].getLayoutY(), 2, carros[2]);
          verde[5].release();//verde e roza
          vermelho[5].acquire();//vermelho e verde
          rota((carros[2].getLayoutX()+11), carros[2].getLayoutY(), 2, carros[2]);
          rota((carros[2].getLayoutX()+85), carros[2].getLayoutY(), 2, carros[2]);
          verde[3].release();//verde e marrom
          verde[2].acquire();//verde e roxo
          verde[6].acquire();//verde e roza
          rota((carros[2].getLayoutX()+11), carros[2].getLayoutY(), 2, carros[2]);
          rota((carros[2].getLayoutX()+85), carros[2].getLayoutY(), 2, carros[2]);
          verde[2].release();//verde e roxo
          amarelo[0].release();//amarelo e verde
          rota((carros[2].getLayoutX()+11), carros[2].getLayoutY(), 2, carros[2]);
          rota((carros[2].getLayoutX()+85), carros[2].getLayoutY(), 2, carros[2]);
          verde[0].release();//verde e azul
          verde[6].release();//verde e roza
       
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }

    /***********************
    * Metodo: setFrequenciaCliente
    * Funcao: adiciona o tempo recebido para as variaveis
    * Parametros: Double tempo de espera
    * Retorno: void
    *********************** */
    public void setVelocidade(double vel) {
      super.setVelocidade(vel);
    }  
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////
  /***********************
  * Classe: Carro4 
  * Funcao: Agrupa os metodos da thread responsavel pelo carro azul
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Carro4 extends Animacao{

    /***********************
    * Metodo: run
    * Funcao: executa cada funcao do carro seguir a rota especifica e esperar
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    public void run(){
      int i =0;
      while(true){
        try {
          if(i==0){
            rota(carros[3].getLayoutX(), (carros[3].getLayoutY()+14), 3, carros[3]);
            i++;
          }
          amarelo[4].acquire();//amarelo e azul
          rota(carros[3].getLayoutX(), (carros[3].getLayoutY()-14), 3, carros[3]);
          rota((carros[3].getLayoutX()-96), carros[3].getLayoutY(), 3, carros[3]);
          rota((carros[3].getLayoutX()-85), carros[3].getLayoutY(), 3, carros[3]);
          azul[0].acquire();//azul e roxo
          azul[3].acquire();//azul e marrom
          azul[5].acquire();//azul e roza
          rota((carros[3].getLayoutX()-11), carros[3].getLayoutY(), 3, carros[3]);
          rota((carros[3].getLayoutX()-85), carros[3].getLayoutY(), 3, carros[3]);
          azul[5].release();//azul e roza
          azul[3].release();//azul e marrom
          azul[0].release();//azul e roxo
          vermelho[8].acquire();//vermelho e azul
          azul[6].acquire();//azul e roza;
          rota((carros[3].getLayoutX()-11), carros[3].getLayoutY(), 3, carros[3]);
          rota((carros[3].getLayoutX()-96), carros[3].getLayoutY(), 3, carros[3]);
          azul[6].release();//azul e roza
          amarelo[4].release();//amarelo e azul
          vermelho[8].release();//vermelho e azul
          rota((carros[3].getLayoutX()-85), carros[3].getLayoutY(), 3, carros[3]);
          
          amarelo[2].acquire();//amarelo e azul
          azul[4].acquire();//azul e marrom
          vermelho[7].acquire();//vermelho e azul
          vermelho[6].acquire();//vermelho e azul
          rota((carros[3].getLayoutX()-11), carros[3].getLayoutY(), 3, carros[3]);
          rota(carros[3].getLayoutX(), (carros[3].getLayoutY()+83), 3, carros[3]);
          azul[7].acquire();//azul e roza
          rota(carros[3].getLayoutX(), (carros[3].getLayoutY()+14), 3, carros[3]);
          rota(carros[3].getLayoutX(), (carros[3].getLayoutY()+83), 3, carros[3]);
          vermelho[6].release();//vermelho e azul
          vermelho[7].release();//vermelho e azul
          
          verde[0].acquire();//verde e azul
          rota(carros[3].getLayoutX(), (carros[3].getLayoutY()+14), 3, carros[3]);
          rota((carros[3].getLayoutX()+96), carros[3].getLayoutY(), 3, carros[3]);
          rota((carros[3].getLayoutX()+85), carros[3].getLayoutY(), 3, carros[3]);
          azul[7].release();//azul e roza
          rota((carros[3].getLayoutX()+11), carros[3].getLayoutY(), 3, carros[3]);
          rota((carros[3].getLayoutX()+85), carros[3].getLayoutY(), 3, carros[3]);
          azul[4].release();//azul e marrom
          azul[1].acquire();//azul e roxo
          azul[8].acquire();//azul e roza
          rota((carros[3].getLayoutX()+11), carros[3].getLayoutY(), 3, carros[3]);
          rota((carros[3].getLayoutX()+96), carros[3].getLayoutY(), 3, carros[3]);
          azul[1].release();//azul e roxo
          amarelo[2].release();//amarelo azul
          rota((carros[3].getLayoutX()+85), carros[3].getLayoutY(), 3, carros[3]);
          verde[0].release();//verde e azul
          
          amarelo[3].acquire();//amarelo e azul
          azul[2].acquire();//azul e roxo
          rota((carros[3].getLayoutX()+11), carros[3].getLayoutY(), 3, carros[3]);
          rota(carros[3].getLayoutX(), (carros[3].getLayoutY()-97), 3, carros[3]);
          azul[8].release();//azul e roza
          amarelo[3].release();//amarelo e azul
          rota(carros[3].getLayoutX(), (carros[3].getLayoutY()-83), 3, carros[3]);
          azul[2].release();//azul e roxo
          
       
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }

    /***********************
    * Metodo: setFrequenciaCliente
    * Funcao: adiciona o tempo recebido para as variaveis
    * Parametros: Double tempo de espera
    * Retorno: void
    *********************** */
    public void setVelocidade(double vel) {
      super.setVelocidade(vel);
    }  
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////
  /***********************
  * Classe: Carro5
  * Funcao: Agrupa os metodos da thread responsavel pelo carro roxo
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Carro5 extends Animacao{

    /***********************
    * Metodo: run
    * Funcao: executa cada funcao do carro seguir a rota especifica e esperar
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    public void run(){
      int i = 0;
      while(true){
        try {
          if(i==0){
            rota((carros[4].getLayoutX()+11), carros[4].getLayoutY(), 4, carros[4]);
            i++;
          }
          roxo[1].acquire();//roxo e roza
          rota((carros[4].getLayoutX()-11), carros[4].getLayoutY(), 4, carros[4]);
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-83), 4, carros[4]);
          amarelo[6].acquire();//amarelo e roxo
          verde[2].acquire();//verde e roxo
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-14), 4, carros[4]);
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-83), 4, carros[4]);
          roxo[1].release();//roxo e roza
          verde[2].release();
          amarelo[6].release();//amarelo e roxo
          vermelho[10].acquire();//vermelho e roxo
          amarelo[5].acquire();//amarelo e roxo
          azul[1].acquire();//azul e roxo
          roxo[0].acquire();//roxo e marrom
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-14), 4, carros[4]);
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-83), 4, carros[4]);
          amarelo[5].release();//amareloe  roxo
          vermelho[10].release();//vermelho e roxo
          azul[1].release();//azul e roxo
          amarelo[10].acquire();//amarelo e roxo
          roxo[2].acquire();//roxo e roza
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-14), 4, carros[4]);
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-83), 4, carros[4]);
          amarelo[10].release();//amarelo e roxo
          amarelo[9].acquire();//amarelo e roxo
          azul[0].acquire();//azul e roxo
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-14), 4, carros[4]);
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-83), 4, carros[4]);
          roxo[2].release();//roxo e roza
          roxo[0].release();//roxo e marrom
          azul[0].release();//azul e roxo
          amarelo[9].release();//amarelo e roxo

          amarelo[8].acquire();//amarelo e roxo
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()-14), 4, carros[4]);
          rota((carros[4].getLayoutX()+96), carros[4].getLayoutY(), 4, carros[4]);
          rota((carros[4].getLayoutX()+96), carros[4].getLayoutY(), 4, carros[4]);

          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()+83), 4, carros[4]);
          amarelo[8].release();//amarelo e roxo
          azul[2].acquire();//azul e roxo
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()+14), 4, carros[4]);
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()+83), 4, carros[4]);
          amarelo[7].acquire();//amarelo e roxo
          roxo[3].acquire();//roxo e roza
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()+14), 4, carros[4]);
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()+83), 4, carros[4]);
          roxo[3].release();//roxo e roza
          azul[2].release();//azul e roxo
          vermelho[9].acquire();//vermelho e roxo
          verde[1].acquire();//verde e roxo
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()+14), 4, carros[4]);
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()+97), 4, carros[4]);
          rota(carros[4].getLayoutX(), (carros[4].getLayoutY()+97), 4, carros[4]);

          rota((carros[4].getLayoutX()-96), carros[4].getLayoutY(), 4, carros[4]);
          rota((carros[4].getLayoutX()-85), carros[4].getLayoutY(), 4, carros[4]);
          verde[1].release();//verde e roxo
          amarelo[7].release();//amarelo e roxo
          vermelho[9].release();//vermelho e roxo
        
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }

    /***********************
    * Metodo: setFrequenciaCliente
    * Funcao: adiciona o tempo recebido para as variaveis
    * Parametros: Double tempo de espera
    * Retorno: void
    *********************** */
    public void setVelocidade(double vel) {
      super.setVelocidade(vel);
    }  
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////
  /***********************
  * Classe: Carro6
  * Funcao: Agrupa os metodos da thread responsavel pelo carro marron
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Carro6 extends Animacao{

    /***********************
    * Metodo: run
    * Funcao: executa cada funcao do carro seguir a rota especifica e esperar
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    public void run(){
      int i = 0;
      while(true){
        try {
          if(i==0){
            rota((carros[5].getLayoutX()-11), carros[5].getLayoutY(),5, carros[5]);
            i++;
          }
          roxo[0].acquire();//roxo e marrom
          marrom[0].acquire();//marrom e roza
          rota((carros[5].getLayoutX()+11), carros[5].getLayoutY(),5, carros[5]);
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()-83), 5, carros[5]);
          marrom[0].release();//marrom e roza
          marrom[1].acquire();//marrom e roza
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()-14), 5, carros[5]);
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()-83), 5, carros[5]);
          azul[3].acquire();//azul e marrom
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()-14), 5, carros[5]);
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()-83), 5, carros[5]);
          roxo[0].release();//roxo e marrom
          azul[3].release();//azul e marrom
          
          amarelo[11].acquire();//amarelo e marrom
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()-14), 5, carros[5]);
          rota((carros[5].getLayoutX()-85), carros[5].getLayoutY(),5, carros[5]);
          marrom[1].release();//marrom e roza
          vermelho[11].acquire();//vermelho e maron
          rota((carros[5].getLayoutX()-11), carros[5].getLayoutY(),5, carros[5]);
          rota((carros[5].getLayoutX()-96), carros[5].getLayoutY(),5, carros[5]);
          rota((carros[5].getLayoutX()-96), carros[5].getLayoutY(),5, carros[5]);

          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()+83), 5, carros[5]);
          azul[4].acquire();//azul e marrom
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()+14), 5, carros[5]);
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()+83), 5, carros[5]);
          marrom[2].acquire();//marrom e roza
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()+14), 5, carros[5]);
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()+83), 5, carros[5]);
          vermelho[11].release();//vermelho e maron
          
          verde[3].acquire();//verde e marrom
          rota(carros[5].getLayoutX(), (carros[5].getLayoutY()+14), 5, carros[5]);
          rota((carros[5].getLayoutX()+85), carros[5].getLayoutY(),5, carros[5]);
          amarelo[13].acquire();//amarelo e marrom
          rota((carros[5].getLayoutX()+11), carros[5].getLayoutY(),5, carros[5]);
          rota((carros[5].getLayoutX()+85), carros[5].getLayoutY(),5, carros[5]);
          marrom[2].release();//marrom e roza
          amarelo[13].release();//amarelo e marrom
          vermelho[12].acquire();//vermelho e marom
          amarelo[12].acquire();//amarelo e marrom
          rota((carros[5].getLayoutX()+11), carros[5].getLayoutY(),5, carros[5]);
          rota((carros[5].getLayoutX()+85), carros[5].getLayoutY(),5, carros[5]);
          azul[4].release();//azul e marrom
          verde[3].release();//verde e marrom
          amarelo[12].release();//amarelo e marrom
          vermelho[12].release();//vermelho e maron
          amarelo[11].release();//amarelo e marrom
          

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }

    /***********************
    * Metodo: setFrequenciaCliente
    * Funcao: adiciona o tempo recebido para as variaveis
    * Parametros: Double tempo de espera
    * Retorno: void
    *********************** */
    public void setVelocidade(double vel) {
      super.setVelocidade(vel);
    }  
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////
  /***********************
  * Classe: Carro7
  * Funcao: Agrupa os metodos da thread responsavel pelo carro roza
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Carro7 extends Animacao{

    /***********************
    * Metodo: run
    * Funcao: executa cada funcao do carro seguir a rota especifica e esperar
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    public void run(){
      int i = 0;
      while(true){
        try {
          if(i==0){
            rota((carros[6].getLayoutX()+11), carros[6].getLayoutY(),6, carros[6]);   
            i++;
          }
          rota((carros[6].getLayoutX()-11), carros[6].getLayoutY(),6, carros[6]);   
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()-83), 6, carros[6]);
          amarelo[16].acquire();//amarelo e roza
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()-14), 6, carros[6]);
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()-83), 6, carros[6]);
          amarelo[16].release();//amarelo e roza
          
          amarelo[14].acquire();//amarelo e roza
          verde[5].acquire();//verde e roza
          azul[7].acquire();//azul e roza
          vermelho[16].acquire();//vermelho e roza
          marrom[2].acquire();//marrom e roza
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()-14), 6, carros[6]);
          rota((carros[6].getLayoutX()-96), carros[6].getLayoutY(),6, carros[6]);
          vermelho[16].release();//vermelho e roza
          rota((carros[6].getLayoutX()-85), carros[6].getLayoutY(),6, carros[6]);
          verde[5].release();//verde e roza

          vermelho[13].acquire();//vermelho e roza
          rota((carros[6].getLayoutX()-11), carros[6].getLayoutY(),6, carros[6]);
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()-97), 6, carros[6]);
          marrom[2].release();//marrom e roza
          azul[7].release();//azzul e roza
          amarelo[14].release();//amarelo e roza
          vermelho[13].release();//vermelho e roza
          
          rota((carros[6].getLayoutX()+85), carros[6].getLayoutY(),6, carros[6]);
          amarelo[19].acquire();//amarelo e roza
          rota((carros[6].getLayoutX()+11), carros[6].getLayoutY(),6, carros[6]);
          rota((carros[6].getLayoutX()+85), carros[6].getLayoutY(),6, carros[6]);
          amarelo[19].release();//amarelo e roza
          
          vermelho[17].acquire();//vermelho e roza
          rota((carros[6].getLayoutX()+11), carros[6].getLayoutY(),6, carros[6]);
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()-83), 6, carros[6]);
          amarelo[20].acquire();//amarelo e roza
          azul[6].acquire();
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()-14), 6, carros[6]);
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()-83), 6, carros[6]);
          azul[6].release();//azul e roza
          amarelo[20].release();//amarelo e roza
          vermelho[17].release();//vermelho e roza
          
          amarelo[22].acquire();//amarelo e roza
          marrom[1].acquire();//marrom e roza
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()-14), 6, carros[6]);
          rota((carros[6].getLayoutX()+85), carros[6].getLayoutY(),6, carros[6]);
          amarelo[22].release();//amarelo e roza
          
          roxo[2].acquire();//roxo e roza
          rota((carros[6].getLayoutX()+11), carros[6].getLayoutY(),6, carros[6]);
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+83), 6, carros[6]);
          amarelo[21].acquire();//amarelo e roza
          azul[5].acquire();//azul e roza
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+14), 6, carros[6]);
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+83), 6, carros[6]);
          marrom[1].release();//marrom e roza
          roxo[2].release();//roxo e roza
          azul[5].release();//azul e roza
          amarelo[21].release();//amarelo e roza
          
          amarelo[18].acquire();//amarelo e roza
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+14), 6, carros[6]);
          rota((carros[6].getLayoutX()+96), carros[6].getLayoutY(),6, carros[6]);
          rota((carros[6].getLayoutX()+85), carros[6].getLayoutY(),6, carros[6]);
          
          azul[8].acquire();//azul e roza
          roxo[3].acquire();//roxo e roza
          rota((carros[6].getLayoutX()+11), carros[6].getLayoutY(),6, carros[6]);
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+83), 6, carros[6]);
          roxo[3].release();//roxo e roza
          amarelo[18].release();//amarelo e roza
          
          verde[6].acquire();//verde e roza
          vermelho[15].acquire();//vermelho e roza
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+14), 6, carros[6]);
          rota((carros[6].getLayoutX()-85), carros[6].getLayoutY(),6, carros[6]);
          vermelho[15].release();//vermelho e roza
          amarelo[15].acquire();//amarelo e roza
          rota((carros[6].getLayoutX()-11), carros[6].getLayoutY(),6, carros[6]);
          rota((carros[6].getLayoutX()-85), carros[6].getLayoutY(),6, carros[6]);
          azul[8].release();//azul e roza
          verde[6].release();//verde e roza
          amarelo[15].release();//amarelo e roza
          
          roxo[1].acquire();//roxo e roza
          marrom[0].acquire();//marrom e roza
          rota((carros[6].getLayoutX()-11), carros[6].getLayoutY(),6, carros[6]);
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+83), 6, carros[6]);
          marrom[0].release();//marrom e roza
          amarelo[16].acquire();//amarelo e roza
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+14), 6, carros[6]);
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+83), 6, carros[6]);
          roxo[1].release();//roxo e roza
          amarelo[16].release();//amarelo e roza

          vermelho[14].acquire();//vermelho e roza
          amarelo[17].acquire();//amarelo e roza
          verde[4].acquire();//verde e roza
          rota(carros[6].getLayoutX(), (carros[6].getLayoutY()+14), 6, carros[6]);
          rota((carros[6].getLayoutX()-85), carros[6].getLayoutY(),6, carros[6]);   
          amarelo[17].release();//amarelo e roza     
          vermelho[14].release();//vermelho e roza
          verde[4].release();//verde e roza

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }

    /***********************
    * Metodo: setFrequenciaCliente
    * Funcao: adiciona o tempo recebido para as variaveis
    * Parametros: Double tempo de espera
    * Retorno: void
    *********************** */
    public void setVelocidade(double vel) {
      super.setVelocidade(vel);
    }
  }
}