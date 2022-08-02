import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MyThreads {
    public TextArea actionTxt;
    public MyThreads(TextArea action1) {
        this.actionTxt = action1;
    }

    private int counter = 1000;

    public class Ano extends Thread{
        private TextField dataInicio;

        public Ano(TextField dataInicio){
            start();
            this.dataInicio = dataInicio;
        }

        public void run(){
            try {
                if(dataInicio.getText().isEmpty()){dataInicio.setText(""+0);}
                for(int i=0;i<=101;){
                    Thread.sleep(counter);
                    dataInicio.setText(""+(Integer.parseInt(dataInicio.getText())+1));
                    i++;
                }
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }

    public class Galhos extends Thread{
        private String action;
        private int time;
        private ImageView o;
        private Label linha = null;
        
        public Galhos(String action, int time, ImageView obj){
            this.action = action;
            this.time = time;
            this.o = obj;
            start();
        }

        public Galhos(String action, int time, ImageView obj, Label l){
            this.action = action;
            this.time = time;
            this.o = obj;
            this.linha = l;
            start();
        }

        public void run(){
            try {
                Thread.sleep(time*counter);
                actionTxt.setText(actionTxt.getText()+"\n"+action);
                System.out.println(action);
                o.setVisible(true);
                if(linha != null){
                    linha.setVisible(true);
                }
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
    
    public class GalhosMorte extends Thread{
        private String action;
        private int time;
        private Label linha;
        
        public GalhosMorte(String action, int time, Label obj){
            this.action = action;
            this.time = time;
            this.linha = obj;
            start();
        }

        public void run(){
            try {
                Thread.sleep(time*counter);
                actionTxt.setText(actionTxt.getText()+"\n"+action);
                System.out.println(action);
                linha.setVisible(true);
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}