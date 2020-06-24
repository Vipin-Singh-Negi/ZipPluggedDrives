
import java.io.File;
import java.util.Calendar;
import java.util.Date;


public class TemporalFileNaming {
        public  static String MakeFile()
	{
	Calendar c=Calendar.getInstance();
	String date=c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR);
	Date d=new Date();
	String time=" "+d.getHours()+"hr"+d.getMinutes()+"min";
	String path=date+time;
	String p=System.getProperty("user.home")+"/ZippedDrives"+"/";
	
	File f=new File(p);
	f.mkdirs();
	return (p+path+".zip");
	
	}
       
}
