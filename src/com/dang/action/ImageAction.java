package com.dang.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import com.dang.util.ImageUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageAction extends BaseAction{
	private InputStream imageStream;
	public InputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
	public String execute(){
		Map<String,BufferedImage> map=ImageUtil.getImage();
		String answer=map.keySet().iterator().next();
		session.put("answer", answer);
		
		BufferedImage image=map.get(answer);
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(bos);
		try {
			encoder.encode(image);
			byte[] bytes=bos.toByteArray();
			imageStream=new ByteArrayInputStream(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
