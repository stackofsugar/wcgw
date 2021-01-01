import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Application {
    public static void main(String[] argv){

    }
}

class mainWindow extends Frame {
    private static final long serialVersionUID = 4268129811635321517L;
    private static final String WINDOW_LABEL = "Frame";

    mainWindow(){
        var mainWindow = new Frame(WINDOW_LABEL);
        mainWindow.setSize(400, 400);
    }
}

class componentPanel implements ItemListener {
    JPanel cardPanel;
    final static String BUTTON_PANEL = "CardPanel";
    final static String TEXT_PANEL = "JTextField";

    public void fillPaneComponent(Container pane_component){
        JPanel comboBoxPane = new JPanel();
        String[] comboBoxItems = {BUTTON_PANEL, TEXT_PANEL};
        var comboBoxObject = new JComboBox<String>(comboBoxItems);
        
        comboBoxObject.setEditable(false);
        comboBoxObject.addItemListener(this);

        comboBoxPane.add(comboBoxObject);
    }
    public void itemStateChanged(ItemEvent event){

    }
}