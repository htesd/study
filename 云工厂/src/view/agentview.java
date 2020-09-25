package view;

import control.console;
import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Stage;

public class agentview extends Application {
	Stage stage=new Stage();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
	@Override
	public void start(Stage main) throws Exception {
		// TODO Auto-generated method stub
		
		main.setWidth(1440);
		main.setHeight(800);
		
		main.setTitle("欢迎您经销商使用云工厂");
		main.show();
		//lable
		Label la1=new Label("订单管理");
		la1.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		Label la2=new Label("我的订单");
		la2.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
		Label la3=new Label("招标选择");
		la3.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
		//
		main.show();
		TabPane tp=new TabPane();
		Tab tip1=new Tab();
		tip1.setStyle("-fx-background-color:#0066CC;");
		tip1.setStyle("-fx-background-color:#0066CC;");
		tip1.setGraphic(la1);
		tip1.setDisable(true);
		Tab t1=new Tab();
		t1.setGraphic(la2);
		t1.setStyle("-fx-background-color:#FFFFFF;");
		Tab t2=new Tab();
		t2.setGraphic(la3);
		t2.setStyle("-fx-background-color:#FFFFFF;");
		Scene scene=new Scene(tp);
		tp.getTabs().addAll(tip1,t1,t2);
		tp.setSide(Side.LEFT);
		main.setScene(scene);
		tp.setTabMinWidth(20);
		tp.setMaxWidth(50);
		tp.setTabMinHeight(150);
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		//
		t1.setContent(ordforag.start(console.usering.getid()));
		t2.setContent(pickfac.start());
		
	}
	public void  showWindow() throws Exception {
		start(stage);
	}

	
	//
	public static int change(int id,int type){
		String a=Integer.toString(id);
		String b=Integer.toString(type);
		for(int i=1;i!=a.length();i++){
			b+=a.charAt(i);
		}
		return Integer.parseInt(b);
	}
	public static int change(int id){
		String a=Integer.toString(id);
		String b="";
		for(int i=1;i!=a.length();i++){
			b+=a.charAt(i);
		}
		return Integer.parseInt(b);
	}
}
