import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {

//    @POST("/1/boards/")
//    Call<Board> createBoard(@Body Board board, @Query("name") String name);
//
//    @PUT("/1/boards/{id}")
//    Call<Board> updateBoard(@Body Board board, @Path("id") String id);
//
//    @DELETE("/1/boards/{id}")
//    Call<Board> deleteBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);

    @POST("/1/cards")
    Call<Card> createCard(@Query("key") String key, @Query("token") String token, @Query("name") String cardName, @Query("idList") String idList);

    @PUT("/1/cards/{id}")
    Call<Card> updateCard(@Body Card card, @Path("id") String cardId);

    @GET("/1/cards/{id}")
    Call<Card> getCard(@Path("id") String cardID, @Query("key") String key, @Query("token") String token);

    @DELETE("/1/cards/{id}")
    Call<Card> deleteCard(@Path("id") String cardID, @Query("key") String key, @Query("token") String token);
}
