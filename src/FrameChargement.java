import java.awt.*;
import java.awt.event.*;
public class FrameChargement  extends Frame implements ActionListener{
	TextField tf;
	TextArea ta;
	Canvas c;
	Button b;
	public FrameChargement() {
		tf = new TextField(10);
		ta = new TextArea(10, 40);
		b = new Button("Charger");
		c = new Canvas();
		c.setSize(450, 30);
		c.setBackground(new Color(255, 255, 255));
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1,2));
		p1.add(new Label("Nom du fichier: "));
		p1.add(tf);
		Panel p2 = new Panel();
		p2.add(b);
		Panel p3 = new Panel();
		p3.add(ta);
		Panel p4 = new Panel();
		p4.add(c);
		setLayout(new GridLayout(4, 1));
		setVisible(true);
		b.addActionListener(this);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		pack();
	
	
		addWindowListener(new WindowAdapter (){ 
		public void windowClosing(WindowEvent e ) {
			System.exit(0);
		}
		});
}

	public void actionPerformed(ActionEvent e) {
		c.repaint();
		ThreadDessin th1 = new ThreadDessin(c, tf, ta);
		th1.start();
	}
		

	public static void main(String[] args) {
		new FrameChargement();

	}

}
