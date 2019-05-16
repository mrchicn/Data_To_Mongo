
import Utils.MD5Utils;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.ConstructionData;
import org.bson.Document;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/***
 @author mrchi
 @Project Data_To_Mongo
 @File Write_to_mongo.java
 @date 2019年05月15日 17:10
 @Website http://www.mrchi.cn
 @version 1.0
 ***/
public class Write_to_mongo {

    private static final String MONGO_ADDRESS = "xx.oo.xx.oo";
    private static final int MONGO_PORT = 5201314;
    private static final String MONGO_USERNAME = "mylove";
    private static final String MONGO_PASSWORD = "mylove";
    private static final String MONGO_DB_NAME = "www.mrchi.cn";
    private static final String MONGO_COLLECTION_NAME = "www.mrchi.cn";


    public static void main(String[] args) throws ParseException, InterruptedException {

        ConstructionData Datas = new ConstructionData();
        MongoCollection<Document> user1 = getDocumentMongoCollection();
        Document document = new Document();

        for (int i = 0; i < 10000; i++) {
            System.out.println("**********************");
            System.out.println("Insert " + i + " Data");
            System.out.println("**********************");
            //todo  给实体类  赋值
            System.out.println(collating_data(Datas));
            //todo  构造数据Document
            document.put("d1", Datas.getD1());
            document.put("d2", Datas.getD2());
            document.put("d3", Datas.getD3());
            document.put("d4", Datas.getD4());
            document.put("d5", Datas.getD5());
            document.put("d6", Datas.getD6());
            document.put("d7", Datas.getD7());
            document.put("d8", Datas.getD8());
            document.put("d9", Datas.getD9());
            document.put("d20", Datas.getD20());
            document.put("d999", Datas.getD999());
            //todo  自己定义的_id mongo 就不会生成_id了
            document.put("_id", Datas.getId());
            document.put("oem", Datas.getOem());
            document.put("pNo", Datas.getpNo());
            document.put("sim", Datas.getSim());
            document.put("time", Datas.getTime());
            document.put("upType", Datas.getUpType());

            //todo  插入数据
            user1.insertOne(document);
            Thread.sleep(1000);

        }
    }

    //  todo   认证方法  返回集合名字
    private static MongoCollection<Document> getDocumentMongoCollection() {
        //todo  mongo 地址和端口
        ServerAddress serverAddress = new ServerAddress(MONGO_ADDRESS, MONGO_PORT);

        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);

        //todo  认证
        MongoCredential credential = MongoCredential.createScramSha1Credential(MONGO_USERNAME, MONGO_DB_NAME, MONGO_PASSWORD.toCharArray());

        //todo 通过连接认证获取MongoDB连接   需要一个List  和一个   MongoCredential
        MongoClient mongoClient = new MongoClient(addrs, Collections.singletonList(credential));

        MongoDatabase db = mongoClient.getDatabase(MONGO_DB_NAME);

