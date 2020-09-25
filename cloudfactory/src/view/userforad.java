package view;

import DAO.idproducer;
import DAO.userdate;
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

public class userforad {
public static AnchorPane start(){
	//布局类(user)//!!注意！！更改账户时要查重！
	ObservableList<POjO.user> ulist=FXCollections.observableArrayList();
	//list.addAll(u1,u2,u3,u4);
	for (user user : userdate.users) {
		ulist.add(user);
	}
	TableColumn<POjO.user,String > utc1=new TableColumn<POjO.user,String>("姓名");
	
	utc1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.user,String>, ObservableValue<String>>() {
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<POjO.user, String> arg0) {
			// TODO Auto-generated method stub
			SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getName());
			return name;
		}
	});
	
	
	TableColumn<POjO.user,String > utc2=new TableColumn<POjO.user,String>("密码");
	
  utc2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.user,String>, ObservableValue<String>>() {
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<POjO.user, String> arg0) {
			// TODO Auto-generated method stub
			SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getpassword());
			return name;
		}
	});


	TableColumn<POjO.user,String > utc3=new TableColumn<POjO.user,String>("联系方式");
	
    utc3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.user,String>, ObservableValue<String>>() {
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<POjO.user, String> arg0) {
			// TODO Auto-generated method stub
			SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getemail());
			return name;
		}
	});
    
    
	TableColumn<POjO.user,String > utc4=new TableColumn<POjO.user,String>("类型");
	
    utc4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.user,String>, ObservableValue<String>>() {
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<POjO.user, String> arg0) {
			// TODO Auto-generated method stub
			SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().gettype());
			return name;
		}
	});
    
    
	TableColumn<POjO.user,String > utc5=new TableColumn<POjO.user,String>("账号");
	
    utc5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.user,String>, ObservableValue<String>>() {
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<POjO.user, String> arg0) {
			// TODO Auto-generated method stub
			SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().getaccount());
			return name;
		}
	});
    
    
	TableColumn<POjO.user,Number > utc6=new TableColumn<POjO.user,Number>("id");
	
	utc6.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.user,Number>, ObservableValue<Number>>() {
		
		@Override
		public ObservableValue<Number> call(CellDataFeatures<POjO.user, Number> param) {
			// TODO Auto-generated method stub
			SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().getid());
			return id;
		}
	});
	//!!!!!!!!!!!!!
	TableView<POjO.user> usertable=new TableView<POjO.user>(ulist);
	//
	usertable.setEditable(true);
	//更改
	utc1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.user,String>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.user, String> event) {
			// TODO Auto-generated method stub
			
			user  temp=event.getRowValue();
			
			userdate.delete(temp.getid());
			temp.setName(event.getNewValue());
			userdate.add(temp);
			usertable.refresh();
			
		}
	});
utc2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.user,String>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.user, String> event) {
			// TODO Auto-generated method stub
			
			user  temp=event.getRowValue();
			
			userdate.delete(temp.getid());
			temp.setpassword(event.getNewValue());
			userdate.add(temp);
			usertable.refresh();
			
		}
	});
utc3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.user,String>>() {
	
	@Override
	public void handle(CellEditEvent<POjO.user, String> event) {
		// TODO Auto-generated method stub
		
		user  temp=event.getRowValue();
		
		userdate.delete(temp.getid());
		temp.setemail(event.getNewValue());
		userdate.add(temp);
		usertable.refresh();
		
	}
});
utc4.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.user,String>>() {
	
	@Override
	public void handle(CellEditEvent<POjO.user, String> event) {
		// TODO Auto-generated method stub
		
		user  temp=event.getRowValue();
		
		userdate.delete(temp.getid());
		temp.settype(event.getNewValue());
		if(event.getNewValue().equals("经销商")){
			temp.setid(administrator.change(temp.getid(), 1));
		}else{
			if(event.getNewValue().equals("云工厂管理员")){
			temp.setid(administrator.change(temp.getid(), 2));
			}
		}
		
		userdate.add(temp);
		usertable.refresh();
		
	}
});

	//
	utc1.setCellFactory(TextFieldTableCell.forTableColumn());
	utc2.setCellFactory(TextFieldTableCell.forTableColumn());
	utc3.setCellFactory(TextFieldTableCell.forTableColumn());
	
	ObservableList<String> list2=FXCollections.observableArrayList();
	list2.add("云工厂管理员");
	list2.add("经销商");
	utc4.setCellFactory(ChoiceBoxTableCell.forTableColumn(list2));
	usertable.getColumns().addAll(utc1,utc2,utc3,utc4,utc5,utc6);
	AnchorPane user =new AnchorPane();
	user.setRightAnchor(usertable, 20.0);
	user.setLeftAnchor(usertable, 20.0);
	user.setTopAnchor(usertable, 50.0);
	user.setBottomAnchor(usertable, 20.0);
	user.setStyle("-fx-background-color:#FFFFFF;");
	user.getChildren().add(usertable);
	BorderStroke bos=new BorderStroke(Paint.valueOf("#337AB7"),BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6) );
	Border bo=new Border(bos);
	
	usertable.setBorder(bo);
	
	//按钮
	Button adduser =new Button("新增");
	adduser.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
	adduser.setLayoutX(20);
			adduser.setOnAction(new EventHandler<ActionEvent>(){

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
				textb1.setPromptText("请输入姓名");
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
				textb2.setPromptText("请输入密码");
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
				textb4.setPromptText("请输入类别");
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
				textb5.setPromptText("请输入账号");
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
				//lable
				Label la=new Label();
				la.setText("请您输入姓名,密码,联系方式,类别,账号，分别在下面的五个空格里输入");
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
						if(!userdate.check(textb5.getText())){
							user temp=new user();
							temp.setaccount(textb5.getText());
							temp.setid(idproducer.getid());
							temp.settype(textb4.getText());
							temp.setemail(textb3.getText());
							temp.setpassword(textb2.getText());
							temp.setName(textb5.getText());
							userdate.add(temp);
							ulist.add(temp);
							usertable.refresh();
							la.setText("成功添加");
						}else{
							la.setText("该用户已经存在！");
						}
						}});
			    group.getChildren().add(b);
			}});
	Button deleteuser =new Button("删除");
	deleteuser.setStyle("-fx-background-color:#D9534F;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
	deleteuser.setOnAction(new EventHandler<ActionEvent>(){

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
						if(userdate.check(textb1.getText())){
							user temp=new user();
							int i=0;
							for (user s : userdate.users) {
								if(s.getaccount().equals(textb1.getText()));{
									temp=s;
									i=1;
									
								}
							}
							if(i==1){
							userdate.delete(temp.getid());
						    ulist.remove(temp);
							usertable.refresh();
							la.setText("成功删除");
							}else{
								i=0;
								la.setText("用户不存在 ");
							}
						}else{
							la.setText("该用户不存在！");
						}
						}});
			    group.getChildren().add(b);
			}});
	user.getChildren().addAll(adduser,deleteuser);
	deleteuser.setLayoutX(80);
	return user;
///////////////////////////////////////////////////////////////////////////////////////////
	//!!注意！！更改账户时要查重！
}
}
