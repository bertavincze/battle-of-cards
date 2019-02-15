package com.codecool.cmdprog;

import com.codecool.api.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Table {
    private Dealer dealer;
    private final Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    public void newGame() {
        Menu menu = new Menu("Óvodáskártya", new String[]{"Játék szimuláció", "Játék számítógép ellen", "Kilépés"});
        while (true) {
            printImage();
            System.out.println("");
            menu.displayMenu();
            switch (sc.nextLine()) {
                case "1":
                    try {
                        startGame(newDeck(), "Simulation");
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case "2":
                    try {
                        startGame(newDeck(), "Two player");
                    } catch (IOException e) {
                        System.out.println("");
                    }
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Nincs ilyen opció");
                    break;
            }
        }

    }

    private void printImage() {
        FileHandler fh = new FileHandler();
        try {
            String[] image = fh.readTxt("./src/main/resources/image.txt");
            for (String s : image) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startGame(Deck deck, String mode) {
        List<PlayerImpl> players;
        dealer = new Dealer(deck);
        dealer.getDeck().shuffle();
        if (mode.equals("Simulation")) {
            players = createPlayers("Linux", "Windows");

        } else {
            System.out.println("Add meg a neved: ");
            String name = sc.nextLine();
            players = createPlayers(name, "Ubuntu");

        }
        dealCards(players, dealer, 4);

        while (players.get(0).getHand().getCards().size() != 0 || players.get(1).getHand().getCards().size() != 0) {
            playOneRound(players);
        }

        evaluateWholeGame(players);

    }

    private void evaluateWholeGame(List<PlayerImpl> players) {
        if (players.get(0).getWonCards().size() > players.get(1).getWonCards().size() ) {
            System.out.println(players.get(0).getName() + " nyerte a játékot " + players.get(0).getWonCards().size() + " kártyával.");
        } else if (players.get(0).getWonCards().size() < players.get(1).getWonCards().size() ) {
            System.out.println(players.get(1).getName() + " nyerte a játékot " + players.get(1).getWonCards().size() + " kártyával.");
        } else {
            System.out.println("Döntetlen!");
        }
    }

    private void playOneRound(List<PlayerImpl> players) {
        dealCards(players, dealer, 1);
        Card player1Card;
        Attribute randAttribute = decideAttribute();
        Card player2Card = chooseCard(players.get(1), randAttribute);
        if (!players.get(0).getName().equals("Linux")) {
            System.out.println("\nVálassz kártyát: \n" + "Ebben a körben az összehasonlítási szempont: " + randAttribute.toString() + "\n");
            printCurrentCards(players.get(0).getHand().getCards());
            System.out.println("\n");
            player1Card = askForCardFromUser(players.get(0));
        } else {
            player1Card = chooseCard(players.get(0), randAttribute);
        }
        System.out.printf(" %18s" + "   ☠️   %-18s ",player1Card.getName() ,player2Card.getName());
        System.out.println("\n");
        printCurrentCards(Arrays.asList(player1Card, player2Card));
        roundEvaluator(randAttribute, player1Card, player2Card, players);
        System.out.println("\nFolytatáshoz nyomd meg az ENTER-t.");
        sc.nextLine();
    }

    private Card askForCardFromUser(PlayerImpl player) {
        Card card = null;
        while(card == null) {
            System.out.println("Írd be a kiválasztott kártya jelét: ");
            card = findCardById(player.getHand().getCards(), sc.nextLine());
        }
        return card;
    }

    private Card findCardById(List<Card> cards, String id) {
        for (Card card : cards) {
            if (card.getId().equalsIgnoreCase(id)) {
                return card;
            }
        }
        return null;
    }

    private void roundEvaluator(Attribute randAttribute, Card userCard, Card computerCard, List<PlayerImpl> players) {

        CardComparator compared = new CardComparator(randAttribute);
        int result = compared.compare(userCard, computerCard);
        if (result < 0) {

            players.get(1).addWonCard(computerCard);
            players.get(1).addWonCard(userCard);
            System.out.println("\n" + players.get(1).getName() + " nyerte a kört");
        } else if (result > 0) {
            players.get(0).addWonCard(userCard);
            players.get(0).addWonCard(computerCard);
            System.out.println("\n" + players.get(0).getName() + " nyerte a kört");
        } else {
            System.out.println("\nDöntetlen kör");

        }
        System.out.println("\n" + players.get(0).getName() + " eddig " + players.get(0).getWonCards().size() + " kártyát nyert" );
        System.out.println("\n" + players.get(1).getName() + " eddig " + players.get(1).getWonCards().size() + " kártyát nyert"  );
        players.get(1).getHand().getCards().remove(computerCard);
        players.get(0).getHand().getCards().remove(userCard);
    }

    private void dealCards(List<PlayerImpl> players, Dealer dealer, int cardNum) {
        if (!dealer.getDeck().getDeck().isEmpty()) {
            for (PlayerImpl player : players) {
                dealer.dealsTo(player, cardNum);
            }
        }
    }

    private Card chooseCard(PlayerImpl player, Attribute attr) {
        if (player.getHand().getCards().size() >= 1) {
            Collections.sort(player.getHand().getCards(), new CardComparator(attr));
            return player.getHand().getCards().get(player.getHand().getCards().size() - 1);
        } else {
            return null;
        }
    }

    private Attribute decideAttribute() {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(Attribute.SANDBUCKETSIZE);
        attributes.add(Attribute.MONEY);
        attributes.add(Attribute.BROCCOLI);
        attributes.add(Attribute.WEIGHT);
        return attributes.get(random.nextInt(attributes.size()));
    }

    private List<PlayerImpl> createPlayers(String name1, String name2) {
        List<PlayerImpl> players = new ArrayList<>();
        PlayerImpl playerOne = new PlayerImpl(name1);
        players.add(playerOne);
        PlayerImpl playerTwo = new PlayerImpl(name2);
        players.add(playerTwo);
        return players;
    }

    private Deck newDeck() throws IOException {
        List<Card> cards = readCards("./src/main/resources/cards.csv");
        return new Deck(cards);
    }


    private List<Card> readCards(String filename) throws IOException {
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

    private void printCurrentCards(List<Card> cards) {

        String closer = "|____________________| ".repeat(cards.size());
        String broccoli = "| megevett brokkoli: | ".repeat(cards.size());
        String apu =      "| apu foglalkozása:  | ".repeat(cards.size());
        String emptyRow = "|                    | ".repeat(cards.size());
        String graphic1 = "        //////         ".repeat(cards.size());
        String graphic2 = "       ( O O )         ".repeat(cards.size());
        String graphic3 = "|--ooO--- ˘ ---Ooo---| ".repeat(cards.size());

        String cardField = "| %-18s |";

        String cardField1 = IntStream.range(0, cards.size()).mapToObj(i -> cardField + " ").collect(Collectors.joining()) + "%n";

        System.out.println(graphic1);
        System.out.println(graphic2);
        System.out.println(graphic3);
        System.out.println(emptyRow);
        System.out.printf(cardField1, cards.stream().map((Card c) -> "jel: " + c.getId()).toArray());
        System.out.printf(cardField1, cards.stream().map((Card c) -> "név: " + c.getName()).toArray());
        System.out.println(emptyRow);
        System.out.println(broccoli);
        System.out.printf(cardField1, cards.stream().map((Card c) -> c.getEatedBrokkoliInKg() + "kg").toArray());
        System.out.println(emptyRow);
        System.out.printf(cardField1, cards.stream().map((Card c) -> ("testsúly: " + c.getWeight()) + "kg").toArray());
        System.out.println(emptyRow);
        System.out.printf(cardField1, cards.stream().map((Card c) -> ("vödör: " + c.getSandBucketSize()) + " literes").toArray());
        System.out.println(emptyRow);
        System.out.println(apu);
        System.out.printf(cardField1, cards.stream().map(Card::getMoney).toArray());
        System.out.println(closer);
    }
}
