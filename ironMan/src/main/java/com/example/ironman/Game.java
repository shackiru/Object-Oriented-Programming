package com.example.ironman;
import java.util.Scanner;

public class Game
{
    protected int size = 0;
    private String gameId[] = new String[169];
    private String gameName[] = new String[169];
    private double gamePrice[] = new double[169];
    private String gameGenre[] = new String[169];

    Scanner scan = new Scanner(System.in);


    public void view(){
        for(int i = 0; i < size; i++){
            System.out.println("Game #"+ (i+1));
            System.out.println("Game name : " + this.gameName[i]);
            System.out.println("game id : " + this.gameId[i]);
            System.out.println("Game price : " + this.gamePrice[i]);
            System.out.println("Game genre : " + this.gameGenre[i]);
        }
    }


    public void addGame(){
        String nameTemp;
        do{

            System.out.print("Enter the game name : ");
            nameTemp = scan.nextLine();
        }while(nameTemp == null);
        this.gameName[size] = nameTemp;

        String genreTemp;
        do{
            System.out.print("Enter the game genre : ");
            genreTemp = scan.nextLine();
        }while(genreTemp.equals("Action") == false && genreTemp.equals("Sports") == false && genreTemp.equals("Arcade") == false);
        this.gameGenre[size] = genreTemp;

        double priceTemp;
        do{
            System.out.print("Enter the price of the game [10000 - 100000]: ");
            priceTemp = scan.nextDouble();
            scan.nextLine();
        }while(priceTemp < 10000 || priceTemp > 100000);
        this.gamePrice[size] = priceTemp;

        String idTemp;
        //pake ini aja id nya [idTemp = "" + (long)(Math.random() * 40000000L);]
        //idTemp = RandomStringUtils.randomNumeric(6);
        idTemp = "" + (long)(Math.random() * 40000000L);
        this.gameId[size] = idTemp;

        size++;
    }


    public void gameMenu(){
        int input;
        do{
            System.out.println("1.Add Game");
            System.out.println("2.View all game");
            System.out.println("3.Update game");
            System.out.println("4.delete game");
            System.out.print(">>");
            input = scan.nextInt();scan.nextLine();

            switch(input){
                case 1 :{
                    addGame();
                    break;
                }
                case 2 :{
                    view();
                    break;
                }
                case 3 : {

                    break;
                }
            }
        }
        while(true);
    }
}
