import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class ArvoreController {
  /*********************************************************************
  * Metodo: organizarEvento
  * Funcao: abre a tela de organizacao de eventos 
  * Parametros: event do botao
  * Retorno: void
  ******************************************************************* */
//   @FXML
//   void organizarEvento(ActionEvent event) throws Exception {
//     OrganizarEventosController oe = new OrganizarEventosController();//instancia o controller do fxml chamado
//     oe.start(new Stage());//chama o metodo de abri a tela do fxml

//     Stage stage = (Stage) btOrganizarEvento.getScene().getWindow(); // pega a tela em que o botao clicado esta
//     stage.close(); //fecha a tela atual
  @FXML
  private TextArea action;

  @FXML
  private ImageView bisneto;

  @FXML
  private TextField dataInicio;

  @FXML
  private Button iniciarArvore;

  @FXML
  private ImageView neto1;

  @FXML
  private ImageView filho2;

  @FXML
  private ImageView neto2;

  @FXML
  private ImageView filho1;

  @FXML
  private ImageView filho3;

  @FXML
  private ImageView avo;

  @FXML
  private Label f1;

  @FXML
  private Label f2;

  @FXML
  private Label f3;

  @FXML
  private Label n1;

  @FXML
  private Label n2;

  @FXML
  private Label b1;

  @FXML
    private Label b1m;

    @FXML
    private Label n2m;

    @FXML
    private Label n1m;

    @FXML
    private Label f2m;

    @FXML
    private Label f3m;

    @FXML
    private Label f1m;

    @FXML
    private Label am;

  @FXML
  void iniciaArvore(ActionEvent event) {
    initialize();
    MyThreads mt = new MyThreads(action);

    MyThreads.Ano ano = mt.new Ano(dataInicio); 
    MyThreads.Galhos paiNasce = mt.new Galhos("Pai Nasce", 0, avo); 
    MyThreads.Galhos paiPrimeiroFilho = mt.new Galhos("O pai tem o primeiro filho aos 22 anos", 22, filho1, f1); 
    MyThreads.Galhos paiSegundoFilho = mt.new Galhos("O pai tem o segundo filho aos 25 anos", 25, filho2, f2); 
    MyThreads.Galhos paiAvoPrimeiro1 = mt.new Galhos("O pai é avô (primeiro filho) aos 38 anos", 38, neto1, n1); 
    MyThreads.Galhos paiAvoSegundoFilho1 = mt.new Galhos("O pai é avô (segundo filho) aos 45 anos", 45, neto2, n2); 
    MyThreads.Galhos paiTerceitoFilho = mt.new Galhos("O pai tem o terceiro filho aos 32 anos", 32, filho3, f3); 
    MyThreads.Galhos paiBisvoPrimeiroFilho = mt.new Galhos("O pai é bisavô (primeiro filho) aos 68 anos", 68, bisneto, b1); 
    MyThreads.GalhosMorte primeiroFilhoMorre = mt.new GalhosMorte("O primeiro filho morre aos 61 anos", 22+61, f1m); 
    MyThreads.GalhosMorte segundoFilhoMorre = mt.new GalhosMorte("O segundo e filho morre aos 55 anos", 25+55, f2m);         
    MyThreads.GalhosMorte terceiroFilhoMorre = mt.new GalhosMorte("O terceiro filho morre aos 55 anos", 32+55, f3m);         
    MyThreads.GalhosMorte primeironetoMorre = mt.new GalhosMorte("O primeiro neto morre anos", 38+35, n1m); 
    MyThreads.GalhosMorte segundonetoMorre = mt.new GalhosMorte("O segundo neto 55 anos", 45+55, n2m); 
    MyThreads.GalhosMorte bisnetoMorre = mt.new GalhosMorte("O bisneto morre aos 12 anos", 68+12, b1m); 
    MyThreads.GalhosMorte PaiMorre = mt.new GalhosMorte("O pai morre aos 90 anos", 90, am);
  }

  public void initialize() { 
    action.setText("");   
    bisneto.setVisible(false);
    neto1.setVisible(false);
    filho2.setVisible(false);
    neto2.setVisible(false);
    filho1.setVisible(false);
    filho3.setVisible(false);
    avo.setVisible(false);
    f1.setVisible(false);
    f2.setVisible(false);
    f3.setVisible(false);
    n1.setVisible(false);
    n2.setVisible(false);
    b1.setVisible(false);
    f1m.setVisible(false);
    f2m.setVisible(false);
    f3m.setVisible(false);
    n1m.setVisible(false);
    n2m.setVisible(false);
    b1m.setVisible(false);
    am.setVisible(false);
  }

  /*********************************************************************
  * Metodo: start
  * Funcao: inicia tela do fxml
  * Parametros: stage para tela
  * Retorno: void
  ******************************************************************* */
  public void start(Stage stage) throws Exception {
    stage.setTitle("Arvore Genealogica");

    Parent root = FXMLLoader.load(getClass().getResource("/inicial.fxml"));

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }
}