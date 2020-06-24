import java.io.*;
public class LinuxDriveDetection
{
String olds[],news[];

	LinuxDriveDetection()throws Exception
	{
	
	olds=LinuxMedias();
	}
 	void LinuxDetect()throws Exception
	{
	while(true)
	{
	
	news=LinuxMedias();
	int o=olds.length;
	int n=news.length;
	if(o>n)
	{
		String Drpath=linuxLive(news,olds);
		System.out.println(Drpath+"  ejected");
	}
	else if(o<n)
	{
		String Drpath=linuxLive(olds,news);
		System.out.println(Drpath+"  detected");
		Zipper.ZipUp("/run/media/Rancho/"+Drpath);
	}
olds=news;
	
		}
	
		}
	public static void detect()throws Exception
	{
	LinuxDriveDetection ldd=new LinuxDriveDetection();
	ldd.LinuxDetect();	
	
	}

String linuxLive(String f1[],String f2[])
	{
	String p="";
		for(int i=0;i<f2.length;i++)
			{
			boolean b=true;
			for(int j=0;j<f1.length;j++)
				{
			String p1=f2[j];
			String p2=f1[i];
			if(p1.equals(p2))
				{
				b=false;
				break;
				}
				}
		if(b)
		{	
			p=f2[i];
			break;
		}
		}	
		return p;
	}
static String[] LinuxMedias()throws Exception
	{
		String s[]=new String[4];
		Runtime rt = Runtime.getRuntime();int n=0;
		Process ps = rt.exec("ls /run/media/Rancho");
		int k=0;
		InputStream in = ps.getInputStream();
		while((n=in.read())!=-1)
		{
		char ch=(char) n;
		s[k]+=ch;
		if(ch==('\n'))
		++k;
		}
	int p=0;
	String[] drive=new String [k];
	
	for(int i=0;i<k;i++)
	{
	p=s[i].length();
	char ch[]=new char[(s[i].length()-1)-4];
	s[i].getChars(4,(s[i].length()-1),ch,0);
		drive[i]=new String(ch);
//System.out.print(drive[i]);
	
	}
		Thread.sleep(100);
		
		return drive;
	}
}
