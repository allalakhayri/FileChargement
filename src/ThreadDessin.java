import java.awt.*;
import java.io.*;
public class ThreadDessin extends Thread {
	Canvas c;
	TextField tf;
	TextArea ta;
	public ThreadDessin(Canvas c,TextField tf,TextArea ta) {
		this.c=c; 
		this.tf=tf;
		this.ta=ta; 
	}
	public void run() {
		try { 
	BufferedReader fin = new BufferedReader(new FileReader(tf.getText()));		
		String ch;
		int i=0;
		Graphics g=c.getGraphics();
		while((ch=fin.readLine())!=null){
			ta.setText(ta.getText()+"\n"+ch);
			g.setColor(Color.GREEN); 
			g.fillRect(i*30,0,150,30);
			i=i+5;
			sleep(1000);
			}
		g.setColor(Color.BLACK);
		g.drawString("Chargement terminé", 50, 30);
		}
		catch(Exception e) { 
			ta.append("Error");
		}
	}
	

}
