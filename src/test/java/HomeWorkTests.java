import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeWorkTests {

    private String boardID;
    private String listId;
    private String cardId;

    @Test(priority = 1)
    public void checkCreateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Card card = new Card();
        String cardName = "New card";

        Card createCard = retrofitBuilder.getTrelloApi().createCard(card.getKey(), card.getToken(), cardName, card.getIdList()).execute().body();

        cardId = createCard.getId();

        Assert.assertEquals(createCard.getName(), cardName);
    }

    @Test(priority = 2)
    public void checkUpdateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Card card = new Card();
        String updatedCardName = "Updated Card";

        card.setName(updatedCardName);

        Card updatedCard = retrofitBuilder.getTrelloApi().updateCard(card, cardId).execute().body();

        Assert.assertEquals(updatedCard.getName(), updatedCardName);
    }

    @Test(priority = 3)
    public void checkGetCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Card card = new Card();

        int getCard = retrofitBuilder.getTrelloApi().getCard(cardId, card.getKey(), card.getToken()).execute().code();

        Assert.assertEquals(getCard, 200);
    }

    @Test(priority = 4)
    public void checkDeleteCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Card card = new Card();

        int deleteCard = retrofitBuilder.getTrelloApi().deleteCard(cardId, card.getKey(), card.getToken()).execute().code();

        Assert.assertEquals(deleteCard, 200);
    }

    @Test(priority = 5)
    public void checkGetCard1() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Card card = new Card();

        int getCard = retrofitBuilder.getTrelloApi().getCard(cardId, card.getKey(), card.getToken()).execute().code();

        Assert.assertEquals(getCard, 404);

    }
}