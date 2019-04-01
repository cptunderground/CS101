import java.util.ArrayList;
import java.util.Random;

/**
 * A deck of 52 french baguettes.
 */
public class Deck
{
    private ArrayList<Card> cards = new ArrayList<>(52);

    /**
     * Constructs a new deck of 52 ordered (!) cards.
     * To retrieve a card randomly, use the getCard method.
     */
    public Deck()
    {
        cards.add(new Card(Suit.SPADES, Rank.TWO));
        cards.add(new Card(Suit.SPADES, Rank.THREE));
        cards.add(new Card(Suit.SPADES, Rank.FOUR));
        cards.add(new Card(Suit.SPADES, Rank.FIVE));
        cards.add(new Card(Suit.SPADES, Rank.SIX));
        cards.add(new Card(Suit.SPADES, Rank.SEVEN));
        cards.add(new Card(Suit.SPADES, Rank.EIGHT));
        cards.add(new Card(Suit.SPADES, Rank.NINE));
        cards.add(new Card(Suit.SPADES, Rank.TEN));
        cards.add(new Card(Suit.SPADES, Rank.JACK));
        cards.add(new Card(Suit.SPADES, Rank.QUEEN));
        cards.add(new Card(Suit.SPADES, Rank.KING));
        cards.add(new Card(Suit.SPADES, Rank.ACE));
        cards.add(new Card(Suit.HEARTS, Rank.TWO));
        cards.add(new Card(Suit.HEARTS, Rank.THREE));
        cards.add(new Card(Suit.HEARTS, Rank.FOUR));
        cards.add(new Card(Suit.HEARTS, Rank.FIVE));
        cards.add(new Card(Suit.HEARTS, Rank.SIX));
        cards.add(new Card(Suit.HEARTS, Rank.SEVEN));
        cards.add(new Card(Suit.HEARTS, Rank.EIGHT));
        cards.add(new Card(Suit.HEARTS, Rank.NINE));
        cards.add(new Card(Suit.HEARTS, Rank.TEN));
        cards.add(new Card(Suit.HEARTS, Rank.JACK));
        cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
        cards.add(new Card(Suit.HEARTS, Rank.KING));
        cards.add(new Card(Suit.HEARTS, Rank.ACE));
        cards.add(new Card(Suit.CLUBS, Rank.TWO));
        cards.add(new Card(Suit.CLUBS, Rank.THREE));
        cards.add(new Card(Suit.CLUBS, Rank.FOUR));
        cards.add(new Card(Suit.CLUBS, Rank.FIVE));
        cards.add(new Card(Suit.CLUBS, Rank.SIX));
        cards.add(new Card(Suit.CLUBS, Rank.SEVEN));
        cards.add(new Card(Suit.CLUBS, Rank.EIGHT));
        cards.add(new Card(Suit.CLUBS, Rank.NINE));
        cards.add(new Card(Suit.CLUBS, Rank.TEN));
        cards.add(new Card(Suit.CLUBS, Rank.JACK));
        cards.add(new Card(Suit.CLUBS, Rank.QUEEN));
        cards.add(new Card(Suit.CLUBS, Rank.KING));
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.DIAMONDS, Rank.TWO));
        cards.add(new Card(Suit.DIAMONDS, Rank.THREE));
        cards.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        cards.add(new Card(Suit.DIAMONDS, Rank.FIVE));
        cards.add(new Card(Suit.DIAMONDS, Rank.SIX));
        cards.add(new Card(Suit.DIAMONDS, Rank.SEVEN));
        cards.add(new Card(Suit.DIAMONDS, Rank.EIGHT));
        cards.add(new Card(Suit.DIAMONDS, Rank.NINE));
        cards.add(new Card(Suit.DIAMONDS, Rank.TEN));
        cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
        cards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
        cards.add(new Card(Suit.DIAMONDS, Rank.KING));
        cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
    }

    /**
     * Gets a random card from the deck and removes it from the ArrayList.
     */
    public Card getCard()
    {
        if (isEmpty())
        {
            return null;
        }

        Random r = new Random();
        int i = r.nextInt(cards.size());
        Card c = cards.get(i);
        cards.remove(i);
        return c;
    }

    public boolean isEmpty()
    {
        return cards.isEmpty();
    }
}
