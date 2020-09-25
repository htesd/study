package view;

import DAO.equipmentdate;
import DAO.etypedate;
import DAO.factorydates;
import DAO.idproducer;
import DAO.orderdate;
import DAO.userdate;
import POjO.Manager;
import POjO.equipment;
import POjO.etype;
import POjO.factory;
import POjO.order;
import POjO.user;
import control.console;
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

public class eqpforma {
public static AnchorPane start(){
	//布局类(equipment)//!!注意！！更改账户时要查重！
			ObservableList<POjO.equipment> ulist=FXCollections.observableArrayList();
			//list.addAll(u1,u2,u3,u4);
			
			for (equipment equipment : equipmentdate.equipments) {
				if(equipment.getfid()==console.managering.getfid()||equipment.getrenterid()==console.managering.getid()){
					ulist.add(equipment);
				}
			}
			TableColumn<POjO.equipment,String > utc1=new TableColumn<POjO.equipment,String>("设备名");
			
			utc1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<POjO.equipment, String> arg0) {
					// TODO Auto-generated method stub
					SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getname());
					return name;
				}
			});
			
			
			TableColumn<POjO.equipment,String > utc2=new TableColumn<POjO.equipment,String>("设备信息");
			
		  utc2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<POjO.equipment, String> arg0) {
					// TODO Auto-generated method stub
					SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getInfo());
					return name;
				}
			});


			TableColumn<POjO.equipment,String > utc3=new TableColumn<POjO.equipment,String>("产品规格");
			
		    utc3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<POjO.equipment, String> arg0) {
					// TODO Auto-generated method stub
					SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getspecification());
					return name;
				}
			});
		    
		    
			TableColumn<POjO.equipment,String > utc4=new TableColumn<POjO.equipment,String>("类型");
			
			utc4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<POjO.equipment, String> param) {
					// TODO Auto-generated method stub
					SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getetid());
					SimpleStringProperty id1= new SimpleStringProperty("自定义设备");
					
					for (equipment equipment : equipmentdate.equipments) {
						if(id.isEqualTo(equipment.getetid()) .getValue()){
							id1=new SimpleStringProperty(etypedate.find(equipment.getetid()).gettypename());
							
						}
					}
					
					return id1;
				}
			});	
			
			TableColumn<POjO.equipment,Number > utc5=new TableColumn<POjO.equipment,Number>("所属工厂id");
			
			utc5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,Number>, ObservableValue<Number>>() {
				
				@Override
				public ObservableValue<Number> call(CellDataFeatures<POjO.equipment, Number> param) {
					// TODO Auto-generated method stub
					SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getfid());
					return id;
				}
			});
		    
		    
			TableColumn<POjO.equipment,Number > utc6=new TableColumn<POjO.equipment,Number>("设备id");
			
			utc6.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,Number>, ObservableValue<Number>>() {
				
				@Override
				public ObservableValue<Number> call(CellDataFeatures<POjO.equipment, Number> param) {
					// TODO Auto-generated method stub
					SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().geteid());
					return id;
				}
			});
			
			TableColumn<POjO.equipment,String > utc7=new TableColumn<POjO.equipment,String>("工作状态");
			utc7.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<POjO.equipment, String> param) {
					// TODO Auto-generated method stub
					SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getworkstatus());
					SimpleStringProperty id1= null;
					if(id.isEqualTo(0) .getValue()){
						return id1= new SimpleStringProperty ("闲置中");
					}else{
						if(id.isEqualTo(1).getValue()){
							return id1= new SimpleStringProperty ("运作中");
						}else{
							
							return id1= new SimpleStringProperty ("出错");
						}
					}
					
					
				}
			});	
			
		TableColumn<POjO.equipment,Number > utc8=new TableColumn<POjO.equipment,Number>("租借状态");
			
			utc8.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,Number>, ObservableValue<Number>>() {
				
				@Override
				public ObservableValue<Number> call(CellDataFeatures<POjO.equipment, Number> param) {
					// TODO Auto-generated method stub
					SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().gettentalstatus());
					return id;
				}
			});
	    TableColumn<POjO.equipment,Number > utc9=new TableColumn<POjO.equipment,Number>("租借人id");
			
			utc9.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,Number>, ObservableValue<Number>>() {
				
				@Override
				public ObservableValue<Number> call(CellDataFeatures<POjO.equipment, Number> param) {
					// TODO Auto-generated method stub
					SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getrenterid());
					return id;
				}
			});
			//!!!!!!!!!!!!!
			TableView<POjO.equipment> equipmenttable=new TableView<POjO.equipment>(ulist);
			//
			equipmenttable.setEditable(true);
			
			equipmenttable.getColumns().addAll(utc1,utc2,utc3,utc4,utc5,utc6,utc7,utc8,utc9);
			AnchorPane equipment =new AnchorPane();
			equipment.setRightAnchor(equipmenttable, 20.0);
			equipment.setLeftAnchor(equipmenttable, 20.0);
			equipment.setTopAnchor(equipmenttable, 50.0);
			equipment.setBottomAnchor(equipmenttable, 20.0);
			equipment.setStyle("-fx-background-color:#FFFFFF;");
			equipment.getChildren().add(equipmenttable);
			BorderStroke bos=new BorderStroke(Paint.valueOf("#337AB7"),BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6) );
			Border bo=new Border(bos);
			
			equipmenttable.setBorder(bo);
			//更改
			utc4.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.equipment,String>>() {
				
				@Override
				public void handle(CellEditEvent<POjO.equipment, String> event) {
					// TODO Auto-generated method stub
					
					equipment  temp=event.getRowValue();
					
					equipmentdate.delete(temp.geteid());
					//temp.setetid(event.getNewValue());
					for (etype e : etypedate.etypes) {
						if(e.gettypename().equals(event.getNewValue())){
							temp.setetid(e.gettypeid());
						}
					}
					
					equipmentdate.add(temp);
					equipmenttable.refresh();
					
				}
			});
			ObservableList<String> list2=FXCollections.observableArrayList();
			for (etype a : etypedate.etypes) {
				list2.add(a.gettypename());
			}
			utc4.setCellFactory(ChoiceBoxTableCell.forTableColumn(list2));
			//检索
			Tooltip tip=new Tooltip("请不要超过10个字符");
			TextField text=new TextField();
			text.setTooltip(tip);
			text.setText("");
			text.setPromptText("请输入需要检索的id");
			equipment.setRightAnchor(text, 20.0);
			
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
			equipment.getChildren().add(text);
			//按钮
			Button addequipment =new Button("新增");
			addequipment.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			addequipment.setLayoutX(20);
					addequipment.setOnAction(new EventHandler<ActionEvent>(){

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
						
						Tooltip tip=new Tooltip("请不要超过10个字符");
						//wenben1
						textb1.setTooltip(tip);
						textb1.setPromptText("请输入设备名");
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
						textb2.setPromptText("请输入设备信息");
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
						textb3.setPromptText("请输入设备规格");
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
						textb4.setPromptText("请输入设备类别");
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
					
						//lable
						Label la=new Label();
						la.setText("请您输入设备名,设备信息,设备规格,设备类别，分别在下面的空格里输入");
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
							
									equipment temp=new equipment();
									temp.setInfo(textb2.getText());
									temp.seteid(Integer.parseInt("4"+idproducer.getid()));
									temp.setetid(Integer.parseInt(textb4.getText()));
									temp.setfid(console.managering.getfid());
									temp.setspecification(textb3.getText());
									temp.setname(textb1.getText());
									temp.setworkstatus(0);
									temp.setrenterid(0);
									temp.settentalstatus(0);
									equipmentdate.add(temp);
									ulist.add(temp);
									equipmenttable.refresh();
									la.setText("成功添加");
							
								}});
					    group.getChildren().add(b);
					}});
			Button deleteequipment =new Button("删除");
			deleteequipment.setStyle("-fx-background-color:#D9534F;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			deleteequipment.setOnAction(new EventHandler<ActionEvent>(){

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
						la.setText("请您输入设备id");
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
								
									equipment temp=new equipment();
									int i=0;
									for (equipment s : equipmentdate.equipments) {
										if(s.geteid()==Integer.parseInt(textb1.getText()));{
											temp=s;
											i=1;
											
										}
									}
									if(i==1){
									equipmentdate.delete(temp.geteid());
								    ulist.remove(temp);
									equipmenttable.refresh();
									la.setText("成功删除");
									}else{
										i=0;
										la.setText("设备不存在 ");
									}
								
								}});
					    group.getChildren().add(b);
					}});
			equipment.getChildren().addAll(addequipment,deleteequipment);
			deleteequipment.setLayoutX(80);
			
			Button changeworkingstatue =new Button("切换");
			changeworkingstatue.setStyle("-fx-background-color:#337AB7;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			changeworkingstatue.setLayoutX(140);
			equipment.getChildren().add(changeworkingstatue);
			
			Button zujie =new Button("租借");
			zujie.setStyle("-fx-background-color:#99CCFF;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			zujie.setLayoutX(200);
			equipment.getChildren().add(zujie);
			
			Button give =new Button("归还");
			give.setStyle("-fx-background-color:#99CCFF;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			give.setLayoutX(260);
			equipment.getChildren().add(give);
			
			//lable
			Label la=new Label("");
			equipment.getChildren().add(la);
			equipment.setLeftAnchor(la, (double) 380);
			equipment.setTopAnchor(la, (double) 5);
		//事件
			
			changeworkingstatue.setOnAction(new EventHandler<ActionEvent>() {
				
				
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					if(text.getText().isEmpty()){
					la.setText("你还没输入信息");
					    }else{
					
					equipment temp2=null;
					int i=0;
					for (equipment equipment2 : ulist) {
						if(Integer.parseInt(text.getText())==equipment2.geteid()&&equipment2.getworkstatus()==1){
						
							
							i=1;
							equipment2.setworkstatus(0);
							System.out.println("6");
							temp2=equipment2;
							break;
						}
						if(Integer.parseInt(text.getText())==equipment2.geteid()&&equipment2.getworkstatus()==0){
							
							i=1;
							equipment2.setworkstatus(1);
							temp2=equipment2;
							temp2.setworkstatus(1);
							
						}
					}
					if(i==1){
					equipmentdate.delete(temp2.geteid());
					equipmentdate.add(temp2);
					System.out.println(temp2.getworkstatus());
					equipmenttable.refresh();
					la.setText("成功切换");
					}else{
						i=0;
						la.setText("该设备不存在！！！");
					}
				
					    }
				}
				
			});
			
         give.setOnAction(new EventHandler<ActionEvent>() {
				
				
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					if(text.getText().isEmpty()){
					la.setText("你还没输入信息");
					    }else{
					
					equipment temp2=null;
					equipment temp3=null;
					int i=0;
					for (equipment equipment2 : ulist) {
						if(Integer.parseInt(text.getText())==equipment2.geteid()&&equipment2.gettentalstatus()==1){
						
							
							i=1;
							temp3=equipment2;
							equipment2.settentalstatus(0);
							equipment2.setrenterid(0);
							
							temp2=equipment2;
							
						}
					
					}
					if(i==1){
					equipmentdate.delete(temp2.geteid());
					equipmentdate.add(temp2);
					ulist.remove(temp3);
					equipmenttable.refresh();
					la.setText("成功归还");
					}else{
						i=0;
						la.setText("该租借设备不存在！！！");
					}
				
					    }
				}
				
			});
		
			
			zujie.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					rentview temp=new rentview();
					try {
						temp.showWindow();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					equipmenttable.refresh();
				}
			});
			
			
			Button addorder1 =new Button("刷新");
			addorder1.setStyle("-fx-background-color:#99CCFF;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			addorder1.setLayoutX(320);
					addorder1.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						ulist.clear();
						for (equipment equipment : equipmentdate.equipments) {
							if(equipment.getfid()==console.managering.getfid()||equipment.getrenterid()==console.managering.getid()){
								ulist.add(equipment);
							}
						}
						equipmenttable.refresh();
						
					}});
			
			equipment.getChildren().addAll(addorder1);	
			
			
			
			
			return equipment;
}
}
