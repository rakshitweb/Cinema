package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i,j,ch;
        int totalSeatsBooked=0;
        int currentIncome=0;
        int totalIncome=0;
        System.out.println("Enter the number of rows: ");
        int nRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int nseats = scanner.nextInt();
        char seatBooked[][] = new char[nRows][nseats];
        for(i=0;i<nRows;i++)
            for(j=0;j<nseats;j++) {
                seatBooked[i][j] = 'S';
                totalIncome += (nseats*nRows<=60)?10:(i<nRows/2)?10:8;
            }

        System.out.println();
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            ch = scanner.nextInt();
            switch (ch){
                case 1 :
                    System.out.println("Cinema:");
                    for (i = 0; i <= nRows; i++) {
                        if (i == 0)
                            System.out.print("  ");
                        if (i != 0)
                            System.out.print(i + " ");
                        for (j = 0; j < nseats; j++) {
                            if (i == 0)
                                System.out.print(j + 1 + " ");
                            else
                                System.out.print(seatBooked[i - 1][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 2:
                    boolean isWrong = true;
                    do {
                        System.out.println("Enter a row number:");
                        int rowNum = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seatNum = scanner.nextInt();
                        if(rowNum<=nRows&&seatNum<=nseats) {
                            if (seatBooked[rowNum - 1][seatNum - 1] == 'S') {
                                int price = ((nRows * nseats <= 60) ? 10 : (rowNum > nRows / 2) ? 8 : 10);
                                System.out.println("Ticket price: $" + price);
                                seatBooked[rowNum - 1][seatNum - 1] = 'B';
                                totalSeatsBooked++;
                                currentIncome += price;
                                isWrong = false;
                            } else
                                System.out.println("That ticket has already been purchased");
                        }
                        if(isWrong)
                            System.out.println("Wrong input!");
                    }while(isWrong);
                    System.out.println();
                    break;
                case 3:

                    System.out.println("Number of purchased tickets: " + totalSeatsBooked);
                    System.out.println("Percentage: "+String.format("%.2f", (float)(totalSeatsBooked*100.00)/(nseats*nRows))+"%");
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + totalIncome);
                    break;
            }
        }while(ch!=0);
    }
}