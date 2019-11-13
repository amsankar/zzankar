package zzankar;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
 

public class TestThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		console("================                        SANKAR MURUGESAN DEBUG WINDOW        ==========================");

		// reportSystemPath();

		
		//log(systemProcessOut("mvn.cmd","install"));
		
		
		 
		findFileType("mp3",new File("C:\\data"));
	        
		
		console("=====================                         completed                          ======================");

	}


	private static void findFiles() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file to be searched.. " );
		String name = scan.next();
		System.out.println("Enter the directory where to search ");
		String directory = scan.next();
		findFileType(name,new File(directory));
	}

	
	   public static void findFile(String name,File file)
	    {
	        File[] list = file.listFiles();
	        if(list!=null)
	        for (File fil : list)
	        {
	            if (fil.isDirectory())
	            {
	                findFile(name,fil);
	            }
	            else if (name.equalsIgnoreCase(fil.getName()))
	            {
	                System.out.println(fil.getAbsolutePath());
	            }
	        }
	    }
	   
	   
	   public static void findFileType(String name,File file)
	    {
	        File[] list = file.listFiles();
	        if(list!=null)
	        for (File fil : list)
	        {
	        	String fileName=fil.getName();
	            if (fil.isDirectory())
	            {
	            	findFileType(name,fil);
	            }
	            else if (fileName.contains(name))
	            {
	                System.out.println(fil.getAbsolutePath());
	            }
	        }
	    }
 
	
	
	private static String systemProcessOut(String cmd,String arg) {
		
		String resp="";
		
		cmd=cmd!=null?cmd:"";
		arg=arg!=null?arg:"";
		
		log("cmd:"+cmd);
		log("arg:"+arg);
					
		Runtime rt = Runtime.getRuntime();
		String[] commands = {cmd, arg };
		Process proc;
		try {
			proc = rt.exec(commands);

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream())); 
			
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				log(s);
			}
 
			while ((s = stdError.readLine()) != null) {
				resp=resp+s;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resp;
	}

	private static void reportSystemPath() {
		String pathString = System.getenv("path");

		String[] paths = pathString.split(";");

		for (int i = 0; i < paths.length; i++) {
			log(paths[i]);
		}

		console(pathString);

		console(System.getenv());

		Map<String, String> systemEnv = System.getenv();
		for (Map.Entry<String, String> entry : systemEnv.entrySet()) {
			log(entry.getKey() + "= " + entry.getValue());
		}
	}

	private static void console(Object msg) {
		log("-------------------------------------------------------------------------------------------------------");
		log(msg);
		log("-------------------------------------------------------------------------------------------------------");
	}

	private static void log(Object msg) {
		System.out.println(msg);
	}

}
