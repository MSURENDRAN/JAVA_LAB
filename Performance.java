package Lab_1;

import java.util.Scanner;
public class Performance
{
    public int n;
    public int mark[];
    public int hmark;
    public int lmark;
    public int mode[];
    public int freq[];
    public int p;
    public Performance()
    {
        n = 0;
        mark=new int[60];
    }

    public void readMarks()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the count of marks to be calculated : ");
        n=sc.nextInt();
        for(int i=0; i<n; i++)
        {
             System.out.print("Enter the marks : ");
             mark[i]=sc.nextInt();
             if(mark[i]<0 || mark[i]>100)
             {
                 System.out.println("Marks is beyond the range between 0 to 100");
                 break;
             }
        }
    }
    
    public int highestMarks()
    {
        hmark=mark[0];
        for(int i=1; i<n; i++)
        {
            if (hmark<mark[i])
                hmark=mark[i];

        }
        return hmark;
    }
    
        public int leastMarks()
    {
        lmark=mark[0];
        for(int i=1; i<n; i++)
        {
            if (lmark>mark[i])
                lmark=mark[i];

        }
        return lmark;
    }
    
    public int[] getMode()
    {
        mode = new int[n];
        freq = new int[n];
        int m;
        int f;
        p=0;
        for(int i=1; i<n; i++)
        {
            int count=-1;
            for(int j=0; j<n; j++)
            {
                if(mark[j]==mark[i])
                    ++count;
            }
            if(count>freq[i])
            {
                mode[p] = mark[i];
                freq[p]=++count; 
                p++;
            }
            /*
            else if(count == freq[i])
            {
                mode[p] = mark[i];
                freq[p] = ++count;
                p++;
            }
            */
        }
        if(freq[0]>0)
            return mode;
        else
        {
            freq[0]=1;
            p=n;
            return mark;
        }
    }
    
    public int[] getFreqAtMode()
    {
        return freq;
    }
    
    public void display()
    {
        int arr[]=getMode();
        int f[]= getFreqAtMode();
        System.out.println("Highest Mark: "+highestMarks());
        System.out.println("Least Mark: "+leastMarks());
        System.out.print("Mode: ");
        for(int i=0;i<p; i++)
        {
                if(arr[i]!=arr[i+1])
                    System.out.print(arr[i]+" ");
            
        }
        System.out.println();
        System.out.println("Frequency At Mode: "+f[0]);
    }
    
    public static void main()
    {
        Performance p = new Performance();
        p.readMarks();
        p.display();
    }
}
