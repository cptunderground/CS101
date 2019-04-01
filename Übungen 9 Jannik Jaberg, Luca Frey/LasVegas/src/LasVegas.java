import java.util.ArrayList;
import java.util.Scanner;


/*
        Spielablauf

        Vor Beginn eines Spiels platzieren die Spieler ihre Einsätze auf den
        bezeichneten Feldern (boxes) entsprechend den vom Casino festgesetzten Einsatzlimits.

        In einer Box dürfen neben dem Boxeninhaber auch andere Spieler mitsetzen;
        mitsetzende Spieler haben aber kein Mitspracherecht und müssen die Entscheidungen
        des Boxeninhabers akzeptieren. Der Einsatz der mitsetzenden Spieler darf nur so hoch sein,
        dass das vom Casino festgelegte Limit pro Box nicht überschritten wird. Hat der Boxinhaber
        bereits den maximal möglichen Einsatz getätigt, darf somit kein Mitspieler mehr auf diese Box mitsetzen.

        Sind die Einsätze getätigt, beginnt der Croupier die Karten auszuteilen. Jeder Spieler und der Croupier
        erhalten zuerst eine offene Karte, danach erhält jeder Spieler − nicht aber der Croupier − eine zweite
        offene Karte (vgl. Regel-Varianten).

        Beginnend mit dem Spieler zur Linken des Croupiers kann nun jeder Teilnehmer solange weitere Karten
        verlangen („hit“, „Karte“ oder „carte“), bis er glaubt, nahe genug an 21 Punkte herangekommen zu sein
        und keine weitere Karte mehr will („stay“, „steht“ oder „reste“). Wer jedoch mit seinen Karten den Wert 21
        überschreitet (bust), hat sich überkauft und verliert sofort;
        die Karten und der Einsatz werden vom Croupier eingezogen.

        Sind alle Spieler bedient, zieht der Croupier seine zweite Karte. Hat er 17 oder mehr Punkte,
        muss er stehen bleiben, hat er 16 oder weniger Punkte, muss er eine weitere Karte ziehen
        (“Dealer must stand on 17 and must draw to 16”).

        Dabei gilt folgende Regel: Der Croupier muss ein Ass stets mit elf Punkten zählen, es sei denn,
        er würde auf diese Weise den Wert 21 überschreiten; nur dann zählt er das Ass mit einem Punkt.
        Hat der Croupier z. B. ein Ass und eine Sechs, muss er das Ass mit elf und die Hand mit siebzehn
        Punkten bewerten und darf keine weitere Karte ziehen (“Dealer stands on soft 17”).

        Wenn der Croupier 21 Punkte überschreitet, haben alle noch im Spiel verbleibenden Teilnehmer
        automatisch gewonnen. Sonst gewinnen nur jene Spieler, deren Kartenwert näher an 21 Punkte
        heranreicht als der des Croupiers.

        Hat ein Spieler gleich viele Punkte wie der Croupier, so ist das Spiel unentschieden
        (stand off, push, tie, égalité, en cartes), der Spieler verliert nichts, er gewinnt aber auch nichts.

        Gewinnt ein Spieler, erhält er einen Gewinn in der Höhe seines Einsatzes (1 : 1, even money);
        in den beiden folgenden Fällen werden jedoch erhöhte Gewinne ausgeschüttet.
*/


public class LasVegas
{
    Deck[] cardDecks = {new Deck(), new Deck(), new Deck(), new Deck(), new Deck(), new Deck()};

    int money = 1000;

    int player = 0;
    int dealer = 0;

    ArrayList<Card> playerCards = new ArrayList<>(10);
    ArrayList<Card> dealerCards = new ArrayList<>(10);

    static Scanner scanner = null;

