package com.codecool.cmdprog;

import com.codecool.api.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Table {

    protected final Scanner sc = new Scanner(System.in);
    protected Random random = new Random();

    public void newGame() {
        Menu menu = new Menu("Menu", new String[]{"Simulate a game", "Play a game", "Exit"});
        while (true) {
            menu.displayMenu();
            switch (sc.nextLine()) {
                case "1":
                    try {
                        Deck deck = newDeck();
                        try{
                            System.out.println(newSimulation(deck).getName());
                        } catch (NullPointerException e) {
                            System.out.println("Draw");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case "2":
                    try {
                        new TableTwoPlayer().startGame(sc, newDeck());
                    } catch (IOException e) {
                        System.out.println("");
                    }
                    break;
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
        System.out.println(attr);
        Card playerOneCard = chooseCard(players.get(0), attr);
        Card playerTwoCard = chooseCard(players.get(1), attr);
        System.out.println(playerOneCard.getId());
        System.out.println(playerTwoCard.getId());
        CardComparator comparator = new CardComparator(attr);
        int result = comparator.compare(playerOneCard, playerTwoCard);

        System.out.println(result);
        if (result > 0) {
            return players.get(0);
        } else if (result < 0 ) {
            return players.get(1);
        } else {
            return null;
        }

    }

    private Card chooseCard(PlayerImpl player, Attribute attr) {
        Collections.sort(player.getHand().getCards(), new CardComparator(attr));
        return player.getHand().getCards().get(player.getHand().getCards().size()-1);
    }

    protected Attribute decideAttribute() {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(Attribute.SANDBUCKETSIZE);
        attributes.add(Attribute.MONEY);
        attributes.add(Attribute.BROCCOLI);
        attributes.add(Attribute.WEIGHT);
        return attributes.get(random.nextInt(attributes.size()));
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
            cards.add(new Card(strings[0], strings[1], Integer.valueOf(strings[2]),
                Integer.valueOf(strings[3]), Integer.valueOf(strings[4]),
                Money.valueOf(strings[5])));
        }
        return cards;
    }
    
    public void showCards(List<Card> cards) {
    
    }
    
}
