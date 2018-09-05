package red.softgrip.com.red.Utils;

/**
 * Created by Qaiser Pasha on 8/31/2018.
 */

public class SpinnerItemsData
{
String text;
		Integer imageId;
public SpinnerItemsData(String text, Integer imageId){
        this.text=text;
        this.imageId=imageId;
        }

public String getText(){
        return text;
        }

public Integer getImageId(){
        return imageId;
        }
}