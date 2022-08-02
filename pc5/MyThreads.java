/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 13/04/2022
* Ultima alteracao.: 22/04/2022
* Nome.............: Jantar dos filosofos
* Funcao...........: O programa e utilizado resolver um problema de concorrencia em que 
* dois ou mais processos necessitam acessar o mesmo recurso e alteralo, no caso o garfo que
* varios filosofos tem que pegar
*************************************************************** */
import java.util.concurrent.Semaphore;

import javafx.scene.control.Label;

/***********************
  * Classe: Threads 
  * Funcao: Agrupa os metodos e as classes compartilhadas das threads 
  * Parametros: 
  * Retorno: 
  *********************** */
public class MyThreads {

  //inicia o semaforo mutex
  public static Semaphore mutex = new Semaphore(1);
  //inicia o array de semaforos 
  public static Semaphore[] semaforos = new Semaphore[5];
  //semaforos dos arrays
  public Semaphore s1 = new Semaphore(1); 
  public Semaphore s2 = new Semaphore(1); 
  public Semaphore s3 = new Semaphore(1); 
  public Semaphore s4 = new Semaphore(1); 
  public Semaphore s5 = new Semaphore(1); 

  //array dos estados de cada filosofo
  //0 = pensando
  //1 = fome
  //2 = comendo
  public static int[] estado = new int[5];
  //numero de estados
  private static int n = 5;
  //array de carfos
  private Label[] garfos;

  /***********************
  * Metodo: MyThreads(Construtor)
  * Funcao: Adiciona os semaforos e o estado a cada filosofo
  * Parametros: 
  * Retorno: void
  *********************** */
  public MyThreads(){
    for(int i =0; i<5;i++){
      estado[i] = 0;
    }
    semaforos[0] = s1;
    semaforos[1] = s2;
    semaforos[2] = s3;
    semaforos[3] = s4;
    semaforos[4] = s5;
    
  }

  /***********************
  * Metodo: setGarfos
  * Funcao: Adiciona os garfos a variavel global de garfos
  * Parametros: Label[] array de garfos
  * Retorno: void
  *********************** */
  public void setGarfos(Label[] garfos){
    this.garfos = garfos;
  }

