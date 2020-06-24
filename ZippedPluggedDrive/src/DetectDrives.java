import java.io.*;
public class DetectDrives 
{
       
 	
    public static void main(String a[])throws Exception
	{
            try{
	String OS=System.getProperty("os.name");
	
	if(OS.contains("Windows"))
	{
	WindowsDriveDetection winD=new WindowsDriveDetection();
	System.out.println("OS detected : "+OS);
        System.out.println("Detecting any drive being plugged in");
	winD.detect();
	
        
	}
	else if(OS.contains("Linux"))
	{
	LinuxDriveDetection linxD=new LinuxDriveDetection();
	System.out.println("OS detected : "+OS);
	System.out.println("Detecting any drive being plugged in");
        linxD.detect();
	
	}
	else
 	System.out.println("Unsupported OS");
            }
            catch(Exception e)
            {
                System.err.println("Error");
               
            }
	
	}
}

    
