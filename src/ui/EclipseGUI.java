package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Moon;

public class EclipseGUI {
	
    private final static int[] ILLUMINATED = new int[] {255, 249, 139};
    private final static int[] ILLUMINATED2 = new int[] {255, 255, 255};

    
    @FXML
    private Pane sky;

    @FXML
    private Circle sun;

    @FXML
    private Circle circleShape;
    
    @FXML
    private Circle star11;

    @FXML
    private Circle star1;

    @FXML
    private Circle star14;

    @FXML
    private Circle star2;

    @FXML
    private Circle star5;

    @FXML
    private Circle star6;

    @FXML
    private Circle star3;

    @FXML
    private Circle star12;

    @FXML
    private Circle star10;

    @FXML
    private Circle star16;

    @FXML
    private Circle star13;

    @FXML
    private Circle star9;

    @FXML
    private Circle star8;

    @FXML
    private Circle star4;

    @FXML
    private Circle star15;

    @FXML
    private Circle star7;
  
    //Custom attributes
    private Stage window;
    private boolean movingRight;
    private boolean onOrOff;
    private Moon mn;
    
    public EclipseGUI(Stage st) {
    	window = st;
    }
    
    public void initialize() {
    	mn = new Moon(circleShape.getLayoutX(), circleShape.getRadius());
    }

    @FXML
    void moveRightBtn(ActionEvent event) {
    	
    	onOrOff = true;
    	mn.setMax(window.getWidth());
    	movingRight = true;
    	new Thread() {
    		public void run() {
    			while(movingRight && onOrOff) {
    				mn.move1(true);
    				Platform.runLater(new Thread() {
    					public void run() {
    						updateMoon(mn.getX());
    						
    						double diff = Math.abs(sun.getLayoutX()-circleShape.getLayoutX());
    				    	double diameter = circleShape.getRadius()*2;
    				    	if(diff<=diameter) {
    				    		double pos = diff/diameter;
    				    		int r = (int)(ILLUMINATED[0]*pos);
    				    		int g = (int)(ILLUMINATED[1]*pos);
    				    		int b = (int)(ILLUMINATED[2]*pos);
    				    		int r1 = (int)(ILLUMINATED2[0]*pos);
    				    		int g1 = (int)(ILLUMINATED2[1]*pos);
    				    		int b1 = (int)(ILLUMINATED2[2]*pos);

    				    		sky.setStyle("-fx-background-color:rgb("+r+","+g+","+b+");");
    				    		star1.setStyle("-fx-background-color:rgb("+r+","+g+","+b+");");
    				    		star2.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star3.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star4.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star5.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star6.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star7.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star8.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star9.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star10.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star11.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star12.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star13.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star14.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star15.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star16.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");

    				    	}  
    						
    					}
    				});
    				
    				try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    		}
    	}.start();
    }

    @FXML
    void moveLeftBtn(ActionEvent event) {
    	
    	onOrOff = true;
    	mn.setMax(window.getWidth());
    	movingRight = false;
    	new Thread() {
    		public void run() {
    			while(!movingRight && onOrOff) {
    				mn.move1(false);
    				Platform.runLater(new Thread() {
    					public void run() {
//    						if(mn.getX() < window.getWidth() + 20) {
//    							circleShape.relocate(646, 92);
//    						}
    						updateMoon(mn.getX());
    						
    						double diff = Math.abs(sun.getLayoutX()-circleShape.getLayoutX());
    				    	double diameter = circleShape.getRadius()*2;
    				    	if(diff<=diameter) {
    				    		double pos = diff/diameter;
    				    		int r = (int)(ILLUMINATED[0]*pos);
    				    		int g = (int)(ILLUMINATED[1]*pos);
    				    		int b = (int)(ILLUMINATED[2]*pos);
    				    		int r1 = (int)(ILLUMINATED2[0]*pos);
    				    		int g1 = (int)(ILLUMINATED2[1]*pos);
    				    		int b1 = (int)(ILLUMINATED2[2]*pos);
    				    		sky.setStyle("-fx-background-color:rgb("+r+","+g+","+b+");");
    				    		star1.setStyle("-fx-background-color:rgb("+r+","+g+","+b+");");
    				    		star2.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star3.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star4.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star5.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star6.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star7.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star8.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star9.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star10.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star11.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star12.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star13.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star14.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star15.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    		star16.setStyle("-fx-background-color:rgb("+r1+","+g1+","+b1+");");
    				    	}  
    					}
    				});
    				try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    		}
    	}.start();
    }
    
    public void updateMoon(double x) {
    	circleShape.setLayoutX(x);
    }
    
    @FXML
    public void stop(ActionEvent e) {
    	//mn.move(true);
    	onOrOff = false;
    	
    }
}
