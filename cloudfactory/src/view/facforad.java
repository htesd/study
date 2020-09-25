package view;

import DAO.factorydates;
import DAO.idproducer;
import POjO.factory;
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

public class facforad {
	
	public static AnchorPane start() throws Exception {
		// TODO Auto-generated method stub
	////fa	////////////////////////////////////////////////////////////////////////////////////factory
			ObservableList<factory> flist=FXCollections.observableArrayList();
			//list.addAll(u1,u2,u3,u4);
			for (factory factory : factorydates.fs) {
				flist.add(factory);
			}
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
			
			//按钮
			Button addfactory =new Button("新增");
			addfactory.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			addfactory.setLayoutX(20);
					addfactory.setOnAction(new EventHandler<ActionEvent>(){

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
						Tooltip tip=new Tooltip("请不要超过10个字符");
						//wenben1
						textb1.setTooltip(tip);
						textb1.setPromptText("请输入工厂名");
						textb1.setLayoutX(230);
						textb1.setLayoutY(100);
						textb1.textProperty().addListener(new ChangeListener<String>(){
	                
							@Override
							public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
								// TODO Auto-generated method stub
								if(arg2.length()>10){
									textb1.setText(arg1);
								}
							}
							
						});
						group.getChildren().add(textb1);
						//wenben2
						textb2.setTooltip(tip);
						textb2.setPromptText("请输入工厂信息");
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
						textb3.setPromptText("请输入管理员id");
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
						//lable
						Label la=new Label();
						la.setText("请您输入工厂名和工厂信息");
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
								if(!factorydates.check(textb1.getText())){
									factory temp=new factory();
									temp.setfid(Integer.parseInt("3"+idproducer.getid()));
									temp.setinfo(textb2.getText());
									temp.setname(textb1.getText());
									temp.setuserid(Integer.parseInt(textb3.getText()));
									factorydates.add(temp);
									flist.add(temp);
									factorytable.refresh();
									la.setText("成功添加");
								}else{
									la.setText("该工厂已经存在！");
								}
								}});
					    group.getChildren().add(b);
					}});
			Button deletefactory =new Button("删除");
			deletefactory.setStyle("-fx-background-color:#D9534F;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			deletefactory.setOnAction(new EventHandler<ActionEvent>(){

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
						textb1.setPromptText("请输入工厂id");
						textb1.setLayoutX(230);
						textb1.setLayoutY(100);
						textb1.textProperty().addListener(new ChangeListener<String>(){
	             
							@Override
							public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
								// TODO Auto-generated method stub
								if(arg2.length()>10){
									textb1.setText(arg1);
								}
							}
							
						});
						group.getChildren().add(textb1);
						
						//lable
						Label la=new Label();
						la.setText("请您输入工厂id");
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
								
									factory temp=factorydates.find(Integer.parseInt(textb1.getText()));
							   if(factorydates.delete(Integer.parseInt(textb1.getText()))){	
								  
								    flist.remove(temp);
								    factorytable.refresh();
									la.setText("成功删除");
									
								}else{
									la.setText("该用户不存在！");
								}
								}});
					    group.getChildren().add(b);
					}});
			factory.getChildren().addAll(addfactory,deletefactory);
			deletefactory.setLayoutX(80);
			return factory;
			//
	}

}
