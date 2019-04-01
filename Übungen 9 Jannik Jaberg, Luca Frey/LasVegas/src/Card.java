public class Card
{
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public Rank getRank()
    {
        return rank;
    }

    /**
     * Gets the numeric value of a card based on its rank.
     * Note that an ace can be 1 or 11 for the player (usually 11 for the Croupier).
     */
    public int getNumericValue()
    {
        switch (rank)
        {
            default:
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
            case KING:
            case QUEEN:
                return 10;
            case ACE:
                return 11;
        }
    }

    @Override
    public String toString()
    {
        return "" + suit + ' ' + rank + " (" + (rank == Rank.ACE ? "1 or 11" : getNumericValue()) + ")";
    }
}
