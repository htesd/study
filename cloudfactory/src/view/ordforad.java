package view;

import DAO.factorydates;
import DAO.idproducer;
import DAO.orderdate;
import DAO.productdate;
import DAO.producttypedate;
import DAO.userdate;
import POjO.factory;
import POjO.order;
import POjO.product;
import POjO.producttype;
import POjO.user;
import javafx.beans.property.SimpleDoubleProperty;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class ordforad {
public static AnchorPane start(){
	//布局类(order)//!!注意！！更改账户时要查重！
		ObservableList<POjO.order> ulist=FXCollections.observableArrayList();
		//list.addAll(u1,u2,u3,u4);
		for (order order : orderdate.orders) {
			ulist.add(order);
		}
		TableColumn<POjO.order,String > utc1=new TableColumn<POjO.order,String>("收货人名");
		
		utc1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<POjO.order, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getConsigneelname());
				return name;
			}
		});
		
		
		TableColumn<POjO.order,String > utc2=new TableColumn<POjO.order,String>("收货地址");
		
	  utc2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<POjO.order, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getConsigneeladdress());
				return name;
			}
		});


		TableColumn<POjO.order,String > utc3=new TableColumn<POjO.order,String>("收货人联系方式");
		
	    utc3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<POjO.order, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getConsigneelcontact());
				return name;
			}
		});
	    
	    
	TableColumn<POjO.order,String > utc4=new TableColumn<POjO.order,String>("开始时间");
		
	    utc4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<POjO.order, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getStart());
				return name;
			}
		});
	    
	TableColumn<POjO.order,String > utc5=new TableColumn<POjO.order,String>("结束时间");
		
	    utc5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<POjO.order, String> arg0) {
				// TODO Auto-generated method stub
				SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getFinish());
				return name;
			}
		});
	    

	    
	    
		TableColumn<POjO.order,Number > utc6=new TableColumn<POjO.order,Number>("订单id");
		
		utc6.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.order, Number> param) {
				// TODO Auto-generated method stub
				SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getOid());
				return id;
			}
		});	
		
		TableColumn<POjO.order,Number > utc7=new TableColumn<POjO.order,Number>("生产工厂id");
		
		utc7.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.order, Number> param) {
				// TODO Auto-generated method stub
				SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getfid());
				return id;
			}
		});
	    
	    
		TableColumn<POjO.order,Number > utc8=new TableColumn<POjO.order,Number>("商品数量");
		
		utc8.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.order, Number> param) {
				// TODO Auto-generated method stub
				SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getProductamount());
				return id;
			}
		});
		
         TableColumn<POjO.order,Number > utc9=new TableColumn<POjO.order,Number>("商品单价");
		
		utc9.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.order, Number> param) {
				// TODO Auto-generated method stub
				SimpleDoubleProperty id=new SimpleDoubleProperty(param.getValue().getprice());
				return id;
			}
		});
		
		
     TableColumn<POjO.order,Number > utc10=new TableColumn<POjO.order,Number>("代理人id");
		
		utc10.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.order, Number> param) {
				// TODO Auto-generated method stub
				SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getAgentid());
				return id;
			}
		});
		
      TableColumn<POjO.order,Number > utc11=new TableColumn<POjO.order,Number>("交付情况");
		
		utc11.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<POjO.order, Number> param) {
				// TODO Auto-generated method stub
				SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getStatus());
				return id;
			}
		});
		

		//!!!!!!!!!!!!!
		TableView<POjO.order> ordertable=new TableView<POjO.order>(ulist);
		//
		ordertable.setEditable(true);
		//更改
		utc1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,String>>() {
			
			@Override
			public void handle(CellEditEvent<POjO.order, String> event) {
				// TODO Auto-generated method stub
				
				order  temp=event.getRowValue();
				
				orderdate.delete(temp.getOid());
				temp.setConsigneelname(event.getNewValue());
				orderdate.add(temp);
				ordertable.refresh();
				
			}
		});
	utc2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,String>>() {
			
			@Override
			public void handle(CellEditEvent<POjO.order, String> event) {
				// TODO Auto-generated method stub
				
				order  temp=event.getRowValue();
				
				orderdate.delete(temp.getOid());
				temp.setConsigneeladdress(event.getNewValue());
				orderdate.add(temp);
				ordertable.refresh();
				
			}
		});
	utc3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,String>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.order, String> event) {
			// TODO Auto-generated method stub
			
			order  temp=event.getRowValue();
			
			orderdate.delete(temp.getOid());
			temp.setConsigneelcontact(event.getNewValue());
			orderdate.add(temp);
			ordertable.refresh();
			
		}
	});
	
	utc4.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,String>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.order, String> event) {
			// TODO Auto-generated method stub
			
			order  temp=event.getRowValue();
			
			orderdate.delete(temp.getOid());
			temp.setStart(event.getNewValue());
			orderdate.add(temp);
			ordertable.refresh();
			
		}
	});
	
	utc5.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,String>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.order, String> event) {
			// TODO Auto-generated method stub
			
			order  temp=event.getRowValue();
			
			orderdate.delete(temp.getOid());
			temp.setFinish(event.getNewValue());
			orderdate.add(temp);
			ordertable.refresh();
			
		}
	});
	

	utc7.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,Number>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.order, Number> event) {
			// TODO Auto-generated method stub
			
			order  temp=event.getRowValue();
			
			orderdate.delete(temp.getOid());
			temp.setfid(event.getNewValue().intValue());
			
			
			orderdate.add(temp);
			ordertable.refresh();
			
		}
	});

	utc8.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,Number>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.order, Number> event) {
			// TODO Auto-generated method stub
			
			order  temp=event.getRowValue();
			
			orderdate.delete(temp.getOid());
			temp.setProductamount(event.getNewValue().intValue());
			
			
			orderdate.add(temp);
			ordertable.refresh();
			
		}
	});
	utc9.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,Number>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.order, Number> event) {
			// TODO Auto-generated method stub
			
			order  temp=event.getRowValue();
			
			orderdate.delete(temp.getOid());
			temp.setprice(event.getNewValue().doubleValue());
			
			
			orderdate.add(temp);
			ordertable.refresh();
			
		}
	});

	utc10.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,Number>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.order, Number> event) {
			// TODO Auto-generated method stub
			
			order  temp=event.getRowValue();
			
			orderdate.delete(temp.getOid());
			temp.setAgentid(event.getNewValue().intValue());
			
			
			orderdate.add(temp);
			ordertable.refresh();
			
		}
	});

	utc11.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,Number>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.order, Number> event) {
			// TODO Auto-generated method stub
			
			order  temp=event.getRowValue();
			
			orderdate.delete(temp.getOid());
			temp.setStatus(event.getNewValue().intValue());
			
			
			orderdate.add(temp);
			ordertable.refresh();
			
		}
	});



		//
		utc1.setCellFactory(TextFieldTableCell.forTableColumn());
		utc2.setCellFactory(TextFieldTableCell.forTableColumn());
		utc3.setCellFactory(TextFieldTableCell.forTableColumn());
		utc4.setCellFactory(TextFieldTableCell.forTableColumn());
		utc5.setCellFactory(TextFieldTableCell.forTableColumn());
		ObservableList<Number> list2=FXCollections.observableArrayList();
		for (factory a : factorydates.fs) {
			list2.add(a.getfid());
		}
		utc7.setCellFactory(ChoiceBoxTableCell.forTableColumn(list2));
		utc8.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {

			@Override
			public Number fromString(String string) {
				// TODO Auto-generated method stub
				return Integer.valueOf(string);
			}

			@Override
			public String toString(Number object) {
				// TODO Auto-generated method stub
				return String.valueOf(object.intValue());
			}
		}));
		utc9.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {

			@Override
			public Number fromString(String string) {
				// TODO Auto-generated method stub
				return Double.valueOf(string);
			}

			@Override
			public String toString(Number object) {
				// TODO Auto-generated method stub
				return String.valueOf(object.doubleValue());
			}
		}));
		
		ObservableList<Number> list3=FXCollections.observableArrayList();
		for (user a : userdate.users) {
			String b=Integer.toString(a.getid());
			if(b.startsWith("1")){
				list3.add(a.getid());
			}
			
		}
		utc10.setCellFactory(ChoiceBoxTableCell.forTableColumn(list3));
		ObservableList<Number> list4=FXCollections.observableArrayList();
		list4.add(0);
		list4.add(1);
		list4.add(2);
		utc11.setCellFactory(ChoiceBoxTableCell.forTableColumn(list4));
		ordertable.getColumns().addAll(utc1,utc2,utc3,utc4,utc5,utc6,utc7,utc8,utc9,utc10,utc11);
		AnchorPane order =new AnchorPane();
		order.setRightAnchor(ordertable, 20.0);
		order.setLeftAnchor(ordertable, 20.0);
		order.setTopAnchor(ordertable, 50.0);
		order.setBottomAnchor(ordertable, 20.0);
		order.setStyle("-fx-background-color:#FFFFFF;");
		order.getChildren().add(ordertable);
		BorderStroke bos=new BorderStroke(Paint.valueOf("#337AB7"),BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6) );
		Border bo=new Border(bos);
		
		ordertable.setBorder(bo);
		
		//按钮
		Button addorder =new Button("新增");
		addorder.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		addorder.setLayoutX(20);
				addorder.setOnAction(new EventHandler<ActionEvent>(){

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
					//private int oid,fid,productamount,agentid,status;
					//private String consigneelname,consigneeladdress,consigneelcontact ,start,finish;

					textb1.setTooltip(tip);
					textb1.setPromptText("请输入收货人姓名");
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
					textb2.setPromptText("请输入收货人地址");
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
					textb3.setPromptText("请输入联系方式");
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
					textb4.setPromptText("请输入开始时间");
					textb4.setLayoutX(230);
					textb4.setLayoutY(190);
					textb4.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
							textb4.setText(arg1);
								
							}
							
						}
						
					});
					group.getChildren().add(textb4);
					//5
					textb5.setTooltip(tip);
					textb5.setPromptText("请输入结束时间");
					textb5.setLayoutX(230);
					textb5.setLayoutY(220);
					textb5.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
								textb5.setText(arg1);
							}
						
						}
						
					});
					group.getChildren().add(textb5);
					//6
					TextField textb6=new TextField();
					textb6.setTooltip(tip);
					textb6.setPromptText("请输入工厂id");
					textb6.setLayoutX(230);
					textb6.setLayoutY(250);
					textb6.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
								textb6.setText(arg1);
							}
							for(int i=0;i<arg2.length();i++){
								if(!Character.isDigit(arg2.charAt(i))){
									textb6.setText(arg1);
								}
							}
						}
						
					});
					group.getChildren().add(textb6);
					TextField textb7=new TextField();
					textb7.setTooltip(tip);
					textb7.setPromptText("请输入商品数量");
					textb7.setLayoutX(230);
					textb7.setLayoutY(280);
					textb7.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
								textb7.setText(arg1);
							}
							for(int i=0;i<arg2.length();i++){
								if(!Character.isDigit(arg2.charAt(i))){
									textb7.setText(arg1);
								}
							}
						}
						
					});
					group.getChildren().add(textb7);

					TextField textb8=new TextField();
					textb8.setTooltip(tip);
					textb8.setPromptText("请输入商品单价");
					textb8.setLayoutX(230);
					textb8.setLayoutY(310);
					textb8.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
								textb8.setText(arg1);
							}
							for(int i=0;i<arg2.length();i++){
								if(!Character.isDigit(arg2.charAt(i))){
									textb8.setText(arg1);
								}
							}
						}
						
					});
					group.getChildren().add(textb8);
					
					TextField textb9=new TextField();
					textb9.setTooltip(tip);
					textb9.setPromptText("请输入代理人id");
					textb9.setLayoutX(230);
					textb9.setLayoutY(340);
					textb9.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
								textb9.setText(arg1);
							}
							for(int i=0;i<arg2.length();i++){
								if(!Character.isDigit(arg2.charAt(i))){
									textb9.setText(arg1);
								}
							}
						}
						
					});
					group.getChildren().add(textb9);
					
					TextField textb10=new TextField();
					textb10.setTooltip(tip);
					textb10.setPromptText("请输入订单状态");
					textb10.setLayoutX(230);
					textb10.setLayoutY(370);
					textb10.textProperty().addListener(new ChangeListener<String>(){
	            
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>1){
								textb10.setText(arg1);
							}
							for(int i=0;i<arg2.length();i++){
								if(!Character.isDigit(arg2.charAt(i))){
									textb10.setText(arg1);
								}
							}
						}
						
					});
					group.getChildren().add(textb10);
					//lable
					Label la=new Label();
					la.setText("请您输入");
					la.setAlignment(Pos.BASELINE_CENTER);
					group.getChildren().add(la);
					//按钮
					Button b=new Button("添加");
					b.setPrefSize(130, 30);
					b.setLayoutX(270);
					b.setLayoutY(420);
				    b.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent arg0) {
								// TODO Auto-generated method stub
						
								order temp=new order();
								temp.setOid(Integer.parseInt("6"+idproducer.getid()));
								temp.setConsigneelname(textb1.getText());
								temp.setConsigneeladdress(textb2.getText());
								temp.setConsigneelcontact(textb3.getText());
								temp.setStart(textb4.getText());
								temp.setFinish(textb5.getText());
								temp.setfid(Integer.parseInt(textb6.getText()));
								temp.setProductamount(Integer.parseInt(textb7.getText()));
								temp.setprice(Double.parseDouble(textb8.getText()));
								temp.setAgentid(Integer.parseInt(textb9.getText()));
								temp.setStatus(Integer.parseInt(textb10.getText()));
								orderdate.add(temp);
								ulist.add(temp);
								ordertable.refresh();
								la.setText("成功添加");
						
							}});
				    group.getChildren().add(b);
				}});
		Button deleteorder =new Button("删除");
		deleteorder.setStyle("-fx-background-color:#D9534F;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
		deleteorder.setOnAction(new EventHandler<ActionEvent>(){

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
					textb1.setPromptText("请输入订单id");
					textb1.setLayoutX(230);
					textb1.setLayoutY(100);
					textb1.textProperty().addListener(new ChangeListener<String>(){
	         
						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
							// TODO Auto-generated method stub
							if(arg2.length()>10){
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
							
								order temp=new order();
								int i=0;
								for (order s : orderdate.orders) {
									if(s.getOid()==Integer.parseInt(textb1.getText()));{
										temp=s;
										i=1;
										
									}
								}
								if(i==1){
								orderdate.delete(temp.getOid());
							    ulist.remove(temp);
								ordertable.refresh();
								la.setText("成功删除");
								}else{
									i=0;
									la.setText("订单不存在 ");
								}
							
							}});
				    group.getChildren().add(b);
				}});
		order.getChildren().addAll(addorder,deleteorder);
		deleteorder.setLayoutX(80);
		return order;
	///////////////////////////////////////////////////////////////////////////////////////////
		//!!注意！！更改账户时要查重！
}
}
