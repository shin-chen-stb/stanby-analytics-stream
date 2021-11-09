package inc.stanby.utils;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import org.apache.flink.core.io.SimpleVersionedSerializer;
import org.apache.flink.streaming.api.functions.sink.filesystem.BucketAssigner;
import org.apache.flink.streaming.api.functions.sink.filesystem.bucketassigners.SimpleVersionedStringSerializer;
import java.io.Serializable;
import inc.stanby.schema.StanbyEvent;

public class StanbyEventBucketAssigner implements BucketAssigner<StanbyEvent, String>, Serializable {
      
    public String getBucketId(StanbyEvent event, Context context) {
      Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
      Date date = new Date(event.getEpoch());
      cal.setTime(date);

      return String.format("date=%04d-%02d-%02d-%02d",
        cal.get(Calendar.YEAR),
        cal.get(Calendar.MONTH) + 1,
        cal.get(Calendar.DAY_OF_MONTH),
        cal.get(Calendar.HOUR_OF_DAY)
      );
    }

    public SimpleVersionedSerializer<String> getSerializer() {
      return SimpleVersionedStringSerializer.INSTANCE;
    }
}
