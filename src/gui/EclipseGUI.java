package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Moon;

public class EclipseGUI {

    @FXML
    private Circle circleShape;
    
    //Custom attributes
    private Stage window;
    private boolean movingLeft;
    private Moon mn;
    
    public EclipseGUI(Stage st) {
    	window = st;
    }
    
    public void initialize() {
    	mn = new Moon(circleShape.getLayoutX(),circleShape.getRadius());
    }

    @FXML
    void moveLeftBtn(ActionEvent event) {
    	mn.setMax(window.getWidth());
    	movingLeft = true;
    	new Thread() {
    		public void run() {
    			while(movingLeft) {
    				mn.move(true);
    				
    				Platform.runLater(new Thread() {
    					public void run() {
    						updateMoon(mn.getX());
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
    void moveRightBtn(ActionEvent event) {

    }
    
    public void updateMoon(double x) {
    	circleShape.setLayoutX(x);
    }

}
