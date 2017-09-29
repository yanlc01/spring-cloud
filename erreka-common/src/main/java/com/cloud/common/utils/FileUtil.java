package com.cloud.common.utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	/**允许上传的文件类型*/
	public static final List<String> fileTypes = 
			Arrays.asList("jpg","jpeg","bmp","png","gif","csv","bin","apk","svg","svgz","xls","xlsx","cfg");
	
	public static InputStream resizeImage(InputStream inputStream, int targetW,int targetH) throws IOException {
		try{
			BufferedImage  source = ImageIO.read(inputStream);
			int type = source.getType();
		
			BufferedImage target = null;
		
			double sx = (double) targetW / source.getWidth();
		
			double sy = (double) targetH / source.getHeight();
		
			if (sx < sy) {
				sx = sy;
				targetW = (int) (sx * source.getWidth());
			} else {
				sy = sx;
				targetH = (int) (sy * source.getHeight());
			}
			if (type == BufferedImage.TYPE_CUSTOM) {
				ColorModel cm = source.getColorModel();
				WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
						targetH);
				boolean alphaPremultiplied = cm.isAlphaPremultiplied();
				target = new BufferedImage(cm, raster, alphaPremultiplied, null);
			} else
				target = new BufferedImage(targetW, targetH, type);
			Graphics2D g = target.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
			g.dispose();
					
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
		
			ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
		
			ImageIO.write(target, "jpg", imOut); 
		
			InputStream is = new ByteArrayInputStream(bs.toByteArray());
		
			return is;
		}finally{
			IOUtils.closeQuietly(inputStream);
		}
		
	}
	
	public static void save2FileSystem(MultipartFile multipartFile, String file) throws Exception{
		if(multipartFile.isEmpty()){
			throw new Exception("文件为空");
		}
		
		String fileType = FilenameUtils.getExtension(multipartFile.getOriginalFilename().trim());
		if(!StringUtil.isEmpty(fileType) && !fileTypes.contains(fileType.toLowerCase())){//软件可能没有后缀
			throw new Exception("不允许上传此文件类型" + fileType);
		}
		
		String path = FilenameUtils.getFullPath(file);
		File f = new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file));
		InputStream inputStream = multipartFile.getInputStream();
		try {
			IOUtils.copy(inputStream, os);
		}finally{
			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(os);
		}
	}
	
	public static void createFile(String fullFilepath, List<String> contents) {
    	if (contents != null && !contents.isEmpty()) {
    		try {
    			File f = new File(FilenameUtils.getFullPath(fullFilepath));
    			if (!f.exists()) {
    	    		f.mkdirs();
    	    	}
    			File file = new File(fullFilepath);
    			if (!file.exists()) {
    				file.createNewFile();
    			}
    			writeContent(fullFilepath, contents);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public static void writeContent(String fullFilepath, List<String> contents) {
    	File file = new File(fullFilepath);
    	FileInputStream fis = null;
    	InputStreamReader isr = null;
    	BufferedReader br = null;
    	
    	FileOutputStream fos = null;
    	PrintWriter pw = null;
    	
    	try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				buffer.append(line + "\r\n");
			}
			if (contents != null && !contents.isEmpty()) {
				for (String content : contents) {
					buffer.append(content + "\r\n");
				}
			}
			
			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buffer.toString().toCharArray());
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				IOUtils.closeQuietly(pw);
			}
			if (fos != null) {
				IOUtils.closeQuietly(fos);
			}
			if (br != null) {
				IOUtils.closeQuietly(br);
			}
			if (isr != null) {
				IOUtils.closeQuietly(isr);
			}
			if (fis != null) {
				IOUtils.closeQuietly(fis);
			}
		}
    }

}
