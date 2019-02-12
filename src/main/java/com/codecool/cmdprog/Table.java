package com.codecool.cmdprog;

import com.codecool.api.*;

import java.io.IOException;
import java.util.*;

public class Table {

    private final Scanner sc = new Scanner(System.in);
    protected Random random = new Random();

    public void newGame() {
        Menu menu = new Menu("Menu", new String[]{"Simulate a game", "Play a game", "Exit"});
        while (true) {
            menu.displayMenu();
            switch (sc.nextLine()) {
                case "1":
                    try {
                        Deck deck = newDeck();
                        System.out.println(newSimulation(deck).getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case "2":
                    new TableTwoPlayer().playGame();
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

    }

    private PlayerImpl newSimulation(Deck deck) {
        List<PlayerImpl> players = createPlayers();
        Dealer dealer = new Dealer(deck);
        for (PlayerImpl player : players) {
            dealer.dealsTo(player, 4);
        }
        Attribute attr = decideAttribute();
        Card playerOneCard = chooseCard(players.get(0), attr);
        Card playerTwoCard = chooseCard(players.get(1), attr);
        CardComparator comparator = new CardComparator(attr);
        int result = comparator.compare(playerOneCard, playerTwoCard);
        Card winner;
        PlayerImpl winnerPlayer = null;
        switch (result) {
            case 1:
                winner = playerOneCard;
                winnerPlayer = players.get(0);
            case -1:
                winner = playerTwoCard;
                winnerPlayer = players.get(1);
            case 0:
                break;
        }
        return winnerPlayer;
    }

    private Card chooseCard(PlayerImpl player, Attribute attr) {
        Collections.sort(player.getHand().getCards(), new CardComparator(attr));
        return player.getHand().getCards().get(0);
    }

    protected Attribute decideAttribute() {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(Attribute.SANDBUCKETSIZE);
        attributes.add(Attribute.MONEY);
        attributes.add(Attribute.RANK);
        attributes.add(Attribute.WEIGHT);
        return attributes.get(random.nextInt(attributes.size() + 1));
    }

    private List<PlayerImpl> createPlayers() {
        List<PlayerImpl> players = new ArrayList<>();
        PlayerImpl playerOne = new PlayerImpl("Player One");
        players.add(playerOne);
        PlayerImpl playerTwo = new PlayerImpl("Player Two");
        players.add(playerTwo);
        return players;
    }

    protected Deck newDeck() throws IOException {
        List<Card> cards = readCards("resources/cards.csv");
        return new Deck(cards);
    }


    protected List<Card> readCards(String filename) throws IOException {
        FileHandler fh = new FileHandler();
        String[][] cardsArray = fh.read(filename);
        List<Card> cards = new ArrayList<>();
        for (String[] strings : cardsArray) {
            cards.add(new Card(strings[0], strings[1], Rank.valueOf(strings[2]),
                Integer.valueOf(strings[3]), Integer.valueOf(strings[4]),
                Money.valueOf(strings[5])));
        }
        return cards;
    }

    /*
    public static void main(String[] args) {
        
        FileHandler fh = new FileHandler();
        String[][] cardsArray = new String[0][];
        try {
            cardsArray = fh.read("resources/cards.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        cards = new ArrayList<>();
        for (String[] strings : cardsArray) {
            cards.add(new Card(strings[0], strings[1], Rank.valueOf(strings[2]),
                Integer.valueOf(strings[3]), Integer.valueOf(strings[4]),
                Money.valueOf(strings[5])));
        }
        deck = new Deck(cards);
        Table t = new Table();
        try {
            String[] image = fh.readTxt("resources/image2Players.txt");
            for (int i = 0; i < image.length; i++) {
                System.out.println(image[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.showCards(cards);
        
    }
    
    public void showCards(List<Card> cards) {
        
        
        
        String leftAligned = "| %-18s | | %-18s |%n";
        String header = " ____________________   ____________________";
        String closer = " --------------------   --------------------";
        String graphic1 = "|-------//////-------| |-------//////-------|";
        String graphic2 = "|------( O O )-------| |------( O O )-------|";
        String graphic3 = "|--ooO---( )---Ooo---| |--ooO---( )---Ooo---|";

        System.out.println(graphic1);
        System.out.println(graphic2);
        System.out.println(graphic3);
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "jel:" + cards.get(0).getId(),"jel:" + cards.get(1).getId());
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "név:" + cards.get(0).getName(), "név:" + cards.get(1).getName());
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "csoport:" + cards.get(0).getRank(), "csoport:" + cards.get(1).getRank());
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "súly: " + cards.get(0).getWeight() + "kg", "súly: " + cards.get(1).getWeight() + "kg");
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "vödör:" + cards.get(0).getSandBucketSize() + " literes", "vödör:" + cards.get(0).getSandBucketSize() + " literes");
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "apu foglalkozása:", "apu foglalkozása:");
        System.out.printf(leftAligned, cards.get(0).getMoney(), cards.get(1).getMoney());
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(closer);
    }
    */
}
