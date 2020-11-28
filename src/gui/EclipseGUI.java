package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Moon;

public class EclipseGUI {
	
    private final static int[] ILLUMINATED = new int[] {255, 249, 139};
    
    @FXML
    private Pane sky;

    @FXML
    private Circle sun;

    @FXML
    private Circle circleShape;
    
  
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
    				    		sky.setStyle("-fx-background-color:rgb("+r+","+g+","+b+");");
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
    				    		sky.setStyle("-fx-background-color:rgb("+r+","+g+","+b+");");
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
