package view;

import DAO.equipmentdate;
import DAO.etypedate;
import DAO.factorydates;
import DAO.idproducer;
import DAO.userdate;
import POjO.equipment;
import POjO.etype;
import POjO.factory;
import POjO.user;
import control.console;
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

public class rentview extends Application{
	Stage stage=new Stage();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
	@Override
	public void start(Stage main) throws Exception {
		// TODO Auto-generated method stub
		//布局类(equipment)//!!注意！！更改账户时要查重！
		
		
				ObservableList<POjO.equipment> ulist=FXCollections.observableArrayList();
				//list.addAll(u1,u2,u3,u4);
				for (equipment equipment : equipmentdate.equipments) {
					if(equipment.getfid()==999&&equipment.gettentalstatus()==0&&equipment.getrenterid()==0)
					{
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
			    
			    
				TableColumn<POjO.equipment,Number > utc4=new TableColumn<POjO.equipment,Number>("类型id");
				
				utc4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,Number>, ObservableValue<Number>>() {
					
					@Override
					public ObservableValue<Number> call(CellDataFeatures<POjO.equipment, Number> param) {
						// TODO Auto-generated method stub
						SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getetid());
						return id;
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
				
			TableColumn<POjO.equipment,Number > utc7=new TableColumn<POjO.equipment,Number>("工作状态");
				
				utc7.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.equipment,Number>, ObservableValue<Number>>() {
					
					@Override
					public ObservableValue<Number> call(CellDataFeatures<POjO.equipment, Number> param) {
						// TODO Auto-generated method stub
						SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getworkstatus());
						return id;
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
				//更改
				utc1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.equipment,String>>() {
					
					@Override
					public void handle(CellEditEvent<POjO.equipment, String> event) {
						// TODO Auto-generated method stub
						
						equipment  temp=event.getRowValue();
						
						equipmentdate.delete(temp.geteid());
						temp.setname(event.getNewValue());
						equipmentdate.add(temp);
						equipmenttable.refresh();
						
					}
				});
			utc2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.equipment,String>>() {
					
					@Override
					public void handle(CellEditEvent<POjO.equipment, String> event) {
						// TODO Auto-generated method stub
						
						equipment  temp=event.getRowValue();
						
						equipmentdate.delete(temp.geteid());
						temp.setInfo(event.getNewValue());
						equipmentdate.add(temp);
						equipmenttable.refresh();
						
					}
				});
			utc3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.equipment,String>>() {
				
				@Override
				public void handle(CellEditEvent<POjO.equipment, String> event) {
					// TODO Auto-generated method stub
					
					equipment  temp=event.getRowValue();
					
					equipmentdate.delete(temp.geteid());
					temp.setspecification(event.getNewValue());
					equipmentdate.add(temp);
					equipmenttable.refresh();
					
				}
			});
			utc4.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.equipment,Number>>() {
				
				@Override
				public void handle(CellEditEvent<POjO.equipment, Number> event) {
					// TODO Auto-generated method stub
					
					equipment  temp=event.getRowValue();
					
					equipmentdate.delete(temp.geteid());
					temp.setetid(event.getNewValue().intValue());
					
					
					equipmentdate.add(temp);
					equipmenttable.refresh();
					
				}
			});
			utc5.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.equipment,Number>>() {
				
				@Override
				public void handle(CellEditEvent<POjO.equipment, Number> event) {
					// TODO Auto-generated method stub
					
					equipment  temp=event.getRowValue();
					
					equipmentdate.delete(temp.geteid());
					temp.setfid(event.getNewValue().intValue());
					
					
					equipmentdate.add(temp);
					equipmenttable.refresh();
					
				}
			});
			utc7.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.equipment,Number>>() {
				
				@Override
				public void handle(CellEditEvent<POjO.equipment, Number> event) {
					// TODO Auto-generated method stub
					
					equipment  temp=event.getRowValue();
					
					equipmentdate.delete(temp.geteid());
					temp.setworkstatus(event.getNewValue().intValue());
					
					
					equipmentdate.add(temp);
					equipmenttable.refresh();
					
				}
			});
			utc8.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.equipment,Number>>() {
				
				@Override
				public void handle(CellEditEvent<POjO.equipment, Number> event) {
					// TODO Auto-generated method stub
					
					equipment  temp=event.getRowValue();
					
					equipmentdate.delete(temp.geteid());
					temp.settentalstatus(event.getNewValue().intValue());
					
					
					equipmentdate.add(temp);
					equipmenttable.refresh();
					
				}
			});
			utc9.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.equipment,Number>>() {
				
				@Override
				public void handle(CellEditEvent<POjO.equipment, Number> event) {
					// TODO Auto-generated method stub
					
					equipment  temp=event.getRowValue();
					
					equipmentdate.delete(temp.geteid());
					temp.setrenterid(event.getNewValue().intValue());
					
					
					equipmentdate.add(temp);
					equipmenttable.refresh();
					
				}
			});
				//
				utc1.setCellFactory(TextFieldTableCell.forTableColumn());
				utc2.setCellFactory(TextFieldTableCell.forTableColumn());
				utc3.setCellFactory(TextFieldTableCell.forTableColumn());
				//
				ObservableList<Number> list2=FXCollections.observableArrayList();
				for (etype a : etypedate.etypes) {
					list2.add(a.gettypeid());
				}
				utc4.setCellFactory(ChoiceBoxTableCell.forTableColumn(list2));
				//
				//
				ObservableList<Number> list3=FXCollections.observableArrayList();
				for (factory a : factorydates.fs) {
					list3.add(a.getfid());
				}
				list3.add(999);
				utc5.setCellFactory(ChoiceBoxTableCell.forTableColumn(list3));
				//
				//
				ObservableList<Number> list4=FXCollections.observableArrayList();
				list4.add(0);
				list4.add(1);
				utc7.setCellFactory(ChoiceBoxTableCell.forTableColumn(list4));
				//
				//
				ObservableList<Number> list5=FXCollections.observableArrayList();
				list5.add(0);
				list5.add(1);
				utc8.setCellFactory(ChoiceBoxTableCell.forTableColumn(list5));
				//
				//
				ObservableList<Number> list6=FXCollections.observableArrayList();
				for (user a :userdate.users) {
					list6.add(a.getid());
				}
				utc9.setCellFactory(ChoiceBoxTableCell.forTableColumn(list6));
				//
				equipmenttable.getColumns().addAll(utc1,utc2,utc3,utc4,utc5,utc6,utc7,utc8,utc9);
				AnchorPane equipment =new AnchorPane();
				equipment.setPrefSize(1440, 800);
				Scene scene=new Scene(equipment);
				main.setScene(scene);
				//lable
				Label la=new Label("");
				equipment.getChildren().add(la);
				equipment.setLeftAnchor(la, (double) 330);
				equipment.setTopAnchor(la, (double) 5);
				main.show();
				equipment.setRightAnchor(equipmenttable, 20.0);
				equipment.setLeftAnchor(equipmenttable, 20.0);
				equipment.setTopAnchor(equipmenttable, 50.0);
				equipment.setBottomAnchor(equipmenttable, 20.0);
				equipment.setStyle("-fx-background-color:#FFFFFF;");
				equipment.getChildren().add(equipmenttable);
				BorderStroke bos=new BorderStroke(Paint.valueOf("#337AB7"),BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6) );
				Border bo=new Border(bos);
				
				equipmenttable.setBorder(bo);
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
				Button addequipment =new Button("租借");
				addequipment.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
				addequipment.setLayoutX(20);
						addequipment.setOnAction(new EventHandler<ActionEvent>(){

						@Override
						public void handle(ActionEvent arg0) {
							if(text.getText().isEmpty()){
								la.setText("请正确输入！");
							}else{
								int i=0;
								equipment temp=null;
								equipment temp1=null;
								for (POjO.equipment a : ulist) {
									if(a.geteid()==Integer.parseInt(text.getText())){
										i=1;
										temp1=a;
										a.setrenterid(console.managering.getid());
										a.settentalstatus(1);
										temp=a;
									}
								}
								if(i==1){
									equipmentdate.delete(temp.geteid());
									equipmentdate.add(temp);
									ulist.remove(temp1);
									la.setText("成功租借");
									equipmenttable.refresh();
								}else{
									la.setText("没有此设备");
								}
							}
						}});
				
				equipment.getChildren().addAll(addequipment);
				
				
		
		
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
