package com.tarena.dang.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ImageUtil {
	private static final int LINES=7;
	private static final int WIDTH=160;
	private static final int HEIGHT=30;
	private static final int FONT_SIZE=30;
	
	public static Map<String,BufferedImage> getImage(){
		BufferedImage image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		Random r=new Random();
		int m=r.nextInt(20);
		int n=r.nextInt(20);
		int answer=m+n;
		String str=m+"+"+n+"=?";
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.setFont(new Font(null,Font.BOLD+Font.ITALIC,FONT_SIZE));
		g.drawString(str, WIDTH/10, HEIGHT);
		//ª≠∏…»≈œﬂ
		for(int i=0;i<LINES;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r.nextInt(HEIGHT));
		}
		Map<String,BufferedImage> map=new HashMap<String,BufferedImage>();
		map.put(answer+"", image);
		return map;
	}
}
