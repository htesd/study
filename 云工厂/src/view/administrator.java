package view;

import DAO.factorydates;
import DAO.idproducer;
import DAO.userdate;
import POjO.factory;
import POjO.user;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;



public class administrator extends Application {
	Stage stage=new Stage();
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage main) throws Exception {
		// TODO Auto-generated method stub
		//基本布局
		main.setWidth(1440);
		main.setHeight(800);
		
		main.setTitle("欢迎您超级管理员使用云工厂");
	//	main.initStyle(StageStyle.UNDECORATED);
		//lable
		Label la1=new Label("系统设置");
		la1.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		Label la2=new Label("云工厂");
		la2.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		Label la3=new Label("产品管理");
		la3.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		Label la4=new Label("产能中心");
		la4.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		Label la5=new Label("订单管理");
		la5.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		Label la6=new Label("用户管理");
		la6.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
		Label la7=new Label("云工厂信息");
		la7.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
		Label la8=new Label("产品类别管理");
		la8.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
		Label la9=new Label("产品信息管理");
		la9.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
		Label la10=new Label("设备类型管理");
		la10.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
		Label la11=new Label("设备管理");
		la11.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
		Label la12=new Label("订单基本信息");
		la12.setStyle("-fx-font-weight:bold;"+"-fx-text-fill:#0066CC;");
		//
		main.show();
		TabPane tp=new TabPane();
		Tab tip1=new Tab();
		tip1.setStyle("-fx-background-color:#0066CC;");
		tip1.setGraphic(la1);
		tip1.setDisable(true);
		Tab tip2=new Tab();
		tip2.setGraphic(la2);
		tip2.setDisable(true);
		tip2.setStyle("-fx-background-color:#0066CC;");
		Tab tip3=new Tab();
		tip3.setGraphic(la3);
		tip3.setDisable(true);
		tip3.setStyle("-fx-background-color:#0066CC;");
		Tab tip4=new Tab();
		tip4.setGraphic(la4);
		tip4.setDisable(true);
		tip4.setStyle("-fx-background-color:#0066CC;");
		Tab tip5=new Tab();
		tip5.setGraphic(la5);
		tip5.setDisable(true);
		tip5.setStyle("-fx-background-color:#0066CC;");
	//tab
		Tab t1=new Tab();
		t1.setGraphic(la6);
		t1.setStyle("-fx-background-color:#FFFFFF;");
		Tab t2=new Tab();
		t2.setGraphic(la7);
		t2.setStyle("-fx-background-color:#FFFFFF;");
		Tab t3=new Tab();
		t3.setGraphic(la8);
		t3.setStyle("-fx-background-color:#FFFFFF;");
		Tab t4=new Tab();
		t4.setGraphic(la9);
		t4.setStyle("-fx-background-color:#FFFFFF;");
		Tab t5=new Tab();
		t5.setGraphic(la10);
		t5.setStyle("-fx-background-color:#FFFFFF;");
		Tab t6=new Tab();
		t6.setGraphic(la11);
		t6.setStyle("-fx-background-color:#FFFFFF;");
		Tab t7=new Tab();
		t7.setGraphic(la12);
		t7.setStyle("-fx-background-color:#FFFFFF;");
		Scene scene=new Scene(tp);
		tp.getTabs().addAll(tip1,t1,tip2,t2,tip3,t3,t4,tip4,t5,t6,tip5,t7);
		tp.setSide(Side.LEFT);
		main.setScene(scene);
		tp.setTabMinWidth(20);
		tp.setMaxWidth(50);
		tp.setTabMinHeight(150);
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
/////////////////////////////////////////////////////////////////
		t1.setContent(userforad.start());
		t2.setContent(facforad.start());
		t3.setContent(prtforad.start());
		t4.setContent(proforad.start());
		t5.setContent(eqtforad.start());
		t6.setContent(eqpforad.start());
		t7.setContent(ordforad.start());
	//
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
