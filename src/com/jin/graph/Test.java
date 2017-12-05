package com.jin.graph;

import java.awt.*;  
import java.awt.event.*;  
import java.awt.image.*;  
import java.math.BigDecimal;  
import static java.lang.Math.*;  
  
public class Test{  
    long start = System.currentTimeMillis();  
    private Frame f = new Frame("心形线");  
    //画布大小  
    private final int SIZE=200;  
    //重写paint()  
    private MyCanvas area = new MyCanvas();  
      
    private BufferedImage image = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);  
    private Graphics2D g = (Graphics2D) image.getGraphics();  
      
    //循环步长  
    private final double STEP = 0.00001;  
      
    private void init(){  
        area.setPreferredSize(new Dimension(SIZE,SIZE));  
        // 画白色背景  
        g.setColor(Color.white);  
        g.fill3DRect(0, 0, SIZE, SIZE,true);  
        // 画两条坐标轴  
        g.setColor(Color.black);  
        g.drawLine(0,SIZE/2,SIZE,SIZE/2);  
        g.drawLine(SIZE/2,0,SIZE/2,SIZE);  
          
        //计算坐标  
        //新坐标  
        int x1, y1,x2, y2;  
        for (double t = -Math.PI; t < Math.PI; t = t + STEP){  
            g.setColor(Color.black);  
            x1 =  (int) ((0.5+(2*cos(t) - cos(2*t))/8)*SIZE);  
            y1 = (int) ((0.5+(2*sin(t) - sin(2*t))/8)*SIZE); 
            x2 = (int) ((0.5+(2*cos(t+STEP) - cos(2*(t+STEP)))/8)*SIZE);  
            y2 = (int) ((0.5+(2*sin(t+STEP) - sin(2*(t+STEP)))/8)*SIZE); 
            //原曲线是横向的，为求美观调整了输出把它画成纵向，若画其他 函数须修改  
            g.drawLine(y1, SIZE-x1, y2, SIZE-x2);  
                  
        }  
          
          
        //关闭窗口  
        f.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e){  
                System.exit(0);  
            }  
        });   
          
        long end = System.currentTimeMillis();  
        g.setColor(Color.red);   
        g.setFont(new Font("Times", Font.BOLD,15));  
          
        g.drawString("步长值：" + BigDecimal.valueOf(STEP) , 20, 30);  
        g.drawString("画图所用时间：" + (end - start) + "毫秒", 20, 50);  
          
        area.repaint();   
        f.add(area);  
        f.pack();  
        f.setVisible(true);  
    }  
      
    private class MyCanvas extends Canvas{  
        public void paint(Graphics g){  
            g.drawImage(image, 0, 0, null);  
        }  
    }  
  
    public static void main(String[] args){  
        new Test().init();  
    }  
    
    public void drawStep(int centerX, int topY,int space, int width, int scale, Graphics g) {
    	g = (Graphics2D) g;
    	g.setColor(Color.RED);
    	g.fillArc(centerX - space - width, topY + scale, width + 10 * scale, scale, 0, 0);
    	g.fillArc(centerX + space, topY + scale, width + 10 * scale, scale, 0, 0);
    }
    
    public void drawHeart() {
    	for (int i = 0; ; ) {
			
		}
    }
}  


