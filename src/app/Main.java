package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

import mylib.*;

class PainterKFrame extends KFrame{

    KMenuBar kMenuBar;
    KToolBar kToolBar;
    DrawingPanel drawingPanel;

    public PainterKFrame() {

        kMenuBar = new KMenuBar();
        KMenu file = new KMenu("File");
        KMenuItem open = new KMenuItem("open");
        open.addKActionListener(new MenuActionListener());
        open.setActionCommand("select_Open");
        KMenuItem save = new KMenuItem("save");
        save.addKActionListener(new MenuActionListener());
        save.setActionCommand("select_Save");
        file.add(open);
        file.add(save);
        kMenuBar.add(file);
        add(kMenuBar); // 메뉴바 생성, 메뉴생성, 메뉴 아이템 추가

        kToolBar = new KToolBar();
        KButton btnRect = new KButton("Rect");
        btnRect.addKActionListener(new MyActionListener());
        btnRect.setActionCommand("select_Rect");//Rect 버튼 추가
        KButton btnOval = new KButton("Oval");
        btnOval.addKActionListener(new MyActionListener());
        btnOval.setActionCommand("select_Oval");//Oval 버튼 추가
        KButton btnLine = new KButton("Line");
        btnLine.addKActionListener(new MyActionListener());
        btnLine.setActionCommand("select_Line");//Line 버튼 추가
        KButton btnMerge = new KButton("복합");
        btnMerge.addKActionListener(new MyActionListener());
        btnMerge.setActionCommand("select_Merge");//복합 버튼 추가
        KButton btnRemove = new KButton("삭제");
        btnRemove.addKActionListener(new MyActionListener());
        btnRemove.setActionCommand("select_Remove");//삭제 버튼 추가
        KButton btnCopy = new KButton("복사");
        btnCopy.addKActionListener(new MyActionListener());
        btnCopy.setActionCommand("select_Copy");//복사 버튼 추가
        KButton btnWhite = new KButton("White");
        btnWhite.addKActionListener(new MyActionListener());
        btnWhite.setActionCommand("select_White");//흰색 버튼 추가
        KButton btnBlack = new KButton("Black");
        btnBlack.addKActionListener(new MyActionListener());
        btnBlack.setActionCommand("select_Black");//검은색 버튼 추가
        KButton btnRed = new KButton("Red");
        btnRed.addKActionListener(new MyActionListener());
        btnRed.setActionCommand("select_Red");//빨간색 버튼 추가
        KButton btnBlue = new KButton("Blue");
        btnBlue.addKActionListener(new MyActionListener());
        btnBlue.setActionCommand("select_Blue");//파란색 버튼 추가
        KCheckBox btnfill = new KCheckBox("Fill");
        btnfill.addKActionListener(new MyActionListener());
        btnfill.setActionCommand("select_Fill");
        kToolBar.add(btnRect);
        kToolBar.add(btnOval);
        kToolBar.add(btnLine);
        kToolBar.add(btnMerge);
        kToolBar.add(btnRemove);
        kToolBar.add(btnCopy);
        kToolBar.add(btnWhite);
        kToolBar.add(btnBlack);
        kToolBar.add(btnRed);
        kToolBar.add(btnBlue);
        kToolBar.add(btnfill);
        add(kToolBar);//툴바 생성, 버튼 추가

        drawingPanel = new DrawingPanel();
        drawingPanel.kCheckBox = btnfill;
        drawingPanel.setBounds(42, 61, 4096, 4096);
        add(drawingPanel);//그림판 패널 추가
    }

    class MyActionListener implements KActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            KAbstractButton kButton = (KAbstractButton) e.getSource();
            switch (kButton.getActionCommand()) {
                case "select_Rect":
                    drawingPanel.setFiguretype(0);
                    break;
                case "select_Oval":
                    drawingPanel.setFiguretype(1);
                    break;
                case "select_Line":
                    drawingPanel.setFiguretype(2);
                    break;
                case "select_Merge":
                    drawingPanel.setFiguretype(3);
                    break;
                case "select_Remove":
                    drawingPanel.setFiguretype(4);
                    break;
                case "select_Copy":
                    drawingPanel.setFiguretype(5);
                    break;
                case "select_White":
                    drawingPanel.setFigureColor(Color.WHITE);
                    break;
                case "select_Black":
                    drawingPanel.setFigureColor(Color.BLACK);
                    break;
                case "select_Red":
                    drawingPanel.setFigureColor(Color.RED);
                    break;
                case "select_Blue":
                    drawingPanel.setFigureColor(Color.BLUE);
                    break;
                case "select_Fill":
                    drawingPanel.setCheckBox(kButton);
                    break;
            }
        }
    }

    class MenuActionListener implements KActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            KMenuItem kMenuItem = (KMenuItem) e.getSource();
            switch (kMenuItem.getActionCommand()) {
                case "select_Save":
                    String outname = "mydraw.pd";
                    try {
                        FileOutputStream fos = new FileOutputStream(outname);
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
                        ObjectOutputStream out = new ObjectOutputStream(bos);
                        writeObject(out);
                        out.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    break;
                case "select_Open":
                    String inname = "mydraw.pd";
                    try {
                        FileInputStream fis = new FileInputStream(inname);
                        BufferedInputStream bis = new BufferedInputStream(fis);

                        ObjectInputStream in = new ObjectInputStream(bis);
                        readObject(in);
                        in.close();
                    }catch (IOException | ClassNotFoundException exception){
                        exception.printStackTrace();
                    }
                    break;
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        for (KComponent kComponent : compoList) {
            kComponent.paint(g);
        }
    }

    @Serial
    private void writeObject(ObjectOutputStream outputStream) throws IOException{
        outputStream.writeObject(drawingPanel.figurelist);
    }

    @Serial
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        ArrayList<FigureThing> arrayList = (ArrayList<FigureThing>) inputStream.readObject();
        drawingPanel.figurelist.clear();
        drawingPanel.figurelist = arrayList;
    }
}

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KAdapterFrame frame = new KAdapterFrame();
        frame.setSize(1440, 800);
        frame.setKFrame(new PainterKFrame());
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}