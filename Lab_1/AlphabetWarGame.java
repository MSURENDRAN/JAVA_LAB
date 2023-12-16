package Lab_1;

import java.util.Scanner;
public class AlphabetWarGame 
{

    String word;;
    int[] S = new int[4];
    AlphabetWarGame() 
    {
        int m=4;
        for(int i=0;i<3;i++)
        {
            this.S[i] =m;
            m--;
        }

    }
    AlphabetWarGame(int[] A) 
    {
        for(int i=0;i<3;i++)
        {
            this.S[i] =A[i];
        }
        System.out.println("The values are updated!!");
        
    }
    void game() 
    {
        String left= " ";
        String right =" ";
        int i = 0;
        while (i < word.length()) {
            if (word.charAt(i)== 'w' || word.charAt(i)== 'W' || word.charAt(i) == 'p' || word.charAt(i) == 'P' || word.charAt(i) == 'b' || word.charAt(i) == 'B' || word.charAt(i) == 's' || word.charAt(i) == 's') {
                left += word.charAt(i);
            } else if (word.charAt(i) == 'm' || word.charAt(i)== 'M' || word.charAt(i)== 'Q' || word.charAt(i) == 'q' || word.charAt(i) == 'd' || word.charAt(i)== 'D' || word.charAt(i) == 'z' || word.charAt(i)== 'Z') {
                right += word.charAt(i);
            } else {
                System.out.println("Invalid characters found");
                break;
            }
            i++;
        }
        game(left,right);
    }

    void game(String left,String right)
    {
        System.out.println(left);
        int lcount=0;
        int rcount=0;
        int i = 0;
        while (i < left.length()) {
            if (left.charAt(i) == 'w' || left.charAt(i) == 'w') 
                lcount += S[0];
            else if (left.charAt(i) == 'p' || left.charAt(i) == 'P') 
                lcount += S[1];
            else if (left.charAt(i) == 'b' || left.charAt(i) == 'B') 
                lcount += S[2];
            else if( left.charAt(i) == 's'|| left.charAt(i) == 'S') 
                lcount += S[3];
            i++;
        }
        i = 0;
        while (i < right.length()) {
            if (right.charAt(i) == 'm' || right.charAt(i) == 'M') 
                rcount += S[0];
            else if (right.charAt(i) == 'q' || right.charAt(i) == 'Q') 
                rcount += S[1];
            else if (right.charAt(i) == 'd' || right.charAt(i) == 'D') 
                rcount += S[2];
            else if (right.charAt(i) == 'Z' || right.charAt(i)
            == 'z') 
                rcount += S[3];
            i++;
        }
        if (lcount > rcount) 
            System.out.println("Left side wins" + lcount);
        else if (lcount < rcount) 
            System.out.println("Right side wins" + rcount);
        else 
            System.out.println("Let's fight again");
    }
    public static void main(String args[]) 
    {
        AlphabetWarGame obj1 = new AlphabetWarGame();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int[] v = new int[4];
        do {
            System.out.println("Menu:");
            System.out.println("1. One Word Game");
            System.out.println("2. Two Words Game");
            System.out.println("3. Change strength");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the word:");
                    obj1.word = scanner.next();
                    obj1.game();
                    break;
                case 2:
                    System.out.println("Enter the left word:");
                    String l = scanner.next();
                    System.out.println("Enter the right word:");
                    String r = scanner.next();
                    obj1.game(l,r);
                    break;
                case 3:
                    System.out.println("Enter the strengths to change:");
                    for(int i=0;i<3;i++)
                        v[i] = scanner.nextInt();
                    obj1 = new AlphabetWarGame(v);
                    break;
                case 4:
                    System.out.println("Exiting the Game!");
                    break;
                default:
                    System.out.println("Invalid choice. Enter a valid option.");
                    break;
            }
        } while (choice != 4);
    }
}
