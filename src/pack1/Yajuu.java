package pack1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Yajuu{
	public static void main(String[] args){
		FileSystem fs = FileSystems.getDefault();
		Path p1 = Paths.get("");
		Path p2 = p1.toAbsolutePath();
		//System.out.println(p2.toString());
            	//Fileオブジェクトを生成する
		Yajuu yajuu = new Yajuu();
		try {
			for(int i=1; i <= 810; i++) {
				Yajuu xyz = new Yajuu();
				InputStream fis = xyz.getJarReader("senpai.png");
				//BufferedReader fis = xyz.getJarReader("senpai.png");

  				//FileInputStream fis = new FileInputStream("../senpai.png");
            			FileOutputStream fos = new FileOutputStream("野獣先輩"+Integer.toString(i)+".png");
				yajuu.copier(fis, fos);
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public void copier(InputStream fis, FileOutputStream fos) {
 	       try {
			//入力ファイルをそのまま出力ファイルに書き出す
            		byte buf[] = new byte[256];
            		int len;
            		while ((len = fis.read(buf)) != -1) {
            		//while ((len = fis.read(buf)) != -1) {
                		fos.write(buf, 0, len);
			}	
			//終了処理
            		fos.flush();
           	 	fos.close();
            		fis.close();
            		//System.out.println("コピーが完了しました。");
        	} catch (IOException ex) {
            		//例外時処理
            		//System.out.println("コピーに失敗しました。");
            		ex.printStackTrace();
       		 }
	}

	public InputStream getJarReader(String path){
    		InputStream stream = this.getClass().getClassLoader().getResourceAsStream(path);
		if(stream!=null){
	    		return stream;
		}
		System.out.println("nnn");
		return stream;	
	} 
/*
	public BufferedReader getJarReader(String path){
    		BufferedReader reader = null;
    		InputStream stream = this.getClass().getClassLoader().getResourceAsStream(path);
    		if(stream!=null){
        		reader = new BufferedReader(new InputStreamReader(stream));
    		}
	    	return reader;
	}
*/
}	
