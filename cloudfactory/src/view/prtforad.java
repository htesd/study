package view;

import DAO.idproducer;
import DAO.producttypedate;
import DAO.userdate;
import POjO.producttype;
import POjO.user;
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
public class prtforad {
public static AnchorPane start(){
	//布局类(producttype)//!!注意！！更改账户时要查重！
		ObservableList<POjO.producttype> ulist=FXCollections.observableArrayList();
		//list.addAll(u1,u2,u3,u4);
		for (producttype producttype : producttypedate.producttypes) {
			ulist.add(producttype);
		}
		TableColumn<POjO.producttype,String > utc1=new TableColumn<POjO.producttype,String>("类别名");
		
		utc1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.producttype,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<POjO.producttype, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().gettypename());
				return name;
			}
		});
		
		
		
	    
		TableColumn<POjO.producttype,Number > utc2=new TableColumn<POjO.producttype,Number>("id");
		
		utc2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.producttype,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.producttype, Number> param) {
				// TODO Auto-generated method stub
				SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().gettypeid());
				return id;
			}
		});
		//!!!!!!!!!!!!!
		TableView<POjO.producttype> producttypetable=new TableView<POjO.producttype>(ulist);
		//
		producttypetable.setEditable(true);
		//更改
		utc1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.producttype,String>>() {
			
			@Override
			public void handle(CellEditEvent<POjO.producttype, String> event) {
				// TODO Auto-generated method stub
				
				producttype  temp=event.getRowValue();
				
				producttypedate.delete(temp.gettypeid());
				temp.settypename(event.getNewValue());
				producttypedate.add(temp);
				producttypetable.refresh();
				
			}
		});


		//
		utc1.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		
		producttypetable.getColumns().addAll(utc1,utc2);
		AnchorPane producttype =new AnchorPane();
		producttype.setRightAnchor(producttypetable, 20.0);
		producttype.setLeftAnchor(producttypetable, 20.0);
		producttype.setTopAnchor(producttypetable, 50.0);
		producttype.setBottomAnchor(producttypetable, 20.0);
		producttype.setStyle("-fx-background-color:#FFFFFF;");
		producttype.getChildren().add(producttypetable);
		BorderStroke bos=new BorderStroke(Paint.valueOf("#337AB7"),BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6) );
		Border bo=new Border(bos);
		
		producttypetable.setBorder(bo);
		
		//按钮
		Button addproducttype =new Button("新增");
		addproducttype.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		addproducttype.setLayoutX(20);
				addproducttype.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Stage a=new Stage();
					Group group=new Group();
					Scene qiandao=new Scene(group);
					a.setScene(qiandao);
					a.isAlwaysOnTop();
					a.setWidth(700);
					a.setHeight(700);
					a.show();
					TextField textb1=new TextField();
					TextField textb2=new TextField();
					
					Tooltip tip=new Tooltip("请不要超过10个字符");
					//wenben1
					textb1.setTooltip(tip);
					textb1.setPromptText("请输入类别名");
					textb1.setLayoutX(90);
					textb1.setLayoutY(100);
					textb1.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>6){
								textb1.setText(arg1);
							}
						}
						
					});
					group.getChildren().add(textb1);
					//wenben2
					textb2.setTooltip(tip);
					textb2.setPromptText("请输入类别id");
					textb2.setLayoutX(90);
					textb2.setLayoutY(130);
					textb2.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
								
								textb2.setText(arg1);
								
							}
							for(int i=0;i<arg2.length();i++){
								if(!Character.isDigit(arg2.charAt(i))){
									textb2.setText(arg1);
								}
							}
						}
						
					});
					group.getChildren().add(textb2);
					
					//lable
					Label la=new Label();
					la.setText("请您输入类别名和类别id");
					la.setAlignment(Pos.BASELINE_CENTER);
					group.getChildren().add(la);
					//按钮
					Button b=new Button("添加");
					b.setPrefSize(130, 30);
					b.setLayoutX(130);
					b.setLayoutY(250);
				    b.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent arg0) {
								// TODO Auto-generated method stub
							if(!producttypedate.check(Integer.parseInt(textb2.getText()))){
								producttype temp=new producttype();
								temp.settypename(textb1.getText());
								temp.settypeid(Integer.parseInt(textb2.getText()));
								producttypedate.add(temp);
								ulist.add(temp);
								producttypetable.refresh();
								la.setText("成功添加");
							}else{
								la.setText("该用户已经存在！");
							}
							}});
				    group.getChildren().add(b);
				}});
		Button deleteproducttype =new Button("删除");
		deleteproducttype.setStyle("-fx-background-color:#D9534F;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		deleteproducttype.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Stage a=new Stage();
					Group group=new Group();
					Scene qiandao=new Scene(group);
					a.setScene(qiandao);
					a.isAlwaysOnTop();
					a.setWidth(700);
					a.setHeight(700);
					a.show();
					TextField textb1=new TextField();
					
					Tooltip tip=new Tooltip("请不要超过10个字符");
					//wenben1
					textb1.setTooltip(tip);
					textb1.setPromptText("请输入类型id");
					textb1.setLayoutX(230);
					textb1.setLayoutY(100);
					textb1.textProperty().addListener(new ChangeListener<String>(){
	         
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>6){
								textb1.setText(arg1);
							}
							for(int i=0;i<arg2.length();i++){
								if(!Character.isDigit(arg2.charAt(i))){
									textb1.setText(arg1);
								}
							}
						}
						
					});
					group.getChildren().add(textb1);
					
					//lable
					Label la=new Label();
					la.setText("请您输入账号");
					la.setAlignment(Pos.BASELINE_CENTER);
					group.getChildren().add(la);
					//按钮
					Button b=new Button("删除");
					b.setPrefSize(130, 30);
					b.setLayoutX(270);
					b.setLayoutY(250);
				    b.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent arg0) {
								// TODO Auto-generated method stub
							if(producttypedate.check(Integer.parseInt(textb1.getText()))){
								producttype temp=new producttype();
								int i=0;
								for (producttype s : producttypedate.producttypes) {
									if(s.gettypeid()==Integer.parseInt(textb1.getText()));{
										temp=s;
										i=1;
										
									}
								}
								if(i==1){
								producttypedate.delete(temp.gettypeid());
							    ulist.remove(temp);
								producttypetable.refresh();
								la.setText("成功删除");
								}else{
									i=0;
									la.setText("类型不存在 ");
								}
							}else{
								la.setText("该类型不存在！");
							}
							}});
				    group.getChildren().add(b);
				}});
		producttype.getChildren().addAll(addproducttype,deleteproducttype);
		deleteproducttype.setLayoutX(80);
		return producttype;
	///////////////////////////////////////////////////////////////////////////////////////////
		//!!注意！！更改账户时要查重！
} 
}
