
import java.io.File;

public class WindowsDriveDetection {

 String p="";
        File oldd[],newd[];
    WindowsDriveDetection()
	{
	oldd=File.listRoots();
	}
    
    
    String detectPath(File f1[],File f2[])
	{System.out.println("1.");
		
		for(int i=0;i<f2.length;i++)
			{
			boolean b=true;
			for(int j=0;j<f1.length;j++)
				{
			String p1=f2[j].getPath();
			String p2=f1[i].getPath();
			if(p1.equals(p2))
				{
				b=false;
				break;
				}
				}
		if(b)
		{	System.out.println("last if");
			p=f2[i].getPath();
			break;
		}
		}	
		return p;
			
	}
    public static void main(String[] args) {
        WindowsDriveDetection ww=new WindowsDriveDetection();
        ww.detect();
    }
    void detect()
        
   {
	while(true)
	{
	newd=File.listRoots();
	int l1=oldd.length;
	int l2=newd.length;
	if(l1<l2)
	{System.out.println("conm");
	   String path=detectPath(oldd,newd);
           
	   System.out.println(path+"  detected");
           Zipper.ZipUp(path);
	}
	else if(l1>l2)
	{System.out.println("ejjjjj");
	   String path=detectPath(newd,oldd);
	   System.out.println(path+"   ejected");
	}
	oldd=newd;
	}

    
}
}
