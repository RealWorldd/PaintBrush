package mylib;


import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class KAbstractButton extends KComponent{

    protected KActionListener kActionListener = null;
    protected String actionCommand = null;

    ArrayList<KActionListener> kActionListeners = new ArrayList<>();

    public KAbstractButton() {}

    public KAbstractButton(String text) {
        super(text);
    }

    public void addKActionListener(KActionListener l){
        kActionListener = l;
        kActionListeners.add(l);
    }

    public void setActionCommand(String actionCommand){
        this.actionCommand = actionCommand;
    }

    public String getActionCommand(){
        return actionCommand;
    }

    @Override
    public void processMouseEvent(MouseEvent e) {
        if (e.getID() == MouseEvent.MOUSE_RELEASED) {
            if (isContain(e.getX(), e.getY())) {
                kActionListener.actionPerformed(new ActionEvent(this, e.getID(), ""));
            }
        }
    }

    public void setSelected(boolean selected){}
    public boolean getSelected(){return false;}
}