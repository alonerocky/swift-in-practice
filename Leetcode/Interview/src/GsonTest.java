import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shoulongli on 5/9/16.
 */
public class GsonTest {

    /**
     * reputation: 23,
     user_id: 4805044,
     user_type: "registered",
     accept_rate: 14,
     profile_image: "https://www.gravatar.com/avatar/36cdb80d69e1f92ca429bdf69ccb05c6?s=128&d=identicon&r=PG&f=1",
     display_name: "Blake Lassiter",
     link: "http://stackoverflow.com/users/4805044/blake-lassiter"
     */
    public static void main(String[] argv) {
        Owner owner1 = new Owner(1, 111111, "registered", 14,
                "https://www.gravatar.com/avatar/36cdb80d69e1f92ca429bdf69ccb05c6?s=128&d=identicon&r=PG&f=1",
                "Blake Lassiter",
                "http://stackoverflow.com/users/4805044/blake-lassiter");

        Owner owner2 = new Owner(2, 222222, "registered", 14,
                "https://www.gravatar.com/avatar/36cdb80d69e1f92ca429bdf69ccb05c6?s=128&d=identicon&r=PG&f=1",
                "Blake Lassiter",
                "http://stackoverflow.com/users/4805044/blake-lassiter");

        Owner owner3 = new Owner(3, 333333, "registered", 14,
                "https://www.gravatar.com/avatar/36cdb80d69e1f92ca429bdf69ccb05c6?s=128&d=identicon&r=PG&f=1",
                "Blake Lassiter",
                "http://stackoverflow.com/users/4805044/blake-lassiter");

        String json = "{\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"tags\": [\n" +
                "        \"android\",\n" +
                "        \"android-manifest\"\n" +
                "      ],\n" +
                "      \"owner\": {\n" +
                "        \"reputation\": 23,\n" +
                "        \"user_id\": 4805044,\n" +
                "        \"user_type\": \"registered\",\n" +
                "        \"accept_rate\": 14,\n" +
                "        \"profile_image\": \"https://www.gravatar.com/avatar/36cdb80d69e1f92ca429bdf69ccb05c6?s=128&d=identicon&r=PG&f=1\",\n" +
                "        \"display_name\": \"Blake Lassiter\",\n" +
                "        \"link\": \"http://stackoverflow.com/users/4805044/blake-lassiter\"\n" +
                "      },\n" +
                "      \"is_answered\": false,\n" +
                "      \"view_count\": 13,\n" +
                "      \"answer_count\": 0,\n" +
                "      \"score\": 0,\n" +
                "      \"last_activity_date\": 1462763611,\n" +
                "      \"creation_date\": 1462762986,\n" +
                "      \"last_edit_date\": 1462763611,\n" +
                "      \"question_id\": 37107214,\n" +
                "      \"link\": \"http://stackoverflow.com/questions/37107214/set-title-to-hidden-on-android-app\",\n" +
                "      \"title\": \"Set Title To Hidden on Android App\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"tags\": [\n" +
                "        \"android\",\n" +
                "        \"c++\",\n" +
                "        \"windows\",\n" +
                "        \"bluetooth\"\n" +
                "      ],\n" +
                "      \"owner\": {\n" +
                "        \"reputation\": 937,\n" +
                "        \"user_id\": 1183804,\n" +
                "        \"user_type\": \"registered\",\n" +
                "        \"accept_rate\": 83,\n" +
                "        \"profile_image\": \"https://i.stack.imgur.com/Z5Lyl.jpg?s=128&g=1\",\n" +
                "        \"display_name\": \"Chris\",\n" +
                "        \"link\": \"http://stackoverflow.com/users/1183804/chris\"\n" +
                "      },\n" +
                "      \"is_answered\": true,\n" +
                "      \"view_count\": 17,\n" +
                "      \"answer_count\": 1,\n" +
                "      \"score\": 3,\n" +
                "      \"last_activity_date\": 1462763542,\n" +
                "      \"creation_date\": 1462701554,\n" +
                "      \"last_edit_date\": 1462743555,\n" +
                "      \"question_id\": 37098557,\n" +
                "      \"link\": \"http://stackoverflow.com/questions/37098557/c-winsock-bluetooth-connection-at-command-error-received\",\n" +
                "      \"title\": \"C++ WinSock Bluetooth Connection - AT Command - Error Received\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"tags\": [\n" +
                "        \"java\",\n" +
                "        \"android\",\n" +
                "        \"user-interface\",\n" +
                "        \"fragment\",\n" +
                "        \"android-orientation\"\n" +
                "      ],\n" +
                "      \"owner\": {\n" +
                "        \"reputation\": 4,\n" +
                "        \"user_id\": 4835349,\n" +
                "        \"user_type\": \"registered\",\n" +
                "        \"profile_image\": \"https://lh4.googleusercontent.com/-ZFmtDec26j4/AAAAAAAAAAI/AAAAAAAAAC4/RGi5zw-SFao/photo.jpg?sz=128\",\n" +
                "        \"display_name\": \"jl1992\",\n" +
                "        \"link\": \"http://stackoverflow.com/users/4835349/jl1992\"\n" +
                "      },\n" +
                "      \"is_answered\": false,\n" +
                "      \"view_count\": 41,\n" +
                "      \"answer_count\": 2,\n" +
                "      \"score\": -1,\n" +
                "      \"last_activity_date\": 1462761445,\n" +
                "      \"creation_date\": 1462750768,\n" +
                "      \"question_id\": 37105990,\n" +
                "      \"link\": \"http://stackoverflow.com/questions/37105990/android-how-do-i-prevent-class-variables-being-cleared-on-orientation-change\",\n" +
                "      \"title\": \"Android: how do I prevent class variables being cleared on orientation change\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"has_more\": true,\n" +
                "  \"quota_max\": 300,\n" +
                "  \"quota_remaining\": 298\n" +
                "}";
        Gson gson = new GsonBuilder().create();

        String jsonArray = "[\n" +
                "    {\n" +
                "      \"tags\": [\n" +
                "        \"android\",\n" +
                "        \"android-manifest\"\n" +
                "      ],\n" +
                "      \"owner\": {\n" +
                "        \"reputation\": 23,\n" +
                "        \"user_id\": 4805044,\n" +
                "        \"user_type\": \"registered\",\n" +
                "        \"accept_rate\": 14,\n" +
                "        \"profile_image\": \"https://www.gravatar.com/avatar/36cdb80d69e1f92ca429bdf69ccb05c6?s=128&d=identicon&r=PG&f=1\",\n" +
                "        \"display_name\": \"Blake Lassiter\",\n" +
                "        \"link\": \"http://stackoverflow.com/users/4805044/blake-lassiter\"\n" +
                "      },\n" +
                "      \"is_answered\": false,\n" +
                "      \"view_count\": 13,\n" +
                "      \"answer_count\": 0,\n" +
                "      \"score\": 0,\n" +
                "      \"last_activity_date\": 1462763611,\n" +
                "      \"creation_date\": 1462762986,\n" +
                "      \"last_edit_date\": 1462763611,\n" +
                "      \"question_id\": 37107214,\n" +
                "      \"link\": \"http://stackoverflow.com/questions/37107214/set-title-to-hidden-on-android-app\",\n" +
                "      \"title\": \"Set Title To Hidden on Android App\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"tags\": [\n" +
                "        \"android\",\n" +
                "        \"c++\",\n" +
                "        \"windows\",\n" +
                "        \"bluetooth\"\n" +
                "      ],\n" +
                "      \"owner\": {\n" +
                "        \"reputation\": 937,\n" +
                "        \"user_id\": 1183804,\n" +
                "        \"user_type\": \"registered\",\n" +
                "        \"accept_rate\": 83,\n" +
                "        \"profile_image\": \"https://i.stack.imgur.com/Z5Lyl.jpg?s=128&g=1\",\n" +
                "        \"display_name\": \"Chris\",\n" +
                "        \"link\": \"http://stackoverflow.com/users/1183804/chris\"\n" +
                "      },\n" +
                "      \"is_answered\": true,\n" +
                "      \"view_count\": 17,\n" +
                "      \"answer_count\": 1,\n" +
                "      \"score\": 3,\n" +
                "      \"last_activity_date\": 1462763542,\n" +
                "      \"creation_date\": 1462701554,\n" +
                "      \"last_edit_date\": 1462743555,\n" +
                "      \"question_id\": 37098557,\n" +
                "      \"link\": \"http://stackoverflow.com/questions/37098557/c-winsock-bluetooth-connection-at-command-error-received\",\n" +
                "      \"title\": \"C++ WinSock Bluetooth Connection - AT Command - Error Received\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"tags\": [\n" +
                "        \"java\",\n" +
                "        \"android\",\n" +
                "        \"user-interface\",\n" +
                "        \"fragment\",\n" +
                "        \"android-orientation\"\n" +
                "      ],\n" +
                "      \"owner\": {\n" +
                "        \"reputation\": 4,\n" +
                "        \"user_id\": 4835349,\n" +
                "        \"user_type\": \"registered\",\n" +
                "        \"profile_image\": \"https://lh4.googleusercontent.com/-ZFmtDec26j4/AAAAAAAAAAI/AAAAAAAAAC4/RGi5zw-SFao/photo.jpg?sz=128\",\n" +
                "        \"display_name\": \"jl1992\",\n" +
                "        \"link\": \"http://stackoverflow.com/users/4835349/jl1992\"\n" +
                "      },\n" +
                "      \"is_answered\": false,\n" +
                "      \"view_count\": 41,\n" +
                "      \"answer_count\": 2,\n" +
                "      \"score\": -1,\n" +
                "      \"last_activity_date\": 1462761445,\n" +
                "      \"creation_date\": 1462750768,\n" +
                "      \"question_id\": 37105990,\n" +
                "      \"link\": \"http://stackoverflow.com/questions/37105990/android-how-do-i-prevent-class-variables-being-cleared-on-orientation-change\",\n" +
                "      \"title\": \"Android: how do I prevent class variables being cleared on orientation change\"\n" +
                "    }\n" +
                "  ]";
        Type collectionType = new TypeToken<List<Item>>(){}.getType();
        List<Item> items = gson.fromJson(jsonArray, collectionType);
        System.out.println(items.size());
        for (int i = 0; i < items.size();i++) {
            System.out.println(items.get(i).questionId);
        }

        Item[] items2 = gson.fromJson(jsonArray, Item[].class);
        ArrayList<Item> items3 = new ArrayList<Item>(Arrays.asList(items2));
        for (int i = 0; i < items3.size();i++) {
            System.out.println(items3.get(i).questionId);
        }

        Result r = gson.fromJson(json, Result.class);
        for (int i = 0; i < r.items.size();i++) {
            System.out.println(r.items.get(i).questionId);
        }
    }
}

