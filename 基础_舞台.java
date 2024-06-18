package com.lab;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
// VBox：垂直布局，子节点按垂直顺序排列。
// HBox：水平布局，子节点按水平顺序排列。
// BorderPane：边界布局，将子节点放在顶部、底部、左侧、右侧和中间的不同区域。
// StackPane：层叠布局，将所有子节点叠加在一起，通常用于创建重叠的视觉效果。
// GridPane：网格布局，子节点按行和列组织在一个网格中，通常用于创建复杂的表格布局。
// FlowPane：流式布局，子节点按水平或垂直顺序排列，当空间不足时会自动换行。
// TilePane：平铺布局，子节点以平铺方式排列，类似于 FlowPane，但所有的单元格尺寸相同。
// AnchorPane：锚点布局，子节点可以通过锚点位置相对于容器的边缘进行定位。
// ScrollPane：滚动布局，用于在需要时提供滚动功能的容器，以容纳较大的内容。
// TabPane：选项卡布局，用于创建带有选项卡的界面，每个选项卡包含不同的内容。
// Accordion：手风琴布局，通常用于创建可折叠的面板，一次只能展开一个面板。
// SplitPane：分割布局，用于将界面分割成两个可拖动的区域，用户可以调整两个区域的大小。
public class 基础_舞台 extends Application 
{
    
    public void start(Stage wutai)throws Exception
    {
        wutai.setTitle("标题");
        VBox shuzhibox = new VBox(100);//控件之间的距离
        
        Scene changjing = new Scene(shuzhibox,400,200);//元素;宽;长
        Button anniu1 = new Button("OK");
        Button anniu2 = new Button("按钮2");

        shuzhibox.getChildren().add(anniu1);//第一种添加控件
        
        ObservableList addlist = shuzhibox.getChildren();
        addlist.add(anniu2);//第二种加控件

        wutai.setScene(changjing);
        wutai.show();
    }
    
    public static void main(String[]args){launch();}
}