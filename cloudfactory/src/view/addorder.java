package view;

import DAO.equipmentdate;
import DAO.factorydates;
import DAO.idproducer;
import DAO.orderdate;
import DAO.pickorderdate;
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

public class addorder {
public static AnchorPane start(){
	//布局类(order)//!!注意！！更改账户时要查重！
	ObservableList<POjO.order> ulist=FXCollections.observableArrayList();
	//list.addAll(u1,u2,u3,u4);
	for (order order : orderdate.orders) {
		if(order.getStatus()==0&&pickorderdate.check(order.getOid())){
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
	

	//!!!!!!!!!!!!!
	TableView<POjO.order> ordertable=new TableView<POjO.order>(ulist);
	//
	ordertable.setEditable(false);
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
			list2.add(a.getid());
		}
		
	}
	utc10.setCellFactory(ChoiceBoxTableCell.forTableColumn(list3));


	ordertable.getColumns().addAll(utc1,utc2,utc3,utc4,utc5,utc6,utc7,utc8,utc9,utc10,utc11);
	AnchorPane order =new AnchorPane();
	//lable
	Label la=new Label("");
	order.getChildren().add(la);
	order.setLeftAnchor(la, (double) 330);
	order.setTopAnchor(la, (double) 5);
	order.setRightAnchor(ordertable, 20.0);
	order.setLeftAnchor(ordertable, 20.0);
	order.setTopAnchor(ordertable, 50.0);
	order.setBottomAnchor(ordertable, 20.0);
	order.setStyle("-fx-background-color:#FFFFFF;");
	order.getChildren().add(ordertable);
	BorderStroke bos=new BorderStroke(Paint.valueOf("#337AB7"),BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6) );
	Border bo=new Border(bos);
	
	ordertable.setBorder(bo);
	//检索
	Tooltip tip=new Tooltip("请不要超过10个字符");
	TextField text=new TextField();
	text.setTooltip(tip);
	text.setText("");
	text.setPromptText("请输入需要检索的id");
	order.setRightAnchor(text, 20.0);
	
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
	order.getChildren().add(text);
	//按钮
	Button addorder =new Button("竞标");
	addorder.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
	addorder.setLayoutX(20);
			addorder.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				if(text.getText().isEmpty()){
					la.setText("请正确输入！");
				}else{
					int i=0;
					order temp=null;
					if(!pickorderdate.check(Integer.parseInt(text.getText()),console.managering.getfid())&&pickorderdate.check(Integer.parseInt(text.getText()))){
						pickorderdate.add(Integer.parseInt(text.getText()), console.managering.getfid());
						
						for (POjO.order n : orderdate.orders) {
							if(n.getOid()==Integer.parseInt(text.getText())){
								temp=n;
							}
						}
						i=1;
					}
					
					
					if(i==1){
						
						orderdate.delete(temp.getOid());
					   
					   orderdate.add(temp);
						la.setText("成功接单，等待中标");
						ordertable.refresh();
					}else{
						la.setText("没有此订单，或者你已经投标");
					}
				}
			}});
	
	order.getChildren().addAll(addorder);

	Button addorder1 =new Button("刷新");
	addorder1.setStyle("-fx-background-color:#99CCFF;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
	addorder1.setLayoutX(80);
			addorder1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				ulist.clear();
				for (order order : orderdate.orders) {
					if(order.getStatus()==0&&pickorderdate.check(order.getOid())){
					ulist.add(order);
					}
				}
				ordertable.refresh();
				
			}});
	
	order.getChildren().addAll(addorder1);
	return order;
///////////////////////////////////////////////////////////////////////////////////////////
	//!!注意！！更改账户时要查重！
}
}