class Result {

    @SerializedName("items")
    @Expose
    public List<Item> items = new ArrayList<Item>();
    @SerializedName("has_more")
    @Expose
    public Boolean hasMore;
    @SerializedName("quota_max")
    @Expose
    public Integer quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    public Integer quotaRemaining;

    /**
     * No args constructor for use in serialization
     */
    public Result() {
    }

    /**
     * @param hasMore
     * @param quotaMax
     * @param items
     * @param quotaRemaining
     */
    public Result(List<Item> items, Boolean hasMore, Integer quotaMax, Integer quotaRemaining) {
        this.items = items;
        this.hasMore = hasMore;
        this.quotaMax = quotaMax;
        this.quotaRemaining = quotaRemaining;
    }

}

class Item {

    @SerializedName("tags")
    @Expose
    public List<String> tags = new ArrayList<String>();
    @SerializedName("owner")
    @Expose
    public Owner owner;
    @SerializedName("is_answered")
    @Expose
    public Boolean isAnswered;
    @SerializedName("view_count")
    @Expose
    public Integer viewCount;
    @SerializedName("answer_count")
    @Expose
    public Integer answerCount;
    @SerializedName("score")
    @Expose
    public Integer score;
    @SerializedName("last_activity_date")
    @Expose
    public Integer lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    public Integer creationDate;
    @SerializedName("last_edit_date")
    @Expose
    public Integer lastEditDate;
    @SerializedName("question_id")
    @Expose
    public Integer questionId;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("accepted_answer_id")
    @Expose
    public Integer acceptedAnswerId;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param tags
     * @param questionId
     * @param lastActivityDate
     * @param link
     * @param score
     * @param lastEditDate
     * @param creationDate
     * @param title
     * @param answerCount
     * @param isAnswered
     * @param owner
     * @param acceptedAnswerId
     * @param viewCount
     */
    public Item(List<String> tags, Owner owner, Boolean isAnswered, Integer viewCount, Integer answerCount, Integer score, Integer lastActivityDate, Integer creationDate, Integer lastEditDate, Integer questionId, String link, String title, Integer acceptedAnswerId) {
        this.tags = tags;
        this.owner = owner;
        this.isAnswered = isAnswered;
        this.viewCount = viewCount;
        this.answerCount = answerCount;
        this.score = score;
        this.lastActivityDate = lastActivityDate;
        this.creationDate = creationDate;
        this.lastEditDate = lastEditDate;
        this.questionId = questionId;
        this.link = link;
        this.title = title;
        this.acceptedAnswerId = acceptedAnswerId;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}

class Owner {

    @SerializedName("reputation")
    @Expose
    public Integer reputation;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("user_type")
    @Expose
    public String userType;
    @SerializedName("accept_rate")
    @Expose
    public Integer acceptRate;
    @SerializedName("profile_image")
    @Expose
    public String profileImage;
    @SerializedName("display_name")
    @Expose
    public String displayName;
    @SerializedName("link")
    @Expose
    public String link;

    /**
     * No args constructor for use in serialization
     */
    public Owner() {
    }

    /**
     * @param profileImage
     * @param link
     * @param userId
     * @param reputation
     * @param displayName
     * @param acceptRate
     * @param userType
     */
    public Owner(Integer reputation, Integer userId, String userType, Integer acceptRate, String profileImage, String displayName, String link) {
        this.reputation = reputation;
        this.userId = userId;
        this.userType = userType;
        this.acceptRate = acceptRate;
        this.profileImage = profileImage;
        this.displayName = displayName;
        this.link = link;
    }
}