        return db.getCollection(MONGO_COLLECTION_NAME);
    }

    private static String collating_data(ConstructionData data) throws ParseException {

        String id = "abcdefalskdasjfhasld#%@^gaadsadkdasjfhasld#%@^gsad#%ssfsafsaafsadkdasjfhasld#%@^gsad#%sssgdsgsdgssssaf543hj5203534y##%@ssssdashfasgfan4621028486u1274910947983529";

        Random random = new Random();

        //todo  id

        Date date = new Date();
        long date_id = date.getTime();
        String clear_id = String.valueOf(date_id);
        data.setId(MD5Utils.MD5Encode(clear_id, "utf8"));

        //todo  oem
        int oem = random.nextInt(99999);
        data.setOem(String.valueOf(oem));

        //todo  sim  手机号
        long sim = random.nextInt(9999999);
        data.setSim(String.valueOf(sim));

        //todo d1  经度
        String s_d1_1 = String.valueOf(random.nextInt(200) + 10);
        String s_d1_2 = String.valueOf(random.nextInt(888) + 111);
        String s_d1_3 = s_d1_1 + "." + s_d1_2;

        Double d1 = Double.valueOf(s_d1_3);
        data.setD1(d1);

        //todo d2  纬度
        String s_d2_1 = String.valueOf(random.nextInt(200) + 10);
        String s_d2_2 = String.valueOf(random.nextInt(888) + 111);
        String s_d2_3 = s_d2_1 + "." + s_d2_2;

        Double d2 = Double.valueOf(s_d2_3);
        data.setD2(d2);

        //todo    d3  速度
        data.setD3(random.nextInt(120));


        //todo  d4  时间戳
        String t1[] = {"154", "155"};
        random.nextInt(t1.length);
        String t11 = t1[(random.nextInt(t1.length))];
        int t2 = random.nextInt(457) + 100;
        int t3 = random.nextInt(888) + 111;
        int t4 = random.nextInt(9);


        // todo   构造 d4
        int t44 = t4 + 1;
        String d_time = t11 + String.valueOf(t2) + String.valueOf(t3) + String.valueOf(t4) + "000";

        //todo   顺便将time 时间字段设置一下
        String time_0 = t11 + String.valueOf(t2) + String.valueOf(t3) + String.valueOf(t44) + "000";

        String d999 = "1534550888000";

        //todo   修改为 mongo 的时间类型的
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));

        String s_d999 = format.format(Long.valueOf(d999));
        String s_time = format.format(Long.valueOf(time_0));
        String s_d4 = format.format(Long.valueOf(d_time));

        Date date_d999 = format.parse(s_d999);
        Date date_d4 = format.parse(s_d4);
        Date date_time = format.parse(s_time);

        data.setD4(date_d4);

        //todo  d5  方向
        data.setD5(random.nextInt(359));

        //todo   d6  海拔高度
        data.setD6(0);

        //todo   d7    速度是D3 的十倍
        data.setD7(data.getD3() * 10);

        //todo  d8  Acc 状态位
        data.setD8(random.nextInt(888888) + 111111);


        //todo   d9  里程
        data.setD9(random.nextInt(888888));

        //todo  d999 系统时间!
        data.setD999(date_d999);

        //todo  time 到服务器的时间!
        data.setTime(date_time);

        //todo   上传类型
        data.setUpType(String.valueOf(random.nextInt(2)));

        //todo  车牌号
        String car_number[] = {"闽DE3177", "京AQ5180", "鄂AVL413", "京AT0478", "川AAB379", "川AAF795", "川AAN679", "鄂AAEM730", "鄂AHD013", "鄂APW743", "鄂ANM719", "鄂APA541", "鄂ATP141", "鄂C9H802", "鄂NCH480", "桂B36968", "桂B37289", "桂BA7586", "黑AK8111", "黑AS3354", "黑MD7810", "黑AB4810", "黑B17542", "泸EA4158", "泸EM3512", "泸EQ5876", "泸EP7480", "泸ETD813", "泸EL1785", "泸EJ0437", "吉A88412", "吉AK2148", "吉AP7401", "吉AL63360", "吉AH8891", "吉A8F701", "吉AM7841", "吉A8E940", "吉A8F402", "吉A88421", "吉AH2417", "吉AL1016", "吉AK5441", "冀FB1027", "冀FN8019", "冀FP8812", "冀FM7492", "冀FP1780", "冀FL4783", "冀AF9B38", "冀A58AM", "冀AB7405", "冀A90831", "冀B3857M", "冀B23C14", "冀B3738M", "冀HZ3512", "冀HZL913", "冀HZL8287", "冀H3845L", "京AAA301", "京AAB208", "京AAB738", "京AA7581", "京ABL200", "京ALC719", "京AL872C", "京ABK911", "京ALK754", "京AK47S0", "京ABB873", "京ABQ397", "京ACQ354", "京AALS02", "京ALBBQ1"};

        int i = random.nextInt(car_number.length);
        String s_numner = car_number[i];

        data.setpNo(s_numner);

        return data.toString();


    }

}

