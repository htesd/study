package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.factorydates;
import DAO.idproducer;
import DAO.userdate;
import POjO.Administrator;
import POjO.Agent;
import POjO.Manager;
import control.console;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import service.utils;



public class login extends Application{



	@Override
	public void start(Stage main) throws Exception {
		// TODO Auto-generated method stub
		main.setWidth(1440);
		main.setHeight(800);
		main.setResizable(false);
		main.initStyle(StageStyle.UNDECORATED);
		main.show();
		
		//donghua
        Timeline timeline = new Timeline();
		timeline.setCycleCount(100);
		timeline.setAutoReverse(true);
	    KeyFrame keyFrame = new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
			double m=0;
            public void handle(ActionEvent t) {
           if(m>1){
        	   m=1;
           }
            main.setOpacity(m);
            m+=0.05;
            }
        });
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		//布局
		        AnchorPane mainpane=new AnchorPane();
				Scene Scene=new Scene(mainpane);
				main.setScene(Scene);
				AnchorPane top=new AnchorPane();
				mainpane.getChildren().add(top);
				BackgroundImage myBI= new BackgroundImage(new Image("image/login.png"), 
		    		     BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
		    		      BackgroundSize.DEFAULT); 
		       mainpane.setBackground(new Background(myBI));
		    	
		
			            	 mainpane.setOnMousePressed(new EventHandler<MouseEvent>() {

								@Override
								public void handle(MouseEvent event) {
									// TODO Auto-generated method stub
									
									mainpane.addEventFilter(MouseDragEvent.MOUSE_DRAGGED, event1 -> {
							            if (event1.isPrimaryButtonDown()) { 
							             double x=event.getSceneX();
										 double y=event.getSceneY();
										 
										 main.setX(event1.getScreenX()-x);
										 //System.out.println(event.getScreenX()-x);
										 main.setY(event1.getScreenY()-y);
										                
										            }

										       
										    });
								}});     	
			
        //lable
			Label la1=new Label("欢迎使用云工厂");
			top.getChildren().add(la1);
			la1.setLayoutX(200);
			la1.setLayoutY(200);
			la1.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#333399;"+"-fx-font-family:Microsoft YaHei;"+"-fx-font-size:40");
			//textfield
			Tooltip tip=new Tooltip("请不要超过10个字符");
			TextField text1=new TextField();
			text1.setTooltip(tip);
			text1.setPromptText("");
			text1.setPromptText("请输入账号");
			text1.setLayoutX(90);
			text1.setLayoutY(160);
			text1.textProperty().addListener(new ChangeListener<String>(){
          
				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					// TODO Auto-generated method stub
				if(arg2.length()>10){
					text1.setText(arg1);
				}
				}
				
			});
			top.getChildren().add(text1);
			text1.setLayoutX(200);
			text1.setLayoutY(300);
			text1.setPrefSize(270, 50);
			PasswordField text2=new PasswordField();
			text2.setTooltip(tip);
			text2.setPromptText("");
			text2.setPromptText("请输入密码");
			text2.setLayoutX(90);
			text2.setLayoutY(160);
			text2.textProperty().addListener(new ChangeListener<String>(){
          
				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					// TODO Auto-generated method stub
					if(arg2.length()>10){
						text1.setText(arg1);
					}
				}
				
			});
			top.getChildren().add(text2);
			text2.setLayoutX(200);
			text2.setLayoutY(380);
			text2.setPrefSize(270, 50);
		//botton
			Button b1=new Button("退出");
			b1.setStyle("-fx-background-color:#6466D5;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			b1.setPrefSize(100, 50);
			top.getChildren().add(b1);
			
			b1.setOnAction(new EventHandler<ActionEvent>(){
			    double i=1;
						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							
							//退出效果
							    Timeline timeline = new Timeline();
								
								timeline.setCycleCount(35);
								
								timeline.setAutoReverse(true);
								
								// 设置为每隔1000毫秒执行一次
								KeyFrame keyFrame = new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
						            public void handle(ActionEvent t) {
						           
						            main.setOpacity(i);
						            i-=0.05;
						            }
						        });
								timeline.getKeyFrames().add(keyFrame);
								timeline.play();
								timeline.setOnFinished(event -> Platform.exit());
						
							
						}});
			Button b2=new Button("登录");
			b2.setPrefSize(270, 50);
			b2.setLayoutX(200);
			b2.setLayoutY(450);
			b2.setStyle("-fx-background-color:#9371FF;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			b2.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(text1.getText().equals(Administrator.getname())&&text2.getText().equals(Administrator.getpassword())){
						la1.setText("登录成功");
						main.close();
						administrator ad=new administrator();
						try {
							ad.showWindow();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("chuowu");
						}
						
					}else{
					if((console.usering=utils.login(text1.getText(), text2.getText()))==null){
						la1.setText("账号或者密码输入错误");
					}else{
						if(Integer.toString(console.usering.getid()).startsWith("1")){
						la1.setText("登录成功");
						agentview agentview =new agentview();
						try {
							agentview.showWindow();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							la1.setText("出现未知异常");
						}
						main.close();
						}else{
							if(Integer.toString(console.usering.getid()).startsWith("2")){
								console.managering=(Manager) utils.login(text1.getText(), text2.getText());
								manageview manager=new manageview();
								try {
									manager.showWindow();
									main.close();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									la1.setText("出现未知异常！");
								}
							}
						}
					}
					}
				}});
			Button b3=new Button("注册");
			b3.setPrefSize(270, 50);
			b3.setLayoutX(200);
			b3.setLayoutY(530);
			b3.setStyle("-fx-background-color:#9371FF;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			b3.setOnAction(new EventHandler<ActionEvent>(){
 
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					
					TilePane register=new TilePane();
					register.setHgap(300);
					register.setVisible(true);
					register.setPrefSize(720, 655);
					register.setLayoutY(70);
					register.setLayoutX(650);
					register.setAlignment(Pos.BASELINE_LEFT);
					register.setStyle("-fx-background-color:#FFFFFF;");
					register.setVgap(5);
				    mainpane.getChildren().add(register);
				    Separator s=new Separator();
				    Separator s1=new Separator();
					TextField name=new TextField("");
					name.setPromptText("请输入姓名");
					TextField account=new TextField("");
					account.setPromptText("请输入账号");
					TextField password=new TextField("");
					password.setPromptText("请输入密码");
					TextField email=new TextField("");
					email.setPromptText("请输入联系方式");
					TextField fname=new TextField("");
					fname.setPromptText("请输入工厂名称");
					fname.setVisible(false);
					TextField finfo=new TextField("");
					finfo.setPromptText("请输入工厂名称");
					finfo.setVisible(false);
				    Button ok=new Button("确定");
				    ok.setStyle("-fx-background-color:#9371FF;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
				    ok.setPrefSize(270, 50);
				    Button quit=new Button ("关闭");
				    quit.setOnAction(new EventHandler<ActionEvent>(){

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							register.setVisible(false);
						}});
				    quit.setStyle("-fx-background-color:#9371FF;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
				    quit.setPrefSize(270, 50);
				   
				    RadioButton a=new RadioButton("经销商");
				    RadioButton b=new RadioButton("云工厂管理员");
				    ToggleGroup group=new ToggleGroup();
				    a.setToggleGroup(group);
				    b.setToggleGroup(group);
				    a.selectedProperty().addListener(new ChangeListener<Boolean>(){

						@Override
						public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
								Boolean newValue) {
							// TODO Auto-generated method stub
							fname.setVisible(false);
							finfo.setVisible(false);
							ok.setOnAction(new EventHandler<ActionEvent>(){

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									if(name.getText().isEmpty()||account.getText().isEmpty()||password.getText().isEmpty()||email.getText().isEmpty()){
										la1.setText("请全部输入！");
									}else{
										la1.setText(utils.Agentregister(name.getText(), password.getText(), email.getText(), "经销商", account.getText()));
										
									}
								}});
						}});
				    b.selectedProperty().addListener(new ChangeListener<Boolean>(){

						@Override
						public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
								Boolean newValue) {
							// TODO Auto-generated method stub
							fname.setVisible(true);
							finfo.setVisible(true);
							ok.setOnAction(new EventHandler<ActionEvent>(){

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									if(name.getText().isEmpty()||account.getText().isEmpty()||password.getText().isEmpty()||email.getText().isEmpty()||fname.getText().isEmpty()||finfo.getText().isEmpty()){
										la1.setText("请全部输入！");
									}else{
										//la1.setText(utils.ManagerRegister(name.getText(), password.getText(), email.getText(), "云工厂管理员", account.getText())+utils.FactoryRegister(fname.getText(), finfo.getText()));
										if(userdate.check(account.getText())){
											la1.setText("用户已经存在");
										}else{
											if(factorydates.check(fname.getText())){
												la1.setText("工厂已经存在");
											}else{
												la1.setText("成功添加");
												String tempid=Integer.toString(idproducer.getid());
												utils.ManagerRegister(name.getText(), password.getText(), email.getText(), "云工厂管理员", account.getText(),Integer.parseInt("2"+tempid),Integer.parseInt("3"+tempid));
												utils.FactoryRegister(fname.getText(), finfo.getText(),Integer.parseInt("2"+tempid),Integer.parseInt("3"+tempid));
											}
										}
									}
								}});
						}});
				    register.getChildren().addAll(name,account,password,email,s,a,b,s1,fname,finfo,ok,quit);
				    
					
				}});
			top.getChildren().addAll(b2,b3);
	
}
	}
