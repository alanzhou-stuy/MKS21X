public class Window2 extends JFrame  implements ActionListener {
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
 
private Container pane;
 private JButton b;
 private JLabel l;
 private JTextField t;
 private JCheckBox c;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window2() {
     this.setTitle("My first GUI");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
     b = new JButton("CtoF");
     b.addActionListener(this);
     b1 = new JButton("FtoC");
     b1.addActionListener(this);
     l = new JLabel("Input",null,JLabel.CENTER);
     l.addActionListener(this);
     l1 = new JLabel("Output",null,JLabel.CENTER);
     l1.addActionListener(this);
     t = new JTextField();
     t.addActionListener(this);
     t1 = new JTextField();
     t1.addActionListener(this);
     pane.add(l);
     pane.add(l1);
     pane.add(b);
     pane.add(b1);
     pane.add(t);
     pane.add(t1);
 }

    public void actionPerformed(ActionEvent e) {
	
    }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window2 g = new Window2();
     g.setVisible(true);
  }
}
    public static double CtoF (double temp){
	return temp * 1.8 + 32;
    }

    public static double FtoC (double temp) {
	return ((temp - 32) * (5 / 9));
    }

}