    public static void main(String[] args)
    {
        System.out.println("\nWelcome to Las Vegas! \uD83C\uDCA1 \uD83C\uDCB1 \uD83C\uDCC1 \uD83C\uDCD1\n");


        LasVegas lv = new LasVegas();

        if (args.length == 1)
        {
            lv.money = Math.abs(Integer.valueOf(args[0]));
        }
        do
        {
            lv.performRound();
            System.out.println("\nDo you want to do another ROUND or do you want to QUIT ?\n");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("quit"))
            {
                break;
            }
            if (command.equalsIgnoreCase("round"))
            {
                continue; // could also be omitted, but it makes this so much more readable and sounds great!
            }
        } while (true);
    }

    void performRound()
    {
        if (scanner == null)
        {
            scanner = new Scanner(System.in);
        }

        // Reset accounts
        player = 0;
        dealer = 0;
        playerCards.clear();
        dealerCards.clear();
        
        if (money <= 0)
        {
            System.out.println("\nYou're outta money!\n");
            System.exit(0);
        }

        printPlayerAccount();

        System.out.println("\n\nDecide how much money you want to bet this round:\n");

        int bet = scanner.nextInt();
        scanner.nextLine();

        bet = Math.abs(bet);

        if (bet > money)
        {
            bet = money;
            System.out.println("\nALL IN!!!  Good luck...\n");
        }

        money -= bet;

        // Player receives 2 cards.
        giveCard(true);
        giveCard(true);

        printPlayerCards();

        // Dealer draws first card.
        giveCard(false);

        printDealerCards();

        for (int i = 0; i < 10; i++)
        {
            new Win("THINK.gif");
            System.out.println("\n\nWant another CARD or are you DONE ?\n\n");

            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("card"))
            {
                giveCard(true);
                printPlayerCards();

                if (player > 21)
                {
                    System.out.println("\n\nYou lost!\n\n");
                    Win win = new Win("REKT.gif");
                    return;
                }
            }
            else
            {
                if (command.equalsIgnoreCase("bj")) // allow erasing player's cards and giving a blackjack combo to test the behaviour
                {
                    playerCards.clear();
                    playerCards.add(new Card(Suit.HEARTS, Rank.ACE));
                    playerCards.add(new Card(Suit.CLUBS, Rank.JACK));
                    break;
                }
                if (command.equalsIgnoreCase("done"))
                {
                    break;
                }
                else
                {
                    //throw new IllegalArgumentException("Wrong input! You should've typed either CARD or DONE!!!");
                    System.out.println("Wrong input! You should've typed either CARD or DONE!!!");
                    i--;
                }
            }
        }

        printPlayerCards();

        if (blackJack(true))
        {
            System.out.println("\nBlack jack! $$$\n");
        }

        System.out.println("\n\nIt's the dealer's turn to draw cards...\n\n");

        while (dealer < 17)
        {
            sleep();
            Card c = giveCard(false);
            System.out.println("\nDealer draws another card: " + c + '\n');
        }
        sleep();

        printDealerCards();

        if (dealer > 21) // deeler got rekt m8
        {
            System.out.println("The dealer busted; you win!");
            money += (bet * (blackJack(true) ? 2.5 : 2));
            printPlayerAccount();
            Win win = new Win("WIN.gif");
            return;
        }

        if (player == dealer)
        {
            System.out.println("\nTIE! Nobody wins, bet is refunded\n");
            money += bet;
            return;
        }

        int playerDelta = (21 - player);
        int dealerDelta = (21 - dealer);

        if (playerDelta < dealerDelta) // player wins
        {
            System.out.println("\nYou win!");
            int gainz = (int) (bet * ((blackJack(true) && !blackJack(false)) ? 2.5 : 2));
            money += gainz;
            printPlayerAccount();
            Win win = new Win("WIN.gif");
            return;
        }
        else // dealer wins
        {
            System.out.println("\n\nYou lost!\n\n");
            Win win = new Win("REKT.gif");
            return;
        }
    }

    void printPlayerAccount()
    {
        System.out.println("\n\nYou have " + money + " CHF\n\n");
    }

    void printPlayerCards()
    {
        System.out.println("\nYour cards:\n\n");
        for (Card card : playerCards)
        {
            System.out.println("-" + card + "\n");
        }
    }

    void printDealerCards()
    {
        System.out.println("\nThe dealer's cards:\n\n");
        for (Card card : dealerCards)
        {
            System.out.println("-" + card + "\n");
        }
    }

    /**
     * Gets one random card from the 6 given decks.
     */
    Card getCard()
    {
        for (int i = 0; i < 6; i++)
        {
            if (!cardDecks[i].isEmpty())
            {
                return cardDecks[i].getCard();
            }
        }
        return null;
    }

    Card giveCard(boolean toPlayer)
    {
        Card card = getCard();
        (toPlayer ? playerCards : dealerCards).add(card);

        int a = ((card.getRank() == Rank.ACE) ? (((toPlayer ? player : dealer) + 11) > 21 ? 1 : 11) : card.getNumericValue());
        if (toPlayer)
        {
            player += a;
        }
        else
        {
            dealer += a;
        }

        return card;
    }

    boolean blackJack(boolean player)
    {
        ArrayList<Card> cards = player ? playerCards : dealerCards;

        if (cards.size() != 2)
        {
            return false;
        }

        Card c1 = cards.get(0);
        Card c2 = cards.get(1);

        if (c1.getRank() == Rank.ACE)
        {
            if (c2.getRank() == Rank.JACK || c2.getRank() == Rank.KING || c2.getRank() == Rank.QUEEN)
            {
                return true;
            }
        }

        if (c2.getRank() == Rank.ACE)
        {
            if (c1.getRank() == Rank.JACK || c1.getRank() == Rank.KING || c1.getRank() == Rank.QUEEN)
            {
                return true;
            }
        }

        return false;
    }

    void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
