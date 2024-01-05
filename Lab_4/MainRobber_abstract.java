import java.util.Scanner;
abstract class Robber{
    void RobbingClass(){
        System.out.println("MScAi&ML");
    }

    abstract int RoundHouse(int[] money);
    abstract int RowHouse(int[] money);
    abstract int SquareHouse(int[] money);
    abstract int MultiHouse(int[] money  );
}

class JAVAProfessionalRobber extends Robber{
    int max=0;
    int RowHouse(int[] arr){
        if(arr[0]+arr[2]>=arr[1]+arr[3]){
            if(arr[0]+arr[2]>=arr[0]+arr[3]){
                max=arr[0]+arr[2];
            }
            else{
                max=arr[0]+arr[3];
            }
        }
        else if(arr[1]+arr[3]>=arr[0]+arr[2]){
            if(arr[1]+arr[3]>=arr[0]+arr[3]){
                max=arr[1]+arr[3];
            }
            else{
                max=arr[0]+arr[3];
            }
        }
        return max;
    }
    int RoundHouse(int[] arr){
        if(arr[0]+arr[2]>=arr[1]+arr[3]){
            max=arr[0]+arr[2];
        }
        else{
            max=arr[1]+arr[3];
        }

        return max;
    }
    int SquareHouse(int[] arr){
        if(arr[0]+arr[2]>=arr[1]+arr[3]){
            max=arr[0]+arr[2];
        }
        else{
            max=arr[1]+arr[3];
        }
        return max;
    }
    int MultiHouse(int[] arr){
        if(arr[0]+arr[2]+arr[4]>=arr[1]+arr[3]+arr[5]){
            max=arr[0]+arr[2]+arr[4];
        }
        else{
            max=arr[1]+arr[3]+arr[5];
        }
        return max;
    }
}
public class MainRobber_abstract{
    public static void main(String args[]){
        int out=0;
        int[] arr= new int[6];
        JAVAProfessionalRobber javapro=new JAVAProfessionalRobber();
        System.out.println("Enter your choice :\n1-Row House\n2-Round House\n3-Square House\n4-Multi House");
        Scanner s = new Scanner(System.in);
        int choice=s.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter amount available in 4 houses :\n");
                for(int i=0;i<4;i++){
                    arr[i]=s.nextInt();
                }
                out=javapro.RowHouse(arr);
                break;
            case 2:
                System.out.println("Enter amount available in 4 houses :\n");
                for(int i=0;i<4;i++){
                    arr[i]=s.nextInt();
                }
                out=javapro.RoundHouse(arr);
                break;
            case 3:
                System.out.println("Enter amount available in 4 houses :\n");
                for(int i=0;i<4;i++){
                    arr[i]=s.nextInt();
                }
                out=javapro.SquareHouse(arr);
                break;
            case 4:
                System.out.println("Enter amount available in 6 houses :\n");
                for(int i=0;i<6;i++){
                    arr[i]=s.nextInt();
                }
                out=javapro.MultiHouse(arr);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        System.out.println(" Max amount you can steal is "+out);
    }
}