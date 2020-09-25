package view;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Stage;

public class manageview extends Application {
	Stage stage=new Stage();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Application.launch(args);
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



	@Override
	public void start(Stage main) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//基本布局
				main.setWidth(1440);
				main.setHeight(800);
				
				main.setTitle("欢迎您云工厂管理员使用云工厂");
			//	main.initStyle(StageStyle.UNDECORATED);
				//lable
				Label la1=new Label("我的工厂");
				la1.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
				Label la2=new Label("我的设备");
				la2.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
				Label la3=new Label("订单管理");
				la3.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
				Label la4=new Label("订单接单");
				la4.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
				Label la5=new Label("订单排产");
				la5.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
				//
				main.show();
				TabPane tp=new TabPane();
				Tab tip1=new Tab();
				tip1.setStyle("-fx-background-color:#0066CC;");
				tip1.setGraphic(la1);
				tip1.setDisable(true);
				Tab tip2=new Tab();
				tip2.setGraphic(la3);
				tip2.setDisable(true);
				tip2.setStyle("-fx-background-color:#0066CC;");
				
			//tab
				Tab t1=new Tab();
				t1.setGraphic(la2);
				t1.setStyle("-fx-background-color:#FFFFFF;");
				Tab t2=new Tab();
				t2.setGraphic(la4);
				t2.setStyle("-fx-background-color:#FFFFFF;");
				Tab t3=new Tab();
				t3.setGraphic(la5);
				t3.setStyle("-fx-background-color:#FFFFFF;");
				
				Scene scene=new Scene(tp);
				tp.getTabs().addAll(tip1,t1,tip2,t2,t3);
				tp.setSide(Side.LEFT);
				main.setScene(scene);
				tp.setTabMinWidth(20);
				tp.setMaxWidth(50);
				tp.setTabMinHeight(150);
				tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		/////////////////////////////////////////////////////////////////
				t1.setContent(eqpforma.start());
				t2.setContent(addorder.start());
				t3.setContent(arrangeorder.start());
			//
	}
}
