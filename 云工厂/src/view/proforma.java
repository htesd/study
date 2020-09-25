package view;

import DAO.idproducer;
import DAO.productdate;
import DAO.producttypedate;
import POjO.product;
import POjO.producttype;
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

public class proforma {
public static AnchorPane start(){
	//布局类(product)//!!注意！！更改账户时要查重！
		ObservableList<POjO.product> ulist=FXCollections.observableArrayList();
		//list.addAll(u1,u2,u3,u4);
		for (product product : productdate.products) {
			ulist.add(product);
		}
		TableColumn<POjO.product,String > utc1=new TableColumn<POjO.product,String>("产品名");
		
		utc1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.product,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<POjO.product, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getname());
				return name;
			}
		});
		
		
		TableColumn<POjO.product,String > utc2=new TableColumn<POjO.product,String>("产品信息");
		
	  utc2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.product,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<POjO.product, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getinfo());
				return name;
			}
		});


		TableColumn<POjO.product,String > utc3=new TableColumn<POjO.product,String>("产品规格");
		
	    utc3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.product,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<POjO.product, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getspecification());
				return name;
			}
		});
	    
	    
		TableColumn<POjO.product,Number > utc4=new TableColumn<POjO.product,Number>("产品id");
		
		utc4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.product,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.product, Number> param) {
				// TODO Auto-generated method stub
				SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getpid());
				return id;
			}
		});	
		
		TableColumn<POjO.product,Number > utc5=new TableColumn<POjO.product,Number>("类型id");
		
		utc5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.product,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.product, Number> param) {
				// TODO Auto-generated method stub
				SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getptid());
				return id;
			}
		});
	    
	    
		TableColumn<POjO.product,Number > utc6=new TableColumn<POjO.product,Number>("订单id");
		
		utc6.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.product,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.product, Number> param) {
				// TODO Auto-generated method stub
				SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getoid());
				return id;
			}
		});
		//!!!!!!!!!!!!!
		TableView<POjO.product> producttable=new TableView<POjO.product>(ulist);
		//
		producttable.setEditable(true);
		//更改
		utc1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.product,String>>() {
			
			@Override
			public void handle(CellEditEvent<POjO.product, String> event) {
				// TODO Auto-generated method stub
				
				product  temp=event.getRowValue();
				
				productdate.delete(temp.getpid());
				temp.setname(event.getNewValue());
				productdate.add(temp);
				producttable.refresh();
				
			}
		});
	utc2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.product,String>>() {
			
			@Override
			public void handle(CellEditEvent<POjO.product, String> event) {
				// TODO Auto-generated method stub
				
				product  temp=event.getRowValue();
				
				productdate.delete(temp.getpid());
				temp.setinfo(event.getNewValue());
				productdate.add(temp);
				producttable.refresh();
				
			}
		});
	utc3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.product,String>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.product, String> event) {
			// TODO Auto-generated method stub
			
			product  temp=event.getRowValue();
			
			productdate.delete(temp.getpid());
			temp.setspecification(event.getNewValue());
			productdate.add(temp);
			producttable.refresh();
			
		}
	});
	utc5.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.product,Number>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.product, Number> event) {
			// TODO Auto-generated method stub
			
			product  temp=event.getRowValue();
			
			productdate.delete(temp.getpid());
			temp.setptid(event.getNewValue().intValue());
			
			
			productdate.add(temp);
			producttable.refresh();
			
		}
	});

		//
		utc1.setCellFactory(TextFieldTableCell.forTableColumn());
		utc2.setCellFactory(TextFieldTableCell.forTableColumn());
		utc3.setCellFactory(TextFieldTableCell.forTableColumn());
		
		ObservableList<Number> list2=FXCollections.observableArrayList();
		for (producttype a : producttypedate.producttypes) {
			list2.add(a.gettypeid());
		}
		utc5.setCellFactory(ChoiceBoxTableCell.forTableColumn(list2));
		producttable.getColumns().addAll(utc1,utc2,utc3,utc4,utc5,utc6);
		AnchorPane product =new AnchorPane();
		product.setRightAnchor(producttable, 20.0);
		product.setLeftAnchor(producttable, 20.0);
		product.setTopAnchor(producttable, 50.0);
		product.setBottomAnchor(producttable, 20.0);
		product.setStyle("-fx-background-color:#FFFFFF;");
		product.getChildren().add(producttable);
		BorderStroke bos=new BorderStroke(Paint.valueOf("#337AB7"),BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6) );
		Border bo=new Border(bos);
		
		producttable.setBorder(bo);
		
		//按钮
		Button addproduct =new Button("新增");
		addproduct.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		addproduct.setLayoutX(20);
				addproduct.setOnAction(new EventHandler<ActionEvent>(){

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
					TextField textb3=new TextField();
					TextField textb4=new TextField();
					TextField textb5=new TextField();
					Tooltip tip=new Tooltip("请不要超过10个字符");
					//wenben1
					textb1.setTooltip(tip);
					textb1.setPromptText("请输入产品名");
					textb1.setLayoutX(230);
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
					textb2.setPromptText("请输入产品信息");
					textb2.setLayoutX(230);
					textb2.setLayoutY(130);
					textb2.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
								
								textb2.setText(arg1);
								
							}
						}
						
					});
					group.getChildren().add(textb2);
					//wenben3
					textb3.setTooltip(tip);
					textb3.setPromptText("请输入产品规格");
					textb3.setLayoutX(230);
					textb3.setLayoutY(160);
					textb3.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
								
								textb3.setText(arg1);
								
							}
						}
					
					});
					group.getChildren().add(textb3);
					//4
					textb4.setTooltip(tip);
					textb4.setPromptText("请输入产品类别");
					textb4.setLayoutX(230);
					textb4.setLayoutY(190);
					textb4.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
							textb4.setText(arg1);
								
							}
							for(int i=0;i<arg2.length();i++){
								if(!Character.isDigit(arg2.charAt(i))){
									textb4.setText(arg1);
								}
							}
						}
						
					});
					group.getChildren().add(textb4);
					//5
					textb5.setTooltip(tip);
					textb5.setPromptText("请输入订单号");
					textb5.setLayoutX(230);
					textb5.setLayoutY(220);
					textb5.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
								textb5.setText(arg1);
							}
							for(int i=0;i<arg2.length();i++){
								if(!Character.isDigit(arg2.charAt(i))){
									textb5.setText(arg1);
								}
							}
						}
						
					});
					group.getChildren().add(textb5);
					//lable
					Label la=new Label();
					la.setText("请您输入产品名,产品信息,产品规格,产品类别,订单号，分别在下面的五个空格里输入");
					la.setAlignment(Pos.BASELINE_CENTER);
					group.getChildren().add(la);
					//按钮
					Button b=new Button("添加");
					b.setPrefSize(130, 30);
					b.setLayoutX(270);
					b.setLayoutY(250);
				    b.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent arg0) {
								// TODO Auto-generated method stub
						
								product temp=new product();
								temp.setinfo(textb2.getText());
								temp.setpid(Integer.parseInt("5"+idproducer.getid()));
								temp.setptid(Integer.parseInt(textb4.getText()));
								temp.setoid(Integer.parseInt(textb5.getText()));
								temp.setspecification(textb3.getText());
								temp.setname(textb1.getText());
								productdate.add(temp);
								ulist.add(temp);
								producttable.refresh();
								la.setText("成功添加");
						
							}});
				    group.getChildren().add(b);
				}});
		Button deleteproduct =new Button("删除");
		deleteproduct.setStyle("-fx-background-color:#D9534F;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		deleteproduct.setOnAction(new EventHandler<ActionEvent>(){

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
					textb1.setPromptText("请输入账号");
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
					la.setText("请您输入订单id");
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
							
								product temp=new product();
								int i=0;
								for (product s : productdate.products) {
									if(s.getpid()==Integer.parseInt(textb1.getText()));{
										temp=s;
										i=1;
										
									}
								}
								if(i==1){
								productdate.delete(temp.getpid());
							    ulist.remove(temp);
								producttable.refresh();
								la.setText("成功删除");
								}else{
									i=0;
									la.setText("订单不存在 ");
								}
							
							}});
				    group.getChildren().add(b);
				}});
		product.getChildren().addAll(addproduct,deleteproduct);
		deleteproduct.setLayoutX(80);
		return product;
	///////////////////////////////////////////////////////////////////////////////////////////
		//!!注意！！更改账户时要查重！
}
}
