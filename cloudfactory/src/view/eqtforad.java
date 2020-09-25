package view;
import DAO.etypedate;
import DAO.idproducer;
import DAO.producttypedate;
import DAO.userdate;
import POjO.etype;
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
public class eqtforad {
public static AnchorPane start(){
	//布局类(etype)//!!注意！！更改账户时要查重！
	ObservableList<POjO.etype> ulist=FXCollections.observableArrayList();
	//list.addAll(u1,u2,u3,u4);
	for (etype etype : etypedate.etypes) {
		ulist.add(etype);
	}
	TableColumn<POjO.etype,String > utc1=new TableColumn<POjO.etype,String>("类别名");
	
	utc1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.etype,String>, ObservableValue<String>>() {
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<POjO.etype, String> arg0) {
			// TODO Auto-generated method stub
			SimpleStringProperty name=new SimpleStringProperty(arg0.getValue().gettypename());
			return name;
		}
	});
	
	
	
    
	TableColumn<POjO.etype,Number > utc2=new TableColumn<POjO.etype,Number>("id");
	
	utc2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<POjO.etype,Number>, ObservableValue<Number>>() {
		
		@Override
		public ObservableValue<Number> call(CellDataFeatures<POjO.etype, Number> param) {
			// TODO Auto-generated method stub
			SimpleIntegerProperty id=new SimpleIntegerProperty(param.getValue().gettypeid());
			return id;
		}
	});
	//!!!!!!!!!!!!!
	TableView<POjO.etype> etypetable=new TableView<POjO.etype>(ulist);
	//
	etypetable.setEditable(true);
	//更改
	utc1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<POjO.etype,String>>() {
		
		@Override
		public void handle(CellEditEvent<POjO.etype, String> event) {
			// TODO Auto-generated method stub
			
			etype  temp=event.getRowValue();
			
			etypedate.delete(temp.gettypeid());
			temp.settypename(event.getNewValue());
			etypedate.add(temp);
			etypetable.refresh();
			
		}
	});


	//
	utc1.setCellFactory(TextFieldTableCell.forTableColumn());
	
	
	
	etypetable.getColumns().addAll(utc1,utc2);
	AnchorPane etype =new AnchorPane();
	etype.setRightAnchor(etypetable, 20.0);
	etype.setLeftAnchor(etypetable, 20.0);
	etype.setTopAnchor(etypetable, 50.0);
	etype.setBottomAnchor(etypetable, 20.0);
	etype.setStyle("-fx-background-color:#FFFFFF;");
	etype.getChildren().add(etypetable);
	BorderStroke bos=new BorderStroke(Paint.valueOf("#337AB7"),BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6) );
	Border bo=new Border(bos);
	
	etypetable.setBorder(bo);
	
	//按钮
	Button addetype =new Button("新增");
	addetype.setStyle("-fx-background-color:#5CB85C;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
	addetype.setLayoutX(20);
			addetype.setOnAction(new EventHandler<ActionEvent>(){

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
				textb2.setPromptText("请输入类别id");
				textb2.setLayoutX(230);
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
				b.setLayoutX(270);
				b.setLayoutY(250);
			    b.setOnAction(new EventHandler<ActionEvent>(){

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
						if(!etypedate.check(Integer.parseInt(textb2.getText()))){
							etype temp=new etype();
							temp.settypename(textb1.getText());
							temp.settypeid(Integer.parseInt(textb2.getText()));
							etypedate.add(temp);
							ulist.add(temp);
							etypetable.refresh();
							la.setText("成功添加");
						}else{
							la.setText("该用户已经存在！");
						}
						}});
			    group.getChildren().add(b);
			}});
	Button deleteetype =new Button("删除");
	deleteetype.setStyle("-fx-background-color:#D9534F;"+"-fx-font-weight:bold;"+"-fx-text-fill:#FFFFFF;");
	deleteetype.setOnAction(new EventHandler<ActionEvent>(){

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
						if(etypedate.check(Integer.parseInt(textb1.getText()))){
							etype temp=new etype();
							int i=0;
							for (etype s : etypedate.etypes) {
								if(s.gettypeid()==Integer.parseInt(textb1.getText()));{
									temp=s;
									i=1;
									
								}
							}
							if(i==1){
							etypedate.delete(temp.gettypeid());
						    ulist.remove(temp);
							etypetable.refresh();
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
	etype.getChildren().addAll(addetype,deleteetype);
	deleteetype.setLayoutX(80);
	return etype;
///////////////////////////////////////////////////////////////////////////////////////////
	//!!注意！！更改账户时要查重！
}
}