  /***********************
  * Classe: Filosofo 
  * Funcao: executa os metodos responsaveis por fazer cada filosofo pensar, comer e demais funcoes
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Filosofo extends Thread{
    private double tempoPensando;
    private double tempoComendo;
    private int id;
    int esq;
    int dir;

    /***********************
    * Metodo: Filosofo(Construtor)
    * Funcao: Inicia as variaveis que são passadas pela classe acima 
    * Parametros: int id de cada filosofo
    * Retorno: void
    *********************** */
    public Filosofo(int id){
      //adiciona o id e a esquerda e direita de cada filosofo passado acima
      this.id = id;
      esq = (((id-1)%n+n)%n);
      dir = (id+1)%n;
      //bloqueia cada filosofo
      try {
        semaforos[id].acquire();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    /***********************
    * Metodo: run
    * Funcao: executa cada funcao dos filosofos para pensar e comer
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    public void run(){

      while(true){
        try {
          
          pensar(id, (long)tempoPensando);
          
          pegaGarfos(id, esq, dir);
          
          comer(id, (long)tempoComendo, esq);

          devolveGarfos(id, esq, dir);

        } catch (InterruptedException e) {
            System.err.println("\n\n\n\nErro\n\n\n");
        }
      }
    }

    /***********************
    * Metodo: setTempos
    * Funcao: adiciona o tempo para variavel utilizada
    * Parametros: double tempo que demora para pensar e comer
    * Retorno: void
    *********************** */
    public void setTempos(double tPensar, double tComer){
        this.tempoPensando = tPensar;
        this.tempoComendo = tComer;
    }

    /***********************
    * Metodo: setTempoPensar
    * Funcao: adiciona o tempo para variavel utilizada
    * Parametros: double tempo que demora para pensar
    * Retorno: void
    *********************** */
    public void setTempoPensar(double tPensar){
      this.tempoPensando = tPensar;
    }
    
    /***********************
    * Metodo: setTemposComer
    * Funcao: adiciona o tempo para variavel utilizada
    * Parametros: double tempo que demora para comer
    * Retorno: void
    *********************** */
    public void setTemposComer(double tComer){
      this.tempoComendo = tComer;
    }
  }

  /***********************
    * Metodo: pensar
    * Funcao: faz o filosofo pensar por determinado tempo
    * Parametros: int id, long tempo que fica pensando
    * Retorno: void
    *********************** */
  public void pensar(int id, long tempoPensando) throws InterruptedException{
    Thread.sleep((long) tempoPensando*1000);
  }

  /***********************
    * Metodo: pegaGarfos
    * Funcao: faz o filosofo tentar pegar os garfos e bloqueia caso nao consiga
    * Parametros: int id, int esq e dir com os filosofos respectivos
    * Retorno: void
    *********************** */
  public void pegaGarfos(int id, int esq, int dir) throws InterruptedException{
    mutex.acquire();
    estado[id] = 1;//coloca o estado como com fome
    //verifica garfos;
    if((estado[id] == 1) && estado[esq]!=2 && estado[dir]!=2){//verifica se o filosofo esta com fome e os outros filosofos nao estao comendo 
      estado[id]=2;//coloca o estado como comendo
      semaforos[id].release();
    }
    mutex.release();
    semaforos[id].acquire();
  }

  /***********************
    * Metodo: devolveGarfos
    * Funcao: faz o filosofo tentar devolver os garfos e verifica se os filosofos adjacentes podem comer
    * Parametros: int id, int esq e dir com os filosofos respectivos
    * Retorno: void
    *********************** */
  public void devolveGarfos(int id, int esq, int dir) throws InterruptedException{
    mutex.acquire();
    estado[id] = 0;//coloca o estado do filosofo
    
    //coloca a cor do garfo como branca(livre)
    garfos[esq].setStyle("-fx-text-fill: white;");
    garfos[id].setStyle("-fx-text-fill: white;");

    Thread.sleep(500);//espera determinado tempo para melhor percepcao(tempo que leva para colocar garfo na mesa)

    if((estado[esq] == 1) && estado[(((esq-1)%n+n)%n)]!=2 && estado[(esq+1)%n]!=2){//verifica se o filosofo da esquerda esta com fome e os outros filosofos nao estao comendo
      estado[esq]=2;//coloca o estado como comendo
      semaforos[esq].release();//destrava o filosofo
    }

    
    if((estado[dir] == 1) && estado[(((dir-1)%n+n)%n)]!=2 && estado[(dir+1)%n]!=2){//verifica se o filosofo da direita esta com fome e os outros filosofos nao estao comendo
      estado[dir]=2;//coloca o estado como comendo
      semaforos[dir].release();//destrava o filosofo
    }
    
    mutex.release();
  }

  /***********************
    * Metodo: comer
    * Funcao: faz o filosofo pensar por determinado tempo
    * Parametros: int id, long tempo que fica comendo, int valor da esquerda
    * Retorno: void
    *********************** */
  public void comer(int id, long tempoComendo, int esq) throws InterruptedException{
    mutex.acquire();
    
    //coloca a cor do garfo como vermelho(sendo usado)
    garfos[esq].setStyle("-fx-text-fill: red;");
    garfos[id].setStyle("-fx-text-fill: red;");

    mutex.release();
    Thread.sleep((long) tempoComendo*1000);

  }

  /***********************
  * Classe: Estado 
  * Funcao: exibe no terminal o estado dos filosofos
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Estado extends Thread{

    /***********************
    * Metodo: run
    * Funcao: exibe no terminal o estado dos filosofos
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    public void run(){
      int i = 0;
      while(true){
        try {
          mutex.acquire();
          for(i = 0;i<5;i++){
            
            if(estado[i]==0){
              System.out.println("Filosofo "+(i+1)+" pensando");
            }
            if(estado[i]==1){
              System.out.println("Filosofo "+(i+1)+" fome");
            }
            if(estado[i]==2){
              System.out.println("Filosofo "+(i+1)+" comendo");
            }
          }
          mutex.release();
        
          Thread.sleep(500);
          if(i==5){
            i=0;
            System.out.println("-----------------------------------");
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}