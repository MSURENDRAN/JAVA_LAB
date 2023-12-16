package Lab_4;

//created abstract class
abstract class Robber
{
    abstract int Rowhouses(int x[]);

    abstract int Roundhouses(int x[]);

    abstract int Squarehouse(int x[]);

    abstract int Multihouse(int x[]);

    void RobbingClass()
    {
        System.out.println("MScAIML");
    }

    void MachineLearning()
    {
        System.out.println("I love Machine Learning");
    }
}
//created child class
public class JavaProfessionalRobber extends Robber
{
    //due to the given logic of code, we can wrap all the maths up in a common function
    int common(int x[])
    {
        //initially only 4 houses accepted
        if(x.length!=4)
        {
            System.out.println("Only 4 houses accepted!");
            return -1;
        }
        int a = x[0]+x[2];
        int b = x[1]+x[3];
        return a>b?a:b;
    }

    int Squarehouse(int x[])
    {
        return common(x);
    }

    int Rowhouses(int x[])
    {
        //small tweak because first and last can be robbed
        return common(x)>x[0]+x[3]?common(x):x[0]+x[3];
    }

    int Roundhouses(int x[])
    {
        return common(x);
    }

    int Multihouse(int x[])
    {
        return common(x);
    }

    public static void main(String[] args)
    {
        JavaProfessionalRobber ob = new JavaProfessionalRobber();
        //special input so that row houses produce different result
        int a[] = {1,2,3,0};
        int b[] = {1,2,3,4};
        int c[] = {5,10,2,7};
        int d[] = {10,12,7,6};
        System.out.println("For square houses: "+ob.Squarehouse(a));
        System.out.println("For round houses: "+ob.Roundhouses(b));
        System.out.println("For row houses: "+ob.Rowhouses(c));
        System.out.println("For multi houses: "+ob.Multihouse(d));
    }
}
