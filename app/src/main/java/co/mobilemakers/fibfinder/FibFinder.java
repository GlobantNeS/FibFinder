package co.mobilemakers.fibfinder;

import android.util.Log;

/**
 * Created by wmbest2 on 11/7/14.
 */
public class FibFinder {

    public int[] mFib = new int[20];

    public void initialize() {
        for(int a=0;a<20;a++)
            if(a>=2)
                mFib[a]=mFib[a-1]+mFib[a-2];
            else
                mFib[a]=1;
    }

    public String checkValue(int value) {
        String output = "This number wasn't found";
        int[] tFib = new int[3];
        int index=1;
        tFib[0]=1;
        tFib[1]=1;
        tFib[2]=2;
        if(value==1)
            output=value+" is the index "+index;
        else {
            index=3;
            do {
                if (tFib[2] == value)
                    output = value + " is the index " + index;
                tFib[0]=tFib[1];
                tFib[1]=tFib[2];
                tFib[2] = tFib[1] + tFib[0];
                index++;
            } while (value >= tFib[2]);
        }
        return output;
    }
}

