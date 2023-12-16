package Lab_2;
import java.util.Scanner;
public class MaxFreq
{
    public static int a[];
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the Array : ");
        int n = sc.nextInt();
        a = new int[n];
        System.out.println("Enter the input of the Array : ");
        for(int i=0; i<n; i++)
        {
            a[i] = sc.nextInt();
        }
   
        int freq[] = new int[n];
        for(int i=0; i<n; i++)
        {
            int count=0;
            for(int j=0; j<n; j++)
            {
                if(a[j]==a[i])
                    ++count;
            }
            freq[i]=count; 
        }
        
        System.out.print("Frequency of Array : ");
        for(int i=0; i<n; i++)
        {
            System.out.print(freq[i]+" ");
        }   
        System.out.println();
        
        /*for (int i=0; i<n; i++) 
        {
            for (int j=i+1; j<n; j++) 
            {
                int temp = 0;
                int t=0;
                if (a[i] < a[j]) 
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        
        System.out.print("Sorted Array : ");
        for(int i=0; i<n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();*/
        
        
        for (int i=0; i<n; i++) 
        {
            for (int j=i+1; j<n; j++) 
            {
                int temp = 0;
                int t=0;
                if (freq[j] > freq[i]) 
                {
                    t = freq[i];
                    freq[i] = freq[j];
                    freq[j] = t;
                    
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        
        System.out.print("Sorted Array : ");
        for(int i=0; i<n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        
        System.out.print("Sorted Frequency of Array : ");
        for(int i=0; i<n; i++)
        {
            System.out.print(freq[i]+" ");
        }   
        System.out.println();
               
        int temp[]=new int[n];
        int p=0;
        
                for (int i=0; i<n; i++) 
        {
            for (int j=i+1; j<n; j++) 
            {
                if (a[i] != a[j]) 
                {
                    temp[i] = a[i];
                    p++;
                }
            }
        }
        
                System.out.print("Temp Array : ");
        for(int i=0; i<n; i++)
        {
            System.out.print(temp[i]+" ");
        } 
        /*
        for (int i = 0; i < n - 1; i++) 
        {
            if (a[i] != a[i + 1]) 
            {
                temp[p++] = a[i];
            }
        }
         */
        //temp[p++] = a[n - 1];

        System.out.print("Enter the highest number of occurences to display the number : ");
        int k = sc.nextInt();
        
        for(int i=0; i<k; i++)
        {
            System.out.print(temp[i]+" ");
        }   
        System.out.println();
        /*
        int occ[]=new int[n];
        int p=0;
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                if(freq[i]>freq[j])
                {
                    //if(a[i] == a[j])
                        occ[i] = a[i];
            
                
                    //else
                }     //System.out.println("No input has "+k+" occurences");
            }
                                System.out.print(occ[i]+" ");

        }
        
        for(int i=0; i<k; i++)
        {
            for(int j=i+1; j<k; j++)
            {
                if(a[i]==a[j])
                    System.out.print(a[i]+" ");
            }
        } */
    }
}
