package view;

import DAO.equipmentdate;
import DAO.factorydates;
import DAO.idproducer;
import DAO.orderdate;
import DAO.userdate;
import POjO.equipment;
import POjO.factory;
import POjO.order;
import POjO.user;
import control.console;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class arrangeorder {
public static AnchorPane start(){
	//布局类(order)//!!注意！！更改账户时要查重！
			ObservableList<POjO.order> ulist=FXCollections.observableArrayList();
			//list.addAll(u1,u2,u3,u4);
			for (order order : orderdate.orders) {
				if(order.getfid()==console.managering.getfid()){
					ulist.add(order);
				}
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
			
			 TableColumn<POjO.order,String > utc11=new TableColumn<POjO.order,String>("交付情况");
				
				utc11.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,String>, ObservableValue<String>>() {
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<POjO.order, String> param) {
						// TODO Auto-generated method stub
						SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getStatus());
						SimpleStringProperty id1=null;
						
						if(id.isEqualTo(0).getValue()){
							 return id1=new SimpleStringProperty("尚未有工厂接单");
							 
						}else{
							if(id.isEqualTo(1) .getValue()){
								return  id1=new SimpleStringProperty("正在生产");
							}else{
								if(id.isEqualTo(2) .getValue()){
								return  id1=new SimpleStringProperty("交接完成");
								}else{
									return id1=new SimpleStringProperty("错误");
								}
							}
						}
						
					}
				});
			
			  TableColumn<POjO.order,Number > utc12=new TableColumn<POjO.order,Number>("设备id");
				
				utc12.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.order,Number>, ObservableValue<Number>>() {
					
					@Override
					public ObservableValue<Number> call(CellDataFeatures<POjO.order, Number> param) {
						// TODO Auto-generated method stub
						SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getEid());
						return id;
					}
				});
			//!!!!!!!!!!!!!
			TableView<POjO.order> ordertable=new TableView<POjO.order>(ulist);
			//
			ordertable.setEditable(true);
			//更改
			

		utc11.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,String>>() {
			
			@Override
			public void handle(CellEditEvent<POjO.order, String> event) {
				// TODO Auto-generated method stub
				
				order  temp=event.getRowValue();
				
				orderdate.delete(temp.getOid());
			if(event.getNewValue().equals("尚未有工厂接单")){
				temp.setStatus(0);
				temp.setfid(0);
			}
			if(event.getNewValue().equals("正在生产")){
				temp.setStatus(1);
				
			}
			if(event.getNewValue().equals("交接完成")){
				temp.setStatus(2);
				
			}
				
				orderdate.add(temp);
				ordertable.refresh();
				
			}
		});
	utc12.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.order,Number>>() {
			
			@Override
			public void handle(CellEditEvent<POjO.order, Number> event) {
				// TODO Auto-generated method stub
				equipment temp1=null;
				order  temp=event.getRowValue();
				factory temp2=null;
				for (equipment o : equipmentdate.equipments) {
					if(o.geteid()==temp.getEid()){
						o.setworkstatus(1);
						
						temp1=o;
						
					}
				}
				//这里尚未完成！
				
				equipmentdate.delete(temp1.geteid());
				equipmentdate.add(temp1);
				orderdate.delete(temp.getOid());
				temp.setEid(event.getNewValue().intValue());
				
				
				orderdate.add(temp);
				ordertable.refresh();
				
			}
		});


			//
			
			ObservableList<String> list4=FXCollections.observableArrayList();
			list4.add("尚未有工厂接单");
			list4.add("正在生产");
			list4.add("交接完成");
			utc11.setCellFactory(ChoiceBoxTableCell.forTableColumn(list4));
			
			ObservableList<Number> list5=FXCollections.observableArrayList();
			for (equipment n : equipmentdate.equipments) {
				if(n.getfid()==console.managering.getfid()||n.getrenterid()==console.managering.getid()){
					list5.add(n.geteid());
				}
			}
			utc12.setCellFactory(ChoiceBoxTableCell.forTableColumn(list5));
			ordertable.getColumns().addAll(utc1,utc2,utc3,utc4,utc5,utc6,utc7,utc8,utc9,utc10,utc11,utc12);
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
			
			
			Button addorder =new Button("刷新");
			addorder.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
			addorder.setLayoutX(20);
					addorder.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						ulist.clear();
						for (order order : orderdate.orders) {
							if(order.getfid()==console.managering.getfid()){
								ulist.add(order);
							}
						}
						ordertable.refresh();
						
					}});
			
			order.getChildren().addAll(addorder);
		
			return order;
		///////////////////////////////////////////////////////////////////////////////////////////
			//!!注意！！更改账户时要查重！
}
}
