package view;

import DAO.factorydates;
import DAO.idproducer;
import DAO.orderdate;
import DAO.pickorderdate;
import POjO.factory;
import POjO.order;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
import javafx.stage.Stage;
import javafx.util.Callback;

public class pickfac {
public static AnchorPane start(){
	ObservableList<factory> flist=FXCollections.observableArrayList();
	//list.addAll(u1,u2,u3,u4);
	
	TableColumn<factory,String > ftc1=new TableColumn<factory,String>("工厂名");
	
	ftc1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<factory,String>, ObservableValue<String>>() {
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<factory, String> arg0) {
			// TODO Auto-generated method stub
			SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getname());
			return name;
		}
	});
	
	
	TableColumn<factory,String > ftc2=new TableColumn<factory,String>("工厂简介");
	
    ftc2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<factory,String>, ObservableValue<String>>() {
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<factory, String> arg0) {
			// TODO Auto-generated method stub
			SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getinfo());
			return name;
		}
	});


	
    
    
	TableColumn<factory,Number > ftc3=new TableColumn<factory,Number>("id");
	
	ftc3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<factory,Number>, ObservableValue<Number>>() {
		
		@Override
		public ObservableValue<Number> call(CellDataFeatures<factory, Number> param) {
			// TODO Auto-generated method stub
			SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getfid());
			return id;
		}
	});
TableColumn<factory,Number > ftc4=new TableColumn<factory,Number>("所有者id");
	
	ftc4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<factory,Number>, ObservableValue<Number>>() {
		
		@Override
		public ObservableValue<Number> call(CellDataFeatures<factory, Number> param) {
			// TODO Auto-generated method stub
			SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getuserid());
			return id;
		}
	});
TableColumn<factory,Number > ftc5=new TableColumn<factory,Number>("状态");
	
	ftc5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<factory,Number>, ObservableValue<Number>>() {
		
		@Override
		public ObservableValue<Number> call(CellDataFeatures<factory, Number> param) {
			// TODO Auto-generated method stub
			SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getstatus());
			return id;
		}
	});
	//!!!!!!!!!!!!!////////////////////////////////////////////////////////////////////////////////
	TableView<factory> factorytable=new TableView<factory>(flist);
	//////////////////////////////////////////////////////////////////////////////////////////////
	factorytable.setEditable(true);
	//更改
	ftc1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<factory,String>>() {
		
		@Override
		public void handle(CellEditEvent<factory, String> event) {
			// TODO Auto-generated method stub
			
			factory  temp=event.getRowValue();
			
			factorydates.delete(temp.getfid());
			temp.setname(event.getNewValue());
			factorydates.add(temp);
			factorytable.refresh();
			
		}
	});
ftc2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<factory,String>>() {
		
		@Override
		public void handle(CellEditEvent<factory, String> event) {
			// TODO Auto-generated method stub
			
			factory temp=event.getRowValue();
			
			factorydates.delete(temp.getfid());
			temp.setinfo(event.getNewValue());
			factorydates.add(temp);
			factorytable.refresh();
			
		}
	});
ftc5.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<factory,Number>>() {
	
	@Override
	public void handle(CellEditEvent<factory, Number> event) {
		// TODO Auto-generated method stub
		
		factory  temp=event.getRowValue();
		
		factorydates.delete(temp.getfid());
		temp.setstatus(event.getNewValue().intValue());
		factorydates.add(temp);
		factorytable.refresh();
		
	}
});


	//
	ftc1.setCellFactory(TextFieldTableCell.forTableColumn());
	ftc2.setCellFactory(TextFieldTableCell.forTableColumn());
	
	ftc5.setCellFactory(ChoiceBoxTableCell.forTableColumn(0,1));
	factorytable.getColumns().addAll(ftc1,ftc2,ftc3,ftc4,ftc5);
	//
	AnchorPane factory =new AnchorPane();
	factory.setRightAnchor(factorytable, 20.0);
	factory.setLeftAnchor(factorytable, 20.0);
	factory.setTopAnchor(factorytable, 50.0);
	factory.setBottomAnchor(factorytable, 20.0);
	factory.setStyle("-fx-background-color:#FFFFFF;");
	factory.getChildren().add(factorytable);
	//
	BorderStroke bos1=new BorderStroke(Paint.valueOf("#337AB7"),BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6) );
	Border bo1=new Border(bos1);
	
	factorytable.setBorder(bo1);
	//lable
	Label la=new Label("");
	factory.getChildren().add(la);
	la.setLayoutX(260);

	//检索
	Tooltip tip=new Tooltip("请不要超过10个字符");
	TextField text=new TextField();
	text.setTooltip(tip);
	text.setText("");
	text.setPromptText("请输入需要检索的id");
	factory.setRightAnchor(text, 20.0);
	
	text.textProperty().addListener(new ChangeListener<String>(){

		@Override
		public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
			// TODO Auto-generated method stub
			if(arg2.length()>10){
			text.setText(arg1);
				
			}
			for(int i=0;i<arg2.length();i++){
				if(!Character.isDigit(arg2.charAt(i))){
					text.setText(arg1);
				}
			}
		}
		
	});
	factory.getChildren().add(text);
	//
	//按钮
	Label b2=new Label();
	Button addfactory1 =new Button("查询");
	addfactory1.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
	addfactory1.setLayoutX(20);
			addfactory1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				for (factory factory : factorydates.fs) {
					if(pickorderdate.check(Integer.parseInt(text.getText()),factory.getfid())){
					b2.setText(text.getText());
					flist.add(factory);
					la.setText("成功添加");
					}
				}
				factorytable.refresh();
			}});
            Button addfactory =new Button("确定");
			addfactory.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			addfactory.setLayoutX(80);
					addfactory.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						int i=0;
						order temp=null;
						for (order f : orderdate.orders) {
							if(f.getOid()==Integer.parseInt(b2.getText()));
							temp=f;
						}
						for (factory f : flist) {
							if(f.getfid()==Integer.parseInt(text.getText())){
								i=f.getfid();
							   
							}
						}
						orderdate.delete(temp.getOid());
						temp.setfid(i);
						orderdate.add(temp);
						if(i!=0){
							la.setText("成功招标！");
						}
						factorytable.refresh();
					}});
	factory.getChildren().addAll(addfactory,addfactory1);
	
	return factory;
}
}
